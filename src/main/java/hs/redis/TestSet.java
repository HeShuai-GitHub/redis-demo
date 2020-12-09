package hs.redis;

import redis.clients.jedis.Jedis;

/**
 * @program: redis-demo
 * @description: 测试Redis Set类型
 * @author: hs
 * @create: 2020-12-08 21:54
 **/
public class TestSet {

    public static void main(String[] args) {
        // 连接指定redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//         输入验证密码
        jedis.auth("123");
//         清空所有数据库数据
        System.out.println("flushAll："+jedis.flushAll());
        System.out.println("批量添加set类型元素");
        System.out.println(jedis.sadd("set","v0", "v1", "v2", "v3", "v4"));
        System.out.println(" 打印所有set下边的元素，是无序且不重复的");
        System.out.println(jedis.smembers("set"));
        System.out.println("判断set集合下某个值是否存在");
        System.out.println(jedis.sismember("set", "v0"));
        System.out.println("查看set集合中的个数");
        System.out.println(jedis.scard("set"));
        System.out.println("移除指定元素");
        System.out.println(jedis.srem("set", "v0"));
        System.out.println("查看set集合中的元素");
        System.out.println(jedis.smembers("set"));
        System.out.println("随机取出指定数量的元素");
        System.out.println(jedis.srandmember("set", 2));
        System.out.println("将指定元素移动到其他set集合中");
        System.out.println(jedis.smove("set", "set1", "v1"));
        System.out.println("显示set1集合内的元素");
        System.out.println(jedis.smembers("set1"));
        System.out.println("在set1集合中添加两个元素：v2、v3");
        System.out.println(jedis.sadd("set1", "v2", "v3"));
        System.out.println("显示set1集合内的元素");
        System.out.println(jedis.smembers("set1"));
        System.out.println("显示set集合内的元素");
        System.out.println(jedis.smembers("set"));
        System.out.println("显示set与set1的差集");
        System.out.println(jedis.sdiff("set", "set1"));
        System.out.println("显示set与set1的交集");
        System.out.println(jedis.sinter("set", "set1"));
        System.out.println("显示set与set1的并集");
        System.out.println(jedis.sunion("set", "set1"));
    }

}
