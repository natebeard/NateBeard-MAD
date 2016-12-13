package com.example.natebeard.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    //Create private variables price_number and total_number and image to get data from petPrice and imageView
    private int priceNumber;
    private String animalFinalImage;
    private String totalText;
    private ImageView finalImageView;
    ViewGroup checkLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        System.out.println(priceNumber);
        checkLayout = (ViewGroup)findViewById(R.id.activity_checkout);

        Intent intent = getIntent();
        priceNumber = intent.getIntExtra("animalPriceValue", priceNumber);
        TextView priceNumberText = (TextView)findViewById(R.id.price_number);
        String priceValue = String.valueOf(priceNumber);
        priceNumberText.setText(priceValue);

        animalFinalImage = intent.getStringExtra("animalPictureName");
        System.out.println(animalFinalImage);
        int resID = getResources().getIdentifier(animalFinalImage, "drawable", getPackageName());
        finalImageView = (ImageView)findViewById(R.id.imageView2);
        finalImageView.setImageResource(resID);


        RadioGroup animalSize = (RadioGroup)findViewById(R.id.size);
        Button lastActivityButton = (Button)findViewById(R.id.orderButton);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                chooseSize(view);
                finalScreen(view);
            }
        };
        animalSize.setOnClickListener(onclick);
        lastActivityButton.setOnClickListener(onclick);

    }


    public void chooseSize(View view){

        ViewGroup.LayoutParams sizeRules = finalImageView.getLayoutParams();

        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(4000);
        TransitionManager.beginDelayedTransition(checkLayout);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.visibility);
        TextView totalNumberText = (TextView)findViewById(R.id.total_price);
        RadioGroup animalSize = (RadioGroup)findViewById(R.id.size);
        int price;
        int sizeRadio = animalSize.getCheckedRadioButtonId();
        switch (sizeRadio) {
            case -1:
                price = 0;
                break;
            case R.id.radio_lap_size:
                price = 100;
                sizeRules.height = finalImageView.getHeight()/2;
                sizeRules.width = finalImageView.getWidth()/2;
                finalImageView.setAnimation(rotate);
                break;
            case R.id.radio_small_car:
                price = 500;
                sizeRules.height = finalImageView.getHeight()+100;
                sizeRules.width = finalImageView.getWidth()+100;
                finalImageView.setAnimation(rotate);
                break;
            default:
                price = 0;
        }

        System.out.println(price);
        linearLayout.setVisibility(View.VISIBLE);
        int totalPrice = priceNumber + price;
        totalText = String.valueOf(totalPrice);
        totalNumberText.setText(totalText);
        System.out.println(totalText);





    }


    public void finalScreen(View view){
        Intent intent = new Intent(this, LastActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Your total price is " + totalText, Toast.LENGTH_LONG).show();
    }




}
