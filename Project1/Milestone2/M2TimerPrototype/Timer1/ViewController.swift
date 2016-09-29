//
//  ViewController.swift
//  Timer1
//
//  Created by Nathan Beard on 9/28/16.
//  Copyright © 2016 natebeard_. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    
    @IBOutlet weak var timerLabel: UILabel!
    @IBOutlet weak var breatheLabel: UILabel!
    
    
    
    var seconds = 0
    var timer = NSTimer()
    var timerIsOn = false
    var startButtonIsOn = true
    var breathe = false
    
    
    @IBAction func startButton(sender: UIButton) {
        
        if timerIsOn == false {
        timer = NSTimer.scheduledTimerWithTimeInterval(1, target: self, selector: (#selector(ViewController.updateTimer)), userInfo: nil, repeats: true)
            timerIsOn = true
            startButtonIsOn = true
        }
        
    }
    
    
    @IBAction func stopButton(sender: UIButton) {
        timer.invalidate()
        seconds = 0
        timerLabel.text = "\(seconds)"
        timerIsOn = false // need this b/c if timer is running, shouldn't start a new timer by hitting start again
    }
    
    func updateTimer() {
        seconds += 1
        timerLabel.text = "\(seconds)"
        
        if timerLabel.text == "11" {
            restartTimer()
            updateBreatheLabel()
        }
        
    }
    
    
    func startTimer() {
        timer = NSTimer.scheduledTimerWithTimeInterval(1, target: self, selector: (#selector(ViewController.updateTimer)), userInfo: "timer", repeats: true)
    }
    
    
    func restartTimer () {
        timer.invalidate()
        seconds = 0
        timerLabel.text = "\(seconds)"
        startTimer()
    }
    
    
    
    
    func updateBreatheLabel(){
        if breathe == false {
            breatheLabel.textColor=UIColor.redColor()
            breathe = true
        } // trying to change from blue to red...
        
        if breathe == true {
            breatheLabel.textColor=UIColor.blueColor()
            breathe = false
        }
        
    }
    
    
 
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

