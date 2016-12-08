package com.example.natebeard.finalpractice;

/**
 * Created by NateBeard on 12/7/16.
 */



public class Place {

    private String placeName;
    private String placeURL;
    private String placeImage;

    public void setPlaceInfo(Integer placeForYou){
        switch (placeForYou){
            case -1:
                placeName = "Lame";
                placeURL = "http://www.10best.com/destinations/colorado/boulder/nightlife/";
                placeImage ="lame";
                break;
            case 1:
                placeName = "Bitter Bar";
                placeURL = "http://www.thebitterbar.com/";
                placeImage = "bitter";
                break;
            case 2:
                placeName = "The Kitchen";
                placeURL = "http://thekitchen.com/";
                placeImage = "kit";
                break;
            case 3:
                placeName = "The Outback Saloon";
                placeURL = "http://www.outbacksaloon.net/";
                placeImage = "saloon";
                break;
            default:
                placeName = "lame";
                placeURL = "http://www.10best.com/destinations/colorado/boulder/nightlife/";
                placeImage = "lame";
        }
    }

    public void setPlaceName(Integer placeForYou){
        setPlaceInfo(placeForYou);
    }
    public void setPlaceURL(Integer placeForYou){
        setPlaceInfo(placeForYou);
    }
    public void setPlaceImage(Integer placeForYou){
        setPlaceImage(placeForYou);
    }
    public String getPlaceImage(){
        return placeImage;
    }
    public String getPlaceName(){
        return placeName;
    }
    public String getPlaceURL(){
        return placeURL;
    }




}
