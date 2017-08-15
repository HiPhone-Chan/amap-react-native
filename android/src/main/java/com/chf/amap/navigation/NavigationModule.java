package com.chf.amap.navigation;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

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
    public void startNavi(ReadableMap to, final Callback error) {
        ReactApplicationContext reactContext = getReactApplicationContext();

        Poi end = getPoi(to);

        AmapNaviPage.getInstance().showRouteActivity(reactContext, new AmapNaviParams(end), new INaviInfoCallback() {
            @Override
            public void onInitNaviFailure() {
                error.invoke("Init Navi Failure");
            }

            @Override
            public void onGetNavigationText(String s) {

            }

            @Override
            public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

            }

            @Override
            public void onArriveDestination(boolean b) {

            }

            @Override
            public void onStartNavi(int i) {

            }

            @Override
            public void onCalculateRouteSuccess(int[] ints) {

            }

            @Override
            public void onCalculateRouteFailure(int i) {

            }

            @Override
            public void onStopSpeaking() {

            }
        });

    }

    private final static String SPLIT_REGEX = ",";

    private Poi getPoi(ReadableMap map) {
        String name = map.getString("name");
        String location = map.getString("coordinate");
        String[] longLat = location.split(SPLIT_REGEX);
        return new Poi(name, new LatLng(Double.valueOf(longLat[1]), Double.valueOf(longLat[0])), "");
    }


}
