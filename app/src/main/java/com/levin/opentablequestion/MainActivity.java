package com.levin.opentablequestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static boolean canMakePalindrom(String s) {
        Set<Character> oddChars = new HashSet<>();

        // Go over the characters
        for (char c : s.toCharArray()) {
            // Record the encountered character:
            if (!oddChars.add(c)) {
                // If the char was already encountered, remove it -
                // this is an even time we encounter it
                oddChars.remove(c);
            }
        }

        // Check the number of characters with odd counts:
        return oddChars.size() <= 1;
    }
}
