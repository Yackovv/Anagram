package com.example.anagramm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mInputStringEditView;
    private EditText mFilterEditText;
    private TextView mOutputStringTextView;

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String inputString = mInputStringEditView.getText().toString().trim();
            String filter = mFilterEditText.getText().toString().trim();
            mOutputStringTextView.setText(Anagram.anagram(inputString, filter));
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputStringEditView = findViewById(R.id.inputStringTextView);
        mFilterEditText = findViewById(R.id.filterEditText);
        mOutputStringTextView = findViewById(R.id.outputTextView);

        mInputStringEditView.addTextChangedListener(textWatcher);
        mFilterEditText.addTextChangedListener(textWatcher);
    }
}
