package com.example.natebeard.finalpractice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GetPlaceActivity extends AppCompatActivity {

    private String placeName;
    private String placeURL;
    private String placeImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_place);

        //get intent when view is loaded
        Intent intent = getIntent();
        placeName = intent.getStringExtra("partyPlaceName");
        placeURL = intent.getStringExtra("partyPlaceURL");

        System.out.println(placeName);
        System.out.println(placeURL);

        TextView checkOutText = (TextView)findViewById(R.id.youLikeTextView);
        checkOutText.setText("You want to check out " + placeName +"?");

        final Button yesFindPlace = (Button)findViewById(R.id.yesButton);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                yesFindPlace(view);
            }
        };
        yesFindPlace.setOnClickListener(onclick);

    }


    public void yesFindPlace(View view){

        TextView checkOutPlace = (TextView)findViewById(R.id.checkOutTextView);
        checkOutPlace.setText("Click on the image below!");
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        placeImage = intent.getStringExtra("partyPlaceImage");
        if (placeImage.equals("bitter")){
            imageButton.setImageResource(R.drawable.bitterbar);
        }
        if (placeImage.equals("kit")){
            imageButton.setImageResource(R.drawable.kitchen);
        }
        if (placeImage.equals("saloon")){
            imageButton.setImageResource(R.drawable.outback);
        }

        View.OnClickListener onclick2 = new View.OnClickListener(){
            public void onClick(View view){
                goWebsite(view);
            }
        };
        imageButton.setOnClickListener(onclick2);

    }

    public void goWebsite(View view){
       Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(placeURL));
        startActivity(intent);


    }


}
