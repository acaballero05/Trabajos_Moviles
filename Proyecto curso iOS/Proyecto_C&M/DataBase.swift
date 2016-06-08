//
//  DataBase.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 3/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import UIKit
import SQLite

class DataBase {
    
    private var db:Connection
    var ListMensaje:[Mensaje]=[Mensaje]()
    private var table_name:Table
    private var idcolumn:Expression<Int>
    private var decolumn:Expression<Int>
    private var paracolumn:Expression<Int>
    private var mensajecolumn:Expression<String>
    
    init(){
        let path = NSSearchPathForDirectoriesInDomains(.DocumentDirectory, .UserDomainMask, true).first!
        
        db = try! Connection("\(path)/db.sqlite3")

        
        table_name = Table("Mensajes")
        idcolumn = Expression<Int>("id")
        decolumn = Expression<Int>("de")
        paracolumn = Expression<Int>("para")
        mensajecolumn = Expression<String>("mensaje")
        
        //try! db.run(tasks.drop(ifExists: true))
        try! db.run(table_name.create(ifNotExists: true) { t in
            t.column(idcolumn, primaryKey: PrimaryKey.Autoincrement)
            t.column(decolumn)
            t.column(paracolumn)
            t.column(mensajecolumn)
            })
    }
    
    func insertData(de:Int, para:Int, mensaje:String) {
        try! db.run(table_name.insert(decolumn  <- de, paracolumn <- para, mensajecolumn <- mensaje))
    }
    
    func getAllData(from:Int, to:Int){
        let query = table_name.filter((decolumn == from && paracolumn == to) || (decolumn == to && paracolumn == from))
        let mensaje = Array(try! db.prepare(query))
        for m in mensaje{
            ListMensaje.append(Mensaje(ID:m.get(idcolumn), FROM: m.get(decolumn), TO: m.get(paracolumn), TEXT: m.get(mensajecolumn)));
        }
        
    }
    
    
    func count() -> Int {
        return db.scalar(table_name.count)
    }
    
}