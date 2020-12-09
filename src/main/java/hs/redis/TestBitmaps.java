package hs.redis;

import redis.clients.jedis.Jedis;

/**
 * @program: redis-demo
 * @description: 测试位图，这个特殊数据类型主要是为了存储一些两种状态的数据
 * @author: hs
 * @create: 2020-12-09 08:38
 **/
public class TestBitmaps {

    public static void main(String[] args) {
        // 连接指定redis, 如果使用的是windows的redis，注意一下该版本是否提供了对三大特殊类型的支持
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//         输入验证密码
        jedis.auth("123");
//         清空所有数据库数据
        System.out.println("flushAll："+jedis.flushAll());
        System.out.println("添加数据");
        System.out.println(jedis.setbit("bitmaps", 0, false));
        System.out.println(jedis.setbit("bitmaps", 1, false));
        System.out.println(jedis.setbit("bitmaps", 2, true));
        System.out.println(jedis.setbit("bitmaps", 3, false));
        System.out.println(jedis.setbit("bitmaps", 4, true));
        System.out.println(jedis.setbit("bitmaps", 5, false));
        System.out.println(jedis.setbit("bitmaps", 6, false));
        System.out.println("显示下标为3的值");
        System.out.println(jedis.getbit("bitmaps", 3));
        System.out.println("计算bitmaps集合中一共有多少个true");
        System.out.println(jedis.bitcount("bitmaps"));
    }

}
