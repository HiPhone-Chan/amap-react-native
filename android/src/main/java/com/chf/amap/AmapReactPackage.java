package com.chf.amap;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chhfeng
 * on 2017/8/8.
 */

public class AmapReactPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        initModule("com.amap.api.location.AMapLocation", "com.chf.amap.location.LocationModule", modules, reactContext);
        initModule("com.amap.api.navi.AmapNaviPage", "com.chf.amap.navigation.NavigationModule", modules, reactContext);
        return modules;
    }

    //    @Override RN 0.47 remove this method
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    private void initModule(String checkClassName, String moduleClassName, List<NativeModule> modules, ReactApplicationContext reactContext) {
        try {
            Class.forName(checkClassName);
            Class<?> moduleClass = Class.forName(moduleClassName);
            modules.add((NativeModule) moduleClass.getConstructor(ReactApplicationContext.class).newInstance(reactContext));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
