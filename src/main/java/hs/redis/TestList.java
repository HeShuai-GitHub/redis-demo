package hs.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ListPosition;

/**
 * @program: redis-demo
 * @description: 测试Redis List类型Jedis命令和Redis命令一致
 * @create: 2020-12-08 11:32
 **/
public class TestList {

    public static void main(String[] args) {
        // 连接指定redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//         输入验证密码
        jedis.auth("123");
//         清空所有数据库数据
        System.out.println("flushAll："+jedis.flushAll());
        System.out.println("右插入数据，新插入数据始终在最后一个");
        System.out.println(jedis.rpush("list", "v1", "v2", "v3"));
        System.out.println("查看指定范围下标的数据，-1表示最后一个");
        System.out.println(jedis.lrange("list", 0, -1));
        System.out.println("左插入数据，新插入数据始终在第一个");
        System.out.println(jedis.lpush("list", "v0"));
        System.out.println("查看指定范围下标的数据，-1表示最后一个");
        System.out.println(jedis.lrange("list", 0, -1));
        System.out.println("移除第一个元素");
        System.out.println(jedis.lpop("list"));
        System.out.println("显示list集合元素");
        System.out.println(jedis.lrange("list", 0, -1));
        System.out.println("移除最后一个元素");
        System.out.println(jedis.rpop("list"));
        System.out.println("显示list集合元素");
        System.out.println(jedis.lrange("list", 0, -1));
        System.out.println("查看指定下标的数据");
        System.out.println(jedis.lindex("list", 0));
        System.out.println(" 移除指定数量的指定元素");
        System.out.println(jedis.lrem("list", 2, "v2"));
        System.out.println("显示list集合元素");
        System.out.println(jedis.lrange("list", 0, -1));
        System.out.println("查看指定list集合的数量");
        System.out.println(jedis.llen("list"));
        System.out.println("截取集合");
        System.out.println(jedis.ltrim("list", 0, 1));
        jedis.rpush("list","v2");
        System.out.println("显示list集合元素");
        System.out.println(jedis.lrange("list", 0, -1));
        System.out.println("将集合list的最后一个元素转移到新的集合list1中");
        System.out.println(jedis.rpoplpush("list", "list1"));
        System.out.println("移除list1集合");
        System.out.println(jedis.move("list1",1));
        System.out.println("显示当前数据库中所包含的key");
        System.out.println(jedis.keys("*"));
        System.out.println("修改下标为0的item");
        System.out.println(jedis.lset("list", 0, "item"));
        System.out.println("显示list集合元素");
        System.out.println(jedis.lrange("list", 0, -1));
        System.out.println("插入item，在某个指定的item前后插入");
        System.out.println(jedis.linsert("list", ListPosition.AFTER, "item", "item-after"));
    }
}
