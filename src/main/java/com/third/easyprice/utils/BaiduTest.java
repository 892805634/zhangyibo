package com.third.easyprice.utils;

import com.baidu.aip.util.Base64Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;


public class BaiduTest {

    String AppID = "15154020";
    String APIKey = "VG5fsySfEWDXa5MOomYHiTcQ";
    private String SecretKey = "f8qy3RSagPPdwzSM2wn6sK8QelGjzoH0";
    private static String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/advanced_general";

    public static String getAccessToken() {
        return AuthService.getAuth();
    }

    public static String detect(File file) {
        String accessToken = getAccessToken();
        try {
            byte[] imgData = FileUtils.readFileToByteArray(file);
            // byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam + "&with_face=" + 1;
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = accessKey;
            String result = HttpUtil.post(url, accessToken, param);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Map<String, Object>> convert(String result) {
        Map<String, Object> jsonMap = (Map<String, Object>) JSONObject.fromObject(result);
        String results = jsonMap.get("result").toString();
        JSONArray jsonArray = JSONArray.fromObject(results);
        List<Map<String, Object>> mapListJson = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Map<String, Object> map = new HashMap<String, Object>();
            for (Iterator<?> iter = jsonObject.keys(); iter.hasNext(); ) {
                String key = (String) iter.next();
                String value = jsonObject.get(key).toString();
                map.put(key, value);
            }
            mapListJson.add(map);
        }
        System.out.println("--" + mapListJson);
        return mapListJson;
    }



    public String detect() {
        try {
            // 本地文件路径
            String filePath = "C:\\Users\\Zhangyibo\\Desktop\\zzz\\timg.jpg";
            byte[] imgData = FileUtils.readFileToByteArray(new File(filePath));
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam + "&with_face=" + 1;
            String accessToken = getAccessToken();
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println("------------" + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Zhangyibo\\Desktop\\zzz\\timg.jpg");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
        System.out.print(multipartFile.getInputStream());
    }
}
