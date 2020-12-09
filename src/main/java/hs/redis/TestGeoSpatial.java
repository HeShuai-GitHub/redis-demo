package hs.redis;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: redis-demo
 * @description: 测试Jedis内GeoSpatial类型
 * @author: hs
 * @create: 2020-12-08 23:19
 **/
public class TestGeoSpatial {

    public static void main(String[] args) {
        // 连接指定redis, 如果使用的是windows的redis，注意一下该版本是否提供了对三大特殊类型的支持
        Jedis jedis = new Jedis("127.0.0.1", 6379);
//         输入验证密码
        jedis.auth("123");
//         清空所有数据库数据
        System.out.println("flushAll："+jedis.flushAll());
        System.out.println("添加地理信息");
        Map<String, GeoCoordinate> memberCoordinateMap = new HashMap<String, GeoCoordinate>();
        memberCoordinateMap.put("beijing",new GeoCoordinate(116.23128,40.22077));
        memberCoordinateMap.put("shanghai",new GeoCoordinate(121.48941, 31.40527));
        memberCoordinateMap.put("qinhuangdao",new GeoCoordinate(119.48458, 39.83507));
        memberCoordinateMap.put("guangzhou",new GeoCoordinate(113.27324, 23.15792));
        memberCoordinateMap.put("shenzhen",new GeoCoordinate(113.88308, 22.55329));
        System.out.println(jedis.geoadd("china:city", memberCoordinateMap));
        System.out.println("显示特定元素的地理位置，如果想显示全部元素，可以使用zset命令");
        System.out.println(jedis.geopos("china:city", "shenzhen"));
        System.out.println("geodist显示两地的直线距离");
        System.out.println(jedis.geodist("china:city", "beijing", "shanghai", GeoUnit.KM));
        System.out.println("显示以113 22坐标200千米半径内的所有城市");
        System.out.println(jedis.georadius("china:city", 113, 22, 200, GeoUnit.KM));
        System.out.println("显示以shenzhen为中心200千米半径内的所有城市");
        System.out.println(jedis.georadiusByMember("china:city", "shenzhen", 200, GeoUnit.KM));

    }

}
