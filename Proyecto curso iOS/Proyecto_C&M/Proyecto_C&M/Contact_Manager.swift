//
//  Contact_Manager.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 4/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import Foundation

class Contact_Manager {
    private  var List = [User]()
    
    
    func addUser(user:User) {
        List.append(user)
    }
    
    func getUsers(index:Int) {
        let panela = GetContactoRest.init()
        panela.TraerContacts(index)
        let seconds = 1.0
        let delay = seconds*Double(NSEC_PER_SEC)
        let dispachtime = dispatch_time(DISPATCH_TIME_NOW,Int64(delay))
        dispatch_after(dispachtime, dispatch_get_main_queue(), {
            self.List = panela.List
        })
        
    }
    
    
    func lenUser() -> Int {
        return List.count
    }
    
    func getUser(index:Int)->User?{
        if (index>=0 && index<=List.count){
            return List[index]
        }
        return nil;
    }
}