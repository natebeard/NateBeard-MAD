//
//  ViewController.swift
//  tipcalculator
//
//  Created by Nathan Beard on 9/20/16.
//  Copyright © 2016 natebeard_. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    
    @IBOutlet weak var checkAmount: UITextField!
    @IBOutlet weak var tipPercent: UITextField!
    @IBOutlet weak var people: UITextField!
    @IBOutlet weak var tipDue: UILabel!
    @IBOutlet weak var totalDue: UILabel!
    @IBOutlet weak var totalDuePerPerson: UILabel!
    
    
    // refreshUI clears saved data from app when app goes from background to foreground
    
    
    // resign first responder resigns whatever the user is interacting with (makes the window go away)
    // it's a boolean so need a boolean statement at the end
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    
    @IBAction func onTapGestureRecognized(sender: UITapGestureRecognizer) {
        checkAmount.resignFirstResponder()
        tipPercent.resignFirstResponder()
        people.resignFirstResponder()
    }
    
    
    // Need to change checkAmount var to a float because it's a String right now?
    // need double unwrap below
    // this function does all the calculations in between the textfields and labels below
    func updateTipTotals() {
        var amount:Float // check amount
        var pct:Float // tip %
        
        // QUESTION: What does thread breakpoint 1.1 mean?
        if checkAmount.text!.isEmpty {
            amount = 0.0
        } else {
            amount = Float(checkAmount.text!)! // double unwrap
        }
        if tipPercent.text!.isEmpty {
            pct = 0.0
        } else {
            pct = Float(tipPercent.text!)!/100
        }
        
        
        let numberOfPeople=Int(people.text!) // returns optional
        let tip=amount*pct
        let total=amount+tip
        var personTotal : Float = 0.0 // Specify Float so it's not a Double... why is a double bad?
        if numberOfPeople != nil {
            if numberOfPeople! > 0 {
                personTotal = total / Float(numberOfPeople!)
            } else {
                // create UIAlertController object... which means it can be a constant
                let alert=UIAlertController(title: "Warning", message: "Number of people must be greater than 0", preferredStyle: UIAlertControllerStyle.Alert)
                let cancelAction=UIAlertAction(title:"Cancel", style:UIAlertActionStyle.Cancel, handler: nil)
                // handler is what happens when you click a button...
                // addAction adds alert that we just created
                alert.addAction(cancelAction) // adds alert action to alert object
                let okAction=UIAlertAction(title: "OK", style: UIAlertActionStyle.Default, handler: {
                    action in
                    self.people.text="1"
                    self.updateTipTotals()})
                    // Change numberOfPeople to 1
                
                alert.addAction(okAction) // present alert
                presentViewController(alert, animated: true, completion: nil)
                }
                // then create UIAlertAction and handler = a block/closer/end action and use "action in"
                // alert.addAction(okAction) initializes action
            }
        
        
        // Go through NSNumberFormatter --> numberStyle --> currencyStyle (stringFromNumber is there too
        // format results as currency
        // NSNumberFormatter = class with number styles and behaviors
        // numberStyle = property
        // NSNumberFormatterStyle contains the styles i.e. CurrencyStyle
        // text is the property that shows on the label
        // .stringFromNumber returns a string containing the formatted value of the provided number object
        
        let currencyFormatter = NSNumberFormatter()
        currencyFormatter.numberStyle = NSNumberFormatterStyle.CurrencyStyle // set the number style
        tipDue.text=currencyFormatter.stringFromNumber(tip) // returns a formatted string
        totalDue.text=currencyFormatter.stringFromNumber(total)
        totalDuePerPerson.text=currencyFormatter.stringFromNumber(personTotal)
        }
        
        
    
    
    // check out textFieldDidEndEditing
    
    func textFieldDidEndEditing(textField: UITextField) {
        updateTipTotals()
    }
   
    
    
    
    // stuff that happens only once, then stored in memory and kept
    // viewWillAppear or viewDidAppear makes things intialize everytime a certain view appears
    override func viewDidLoad() {
        checkAmount.delegate=self
        tipPercent.delegate=self
        people.delegate=self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

