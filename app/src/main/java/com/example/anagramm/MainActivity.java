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
        filter = filter.replace(" ", "");
        StringBuilder outputString = new StringBuilder();

        for (String s : inputArr) {

            outputString.append(" ").append(revers(s, filter));
        }
        return outputString.toString().trim();
    }

    static char[] revers(String s, String filter) {

        char ch1;
        char ch2;
        char tempChar;

        char[] inputCharArr = s.toCharArray();
        int j = inputCharArr.length - 1;

        for (int i = 0; i < j; ) {

            ch1 = inputCharArr[i];
            ch2 = inputCharArr[j];

            if (filter.indexOf(ch1) > -1) {
                i++;
            } else if (filter.indexOf(ch2) > -1) {
                j--;
            } else {
                tempChar = inputCharArr[i];
                inputCharArr[i] = inputCharArr[j];
                inputCharArr[j] = tempChar;
                i++;
                j--;
            }
        }
        return inputCharArr;
    }
}

public class MainActivity extends AppCompatActivity {

    private EditText mInputStringEditView;
    private EditText mFilterEditText;
    private TextView mOutputStringTextView;

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String inputString = mInputStringEditView.getText().toString().trim();
            String filter = mFilterEditText.getText().toString().trim();
            mOutputStringTextView.setText(Anagram.anagram(inputString, filter));

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
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
