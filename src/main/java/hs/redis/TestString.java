package hs.redis;

import redis.clients.jedis.Jedis;
import sun.java2d.SurfaceDataProxy;

/**
 * @program: redis-demo
 * @description: 测试String类型，Jedis命令和Redis命令一致
 * @create: 2020-12-07 20:43
 **/
public class TestString {

    public static void main(String[] args) throws InterruptedException {
        // 连接指定redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//         输入验证密码
        jedis.auth("123");
//        测试是否连接成功，成功返回 pong
        System.out.println("ping："+jedis.ping());
//        清空所有数据库数据
        System.out.println("flushAll："+jedis.flushAll());
//        打印目前数据库中所有的key
        System.out.println("keys："+jedis.keys("*"));
//        输入一个key为name的String类型数据
        System.out.println("set："+jedis.set("name", "cainiao"));
//        判断key为name的元素是否存在
        System.out.println("exists："+jedis.exists("name"));
//        获得key为name的value值
        System.out.println("get："+jedis.get("name"));
//        获得key为name的字符长度
        System.out.println("strlen："+jedis.strlen("name"));
//        在key为name的元素后追加字符
        System.out.println("append："+jedis.append("name", ",nihao"));
//        查看key为name的元素
        System.out.println("get："+jedis.get("name"));
//        截取key为name的元素第2到第4的字符
        System.out.println("getrange："+jedis.getrange("name", 2, 4));
//        批量输入元素
        System.out.println("mset："+jedis.mset("age", "10", "key", "value"));
//        查看当前数据库中存在的key
        System.out.println("keys："+jedis.keys("*"));
//        批量获得元素
        System.out.println("mget："+jedis.mget("name", "age", "key"));
//        自第7位置开始替换元素
        System.out.println(jedis.setrange("name", 7, "1"));
//        查看元素
        System.out.println(jedis.get("name"));
//        如果元素不存在则设置一个新的元素，如果存在则设置失败
        System.out.println(jedis.setnx("name", "replace"));
//        查看元素
        System.out.println(jedis.get("name"));
//        先查看元素，然后给元素赋新的值
        System.out.println(jedis.getSet("name", "replace"));
//        设置一个key为view的元素
        System.out.println(jedis.set("view", "10"));
//        递增
        System.out.println(jedis.incr("view"));
//        查看元素
        System.out.println(jedis.get("view"));
//        递减
        System.out.println(jedis.decr("view"));
//        查看元素
        System.out.println(jedis.get("view"));
//        将元素减去10
        System.out.println(jedis.decrBy("view", 10));
//        查看元素
        System.out.println(jedis.get("view"));
//        将元素增加10
        System.out.println(jedis.incrBy("view", 5));
//        查看元素
        System.out.println(jedis.get("view"));
//        设置元素过期时间
        System.out.println(jedis.expire("view",10));
//        停滞程序5秒
        Thread.sleep(5000);
//        查看某元素过期时间，-2：已过期，-1：未设置过期时间
        System.out.println(jedis.ttl("view"));
//        停滞程序5秒
        Thread.sleep(5000);
//        查看过期元素的剩余过期时间
        System.out.println(jedis.ttl("view"));
//        查看过期元素
        System.out.println(jedis.get("view"));
//        在添加元素的时候设置过期时间
        System.out.println(jedis.setex("view", 10, "10"));
//        停滞程序5秒
        Thread.sleep(5000);
//        查看元素剩余过期时间
        System.out.println(jedis.ttl("view"));
//        停滞程序5秒
        Thread.sleep(5000);
//        查看元素剩余过期时间
        System.out.println(jedis.ttl("view"));
//        查看元素
        System.out.println(jedis.get("view"));
    }
}
