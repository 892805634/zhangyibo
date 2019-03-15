package com.third.easyprice.utils;

import redis.clients.jedis.Jedis;

import java.util.*;

public class RedisTest {

    Jedis jedis = new Jedis("127.0.0.1", 6379);

    public static void main(String[] args) {
        RedisTest test = new RedisTest();
        test.test01();
        test.test02();
        test.test03();
        test.test04();
        test.test05();
    }

    /**
     * 操作普通键值对
     */

    public void test01() {
        //存入1个key=name value=hello的键值对
        jedis.set("name", "hello");
        String value = jedis.get("name");
        //获取key=name的值
        System.out.println(value);
        // jedis.del("name");
        //value = jedis.get("name");   //获取key=name的值
        // System.out.println(value);
    }

    /**
     * 操作List
     */

    public void test02() {
        //将zhoufeng 加入students数组的开头,如果该元素是第一个元素，那么会自动创建students数组
        jedis.rpush("studentsList", "first");
        //将zhangsan加入到students的末尾
        jedis.lpush("studentsList", "end");
//        //移除students的第一个元素
//        jedis.lpop("students");
//        //移除students的最后一个元素
//        jedis.rpop("students");
        //移除制定的元素,第二个参数表示要移除的个数，因为list中是允许出现重复元素的
        jedis.lrem("student", 1, "first");
        //获取students数组的所有元素
        List<String> students = jedis.lrange("studentsList", 0, -1);
        System.out.println(students);
    }

    /**
     * 操作Set
     */

    public void test03() {
        //添加元素
        jedis.sadd("teachersSet", "zhangsan");
        jedis.sadd("teachersSet", "lisi", "hello");
        jedis.sadd("teachersSet", "wangwu");
        //判断Set是否包含制定元素
        Boolean b1 = jedis.sismember("teachers", "wangwu");
        Boolean b2 = jedis.sismember("teachers", "xxxxx");
        System.out.println(b1 + "   " + b2);
        //获取Set内所有的元素
        Set<String> members = jedis.smembers("teachersSet");
        Iterator<String> it = members.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //  jedis.sunion(keys...) 可以将多个Set合并成1个并返回合并后的Set
    }

    /**
     * 操作带排序功能的Set
     */

    public void test04() {
        //添加元素，会根据第二个参数排序
        jedis.zadd("empsSortSet", 5, "aaa");
        jedis.zadd("empsSortSet", 1, "bbbb");
        jedis.zadd("empsSortSet", 3, "ccc");
        jedis.zadd("empsSortSet", 2, "ddd");
        //获取所有元素
        Set<String> emps = jedis.zrange("empsSortSet", 0, -1);
        Iterator<String> it = emps.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * 存入对象,使用Map作为对象
     */

    public void test05() {
        Map<String, String> car = new HashMap<String, String>();
        car.put("COLOR", "red");
        car.put("SIZE", "2T");
        car.put("NO", "8888");
        jedis.hmset("carMap", car);
        //获取整个对象
        Map<String, String> result = jedis.hgetAll("carMap");
        Iterator<Map.Entry<String, String>> it = result.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

        //也可以获取制定的属性
        String no = jedis.hget("car", "NO");
        System.out.println("NO:" + no);
    }
}
