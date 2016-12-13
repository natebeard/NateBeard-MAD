//
//  ViewController.swift
//  Timer1
//
//  Created by Nathan Beard on 9/28/16.
//  Copyright © 2016 natebeard_. All rights reserved.
//

import UIKit
import AVFoundation

class ViewController: UIViewController {

    
    @IBOutlet weak var globeImage: UIImageView!
    @IBOutlet weak var background: UIImageView!
    @IBOutlet weak var timerLabel: UILabel!
    @IBOutlet weak var breatheLabel: UILabel!
    
    
    var audioPlayer = AVAudioPlayer()
    var seconds = 0
    var loop10 = true
    var timer = NSTimer()
    var timerIsOn = false
    var startButtonIsOn = true
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    
    @IBAction func startButton(sender: UIButton) {
        
        let alert=UIAlertController(title: "Ready to mediate?", message: "Breathe in for 10 seconds then out for 15.", preferredStyle: UIAlertControllerStyle.Alert)
        let cancelAction=UIAlertAction(title: "Cancel", style: UIAlertActionStyle.Cancel, handler: nil)
        alert.addAction(cancelAction)
        let okAction=UIAlertAction(title: "I'm ready!", style: UIAlertActionStyle.Default, handler:
            { action in
                
                let oceanSound = NSURL(fileURLWithPath: NSBundle.mainBundle().pathForResource("OceanWaves", ofType: "mp3")!)
                self.audioPlayer = try! AVAudioPlayer(contentsOfURL: oceanSound)
                self.audioPlayer.numberOfLoops = -1
                self.audioPlayer.prepareToPlay()
                self.audioPlayer.play()
                
                if self.timerIsOn == false {
                    self.timer = NSTimer.scheduledTimerWithTimeInterval(1.0, target: self, selector: #selector(ViewController.updateTimer), userInfo: 10, repeats: true)
                    self.timerIsOn = true
                    self.startButtonIsOn = true
                    self.breatheLabel.text = "Breathe in"
                    UIView.animateWithDuration(10.0, animations: {
                        self.background.alpha = 0
                        let grow = CGAffineTransformMakeScale(2, 2)
                        let angle = CGAffineTransformMakeRotation(2)
                        self.globeImage.transform = CGAffineTransformConcat(grow, angle)
                    })
                }
            }
        )
        alert.addAction(okAction)
        presentViewController(alert, animated: true, completion: nil)
    }
    
    @IBAction func stopButton(sender: UIButton) {
        timer.invalidate()
        seconds = 0
        timerLabel.text = "\(seconds)"
        timerIsOn = false // need this b/c if timer is running, shouldn't start a new timer by hitting start again
        audioPlayer.stop()
    }
    
    func updateTimer(time: NSTimer) {
        seconds += 1
        timerLabel.text = "\(seconds)"
        updateNextTimer()
    }
    
    func updateNextTimer() {
        if loop10 == true {
            if seconds ==  11 {
                restartTimer()
            }
        } else {
            if seconds == 16 {
                restartTimer()
            }
        }
    }

    func startNewTimer(t:Int) {
        timer = NSTimer.scheduledTimerWithTimeInterval(1, target: self, selector: #selector(ViewController.updateTimer), userInfo: t, repeats: true)
        // if userInfo = t then I can get rid of the two functions that I'm calling above...
    }
    
    // restartTimer tells updateNextTimer to stop timer, start seconds at 0, and startNewTimer function with new t value
    func restartTimer () {
        timer.invalidate()
        seconds = 0
        timerLabel.text = "\(seconds)"
        
        if loop10 == true {
            loop10 = false
            startNewTimer(15)
            breatheLabel.text = "Breathe out"
            UIView.animateWithDuration(15.0, animations: {
                self.background.alpha = 1.0
                let grow = CGAffineTransformMakeScale(-1, -1)
                let angle = CGAffineTransformMakeRotation(-1)
                self.globeImage.transform = CGAffineTransformConcat(grow, angle)
            })
        } else {
            loop10 = true
            startNewTimer(10)
            breatheLabel.text = "Breathe in"
            UIView.animateWithDuration(10.0, animations: {
                self.background.alpha = 0
                let grow = CGAffineTransformMakeScale(2, 2)
                let angle = CGAffineTransformMakeRotation(1)
                self.globeImage.transform = CGAffineTransformConcat(grow, angle)
            })
        }
    }
 
    
    


}

