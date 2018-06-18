package spring.boot.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *redis连接池
 */
public class JedisPoolTest {

	public static void main(String[] args) {
		
		// 建立连接池配置参数
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxIdle(100);
        // 设置最大阻塞时间，记住是毫秒数milliseconds
        config.setMaxWaitMillis(1000);
        // 设置空间连接
        config.setMaxIdle(10);
		
		//1.创建连接池JedisPool对象
//      JedisPool jedisPool = new JedisPool(config, "192.168.124.29", 6379);
		JedisPool jedisPool = new JedisPool("192.168.124.29", 6379);
		
		//2.从连接池获取链接jedis
		Jedis jedis = jedisPool.getResource();
		
		//3.使用连接jedis操作redis
		jedis.select(2);
		
		String pong = jedis.ping();
		System.out.println("pong="+pong);
		
		String key = "jedisPoll";
		String setValue = jedis.set(key, "hello redis");
		System.out.println(setValue);
		
		String getValue = jedis.get(key);
		System.out.println(getValue);
		
		//4.释放资源。每次用完jedis连接池，必须close,指的是还回连接池
		jedis.close();
		
		//5.程序结束，销毁连接池
		jedisPool.close();
	}
}