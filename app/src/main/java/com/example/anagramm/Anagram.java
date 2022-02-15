package com.example.anagramm;

public class Anagram {
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
