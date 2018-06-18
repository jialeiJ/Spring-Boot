package spring.boot.utils;

import redis.clients.jedis.Jedis;

public class RedisUtil {
	private String host = "127.0.0.1";
	private int port = 6379;
	
	public void clear() {
		Jedis jedis = new Jedis(host, port);
		//验证密码,无密码则省略
		//jedis.auth("");
		//连接
		jedis.connect();
		//清空所有key
		jedis.flushAll();
		//清空redis所有数据
		jedis.flushDB();
		jedis.quit();
		//断开连接
		jedis.disconnect();
		//关闭
		jedis.close();
	}
    
}