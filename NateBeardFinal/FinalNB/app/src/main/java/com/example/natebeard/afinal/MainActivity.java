package com.example.natebeard.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String iceCreamShop;
    private String iceCreamShopURL;

    public void generateTreatButton(View view){
        EditText nameTreat = (EditText)findViewById(R.id.editText);
        String nameValue = nameTreat.getText().toString();

        Spinner flavor = (Spinner)findViewById(R.id.spinner);
        String flavorValue = String.valueOf(flavor.getSelectedItem());
        System.out.println(flavorValue);

        RadioGroup typeOfTreatGroup = (RadioGroup)findViewById(R.id.type_of_ice_cream_radio_group);
        String treatType = "";
        int typeRadio = typeOfTreatGroup.getCheckedRadioButtonId();
        switch (typeRadio){
            case -1:
                treatType = "what treat";
                break;
            case R.id.iceCreamRadioButton:
                treatType = " ice cream";
                break;
            case R.id.froyoRadioButton:
                treatType = " frozen yogurt";
                break;
            case R.id.gelatoRadioButton:
                treatType = " gelato";
                break;
            default:
                treatType = "dude get a treat";
        }

        String toppings = "";
        CheckBox sprinkles = (CheckBox)findViewById(R.id.sprinklesCheckBox);
        boolean sprinklesChecked = sprinkles.isChecked();
        if (sprinklesChecked){
            toppings = " sprinkles";
        }

        CheckBox hotFudge = (CheckBox)findViewById(R.id.fudgeCheckBox);
        boolean fudgeChecked = hotFudge.isChecked();
        if (fudgeChecked){
            toppings = " hot fudge";
        }

        CheckBox nuts = (CheckBox)findViewById(R.id.nutsCheckBox);
        boolean nutsChecked = nuts.isChecked();
        if (nutsChecked){
            toppings = " nuts";
        }

        TextView yourTreatText = (TextView)findViewById(R.id.resultTextView);
        yourTreatText.setText("Your " + nameValue + " is a " + flavorValue + treatType + " with " + toppings);

        ImageView treatImage = (ImageView)findViewById(R.id.ice_cream_image);
        if (flavorValue.equals("death by chocolate")){
            treatImage.setImageResource(R.drawable.chocolate);
            iceCreamShop = "Glacier";
            iceCreamShopURL = "http://www.glaciericecream.com/";
        }
        if (flavorValue.equals("cookies and cream")){
            treatImage.setImageResource(R.drawable.cookiescream);
            iceCreamShop = "Sweet Cow";
            iceCreamShopURL = "http://www.sweetcowicecream.com/";
        }
        if (flavorValue.equals("salted caramel")){
            treatImage.setImageResource(R.drawable.caramel);
            iceCreamShop = "Fior di Latte";
            iceCreamShopURL = "http://fiordilattegelato.com/";
        }
        System.out.println(iceCreamShop);
        System.out.println(iceCreamShopURL);

    }

    public void findTreatButton(View view){
        Button getTreat = (Button)findViewById(R.id.findTreatButton);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                generateTreatButton(view);
            }
        };
        getTreat.setOnClickListener(onclick);

        Intent intent = new Intent(this, FindStoreActivity.class);
        intent.putExtra("suggestShop",iceCreamShop);
        intent.putExtra("suggestShopURL", iceCreamShopURL);

        startActivity(intent);



    }
}
