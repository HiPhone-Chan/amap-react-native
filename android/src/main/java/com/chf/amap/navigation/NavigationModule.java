package com.chf.amap.navigation;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by chhfeng
 * on 2017/8/8.
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
    public void startNavi(String from, String to, Callback callback) {
        Activity currentActivity = getCurrentActivity();
        Intent intent = new Intent(currentActivity, NavigationActivity.class);
        intent.putExtra("from", from);
        intent.putExtra("to", to);
        currentActivity.startActivity(intent);

    }


}
