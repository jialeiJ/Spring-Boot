package spring.boot.common;

import java.util.HashMap;
import java.util.Map;

/**
 *  通用的返回json格式的类
 */
public class Message {
	//状态码：成功-100  失败-200
	private Integer code;
	//提示信息
	private String info;
	
	//返回给浏览器的数据
	private Map<String, Object> map = new HashMap<String, Object>();
	
	public static Message success() {
		Message message = new Message();
		message.setCode(100);
		message.setInfo("处理成功！");
		return message;
	}
	
	public static Message fail() {
		Message message = new Message();
		message.setCode(200);
		message.setInfo("处理失败！");
		return message;
	}
	
	public Message add(String key, Object value) {
		this.getMap().put(key, value);
		return this;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}

