package hs.redis;

import redis.clients.jedis.Jedis;

/**
 * @program: redis-demo
 * @description: 测试Jedis的Zset类型
 * @author: hs
 * @create: 2020-12-08 23:04
 **/
public class TestZset {


    public static void main(String[] args) {
        // 连接指定redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//         输入验证密码
        jedis.auth("123");
//         清空所有数据库数据
        System.out.println("flushAll："+jedis.flushAll());
        System.out.println("向Zset内添加元素");
        System.out.println(jedis.zadd("zset", 0D, "v0"));
        System.out.println(jedis.zadd("zset", 1D, "v1"));
        System.out.println(jedis.zadd("zset", 2D, "v2"));
        System.out.println(jedis.zadd("zset", 3D, "v3"));
        System.out.println("显示Zset内所有元素");
        System.out.println(jedis.zrange("zset", 0, -1));
        System.out.println("显示zset集合中元素的个数");
        System.out.println(jedis.zcard("zset"));
        System.out.println("统计某个范围元素的个数");
        System.out.println(jedis.zcount("zset", 2, 3));
        System.out.println("删除指定元素v3");
        System.out.println(jedis.zrem("zset", "v3"));
        System.out.println("倒序输出Zset元素");
        System.out.println(jedis.zrevrange("zset", 0, -1));
    }

}
