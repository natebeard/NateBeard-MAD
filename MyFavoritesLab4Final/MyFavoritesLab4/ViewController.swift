//
//  ViewController.swift
//  MyFavoritesLab4
//
//  Created by Nathan Beard on 9/27/16.
//  Copyright © 2016 natebeard_. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var bookLabel: UILabel!
    @IBOutlet weak var authorLabel: UILabel!
    @IBOutlet weak var publishDate: UILabel!
    
    
    var user = Favorites()
    
    // supposed to update labels...
    @IBAction func unwindSegue(segue: UIStoryboardSegue) {
        bookLabel.text=user.favBook
        authorLabel.text=user.favAuthor
        publishDate.text=user.favDate 
    }
        
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

