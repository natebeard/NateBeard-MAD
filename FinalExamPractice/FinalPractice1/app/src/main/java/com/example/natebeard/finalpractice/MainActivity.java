package com.example.natebeard.finalpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Place  myPlace = new Place();
    private int typeOfPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void findWho(View view){
        EditText name = (EditText)findViewById(R.id.nameTextEdit);
        // grab textedit object and then get the text entered and convert it into a string
        String nameValue = name.getText().toString();

        //get spinner and convert value to a string
        Spinner moodSpinnerValue = (Spinner)findViewById(R.id.moodSpinner);
        String moodValue = String.valueOf(moodSpinnerValue.getSelectedItem());
        System.out.println(moodValue);

        ToggleButton toggle = (ToggleButton)findViewById(R.id.toggleButton2);
        boolean gender = toggle.isChecked();
        String genderValue;
        if (gender) {
            genderValue = "girl";
        } else {
            genderValue = "guy";
        }

        RadioGroup drink = (RadioGroup)findViewById(R.id.drinks_radio_group);
        String drinkType = "";
        int drinkRadio = drink.getCheckedRadioButtonId();
        //radio buttons provide an int so need to get the radio button id from RadioGroup
        switch (drinkRadio){
            case -1:
                drinkType = "sober";
                break;
            case R.id.radioButton3:
                drinkType = "beer";
                break;
            case R.id.radioButton4:
                drinkType = "wine";
                break;
            default:
                drinkType = "super sober";
        }

        //check boxes are individual buttons that hold data so need to grab each one individually
        // and they are booleans so no need for int and convert to string

        CheckBox checkHappyHour = (CheckBox)findViewById(R.id.happyHourCheck);
        boolean checkBoxHappy = checkHappyHour.isChecked();
        if (checkBoxHappy){
            typeOfPlace =1;
        }
        CheckBox checkDinner = (CheckBox)findViewById(R.id.dinnerCheck);
        boolean checkBoxDinner = checkDinner.isChecked();
        if (checkBoxDinner){
            typeOfPlace = 2;
        }




        TextView whoAreYou = (TextView)findViewById(R.id.youAreTextView);
        whoAreYou.setText(nameValue + " is a " + moodValue + " " + genderValue + " who drinks " + drinkType);

        Button goToNextScreen = (Button)findViewById(R.id.nextActivityButton);
        goToNextScreen.setVisibility(View.VISIBLE);

    }

    public void nextActivity(View view){

        final Button goToNextScreen = (Button)findViewById(R.id.nextActivityButton);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                findWho(view);
            }
        };

        goToNextScreen.setOnClickListener(onclick);

        // set myPlace from Place class value passed called setPlaceName
        myPlace.setPlaceName(typeOfPlace);
        //get name and URL from Place class
        String suggestedWateringHole = myPlace.getPlaceName();
        String suggestedWateringHoleURL = myPlace.getPlaceURL();
        String suggestedPlaceImage = myPlace.getPlaceImage();
        System.out.println(suggestedWateringHole);
        System.out.println(suggestedWateringHoleURL);

        //create an intent

        Intent intent = new Intent(this, GetPlaceActivity.class);

        //pass data
        intent.putExtra("partyPlaceName", suggestedWateringHole);
        intent.putExtra("partyPlaceURL", suggestedWateringHoleURL);
        intent.putExtra("partyPlaceImage", suggestedPlaceImage);

        startActivity(intent);


    }






}
