//
//  Contacts.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 4/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import UIKit

class Contacts: UIViewController, UITableViewDataSource{
    
    var idFrom:Int?
    var idDestino:Int?
    var Destinatario:User?
    
    var Controlador:Contact_Manager = Contact_Manager()

    
    @IBOutlet var tableView: UITableView!

    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:CustomTableViewCell=tableView.dequeueReusableCellWithIdentifier("Conta") as! CustomTableViewCell
        let task = Controlador.getUser(indexPath.row)
        cell.lblNombre?.text = task?.getUserName()
        return cell
        
    }
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return Controlador.lenUser()
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        Controlador.getUsers(idFrom!)
        let seconds = 2.0
        let delay = seconds*Double(NSEC_PER_SEC)
        let dispachtime = dispatch_time(DISPATCH_TIME_NOW,Int64(delay))
        dispatch_after(dispachtime, dispatch_get_main_queue(), {
            self.viewWillAppear(true)
        })
       
        
    }

    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        
        if(segue.identifier == "OpenChat"){
            
            
            Destinatario = Controlador.getUser((tableView.indexPathForSelectedRow?.row)!)!
            
            (segue.destinationViewController as! Chat).idFrom = Int(self.idFrom!)
            (segue.destinationViewController as! Chat).idTo = Int((self.Destinatario?.getUserId())!)
            (segue.destinationViewController as! Chat).NameOtro = String((self.Destinatario?.getUserName())!)
            debugPrint(Int(self.idFrom!))
            debugPrint(Int((Destinatario?.getUserId())!))
            
        }
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    override func viewWillAppear(animated: Bool) {
        tableView.reloadData()
    }
    

}
