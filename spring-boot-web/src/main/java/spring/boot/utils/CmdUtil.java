package spring.boot.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CmdUtil {
	
	
	public void testSimpleCmd() {
		try {
			String cmd ="cmd /c dir c:\\";
			Process process = Runtime.getRuntime().exec(cmd);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
			String str = null;
			while((str=bufferedReader.readLine())!=null) {
				System.out.println(str);
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����
	public static void testMySql() {
		try {
			//String cmd ="cmd /c mysqldump -u yqyq -p yqyq yqyq";//cmd /c mysqldump -u �û��� -p ����  ���ݿ���
			String cmd = "cmd /c exp yqyq/yqyq1234@YQYQ file =d:\\fz.dmp file=true";
			Process process = Runtime.getRuntime().exec(cmd);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/fz.sql"));
			String str = null;
			while((str=bufferedReader.readLine())!=null) {
				bufferedWriter.write(str);
				bufferedWriter.newLine();
		    }
			bufferedReader.close();
			bufferedWriter.close();
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
	}
	
	public static void testResumeMySql() {
		try {
			String cmd ="cmd /c mysql -u yqyq -p yqyq yqyq";//cmd /c mysqldump -u �û��� -p ����  ���ݿ���
			Process process = Runtime.getRuntime().exec(cmd);
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
			BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/fz.sql"));
			
			
			
			String str = null;
			while((str=bufferedReader.readLine())!=null) {
				bufferedWriter.write(str);
				bufferedWriter.newLine();
		    }
			bufferedReader.close();
			bufferedWriter.close();
	    } catch (IOException e) {
		    e.printStackTrace();
	    }
		
	}
	
	
	
	public static void main(String[] args) {
		testMySql();
		testResumeMySql();
	}

}
