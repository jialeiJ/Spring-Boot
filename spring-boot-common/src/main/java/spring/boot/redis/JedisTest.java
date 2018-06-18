package spring.boot.redis;

import redis.clients.jedis.Jedis;

/**
 *redis
 */
public class JedisTest {

	public static void main(String[] args) {
		//创建jedis对象，相当于创建一个客户端和redis服务器的链接，需要参数ip(安装有redis服务的器的地址)和端口号(默认6379)
		Jedis jedis = new Jedis("192.168.124.29", 6379);
		
		//ping redis服务器，这是它的一个方法，如果服务器正常，会返回一个pong
		String pong = jedis.ping();
		System.out.println("如果服务器可用返回pong	:  "+pong);
		
		//先用第一个键取一次值，这时redis中无数据返回null
		String value = jedis.get("key");
		System.out.println("第一次访问取到的值	=  "+value);
		
		//将数据存入redis服务器中
		jedis.set("key", "keyValue");
		
		//将取出数据
		value = jedis.get("key");
		System.out.println("存入之后取到的值	=  "+value);
		
		//将取出数据
		jedis.del("key");
		value = jedis.get("key");
		System.out.println("存入之后取到的值	=  "+value);
		
		
		//关闭redis的链接
		jedis.close();
	}
}