package com.third.easyprice.controller;

import com.third.easyprice.bean.China;
import com.third.easyprice.service.IChinaMobile;
import com.third.easyprice.utils.ConvertUtil;
import com.third.easyprice.utils.TencentApi;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.*;


/**
 * @author Zhangyibo
 */
@RestController

@Api(value = "putCity", description = "访问")
@RequestMapping(value = "/putCity")
public class ChinaMobileController {
    public static final String DATA = "data";
    public static final String RESULT = "result";
    @Autowired
    IChinaMobile chinaMobileService;

    @RequestMapping(value = "/putCity", method = RequestMethod.GET)
    public void putCity(@RequestParam("keyword") String keyword) throws InterruptedException {
        List<China> cityList = chinaMobileService.getCity();
        ExecutorService executor = newFixedThreadPool(4);
        CountDownLatch doneSignal = new CountDownLatch(cityList.size());
        cityList.forEach(map -> executor.execute(() -> {
            try {
                String result = TencentApi.citySerach(keyword, map.getName());
                Map<String, Object> jsonMap = (Map<String, Object>) JSONObject.fromObject(result);
                List<Map<String, Object>> paramsList = ConvertUtil.convert(jsonMap, DATA);
                paramsList.forEach(param -> chinaMobileService.insertData(param));
            } catch (Exception e) {
                e.printStackTrace();
            }
            doneSignal.countDown();
        }));
        doneSignal.await();
        executor.shutdown();

    }

    @RequestMapping(value = "/putCityKey", method = RequestMethod.GET)
    public void putCityKey(@RequestParam("keyword") String keyword, @RequestParam("city") String city) {
        String result = TencentApi.citySerach(keyword, city);
        Map<String, Object> jsonMap = (Map<String, Object>) JSONObject.fromObject(result);
        System.out.println(result);
        List<Map<String, Object>> paramsList = ConvertUtil.convert(jsonMap, DATA);
        for (Map<String, Object> map : paramsList) {
            chinaMobileService.insertData(map);
        }

    }


    @RequestMapping(value = "/searchAddress", method = RequestMethod.GET)
    public void searchAddress() throws InterruptedException {
        Vector<China> addressList = (Vector<China>) chinaMobileService.getCity();
        ExecutorService executor = newFixedThreadPool(4);
        CountDownLatch doneSignal = new CountDownLatch(addressList.size());
        addressList.forEach(map -> executor.execute(() -> {
            try {
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("address", map.getName());
                //调用腾讯地图API
                String results = TencentApi.addressResolution(map.getName());
                Map<String, Object> jsonMap = (Map<String, Object>) JSONObject.fromObject(results);
                String result = jsonMap.get(RESULT).toString();
                JSONObject jsonObject = JSONObject.fromObject(result);
                resultMap.putAll(ConvertUtil.mergeResults(jsonObject));
                //结果插入数据库
                chinaMobileService.insertData(resultMap);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                doneSignal.countDown();
            }
        }));
        doneSignal.await();
        executor.shutdown();
    }
}