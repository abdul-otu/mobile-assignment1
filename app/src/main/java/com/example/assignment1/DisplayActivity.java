package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView emiDisplay;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // Initialize UI elements
        emiDisplay = findViewById(R.id.tvEMIResultDisplay);
        backButton = findViewById(R.id.btnBackToMain);

        // Retrieve the EMI result from the intent
        double emiResult = getIntent().getDoubleExtra("emiResult", 0.0);
        String formattedEMI = String.format("%.2f", emiResult);
        emiDisplay.setText("Monthly EMI: $" + formattedEMI);

        // Set a click listener for the "Back to Main" button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to go back to MainActivity
                Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
