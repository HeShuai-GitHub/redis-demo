package com.cainiao.redisspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSpringbootApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 在RedisTemplate中使用的不是Jedis，而是Lettuce,Lettuce使用的是netty
     */
    @Test
    void contextLoads() {
        /* opsForValue() 操作String类型 */
        redisTemplate.opsForValue().set("name","cainiao");
        System.out.println(redisTemplate.opsForValue().get("name"));
        System.out.println(redisTemplate.keys("*"));
        /* opsForZSet 操作Zset类型 */
        redisTemplate.opsForZSet().add("zset","v0",0);
        System.out.println(redisTemplate.opsForZSet().rangeByScoreWithScores("zset",0,10));
        /* opsForGeo 操作Geo类型 , 如果使用的是windows的redis，注意一下该版本是否提供了对三大特殊类型的支持 */
//        redisTemplate.opsForGeo().add("geos",new RedisGeoCommands.GeoLocation("beijing",new Point(116.23128,40.22077)));
//        System.out.println(redisTemplate.opsForGeo().position("geos","beijing"));
        /* opsForSet 操作set类型 */
        redisTemplate.opsForSet().add("set","v0","v1","v2","v3");
        System.out.println(redisTemplate.opsForSet().members("set"));
        /* opsForHash 操作Hash类型 */
        redisTemplate.opsForHash().put("hash","k1","v1");
        System.out.println(redisTemplate.opsForHash().get("hash","k1"));
        /* opsForList 操作List类型 */
        redisTemplate.opsForList().rightPush("list","v0");
        System.out.println(redisTemplate.opsForList().rightPop("list"));

        /* 其他操作方式都和Jedis大同小异，不再多练习了 */

    }

}
