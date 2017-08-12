package com.chf.amap.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.enums.NaviType;
import com.amap.api.navi.model.NaviLatLng;
import com.chf.amap.R;

/**
 * Created by chhfeng
 * on 2017/8/11.
 */

public class NavigationActivity extends BaseActivity {

    private AMapNaviView mAMapNaviView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAMapNaviView = findViewById(R.id.navi_view);
        mAMapNaviView.setAMapNaviViewListener(this);

        Intent intent = getIntent();
        String from = intent.getStringExtra("from");
        String to = intent.getStringExtra("to");

        String[] fromNaviLatLng = from.split(",");
        String[] toNaviLatLng = to.split(",");
        NaviLatLng mStartLatlng = new NaviLatLng(Double.valueOf(fromNaviLatLng[1]), Double.valueOf(fromNaviLatLng[0]));
        NaviLatLng mEndLatlng = new NaviLatLng(Double.valueOf(toNaviLatLng[1]), Double.valueOf(toNaviLatLng[0]));
        sList.add(mStartLatlng);
        eList.add(mEndLatlng);
    }

    @Override
    public void onInitNaviSuccess() {
        super.onInitNaviSuccess();
        int strategy = 0;
        try {
            strategy = mAMapNavi.strategyConvert(true, false, false, false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mAMapNavi.calculateDriveRoute(sList, eList, mWayPointList, strategy);

    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {
        super.onCalculateRouteSuccess(ints);
        mAMapNavi.startNavi(NaviType.GPS);
    }

}
