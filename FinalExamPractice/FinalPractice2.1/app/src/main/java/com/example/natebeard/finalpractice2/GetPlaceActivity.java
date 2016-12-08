package com.example.natebeard.finalpractice2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GetPlaceActivity extends AppCompatActivity {


    private String checkboxFeeling;
    private String nameString;
    private String spinnerMoodValue;
    private String genderValue;
    private String withFriends;
    private String drinkType;
    private String websiteURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_place);

        Intent intent = getIntent();
        nameString = intent.getStringExtra("nameText");
        spinnerMoodValue = intent.getStringExtra("mood");
        genderValue = intent.getStringExtra("gender");
        checkboxFeeling = intent.getStringExtra("feelingCheckBox");
        drinkType = intent.getStringExtra("typeOfDrink");
        withFriends = intent.getStringExtra("friends");

        TextView whoYouAreText = (TextView)findViewById(R.id.finalTextView);
        whoYouAreText.setText(nameString + " is a " + spinnerMoodValue + genderValue + " in a " + checkboxFeeling + " mood who drinks " + drinkType + withFriends);

        ImageButton imagePlace = (ImageButton)findViewById(R.id.imageButton);
        if (drinkType.equals("beer")){
            imagePlace.setImageResource(R.drawable.kitchen);
            websiteURL = "http://thekitchen.com/";
        }
        if (drinkType.equals("whiskey")){
            imagePlace.setImageResource(R.drawable.bitterbar);
            websiteURL = "http://www.thebitterbar.com/";
        }

        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                goToWebsite(view);
            }
        };
        imagePlace.setOnClickListener(onclick);



    }

    public void goToWebsite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(websiteURL));
        startActivity(intent);
    }
}
