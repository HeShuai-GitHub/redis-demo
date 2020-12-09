package hs.redis;

import redis.clients.jedis.Jedis;

/**
 * @program: redis-demo
 * @description: 这个数据类型一般情况下，是用来做流量统计用的，内部算法保持了流量中数据的唯一性
 * @author: hs
 * @create: 2020-12-09 08:27
 **/
public class TestHyperloglog {

    public static void main(String[] args) {
        // 连接指定redis, 如果使用的是windows的redis，注意一下该版本是否提供了对三大特殊类型的支持
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//         输入验证密码
        jedis.auth("123");
//         清空所有数据库数据
        System.out.println("flushAll："+jedis.flushAll());
        System.out.println("添加两个集合");
        System.out.println(jedis.pfadd("hyper", "1", "2", "3", "4"));
        System.out.println(jedis.pfadd("hyper1", "5", "0", "3", "4"));
        System.out.println("显示两个集合的统计个数");
        System.out.println(jedis.pfcount("hyper", "hyper1"));
        System.out.println("合并两个集合");
        System.out.println(jedis.pfmerge("hyper2","hyper", "hyper1"));
        System.out.println("显示合并后的集合的个数");
        System.out.println(jedis.pfcount("hyper2"));
    }

}
