package com.example.natebeard.finalpractice2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private String checkboxFeeling;
    private String nameString;
    private String spinnerMoodValue;
    private String genderValue;
    private String withFriends;
    private String drinkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getTheFeelin(View view){
        EditText name = (EditText)findViewById(R.id.editNameText);
        String nameValue = name.getText().toString();
        nameString = nameValue;

        Spinner moodFeeling = (Spinner)findViewById(R.id.spinner);
        String spinnerValue = String.valueOf(moodFeeling.getSelectedItem());
        spinnerMoodValue = spinnerValue;

        ToggleButton genderToggle = (ToggleButton)findViewById(R.id.genderToggleButton);
        boolean gender = genderToggle.isChecked();
        //String genderValue;
        if (gender){
            genderValue="dude";
        } else {
            genderValue="dudette";
        }

        //String withFriends = "";
        Switch friendWithSwitch = (Switch)findViewById(R.id.friendSwitch);
        boolean friends = friendWithSwitch.isChecked();
        if (friends){
            withFriends=" with friends";
        }


        RadioGroup drinkingBooz = (RadioGroup)findViewById(R.id.drinks_radio_group);
        //String drinkType="";
        int drinkRadio = drinkingBooz.getCheckedRadioButtonId();
        switch (drinkRadio){
            case -1:
                drinkType="nada";
                break;
            case R.id.beerRadioButton:
                drinkType="beer";
                break;
            case R.id.whiskeyRadioButton2:
                drinkType="whiskey";
                break;
            default:
                drinkType="grow up";
        }

        //String checkboxFeeling = "";
        CheckBox hungryBox = (CheckBox)findViewById(R.id.hungryCheckBox);
        boolean hungryCheck = hungryBox.isChecked();
        if (hungryCheck){
            checkboxFeeling = " hungry";
        }

        CheckBox chattyBox = (CheckBox)findViewById(R.id.chattyCheckBox);
        boolean chattyCheck = chattyBox.isChecked();
        if (chattyCheck){
            checkboxFeeling = " chatty";
        }

        TextView moodTextView = (TextView)findViewById(R.id.moodText);
        moodTextView.setText(nameValue + " is a " + spinnerValue + genderValue + " in a " + checkboxFeeling + " mood who drinks " + drinkType + withFriends);

        Button nextActivityButton = (Button)findViewById(R.id.findPlaceButton);
        nextActivityButton.setVisibility(View.VISIBLE);

    }

    public void goToNextActivity (View view){
        final Button nextActivityButton = (Button)findViewById(R.id.findPlaceButton);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                getTheFeelin(view);
            }
        };
        nextActivityButton.setOnClickListener(onclick);

        Intent intent = new Intent(this, GetPlaceActivity.class);
        intent.putExtra("nameText", nameString);
        intent.putExtra("mood", spinnerMoodValue);
        intent.putExtra("gender", genderValue);
        intent.putExtra("feelingCheckBox", checkboxFeeling);
        intent.putExtra("typeOfDrink", drinkType);
        intent.putExtra("friends", withFriends);

        startActivity(intent);

    }






}
