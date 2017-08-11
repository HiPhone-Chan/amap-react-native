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
    compile project(':amap-react-native')
}

2 在android/settings.gradle下添加
include ':amap-react-native'
project(':amap-react-native').projectDir = new File(rootProject.projectDir, '../node_modules/amap-react-native/android')

3 在MainApplication.java下添加
import com.chf.amap.AmapReactPackage;
...
protected List<ReactPackage> getPackages() {
  return Arrays.<ReactPackage>asList(
      new MainReactPackage(), ...
      new AmapReactPackage()
  );
}

```
