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

    private static final int SUCCESS_CODE = 0;

    private AMapLocationClient mLocationClient;

    private String mLocation;

    private int mLastErrorCode;

    private String mLastErrorInfo;

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

        mLastErrorCode = -1;
        mLastErrorInfo = "Have not started.";

        mLocationClient = new AMapLocationClient(getCurrentActivity());
        AMapLocationClientOption locationOption = new AMapLocationClientOption();

        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        locationOption.setInterval(PERIOD);

        mLocationClient.setLocationOption(locationOption);
        mLocationClient.setLocationListener(new AMapLocationListener() {

            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    mLastErrorCode = aMapLocation.getErrorCode();
                    if (mLastErrorCode == SUCCESS_CODE) {
                        mLocation = getPosition(aMapLocation);
                    } else {
                        mLastErrorInfo = aMapLocation.getErrorInfo();
                        Log.e("AmapError", "location Error, ErrCode:"
                                + mLastErrorCode + ", errInfo:"
                                + mLastErrorInfo);
                    }
                }
            }
        });
        mLocationClient.startLocation();
    }

    @ReactMethod
    public void getLocation(Callback success, Callback error) {
        if (mLastErrorCode == SUCCESS_CODE) {
            success.invoke(mLocation);
        } else {
            error.invoke(mLastErrorCode, mLastErrorInfo, mLocation);
        }
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
