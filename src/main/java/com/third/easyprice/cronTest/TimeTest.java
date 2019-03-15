package com.third.easyprice.cronTest;

import cn.hutool.cron.CronUtil;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/11/28
 * Time:15:46
 */
public class TimeTest {
    public void test() throws InterruptedException {
        //设置Cron表达式匹配到秒，不然使用的是Linux的crontab表达式，最小单位是分钟
        CronUtil.setMatchSecond(true);
        CronUtil.start();
        //可以手动停止定时任务
        //CronUtil.stop();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }

}
