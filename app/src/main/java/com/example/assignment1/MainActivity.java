package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText principalInput;
    private EditText interestRateInput;
    private EditText loanTenureInput;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        principalInput = findViewById(R.id.etPrincipalAmount);
        interestRateInput = findViewById(R.id.etInterestRate);
        loanTenureInput = findViewById(R.id.etLoanTenure);
        calculateButton = findViewById(R.id.btnCalculateEMI);

        // Set a click listener for the "Calculate EMI" button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateEMI();
            }
        });
    }

    private void calculateEMI() {
        // Get user input from EditText fields
        String principalText = principalInput.getText().toString();
        String interestRateText = interestRateInput.getText().toString();
        String loanTenureText = loanTenureInput.getText().toString();

        // Convert input to appropriate data types
        double principalAmount = Double.parseDouble(principalText);
        double interestRate = Double.parseDouble(interestRateText);
        int loanTenure = Integer.parseInt(loanTenureText);

        // Calculate the EMI
        double monthlyInterestRate = (interestRate / 12) / 100;
        double emi = principalAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTenure)
                / (Math.pow(1 + monthlyInterestRate, loanTenure) - 1);

        // Start the DisplayActivity and pass the EMI result
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("emiResult", emi);
        startActivity(intent);
    }
}
