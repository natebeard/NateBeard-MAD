package com.example.natebeard.lab8burrito;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private BurritoShop myBurritoShop = new BurritoShop();

    public void findBurrito(View view){
        //get radio
        RadioGroup burritoRadioButton = (RadioGroup)findViewById(R.id.burrito_radiogroup);
        // get radio button
        Integer burrito = burritoRadioButton.getCheckedRadioButtonId();
        // set the burrito shop
        myBurritoShop.setBurritoShop(burrito);
        // get suggested burrito shop
        String suggestedBurritoShop = myBurritoShop.getBurritoShop();
        // get URL of suggested burrito shop
        String suggestedBurritoShopURL = myBurritoShop.getBurritoShopURL();
        System.out.println(suggestedBurritoShop);
        System.out.println(suggestedBurritoShopURL);

        // create an intent
        Intent intent = new Intent(this, ReceiveBurritoActivity.class);
        //start the intent
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get button
        final Button button = (Button)findViewById(R.id.button);
        // create listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                findBurrito(view);
            }
        };
        //ad listner to the button
        button.setOnClickListener(onclick);
    }
}
