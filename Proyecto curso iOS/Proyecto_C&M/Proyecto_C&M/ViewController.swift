//
//  ViewController.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 3/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var idF:Int = 0
    
    @IBOutlet var rada: UIButton!
    
    @IBOutlet var caba: UIView!
    @IBOutlet var gonza: UIView!
    
    @IBOutlet var villa: UIView!
    @IBOutlet var mogo: UIView!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if (segue.identifier == "OpenContacts"){
            switch sender as! NSObject {
            case self.rada:
                idF=1
            case self.gonza:
                idF=2
            case self.caba:
                idF=3
            case self.mogo:
                idF=4
            case self.villa:
                idF=5
            default:
                idF=2
            }
        }
        (segue.destinationViewController as! Contacts).idFrom = Int(idF)
        //_ = Contacts.initialize()
    }
}

