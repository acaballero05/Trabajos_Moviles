//
//  DB_Manager.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 8/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//



import Foundation

class DB_Manager {
    private  var List = [Mensaje]()
    
    
    func getMsgs(idfrom:Int, idto:Int) {
        let panela = DataBase.init()
        
        let seconds = 1.0
        let delay = seconds*Double(NSEC_PER_SEC)
        let dispachtime = dispatch_time(DISPATCH_TIME_NOW,Int64(delay))
        panela.getAllData(idfrom, to: idto)
        dispatch_after(dispachtime, dispatch_get_main_queue(), {
            self.List = panela.ListMensaje})
        
    }
    
    
    func lenMsg() -> Int {
        return List.count
    }
    
    func getMsg(index:Int)->Mensaje?{
        if (index>=0 && index<=List.count){
            return List[index]
        }
        return nil;
    }
}