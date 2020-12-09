package hs.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @program: redis-demo
 * @description: 测试事务
 **/
public class TestTransaction {
    public static void main(String[] args) {
        // 连接指定redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//         输入验证密码
        jedis.auth("123");
//         清空所有数据库数据
        System.out.println("flushAll："+jedis.flushAll());
        Transaction multi = jedis.multi();

        try{
            System.out.println(multi.set("name", "cainiao"));
            multi.exec();
        }catch (Exception e){
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("name"));
            jedis.close();
        }
    }
}
