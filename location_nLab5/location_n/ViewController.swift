//
//  ViewController.swift
//  location_n
//
//  Created by Nathan Beard on 10/4/16.
//  Copyright © 2016 natebeard_. All rights reserved.
//

import UIKit
import MapKit
import CoreLocation

class ViewController: UIViewController, CLLocationManagerDelegate {

    @IBOutlet weak var mapView: MKMapView!
    
    var locationManager = CLLocationManager()
    var annotation = MKPointAnnotation()
    
    override func viewDidLoad() {
        mapView.mapType=MKMapType.Hybrid //hybrid with map and satellite
        let status = CLLocationManager.authorizationStatus()
        if status == CLAuthorizationStatus.NotDetermined {
            locationManager.requestWhenInUseAuthorization()
        }
        locationManager.delegate=self
        locationManager.desiredAccuracy=kCLLocationAccuracyBest // specify the desired accuracy
        locationManager.distanceFilter=kCLDistanceFilterNone //specify distance device must move laterally (meters) to generate update. We specify to be noticed of all movements
        mapView.showsUserLocation=true
        
        super.viewDidLoad()
    }
    
    
    
    //CLLocationManagerDelegate methods
    
    //called when a new location value is available 
    //check steve morse .org for long/lat of my location in simulator
    func locationManager(manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        let span = MKCoordinateSpanMake(0.05, 0.05) // defines the area spanned by a map region
        let region = MKCoordinateRegionMake(manager.location!.coordinate, span) // region of the map to be displayed
        mapView.setRegion(region, animated: true)
        
        // annotations add markers to the map to represent our location
        annotation.coordinate=manager.location!.coordinate
        annotation.title="You are here"
        annotation.subtitle="Latitude: \(manager.location!.coordinate.latitude), Longitude: \(manager.location!.coordinate.longitude)"
        mapView.addAnnotation(annotation)
    }
    
    
    // called when the authorization status for the application changed.
    func locationManager(manager: CLLocationManager, didChangeAuthorizationStatus status: CLAuthorizationStatus) {
        if status == CLAuthorizationStatus.AuthorizedWhenInUse {
            locationManager.startUpdatingLocation() // starts the location manager
        }
    }
    
 
    //called when a location cannot be determined
    func locationManager(manager: CLLocationManager, didFailWithError error: NSError) {
        var errorType=String()
        if let CLError=CLError(rawValue: error.code) {
            if CLError == .Denied {
                errorType="access denied"
                let alert=UIAlertController(title: "Error", message: errorType, preferredStyle: UIAlertControllerStyle.Alert)
                let okAction:UIAlertAction=UIAlertAction(title: "OK", style: UIAlertActionStyle.Default, handler: nil)
                alert.addAction(okAction)
                presentViewController(alert, animated: true, completion: nil)
            }
        }
    }
    
    
    

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

