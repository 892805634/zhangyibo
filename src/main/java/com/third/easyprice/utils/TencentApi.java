package com.third.easyprice.utils;


/**
 * @创建人 zhangyibo
 * @创建时间 2018/10/16
 * @描述
 */
public class TencentApi {
    public static final String URL = "https://apis.map.qq.com/ws/place/v1/search";
    public static final String ADDRESSURL = "https://apis.map.qq.com/ws/geocoder/v1/?address=";
    public static final String STRING = "&";
    public static final int INT = 1;
    public static final int PAGE_SIZE = 20;
    public static final String DISTANCE = "_distance";
    public static final String KEY = "LCFBZ-G6T3U-APCV3-4TYX6-4VIIJ-TRFGN";

    public static String citySerach(String keyword, String city) {
        final String boundary = "region(" + city + ",0)";
        final String params = "boundary=" + boundary + STRING + "keyword=" + keyword + STRING + "page_size=" + PAGE_SIZE + STRING + "page_index=" + INT + STRING + "orderby=" + DISTANCE + STRING + "key=" + KEY;
        String result = HttpUtils.sendGet(URL, params);
        return result;
    }

    public static String addressResolution(String address) {
        final String params = address + STRING + "key=" + KEY;
        String result = HttpUtils.sendGet(ADDRESSURL, params);
        return result;
    }
}


