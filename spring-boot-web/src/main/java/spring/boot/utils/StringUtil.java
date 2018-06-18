package spring.boot.utils;

/**
 * 功能描述：字符串操作工具类
 * @autor:tianming
 * @date: 2015-8-5
 */
import java.io.UnsupportedEncodingException;

public class StringUtil {
	private String UTF_8 = "UTF-8";
	private String ISO_8859_1 = "ISO-8859-1";
	private String GBK = "GBK";
	
	public String utf_8ToIso_8859_1(String s) {
		try {
			s =  new String(s.getBytes(UTF_8),ISO_8859_1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public String iso_8859_1ToUtf_8(String s) {
		try {
			s =  new String(s.getBytes(ISO_8859_1),UTF_8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public String iso_8859_1ToGbk(String s) {
		try {
			s =  new String(s.getBytes(ISO_8859_1),GBK);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public String gbkToIso_8859_1(String s) {
		try {
			s =  new String(s.getBytes(GBK),ISO_8859_1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public String utf_8ToGbk(String s) {
		try {
			s =  new String(s.getBytes(UTF_8),GBK);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public String gbkToUtf_8(String s) {
		try {
			s =  new String(s.getBytes(GBK),UTF_8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}
	
}
