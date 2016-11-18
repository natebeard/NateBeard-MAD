package com.example.natebeard.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Integer petPrice;

    public void generatePetAction(View view){
        Spinner animalSpinner = (Spinner)findViewById(R.id.spinner);
        String animalValue = String.valueOf(animalSpinner.getSelectedItem());

        RadioGroup animalType = (RadioGroup)findViewById(R.id.type_of_animal_radiogroup);
        String typeOfAnimal = "";
        int animal_id = animalType.getCheckedRadioButtonId();
        switch (animal_id) {
            case -1:
                typeOfAnimal="no";
                break;
            case R.id.radio1:
                typeOfAnimal="Prehistoric";
                break;
            case R.id.radio2:
                typeOfAnimal="Alien";
                break;
            default:
                typeOfAnimal="no";
        }


        ToggleButton toggle = (ToggleButton)findViewById(R.id.genderToggleButton);
        boolean gender = toggle.isChecked();
        String genderAnimal;
        if (gender) {
            genderAnimal="female";
        } else {
            genderAnimal="male";
        }


        String wings = "";
        Switch wingAnimal = (Switch)findViewById(R.id.wings_switch);
        boolean animalHasWings = wingAnimal.isChecked();
        if (animalHasWings) {
            wings = "yes";
        } else {
            wings = "no";
        }


        ImageView animalImage = (ImageView)findViewById(R.id.imageView);


        if (animalValue.equals("Cat") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.sabertoothmalewing);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.sabertoothmale);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.sabertoothmalewing);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.sabertoothmale);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.aliencat);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.aliencat);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.aliencat);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.aliencat);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.sabertoothmalewing);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.sabertoothmalewing);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.sabertoothmalewing);
            //
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.sabertoothmalewing);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.aliendog);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.aliendog);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.aliendog);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.aliendog);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.mammothnowing);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.mammoth);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.mammothnowing);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.mammoth);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.mammothnowing);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.mammoth);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.mammoth);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.mammothnowing);
        }



        if (typeOfAnimal.equals("Dog") || typeOfAnimal.equals("Cat")) {
            petPrice = 2000;
        } else if (typeOfAnimal.equals("Elephant")) {
            petPrice = 3000;
        }





    }

    public void goToCheckout(View view) {

        Intent intent = new Intent(this, CheckoutActivity.class);
        intent.putExtra("animalPriceValue", petPrice);
        startActivity(intent);
    }
    //Create checkout button
    // find checkout button
    // create listener for generatePetAction data: petPrice and imageView data to pass
    // add listener to button that makes it go to next screen



    //Example code:
           /* final Button button = (Button) findViewById(R.id.button);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                findCoffee(view);
            }
        };
        //add listener to the button
        button.setOnClickListener(onclick);*/



}
