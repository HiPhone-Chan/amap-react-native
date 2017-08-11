package com.chf.amap.location;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by chhfeng
 * on 2017/8/11.
 */

public class LocationModule extends ReactContextBaseJavaModule {

    public LocationModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "AmapLocation";
    }

    @ReactMethod
    public void getLocation(Callback callback) {
        String location = "l";
        callback.invoke(location);

    }
}
