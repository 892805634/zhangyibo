package com.third.easyprice.wx;

import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/12/19
 * Time:15:42
 */
public class CreateExcle {
    public static void create(List<List<String>> dataList) {
        BigExcelWriter writer = ExcelUtil.getBigWriter("e:/15.xlsx");
        // 一次性写出内容，使用默认样式
        writer.write(dataList);
        // 关闭writer，释放内存
        writer.close();
    }
}
