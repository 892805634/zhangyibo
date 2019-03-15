package com.third.easyprice.cronTest;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ArrayUtil;

import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/11/27
 * Time:16:04
 */
public class HuToolTest {

    public static void main(String[] args) throws InterruptedException {


    }

    private static void cronTest() throws InterruptedException {
        TimeTest a = new TimeTest();
        a.test();
    }

    private static void collUtil() {
        //  集合工具-CollUtil
        String[] col = new String[]{"a", "b", "c", "d", "e"};
        List<String> colList = CollUtil.newArrayList(col);

        String str = CollUtil.join(colList, "#");

    }

    private static void convert() {
        //        1、转换为字符串：
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);
        long[] b = {1, 2, 3, 4, 5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        //        2、转换为指定类型数组：
        String[] c = {"1", "2", "3", "4"};
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);
        long[] d = {1, 2, 3, 4, 5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        //        3、转换为日期对象：
        String e = "2017-05-06";
        Date value = Convert.toDate(a);
        //        4、转换为集合
        Object[] f = {"a", "你", "好", "", 1};
        List<?> list = Convert.convert(List.class, a);
        List<?> list1 = Convert.toList(a);
    }

    private static void arrayUtil() {
        int[] a = {};
        int[] b = null;
        System.out.println(ArrayUtil.isEmpty(a));
        ArrayUtil.isEmpty(b);
    }
}
