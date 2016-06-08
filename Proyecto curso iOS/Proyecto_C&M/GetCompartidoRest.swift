//
//  GetCompartidoRest.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 8/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

class GetCompartidoRest{
    
    var compartidos :[Archivo] = [Archivo]()
    func TraerCompartidos(idFrom:Int,idTo:Int){
        
        
        Alamofire.request(.GET, "http://10.5.99.70:8191/rest/shared_files/"+String(idFrom)+"/"+String(idTo))
            .responseJSON { response in
                guard response.result.error == nil else {
                    debugPrint("error calling GET on /messages/")
                    debugPrint(response.result.error!)
                    return
                }
                
                if let value = response.result.value{
                    // handle the results as JSON, without a bunch of nested if loops
                    let todo = JSON(value)
                    // now we have the results, let's just print them though a tableview would definitely be better UI:
                    
                    if let items = todo.array
                    {
                        
                        for item in items{
                            
                            let Con = Archivo(ID: Int(String(item["id"]))!, FROM: Int(String(item["from"]))!, TO: Int(String(item["to"]))!, contentType:String(item["contentType"]), name:String(item["name"]))
                            
                            self.compartidos.append(Con)
                        }
                        
                    }
                    
                }
        }
        
        
        
        /*Alamofire.request(.GET, "http://172.17.17.243:8191/rest/contacts/1").responseJSON(options: NSJSONReadingOptions.AllowFragments) { (requests, response, data, error) in debugPrint(data)}*/
    }
}