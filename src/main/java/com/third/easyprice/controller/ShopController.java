package com.third.easyprice.controller;

import com.alibaba.fastjson.JSONObject;
import com.third.easyprice.bean.Shop;
import com.third.easyprice.service.ShopService;
import com.third.easyprice.utils.BaiduTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController

@Api(value = "userGroup", description = "访问")

@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public JSONObject queryShop(@RequestParam("file") MultipartFile file) throws IOException {
        JSONObject jsonObject = new JSONObject();
        if (file.isEmpty()) {
            jsonObject.put( "msg", "图片不存在,请重新上传" );
            return jsonObject;
        }
        String detect = tempFile( file );
        List<Map<String, Object>> convert = BaiduTest.convert( detect );
        String key = UUID.randomUUID().toString().replace( "-", "" );
        List<Shop> result = shopService.queryByName( convert, key );
        jsonObject.put( "data", result );
        jsonObject.put( "key", key );
        return jsonObject;
    }

    private String tempFile(@RequestParam("file") MultipartFile file) throws IOException {
        String filePath = "C:\\Users\\Zhangyibo\\Desktop\\zzz\\";
        String filename = file.getOriginalFilename();
        String suffix = filename.substring( filename.indexOf( "." ) );
        String uuid = UUID.randomUUID().toString().replace( "-", "" );
        final File tempFile = File.createTempFile( uuid, suffix, new File( filePath ) );
        file.transferTo( tempFile );
        return baiduResult( tempFile );
    }

    private String baiduResult(File tempFile) {
        String detect = BaiduTest.detect( tempFile );
        tempFile.delete();
        return detect;
    }

    /**
     * @param
     * @param type 用户分类 类型
     * @return
     */
    @ApiOperation(value = "查询详情")
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public JSONObject orderResult(@RequestParam String type) {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isBlank( type )) {
            jsonObject.put( "msg", "服务器错误" );
            jsonObject.put( "data", null );
            jsonObject.put( "code", "403" );
            return jsonObject;
        }
        List<Shop> shops = shopService.orderList( type );
        jsonObject.put( "msg", "请求正常" );
        jsonObject.put( "data", shops );
        jsonObject.put( "code", "200" );
        return jsonObject;
    }
}
