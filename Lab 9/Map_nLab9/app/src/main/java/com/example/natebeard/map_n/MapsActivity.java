package com.example.natebeard.map_n;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    // mMap object that is the actual map that we see

    // Right click, Generate, Methods, just four of them... (the above?)
    // My API Link: https://console.developers.google.com/flows/enableapi?apiid=maps_android_backend&keyType=CLIENT_SIDE_ANDROID&r=7B:2A:9E:C7:B4:6F:A2:62:93:AE:46:F6:19:98:22:52:35:6E:FA:73;com.example.natebeard.map_n&pli=1
    // If you create a new google map app, you need to generate a new API key by going into the console and adding another package then copying
    // package has to be listed under API key

    // Defining at class level so they can be used in all methods

    private LocationRequest mLocationRequest;
    // requests object that stores parameters for requests that are sent to the FusedLocationProviderApi

    //location where the device is currently located
    private Location mCurrentLocation;

    // marker for current location
    private Marker mCuurentLocationMarker;

    private GoogleApiClient mGoogleApiClient;
    // Entry point for Google Play services used by the Places API and Fused Location Provider


    // can be any value >0
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;
    // need to make it a constant ("final") because...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        checkLocationPermission(); // calling check permission method here
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //set a callback object which will be triggered when GoogleMap Instance is ready to be used
        mapFragment.getMapAsync(this);
        buildGoogleApiClient();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // googleMap = "view"? so it loads the google map view rather than the view?

        // set map type
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // check for permission
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // enables location layer
            mMap.setMyLocationEnabled(true);
        }
        /*
        // Add a marker in Sydney and move the camera
        LatLng = new LatLng(-34,151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
         */

    }



    // what is "synchronized"
    private synchronized void buildGoogleApiClient() {
        //GoogleApiClient class is the main entry point for integrating with Google Play services
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this) // connection callbacks are called when client is connected/disconnected
                .addOnConnectionFailedListener(this) // handles failed attempt of connect client to service
                .addApi(LocationServices.API) // adds the Google Play Service LocationServices API
                .build(); // builds GoogleApiClient object on the view
        mGoogleApiClient.connect(); // connect client
    }

    // if this isn't being called, might want to move this function to a different place?
    @Override // Why Override again?
    public void onConnected(@Nullable Bundle bundle) { //why @Nullable Bundle bundle?
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000); //set desired inteval for active location updates (milliseconds)
        mLocationRequest.setFastestInterval(1000); //set fastest interval for location updates (milliseconds)
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY); //set priority of request... why?

        // check for permission
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //request location updates
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        //set current location to the new location
        mCurrentLocation = location;

        //define an object of the Google LatLng class with location coordinates
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //check to see if there's a current marker
        if (mCuurentLocationMarker == null){
            //define object of Google MarkerOptions class
            MarkerOptions makerOptions = new MarkerOptions();
            makerOptions.position(latLng);
            makerOptions.title("Current Position");

            // place current location marker
            mCuurentLocationMarker = mMap.addMarker(makerOptions);
        } else{
            //set position of existing marker
            mCuurentLocationMarker.setPosition(latLng);
        }

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    public void checkLocationPermission(){
        //check permission
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                //returns true if the app has requested this permission previously and the user denied the request

                //show explanation to user *asynchronously* -- don't block this thread wating for user's response!
                //After user sees explanation, try again to request permission

                //request permission once explanation has been shown
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                //if request is canceled, result arrays are empty (so testing grantResults > 0
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //permission was granted
                    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                        Toast.makeText(this, "permission granted", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
            }
        }

        // add other 'case' lines to check for other permissions your app might request
    }

}
