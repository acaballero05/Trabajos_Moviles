//
//  Archivo.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 3/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import Foundation
class Archivo {
    private var id=0
    private var name=" "
    private var contentType=" "
    private var from=0
    private var to=0
    private var date=" "
    
    init(ID:Int,FROM:Int,TO:Int,contentType:String,name:String){
        self.id = ID
        self.from = FROM
        self.to = TO
        self.contentType=contentType
        self.name=name
        
    }
    
    func getFrom() -> Int {
        return from
    }
    
    func getId() -> Int {
        return id
    }
    func getTo() -> Int {
        return to
    }
    
    func getContentType() -> String {
        return contentType
    }
    
    func getDate() -> String {
        return date
    }
    
    func getName() -> String {
        return name
    }
}

