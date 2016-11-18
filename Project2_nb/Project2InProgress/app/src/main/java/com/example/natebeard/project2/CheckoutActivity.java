package com.example.natebeard.project2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class CheckoutActivity extends AppCompatActivity {

    //Create private variables price_number and total_number and image to get data from petPrice and imageView
    private String priceNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        // put override at bottom so that I can update total_number for radioGroup data?
        // Or just put update TextView inside chooseSize method?

        // get intent and petPrice + imageview
        // update imageview at bottom of screen
        // update price_number textview and total_number textview for Lap price
        // price_number TextView to petPrice
        // total_number = price_number * 1.1

        //Intent intent = getIntent();

        //priceNumber = intent.getIntExtra("animalPriceValue", petPrice);

        /*
         //get intent
        Intent intent = getIntent();
        coffeeShop = intent.getStringExtra("coffeeShopName");
        coffeeShopURL = intent.getStringExtra("coffeeShopURL");
        System.out.println(coffeeShop);
        System.out.println(coffeeShopURL);

        //update text view
        TextView messageView = (TextView) findViewById(R.id.coffeeShopTextView);
        messageView.setText("You should check out " + coffeeShop);

        //get image button
        final ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                loadWebSite(view);
            }
        };
        //add listener to the button
        imageButton.setOnClickListener(onclick);
         */


    }

    public void chooseSize(View view) {
        RadioGroup animalSize = (RadioGroup)findViewById(R.id.size);
        int sizeRadio = animalSize.getCheckedRadioButtonId();
        switch (sizeRadio) {
            case R.id.radio_lap_size:
                //sizeRadio = do nothing
                break;
            case R.id.radio_knee_high:
                //update price_number textview to + 500
                break;
            case R.id.radio_waist_size:
                // update price_number
                break;
            case R.id.radio_small_car:
                //update price_number
                break;
            default:
                sizeRadio = 0;
                break;
        }
    }

}
