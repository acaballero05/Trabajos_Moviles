//
//  Chat_Manager.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 8/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import Foundation

class Chat_Manager {
    internal  var List = [Mensaje]()
    
    
    func addMensaje(msj:Mensaje) {
        List.append(msj)
    }
    
    func getMensajes(idFrom:Int,idTo:Int) {
        let panela = GetMensajeRest.init()
        panela.TraerMensajes(idTo, idTo: idFrom)
        let seconds = 1.0
        let delay = seconds*Double(NSEC_PER_SEC)
        let dispachtime = dispatch_time(DISPATCH_TIME_NOW,Int64(delay))
        dispatch_after(dispachtime, dispatch_get_main_queue(), {
            self.List = panela.List
            for m in self.List{
                debugPrint(m.getText())
            }
        })
        
    }
    
    
    func lenMensaje() -> Int {
        return List.count
    }
    
    func getMensaje(index:Int)->Mensaje?{
        if (index>=0 && index<=List.count){
            return List[index]
        }
        return nil;
    }
}