//
//  Chat.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 8/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import UIKit

class Chat: UIViewController, UITableViewDataSource{
    
    var idFrom:Int?
    var idTo:Int?
    var NameOtro:String?
    var Controlador:Chat_Manager = Chat_Manager()
    var db:DB_Manager=DB_Manager()
    var data:DataBase=DataBase()
   
    @IBOutlet var Nome: UIButton!
    
    @IBOutlet var Texto: UITextField!
    @IBOutlet var tableView: UITableView!
   
    
    
    @IBAction func Refrescar(sender: AnyObject) {

        Controlador.getMensajes(idFrom!, idTo: idTo!)
        let Msj = Controlador.List
        for m in Msj{
            data.insertData(idFrom!, para: idTo!, mensaje: String(m.getText()))
        }
        viewDidLoad()
    }
    
    @IBAction func Enviar(sender: AnyObject) {
        let chuspa = Texto.text
        data.insertData(idFrom!, para: idTo!, mensaje: chuspa!)
        PostMensajeRest.PostMensaje(idFrom!, to: idTo!, text: chuspa!)
    }
    
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:CustomTableChat=tableView.dequeueReusableCellWithIdentifier("Chancla") as! CustomTableChat
        let task = db.getMsg(indexPath.row)
        var Efrain = ""
        if (task?.getFrom()==self.idFrom){
            Efrain="Yo: "+(task?.getText())!
        }
        else{
            Efrain=NameOtro!+": "+(task?.getText())!
        }
        cell.Textos?.text = Efrain
        debugPrint(task?.getText())
        //cell!.text=task.getNombre()
        return cell
        
    }
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return db.lenMsg()
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        Nome.setTitle(NameOtro, forState: UIControlState.Normal)
        db.getMsgs(idFrom!, idto: idTo!)
        let seconds = 2.0
        let delay = seconds*Double(NSEC_PER_SEC)
        let dispachtime = dispatch_time(DISPATCH_TIME_NOW,Int64(delay))
        dispatch_after(dispachtime, dispatch_get_main_queue(), {
            self.viewWillAppear(true)
        })
        //fromid = idFrom!
        
        
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        
        if(segue.identifier == "OpenArchivos"){
            (segue.destinationViewController as! Archivos).idFrom = Int(self.idFrom!)
            (segue.destinationViewController as! Archivos).idTo = Int(self.idTo!)
            (segue.destinationViewController as! Archivos).NameOtro = String(self.NameOtro!)
            debugPrint(Int(self.idFrom!))

            
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