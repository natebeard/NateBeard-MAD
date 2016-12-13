package com.example.natebeard.lab8burrito;

/**
 * Created by NateBeard on 11/30/16.
 */

public class BurritoShop {
    private String burritoShop;
    private String burritoShopURL;

    private void setBurritoInfo(Integer burritoType) {
        switch (burritoType){
            case -1:
                burritoShop="no";
                burritoShopURL="none";
                break;
            case R.id.radioButton:
                burritoShop="Santiago's";
                burritoShopURL="http://eatatsantiagos.com/Boulder";
                break;
            case R.id.radioButton2:
                burritoShop="Cafe Mexicali";
                burritoShopURL="http://www.cafemexicali.com/";
                break;
            default:
                burritoShop="none";
                burritoShopURL="https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=burritos%20boulder%20colorado";
        }
    }

    public void setBurritoShop(Integer burritoType){
        setBurritoInfo(burritoType);
    }

    public void setBurritoShopURL(Integer burritoType){
        setBurritoInfo(burritoType);
    }

    public String getBurritoShop(){
        return burritoShop;
    }

    public String getBurritoShopURL(){
        return burritoShopURL;
    }

}
