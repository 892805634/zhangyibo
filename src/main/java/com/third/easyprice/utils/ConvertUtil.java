package com.third.easyprice.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;

/**
 * @author Zhangyibo
 */

public class ConvertUtil {
    public static final String LOCATION = "location";
    public static final String AD_INFO = "ad_info";
    public static final String ADDRESS_COMPONENTS = "address_components";

    public static List<Map<String, Object>> convert(Map<String, Object> jsonMap, String status) {
        String results = jsonMap.get(status).toString();
        System.out.println(results);
        JSONArray jsonArray = JSONArray.fromObject(results);
        List<Map<String, Object>> resultList = new ArrayList<>();
        jsonArray.forEach(item->{
            JSONObject jsonObject = (JSONObject) item;
            Map<String, Object> map = mergeResults(jsonObject);
            resultList.add(map);
        });
        return resultList;
    }

    public static Map<String, Object> mergeResults(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<String, Object>();
        jsonObject.forEach((k, v) -> {
            if (LOCATION.equals(k) || AD_INFO.equals(k) || ADDRESS_COMPONENTS.equals(k)) {
                JSONObject jb = JSONObject.fromObject(v);
                jb.forEach((key, value) -> {
                    map.put(key.toString(), value);
                });
            } else {
                map.put(k.toString(), v);
            }
        });
        return map;
    }
}
