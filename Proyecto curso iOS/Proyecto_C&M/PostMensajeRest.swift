//
//  PostMensajeRest.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 8/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

class PostMensajeRest {
    typealias Model = [[String: AnyObject]]
    
    static func PostMensaje(from:Int,to:Int,text:String) {
        let mensaje : Dictionary<String,AnyObject> = Dictionary<String,AnyObject>(dictionaryLiteral: ("from",from),("to",to),("text",text))
        Alamofire.request(.POST,"http://10.5.99.70:8191/rest/messages/", parameters: mensaje, encoding: .JSON)
    }
}