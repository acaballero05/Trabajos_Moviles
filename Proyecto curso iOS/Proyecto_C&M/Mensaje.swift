//
//  Mensaje.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 3/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import Foundation

class Mensaje {
    private var id=0
    private var from=0
    private var to=0
    private var text=" "
    private var date=" "
    
    init(ID:Int,FROM:Int,TO:Int,TEXT:String){
        self.id = ID
        self.from = FROM
        self.to = TO
        self.text=TEXT
    }
    
    func getDate() -> String {
        return date
    }
    
    func getTo() -> Int {
        return to
    }
    
    func getId() -> Int {
        return id
    }
    
    func getFrom() -> Int {
        return from
    }
    
    func getText() -> String {
        return text
    }
}