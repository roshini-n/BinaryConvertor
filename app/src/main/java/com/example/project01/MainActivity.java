package com.example.project01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText valueET;
    private TextView displayTV, errorTV, welcomeText;
    private Button toBinaryButton, learnBinaryButton, complementButton, twosComplementButton, hexButton, toDecimalButton;
    private Animation fadeOut, welcomeAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        valueET = findViewById(R.id.valueET);
        displayTV = findViewById(R.id.displayTV);
        errorTV = findViewById(R.id.errorTV);
        welcomeText = findViewById(R.id.welcomeText);
        toBinaryButton = findViewById(R.id.toBinaryButton);
        learnBinaryButton = findViewById(R.id.learnBinaryButton);
        complementButton = findViewById(R.id.complementButton);
        twosComplementButton = findViewById(R.id.twosComplementButton);
        hexButton = findViewById(R.id.hexButton);
        toDecimalButton = findViewById(R.id.toDecimalButton);



        // Load animations
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        welcomeAnim = AnimationUtils.loadAnimation(this, R.anim.welcome_anim);
        welcomeText.startAnimation(AnimationUtils.loadAnimation(this, R.anim.glow));

        // Animate welcome message
        welcomeText.setVisibility(View.VISIBLE);
        welcomeText.startAnimation(welcomeAnim);

        // Button to convert to binary
        toBinaryButton.setOnClickListener(v -> {
            applyFadeOut();
            try {
                String inputValue = valueET.getText().toString();
                int number = Integer.parseInt(inputValue);
                String binaryString = Integer.toBinaryString(number);
                String paddedBinaryString = String.format("%32s", binaryString).replace(' ', '0');
                displayTV.setText(paddedBinaryString);
                errorTV.setText("");  // Clear error message
            } catch (NumberFormatException e) {
                displayTV.setText("00000000000000000000000000000000");
                errorTV.setText("Invalid input! Please enter a valid number.");
            }
        });

        // Implicit intent to learn about binary numbers
        learnBinaryButton.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Binary_number"));
            startActivity(browserIntent);
        });


        // Button to complement the binary string
        complementButton.setOnClickListener(v -> {
            applyFadeOut();
            String currentBinary = displayTV.getText().toString();
            if (!currentBinary.equals("No result")) {
                StringBuilder complemented = new StringBuilder();
                for (char bit : currentBinary.toCharArray()) {
                    complemented.append(bit == '0' ? '1' : '0');
                }
                displayTV.setText(complemented.toString());
            }
        });

        // Button to perform 2's complement
        twosComplementButton.setOnClickListener(v -> {
            applyFadeOut();
            String currentBinary = displayTV.getText().toString();
            if (!currentBinary.equals("No result")) {
                StringBuilder twosComplemented = new StringBuilder();
                boolean flipNext = true;
                for (int i = currentBinary.length() - 1; i >= 0; i--) {
                    char bit = currentBinary.charAt(i);
                    if (flipNext) {
                        twosComplemented.append(bit == '0' ? '1' : '0');
                    } else {
                        twosComplemented.append(bit);
                    }
                    if (bit == '1') {
                        flipNext = false;
                    }
                }
                displayTV.setText(twosComplemented.reverse().toString());
            }
        });

        // Button to convert to hexadecimal
        hexButton.setOnClickListener(v -> {
            applyFadeOut();
            try {
                String inputValue = valueET.getText().toString();
                int number = Integer.parseInt(inputValue);
                String hexString = Integer.toHexString(number).toUpperCase();
                displayTV.setText(hexString);
                errorTV.setText("");  // Clear error message
            } catch (NumberFormatException e) {
                displayTV.setText("Invalid input");
                errorTV.setText("Invalid number format.");
            }
        });

        toDecimalButton.setOnClickListener(v -> {
            try {
                String binaryString = displayTV.getText().toString();
                int decimalValue = Integer.parseInt(binaryString, 2);
                displayTV.setText(String.valueOf(decimalValue));
                errorTV.setText(""); // Clear error message
            } catch (Exception e) {
                errorTV.setText("Invalid binary input.");
            }
        });


    }


    // Method to apply fade-out animation before updating text
    private void applyFadeOut() {
        displayTV.startAnimation(fadeOut);
    }
}
