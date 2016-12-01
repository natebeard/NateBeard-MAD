package com.example.natebeard.lab8burrito;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ReceiveBurritoActivity extends AppCompatActivity {

    private String burritoShop;
    private String burritoShopURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_burrito);

        // get intent
        Intent intent = getIntent();
        burritoShop = intent.getStringExtra("burritoShopName");
        burritoShopURL = intent.getStringExtra("burritoShopURL");
        System.out.println(burritoShop);
        System.out.println(burritoShopURL);

        // update text view
        TextView messageView=(TextView)findViewById(R.id.burritoShopTextView);
        messageView.setText("You should check out" + burritoShop);

        final ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
        // create listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                loadWebsite(view);
            }
        };
        //add listner to the button
        imageButton.setOnClickListener(onclick);

    }

    public void loadWebsite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(burritoShopURL));
        startActivity(intent);
    }
}
