package com.third.easyprice.wx;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/12/19
 * Time:15:22
 */

public class DoTask {
    public static String task() throws Exception {
        String url = "C:\\Users\\Zhangyibo\\Desktop\\0.xlsx";
        List<Map<String, Object>> dataList = ExcleData.redExle(url);
        List<List<String>> excleLsit = new ArrayList<>();
        for (Map<String, Object> map : dataList) {
            //  String appId = map.get("appId").toString();
            String related_name = map.get("related_name").toString();
            String related_credential = map.get("related_credential").toString();
            //  String address = map.get("address").toString();
            String related_address = map.get("related_address").toString();
            // String prvinceName = map.get("prvinceName").toString();
            String result = AddNearByPoi.addNear(related_name, related_credential, related_address);
            //  List<String> excleRows = CollUtil.newArrayList(appId,related_name, related_credential,address, related_address,prvinceName, result);
            List<String> excleRows = CollUtil.newArrayList(related_name, related_credential, related_address, result);
            excleLsit.add(excleRows);
        }
        CreateExcle.create(excleLsit);
        return null;
    }

    public static void main(String[] args) throws Exception {
        task();
    }
}
