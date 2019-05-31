package com.example.rpgdiceroller2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rollButton; // Stores the button view
    private Spinner diceSpinner; // Stores the spinner view
    private TextView resultsView; // Stores the textview view
    private Random rng = new Random(); // Stores a random number
    private ArrayAdapter<String> diceContainer; // Stores the different dice values


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* find the fields from our layout based on the id id
           and store the in variables */
        rollButton = findViewById(R.id.roll);
        diceSpinner = findViewById(R.id.diceSelectionDropDown);
        resultsView = findViewById(R.id.resultsTextView);

        // Create an array to hold the value of our string array 'dice' in strings.xml
        diceContainer = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.dice));
        diceContainer.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Add the array to the spinner
        diceSpinner.setAdapter(diceContainer);

        // Listen for when the user clicks the roll button and call the rollDice function
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 rollDice();
            }
        });
    }

    /*
        This function grabs the dice choice made by the user and then
        generates a random number based on the value of the dice. Using
        the dice value as an upper bound, it then displays that value
        in the textview field.
    */
    private void rollDice() {

        // Retrieve dice choice made by the user
        String diceSelection = diceSpinner.getSelectedItem().toString();

        /* Chose case based on choice and then generate random number using the dice choice
           as the upper bound
        */
        switch (diceSelection) {
            case "d4":
                resultsView.setText((rng.nextInt(4) + 1) + "");
                break;
            case "d6":
                resultsView.setText((rng.nextInt(6) + 1) + "");
                break;
            case "d8":
                resultsView.setText((rng.nextInt(8) + 1) + "");
                break;
            case "d10":
                resultsView.setText((rng.nextInt(10) + 1) + "");
                break;
            case "d12":
                resultsView.setText((rng.nextInt(12) + 1) + "");
                break;
            case "d20":
                resultsView.setText((rng.nextInt(20) + 1) + "");
                break;
        }
    }
}