package com.example.anagramm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

class Anagram {
    static String anagram(String inputString, String filter) {

        String[] inputArr = inputString.split(" ");
        String ch1;
        String ch2;
        char tempChar;
        filter = filter.replace(" ", "");
        StringBuilder outputString = new StringBuilder();

        for (String s : inputArr) {

            char[] inputCharArr = s.toCharArray();
            int j = inputCharArr.length - 1;

            for (int i = 0; i < j; ) {

                ch1 = String.valueOf(inputCharArr[i]);
                ch2 = String.valueOf(inputCharArr[j]);

                if (filter.contains(ch1)) {
                    i++;
                } else if (filter.contains(ch2)) {
                    j--;
                } else {
                    tempChar = inputCharArr[i];
                    inputCharArr[i] = inputCharArr[j];
                    inputCharArr[j] = tempChar;
                    i++;
                    j--;
                }
            }
            outputString.append(" ").append(inputCharArr);
        }
        return outputString.toString().trim();
    }
}

public class MainActivity extends AppCompatActivity {

    private EditText mInputStringEditView;
    private EditText mFilterEditText;
    private TextView mOutputStringTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputStringEditView = findViewById(R.id.inputStringTextView);
        mFilterEditText = findViewById(R.id.filterEditText);
        mOutputStringTextView = findViewById(R.id.outputTextView);

        mFilterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String inputString = mInputStringEditView.getText().toString();
                String filter = mFilterEditText.getText().toString();
                mOutputStringTextView.setText(Anagram.anagram(inputString, filter));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        mInputStringEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String inputString = mInputStringEditView.getText().toString();
                String filter = mFilterEditText.getText().toString();
                mOutputStringTextView.setText(Anagram.anagram(inputString, filter));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
