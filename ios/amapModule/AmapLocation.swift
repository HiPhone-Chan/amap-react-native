//
//  AmapLocation.swift
//  amap
//
//  Created by 陈海锋 on 2017/8/17.
//  Copyright © 2017年 陈海锋. All rights reserved.
//

import Foundation

@objc(AmapLocation)
class AmapLocation: NSObject, AMapLocationManagerDelegate {
    
    var locationManager: AMapLocationManager;
    
    var location: String;
    
    override init() {
        locationManager = AMapLocationManager();
        location = "";
    }
    
    @objc func startLocation()  {
        locationManager.distanceFilter = 10;
        locationManager.startUpdatingLocation();
        locationManager.delegate = self;
    }
    
    @objc func getLocation() -> String {
       return location;
    }
    
    @objc func stopLocation()  {
        locationManager.stopUpdatingLocation();
    }
    
    func amapLocationManager(_ manager: AMapLocationManager!, didUpdate updateLocation: CLLocation!) {
        let coordinate = updateLocation.coordinate;
        location = String(format: "%f,%f", coordinate.longitude, coordinate.latitude);
    }
    
}
