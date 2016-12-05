package com.example.natebeard.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private int petPrice;
    private ImageView animalImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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

        animalImage = (ImageView)findViewById(R.id.imageView);

        if (animalValue.equals("Cat") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.sabertoothmalewing);
            animalImage.setTag(R.drawable.sabertoothmalewing);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.sabertoothmale);
            animalImage.setTag(R.drawable.sabertoothmale);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.girlsabertoothwing);
            animalImage.setTag(R.drawable.girlsabertoothwing);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.girlsabertooth);
            animalImage.setTag(R.drawable.girlsabertooth);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.aliencatwings);
            animalImage.setTag(R.drawable.aliencatwings);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.aliencat);
            animalImage.setTag(R.drawable.aliencat);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.girlcatalienwings);
            animalImage.setTag(R.drawable.girlcatalienwings);
        } else if (animalValue.equals("Cat") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.girlcatalien);
            animalImage.setTag(R.drawable.girlcatalien);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.dingowings);
            animalImage.setTag(R.drawable.dingowings);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.dingo);
            animalImage.setTag(R.drawable.dingo);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.girldogwings);
            animalImage.setTag(R.drawable.girldogwings);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.girldog);
            animalImage.setTag(R.drawable.girldog);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.aliendog);
            animalImage.setTag(R.drawable.aliendog);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.aliendogwings);
            animalImage.setTag(R.drawable.aliendogwings);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.girlaliendogwings);
            animalImage.setTag(R.drawable.girlaliendogwings);
        } else if (animalValue.equals("Dog") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.girlaliendog);
            animalImage.setTag(R.drawable.girlaliendog);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.mammoth);
            animalImage.setTag(R.drawable.mammoth);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.mammothnowing);
            animalImage.setTag(R.drawable.mammothnowing);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.girlmammothwings);
            animalImage.setTag(R.drawable.girlmammothwings);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Prehistoric") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.girlmammoth);
            animalImage.setTag(R.drawable.girlmammoth);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.alienelephantwings);
            animalImage.setTag(R.drawable.alienelephantwings);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Alien") && genderAnimal.equals("male") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.alienelephant);
            animalImage.setTag(R.drawable.alienelephant);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("no")) {
            animalImage.setImageResource(R.drawable.girlalienelephant);
            animalImage.setTag(R.drawable.girlalienelephant);
        } else if (animalValue.equals("Elephant") && typeOfAnimal.equals("Alien") && genderAnimal.equals("female") && wings.equals("yes")) {
            animalImage.setImageResource(R.drawable.girlalienelephantwings);
            animalImage.setTag(R.drawable.girlalienelephantwings);
        }

        if (animalValue.equals("Dog") || animalValue.equals("Cat")) {
            petPrice = 2000;
        } else if (animalValue.equals("Elephant")) {
            petPrice = 3000;
        }
        System.out.println(petPrice);

    }
    public void goToCheckout(View view){
        Button clickCheckout = (Button)findViewById(R.id.checkout_button);
        View.OnClickListener onclick = new View.OnClickListener() {
            public void onClick(View view) {
                generatePetAction(view);
            }
        };

        clickCheckout.setOnClickListener(onclick);

        Intent intent = new Intent(this, CheckoutActivity.class);
        intent.putExtra("animalPriceValue", petPrice);
        // use putIntExtra or "putExtra"

        String nameOfImage = getResources().getResourceEntryName((Integer)animalImage.getTag());
        intent.putExtra("animalPictureName", nameOfImage);

        //System.out.println(nameOfImage);
        //intent.putExtra("animalPictureName", nameOfImage);
        //explicit intent that is named "animalPriceValue", intValue

        startActivity(intent);

        System.out.println(petPrice);

    }

}
