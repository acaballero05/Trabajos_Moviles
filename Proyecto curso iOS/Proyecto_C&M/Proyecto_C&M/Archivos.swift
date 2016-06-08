//
//  Archivos.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 8/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import UIKit

class Archivos: UIViewController, UITableViewDataSource{
    
    var idFrom:Int?
    var idTo:Int?
    var NameOtro:String?
    var Controlador:File_Manager = File_Manager()
    @IBOutlet var Nome: UIButton!
    @IBOutlet var tableView: UITableView!
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell:CustomTableFiles=tableView.dequeueReusableCellWithIdentifier("FILESS") as! CustomTableFiles
        let task = Controlador.getArchivo(indexPath.row)
        cell.Textos?.setTitle(task?.getName(), forState: UIControlState.Normal)
        //cell!.text=task.getNombre()
        return cell
        
    }
    
    @IBAction func Descarga(sender: AnyObject) {
        //let idfile = Controlador.getArchivo((tableView.indexPathForSelectedRow?.row)!)!
        //GetArchivoRest.ObtenerArchivo(idfile.getId())
        debugPrint(tableView.indexPathForSelectedRow?.row)
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return Controlador.lenMensaje()
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        Nome.setTitle(NameOtro, forState: UIControlState.Normal)
        Controlador.getArchivos(idFrom!, idTo: idTo!)
        let seconds = 2.0
        let delay = seconds*Double(NSEC_PER_SEC)
        let dispachtime = dispatch_time(DISPATCH_TIME_NOW,Int64(delay))
        dispatch_after(dispachtime, dispatch_get_main_queue(), {
            self.viewWillAppear(true)
        })
        //fromid = idFrom!
        
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    override func viewWillAppear(animated: Bool) {
        tableView.reloadData()
    }
    
    
    
}
