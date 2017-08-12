package com.chf.amap.navigation;

import android.content.Intent;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.enums.NaviType;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.autonavi.tbt.TrafficFacilityInfo;
import com.chf.amap.R;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chhfeng on 2017/8/12.
 */

public class NavigationMapView extends SimpleViewManager<AMapNaviView> implements AMapNaviListener, AMapNaviViewListener {

    private final static String TAG = "NavigationMapView";

    protected AMapNaviView mAMapNaviView;
    protected AMapNavi mAMapNavi;
    protected final List<NaviLatLng> sList = new ArrayList<NaviLatLng>();
    protected final List<NaviLatLng> eList = new ArrayList<NaviLatLng>();
    protected List<NaviLatLng> mWayPointList;

    private String mFrom;
    private String mTo;

    @Override
    public String getName() {
        return "NavigationMapView";
    }

    @Override
    protected AMapNaviView createViewInstance(ThemedReactContext reactContext) {

        // TODO 实例化语音引擎

        mAMapNavi = AMapNavi.getInstance(reactContext);
        mAMapNavi.addAMapNaviListener(this);

        mAMapNaviView = createViewInstance(reactContext);
        mAMapNaviView.setAMapNaviViewListener(this);


        String[] fromNaviLatLng = mFrom.split(",");
        String[] toNaviLatLng = mTo.split(",");
        NaviLatLng mStartLatlng = new NaviLatLng(Double.valueOf(fromNaviLatLng[1]), Double.valueOf(fromNaviLatLng[0]));
        NaviLatLng mEndLatlng = new NaviLatLng(Double.valueOf(toNaviLatLng[1]), Double.valueOf(toNaviLatLng[0]));
        sList.add(mStartLatlng);
        eList.add(mEndLatlng);
        return mAMapNaviView;
    }


    @ReactProp(name = "from")
    public void setFrom(String from) {
        mFrom = from;
    }

    @ReactProp(name = "to")
    public void setTo(String to) {
        mTo = to;
    }

    @Override
    public void onInitNaviFailure() {

    }

    @Override
    public void onInitNaviSuccess() {
        int strategy = 0;
        try {
            strategy = mAMapNavi.strategyConvert(true, false, false, false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mAMapNavi.calculateDriveRoute(sList, eList, mWayPointList, strategy);
    }

    @Override
    public void onStartNavi(int i) {

    }

    @Override
    public void onTrafficStatusUpdate() {

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onGetNavigationText(int i, String s) {

    }

    @Override
    public void onEndEmulatorNavi() {

    }

    @Override
    public void onArriveDestination() {

    }

    @Override
    public void onCalculateRouteFailure(int i) {

    }

    @Override
    public void onReCalculateRouteForYaw() {

    }

    @Override
    public void onReCalculateRouteForTrafficJam() {

    }

    @Override
    public void onArrivedWayPoint(int i) {

    }

    @Override
    public void onGpsOpenStatus(boolean b) {

    }

    @Override
    public void onNaviInfoUpdate(NaviInfo naviInfo) {

    }

    @Override
    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {

    }

    @Override
    public void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfos) {

    }

    @Override
    public void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfos) {

    }

    @Override
    public void showCross(AMapNaviCross aMapNaviCross) {

    }

    @Override
    public void hideCross() {

    }

    @Override
    public void showLaneInfo(AMapLaneInfo[] aMapLaneInfos, byte[] bytes, byte[] bytes1) {

    }

    @Override
    public void hideLaneInfo() {

    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {
        mAMapNavi.startNavi(NaviType.GPS);
    }

    @Override
    public void notifyParallelRoad(int i) {
        if (i == 0) {
            Log.d(TAG, "当前在主辅路过渡");
            return;
        }
        if (i == 1) {
            Log.d(TAG, "当前在主路");
            return;
        }
        if (i == 2) {
            Log.d(TAG, "当前在辅路");
        }
    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {

    }

    @Override
    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfos) {

    }

    @Override
    public void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {

    }

    @Override
    public void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {

    }

    @Override
    public void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {

    }

    @Override
    public void onPlayRing(int i) {

    }

    @Override
    public void onNaviSetting() {

    }

    @Override
    public void onNaviCancel() {

    }

    @Override
    public boolean onNaviBackClick() {
        return false;
    }

    @Override
    public void onNaviMapMode(int i) {

    }

    @Override
    public void onNaviTurnClick() {

    }

    @Override
    public void onNextRoadClick() {

    }

    @Override
    public void onScanViewButtonClick() {

    }

    @Override
    public void onLockMap(boolean b) {

    }

    @Override
    public void onNaviViewLoaded() {
        Log.d(TAG, "导航页面加载成功");
        Log.d(TAG, "请不要使用AMapNaviView.getMap().setOnMapLoadedListener();会overwrite导航SDK内部画线逻辑");
    }
}
