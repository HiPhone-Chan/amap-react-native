package com.chf.amap;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by chhfeng on 2017/8/8.
 */

public class NavigationModule extends ReactContextBaseJavaModule {


    public NavigationModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "AmapNavigation";
    }

    @ReactMethod
    public void sayHi(String who, Callback callback) {
        callback.invoke("Hello " + who);

    }
}
