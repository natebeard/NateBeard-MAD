package com.example.natebeard.afinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class FindStoreActivity extends AppCompatActivity {

    private String iceCreamShop;
    private String iceCreamShopURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_store);

        Intent intent = getIntent();
        iceCreamShop = intent.getStringExtra("suggestShop");
        iceCreamShopURL = intent.getStringExtra("suggestShopURL");
        System.out.println(iceCreamShop);
        System.out.println(iceCreamShopURL);

        TextView storeName = (TextView)findViewById(R.id.webTextView);
        storeName.setText("You should check out " + iceCreamShop);

        ImageButton goWebsiteButton = (ImageButton)findViewById(R.id.webImageButton);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                goWebsite(view);
            }
        };
        goWebsiteButton.setOnClickListener(onclick);


    }

    public void goWebsite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(iceCreamShopURL));
        startActivity(intent);

    }
}
