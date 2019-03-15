package com.third.easyprice.wx;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/11/28
 * Time:16:26
 */
public class ExcleData {
    public static List<Map<String, Object>> redExle(String url) {
        //默认读全部行列，还可以通过重载函数，第二个参数指定读取的Sheet
        ExcelReader reader1 = ExcelUtil.getReader(url);
        List<Map<String, Object>> readAll = reader1.readAll();
        System.out.println("readAll" + readAll);
        reader1.close();
        return readAll;
    }
}
