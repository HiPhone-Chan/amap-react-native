package com.chf.amap;

import com.chf.amap.location.LocationModule;
import com.chf.amap.navigation.NavigationMapView;
import com.chf.amap.navigation.NavigationModule;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by chhfeng
 * on 2017/8/8.
 */

public class AmapReactPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(new NavigationModule(reactContext), new LocationModule(reactContext));
    }

    //    @Override RN 0.47 remove this method
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(new NavigationMapView());
    }
}
