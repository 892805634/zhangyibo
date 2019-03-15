package com.third.easyprice.cronTest;

import cn.hutool.core.date.DateTime;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/11/28
 * Time:15:45
 */
public class CronTest {
    public static int count = 0;
    public void start(){
        System.out.printf("第%d次执行定时任务，当前时间：%s\n",++count, DateTime.now().toString());
    }
}
