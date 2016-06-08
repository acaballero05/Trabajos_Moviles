//
//  GetArchivoRest.swift
//  Proyecto_C&M
//
//  Created by Estudiantes on 4/06/16.
//  Copyright © 2016 javerianacali. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

class GetArchivoRest{
    
    static func ObtenerArchivo(ID:Int){
        Alamofire.download(.GET, "http://10.5.99.70:8191/rest/files/"+String(ID), destination: Alamofire.Request.suggestedDownloadDestination())
        .progress { bytesRead, totalBytesRead, totalBytesExpectedToRead in
        print(totalBytesRead)
        debugPrint(Alamofire.Request.suggestedDownloadDestination())
        dispatch_async(dispatch_get_main_queue()) {
            print("Total bytes read on main queue: \(totalBytesRead)")
        }
            }
            .response { _, _, _, error in
                if let error = error {
                    print("Failed with error: \(error)")
                } else {
                    print("Downloaded file successfully")
                }
        }
    }
}