package com.chf.amap.navigation.util;

import android.util.SparseArray;

/**
 * -1	路径计算失败。	在导航过程中调用calculateDriveRoute方法导致的失败，导航过程中只能用reCalculate方法进行路径计算。
 * 1	路径计算成功。
 * 2	网络超时或网络失败,请检查网络是否通畅，稍候再试。
 * 3	路径规划起点经纬度不合法,请选择国内坐标点，确保经纬度格式正常。
 * 4	协议解析错误,请稍后再试。
 * 6	路径规划终点经纬度不合法,请选择国内坐标点，确保经纬度格式正常。
 * 7	算路服务端编码失败.
 * 10	起点附近没有找到可行道路,请对起点进行调整。
 * 11	终点附近没有找到可行道路,请对终点进行调整。
 * 12	途经点附近没有找到可行道路,请对途经点进行调整。
 * 13	key鉴权失败。	请仔细检查key绑定的sha1值与apk签名sha1值是否对应，或通过;高频问题查找相关解决办法。
 * 14	请求的服务不存在,	请稍后再试。
 * 15	请求服务响应错误,请检查网络状况，稍后再试。
 * 16	无权限访问此服务,请稍后再试。
 * 17	请求超出配额。
 * 18	请求参数非法,请检查传入参数是否符合要求。
 * 19	未知错误。
 **/
public class ErrorInfo {

    private static SparseArray<String> array = new SparseArray<>();

    static {
        array.put(-1, "路径计算失败，在导航过程中调用calculateDriveRoute方法导致的失败，导航过程中只能用reCalculate方法进行路径计算。");
        array.put(1, "路径计算成功。");
        array.put(2, "网络超时或网络失败,请检查网络是否通畅，如网络没问题,查看Logcat输出是否出现鉴权错误信息，如有，说明SHA1与KEY不对应导致。");
        array.put(3, "路径规划起点经纬度不合法,请选择国内坐标点，确保经纬度格式正常。");
        array.put(4, "协议解析错误,请稍后再试。");
        array.put(6, "路径规划终点经纬度不合法,请选择国内坐标点，确保经纬度格式正常。");
        array.put(7, "算路服务端编码失败.");
        array.put(10, "起点附近没有找到可行道路,请对起点进行调整。");
        array.put(11, "终点附近没有找到可行道路,请对终点进行调整。");
        array.put(12, "途经点附近没有找到可行道路,请对途经点进行调整。");
        array.put(13, "key鉴权失败，请仔细检查key绑定的sha1值与apk签名sha1值是否对应，或通过;高频问题查找相关解决办法。");
        array.put(14, "请求的服务不存在,请稍后再试。");
        array.put(15, "请求服务响应错误,请检查网络状况，稍后再试。");
        array.put(16, "无权限访问此服务,请稍后再试。");
        array.put(17, "请求超出配额。");
        array.put(18, "请求参数非法,请检查传入参数是否符合要求。");
        array.put(19, "未知错误。");

    }

    public static String getError(int id) {
        return array.get(id);
    }

}
