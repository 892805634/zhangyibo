package com.third.easyprice.wx;

import com.alibaba.fastjson.JSONObject;
import com.third.easyprice.utils.HttpUtil;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/12/19
 * Time:14:14
 */
public class AddNearByPoi {

    public static final String URL = "https://api.weixin.qq.com/wxa/addnearbypoi";

    public static String addNear(String related_name, String related_credential, String related_address) throws Exception {
        String token = "17_QF-hMggIgP5pigKppCtvybcZuNRER5UdfEElCkNzjiH5Y6eBJcBNxsJHcJJJGfXiJpvY68b0rZ_etwbH9M7gMRZgxfk-saHze4m0TJbA5fncW8ezvLCbKw3InEHxtBsogQ-rkvcB_eC12alWKRMbAJAFMH";
        JSONObject params = new JSONObject();
        params.put("related_name",related_name);
        params.put("related_credential",related_credential);
        params.put("related_address",related_address);
        return HttpUtil.post(URL, token, params.toString());
    }
}
