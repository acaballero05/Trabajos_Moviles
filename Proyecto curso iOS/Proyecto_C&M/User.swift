//
//  User.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 3/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import Foundation

class User {
    private var userId=0
    private var userName=" "
    private var nombre=" "
    
    init (UsId:Int, UsN:String,Na:String){
        self.userId=UsId
        self.userName=UsN
        self.nombre=Na
    }
    
    func getUserId() -> Int{
        return userId
    }
    
    func getUserName() -> String{
        return userName
    }
    
    func getNombre() -> String{
        return nombre
    }
}



