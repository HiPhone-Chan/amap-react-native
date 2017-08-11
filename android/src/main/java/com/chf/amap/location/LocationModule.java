package com.chf.amap.location;

import android.location.Location;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by chhfeng
 * on 2017/8/11.
 */

public class LocationModule extends ReactContextBaseJavaModule {


    private static final int PERIOD = 2000;

    private AMapLocationClient mLocationClient;

    private String mLocation;

    public LocationModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "AmapLocation";
    }


    @ReactMethod
    public void startLocation() {
        if (mLocationClient != null) {
            return;
        }

        mLocationClient = new AMapLocationClient(getCurrentActivity());
        AMapLocationClientOption locationOption = new AMapLocationClientOption();

        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        locationOption.setInterval(PERIOD);

        mLocationClient.setLocationOption(locationOption);
        mLocationClient.setLocationListener(new AMapLocationListener() {

            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        mLocation = getPosition(aMapLocation);
                    } else {
                        Log.e("AmapError", "location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
        mLocationClient.startLocation();
    }

    @ReactMethod
    public void getLocation(Callback callback) {
        callback.invoke(mLocation);
    }


    @ReactMethod
    public void stopLocation() {
        if (mLocationClient != null) {
            mLocationClient.stopLocation();
        }
    }

    private String getPosition(Location location) {
        return location.getLongitude() + "," + location.getLatitude();
    }
}
