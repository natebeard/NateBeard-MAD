//
//  ViewController.swift
//  Lab1
//
//  Created by Nathan Beard on 8/30/16.
//  Copyright © 2016 natebeard_. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    @IBAction func chooseImage(sender: UIButton) {
        if sender.currentTitle=="Star Wars" {
            robotImage.image=UIImage(named:"robotStarWars")
            label.text = "Father and son time"
            
        }
        else if sender.currentTitle=="Star Trek" {
            robotImage.image=UIImage(named: "robotStarTrek")
            label.text = "Vulcan nerve pinch"
        }
        
    }
    
    
    @IBOutlet weak var robotImage: UIImageView!
    
    
    @IBOutlet weak var label: UILabel!
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

