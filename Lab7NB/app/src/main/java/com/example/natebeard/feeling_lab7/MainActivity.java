package com.example.natebeard.feeling_lab7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findMood(View view) {
        EditText name=(EditText)findViewById(R.id.nameEditText);
        String nameValue=name.getText().toString();
        // spinner
        Spinner moodSpinner=(Spinner)findViewById(R.id.spinner);
        String moodValue=String.valueOf(moodSpinner.getSelectedItem());
        // gets spinner value and converts it to string so we can use it

        //adding an imageview for the toggle to call
        ImageView energyImage = (ImageView)findViewById(R.id.imageView);

        //adding toggle before the textView
        // casting energyToggleButton value as toggle button because it's in its view class
        // can only cast things that are a part of its class, but casting to get more specific (ie toggle)
        // need to cast energyToggleButton as a ToggleButton because we need to see if it's on or off
        ToggleButton toggle = (ToggleButton)findViewById(R.id.energyToggleButton);
        boolean energy = toggle.isChecked();
        //if get a message "energyString might not have a value," then can deifne it at the start
        //String is a class
        String energyString;
        if(energy) {
            energyString="positive";
            energyImage.setImageResource(R.drawable.happyface);
        } else {
            energyString="negative";
            energyImage.setImageResource(R.drawable.sadface);
        }

        //switch logic
        //if if statement is false, you wouldn't have a value so you need to give it a default value
        String meditate_string="";
        Switch meditate_switch=(Switch)findViewById(R.id.switch1);
        boolean mediate = meditate_switch.isChecked();
        if (mediate) {
            meditate_string="who meditates";
        }

        //radio buttons
        RadioGroup yoga =(RadioGroup)findViewById(R.id.yogaRadioGroup);
        String yogatype="";
        int yoga_id=yoga.getCheckedRadioButtonId();
        switch (yoga_id) {
            case -1:
                yogatype="no";
                break;
            case R.id.radioButton1:
                yogatype="Yin";
                break;
            case R.id.radioButton2:
                yogatype="Bikram";
                break;
            case R.id.radioButton3:
                yogatype="Hatha";
                break;
            default:
                yogatype="no";
        }


        //check boxes
        String checkbox_string="";
        CheckBox check1=(CheckBox)findViewById(R.id.checkBox1);
        boolean checked1 = check1.isChecked();
        if(checked1){
            checkbox_string += " conservative";
        }

        CheckBox check2=(CheckBox)findViewById(R.id.checkBox2);
        boolean checked2 = check2.isChecked();
        if(checked2){
            checkbox_string += " sarcastic";
        }

        CheckBox check3=(CheckBox)findViewById(R.id.checkBox3);
        boolean checked3 = check3.isChecked();
        if(checked3){
            checkbox_string += " enlightened";
        }

        CheckBox check4=(CheckBox)findViewById(R.id.checkBox4);
        boolean checked4 = check4.isChecked();
        if(checked4){
            checkbox_string += " secretive";
        }

        //textView
        TextView feeling=(TextView)findViewById(R.id.feelingTextView);
        feeling.setText(nameValue + " is a " + energyString + checkbox_string + " person in a " + moodValue + " mood " + meditate_string + " and does " + yogatype + " yoga?");



    }


}
