package hs.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: redis-demo
 * @description: 测试Jedis的Hash类型
 * @author: hs
 * @create: 2020-12-08 22:14
 **/
public class TestHash {

    public static void main(String[] args) {
        // 连接指定redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//         输入验证密码
        jedis.auth("123");
//         清空所有数据库数据
        System.out.println("flushAll："+jedis.flushAll());
        System.out.println("同String中set,不过可以设置多个值");
        Map<String,String> map = new HashMap<String, String>();
        map.put("k0","v0");
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        System.out.println(jedis.hset("hash", map));
        System.out.println("同String中get");
        System.out.println(jedis.hget("hash", "k0"));
        System.out.println("同String中mget");
        System.out.println(jedis.hmget("hash","k0","k1","k2","k3"));
        System.out.println("同String中strlen");
        System.out.println(jedis.hlen("v0"));
        System.out.println("移除元素");
        System.out.println(jedis.hdel("hash", "k3"));
        System.out.println("得到所有k-v");
        System.out.println(jedis.hgetAll("hash"));
        System.out.println("判断k2是否存在");
        System.out.println(jedis.hexists("hash", "k2"));
        System.out.println("获得hash所有的key");
        System.out.println(jedis.hkeys("hash"));
        System.out.println("获得hash所有的value");
        System.out.println(jedis.hvals("hash"));
    }

}
