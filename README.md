高德sdk封装
==========

# 安装
```
npm install amap-react-native --save
```

# 配置
## android
```
1 your react native project/android/app/build.gradle下添加
dependencies {
    ...
    # 根据需要添加以下依赖
    compile 'com.amap.api:map2d:latest.integration' # 导航相关
    compile 'com.amap.api:navi-3dmap:latest.integration' # 导航相关
    compile 'com.amap.api:location:latest.integration' # 定位相关
    # 必要
    compile project(':amap-react-native')
}

2 在android/settings.gradle下添加
include ':amap-react-native'
project(':amap-react-native').projectDir = new File(rootProject.projectDir, '../node_modules/amap-react-native/android')

3 在MainApplication.java下添加
import com.chf.amap.AmapReactPackage; // add this
...
protected List<ReactPackage> getPackages() {
  return Arrays.<ReactPackage>asList(
      new MainReactPackage(), ...
      new AmapReactPackage() // add this
  );
}

4 在AndroidManifest.xml中
<!-- 配置activity -->
<activity android:name="com.amap.api.navi.AmapRouteActivity"
              android:theme="@android:style/Theme.NoTitleBar"
              android:configChanges="orientation|keyboardHidden|screenSize" />

<!-- 增加所需权限 -->
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
<user-permission android:name="android.permission.WAKE_LOCK" />
```

## ios
```
暂未实现
```

# Usage

## location
```
import Amap from 'amap-react-native';
Amap.location.startLocation(); // 启动时调一次
// 中途需要获取的时候调用
Amap.location.getLocation(function(location){ // 成功回调函数
              console.log(location); // 格式 long,lat
          }, function(code, info, lastLocation) { // 失败回调函数
              console.log(code); // 失败代码
              console.log(info); // 失败信息
              console.log(lastLocation); // 最近一次获取的位置
          });   
Amap.location.stopLocation();  // 结束时调一次
```

## navigation
```
Amap.navigation.startNavi({
    "name" : "地图上显示的名字",
    "coordinate" : "经纬度坐标"  // 格式 long,lat
  }, function(e){ // 错误返回
    console.log(e);
  });
```
