//
//  AmapNavigation.swift
//  amap
//
//  Created by 陈海锋 on 2017/8/18.
//  Copyright © 2017年 陈海锋. All rights reserved.
//

import Foundation

@objc(AmapNavigation)
class AmapNavigation: NSObject, AMapNaviCompositeManagerDelegate {
    
    
    var navigationManager: AMapNaviCompositeManager!;

    override init() {
    }

    @objc func startNavi(map: [String:NSObject]) {
        if  navigationManager == nil {
            navigationManager = AMapNaviCompositeManager.init();
            navigationManager.delegate = self;
        }
        
        let config = AMapNaviCompositeUserConfig.init();
        let name = map["name"] as! String;
        let coordinate = map["coordinate"] as! String;
        let longLat = coordinate.components(separatedBy: ",");
        let longitude = CGFloat((longLat[0] as NSString).floatValue);
        let latitude = CGFloat((longLat[1] as NSString).floatValue);
        
        config.setRoutePlanPOIType(AMapNaviRoutePlanPOIType.end, location: AMapNaviPoint.location(withLatitude: latitude, longitude: longitude), name: name, poiId: nil);
        navigationManager.presentRoutePlanViewController(withOptions: config);

    }
    
    func compositeManager(_ compositeManager: AMapNaviCompositeManager, error: Error) {
        let error = error as NSError
        NSLog("error:{%d - %@}", error.code, error.localizedDescription)
    }
    
    func compositeManager(onCalculateRouteSuccess compositeManager: AMapNaviCompositeManager) {
    }
    
    func compositeManager(_ compositeManager: AMapNaviCompositeManager, onCalculateRouteFailure error: Error) {
        let error = error as NSError
        NSLog("onCalculateRouteFailure error:{%d - %@}", error.code, error.localizedDescription)
    }
    
    func compositeManager(_ compositeManager: AMapNaviCompositeManager, didStartNavi naviMode: AMapNaviMode) {
    }
    
    func compositeManager(_ compositeManager: AMapNaviCompositeManager, didArrivedDestination naviMode: AMapNaviMode) {
    }
    
    func compositeManager(_ compositeManager: AMapNaviCompositeManager, update naviLocation: AMapNaviLocation?) {
    }

    
}
