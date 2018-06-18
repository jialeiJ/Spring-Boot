package spring.boot.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Company:  Jaray.com
 *  @Author:  JiaLei
 *    @Date:  2018年5月18日
 */
public class SocketClient {
	
	public SocketClient() {
		try {  
            Socket socket = new Socket("127.0.0.1",8888);
            socket.setSoTimeout(80000);
            OutputStream outputStream=socket.getOutputStream();  
            PrintWriter printWriter=new PrintWriter(outputStream);  
            printWriter.write("你好，我是客户端");  
            printWriter.flush();  
            socket.shutdownOutput();  
              
            //获取服务器端返回的信息  
            //获取服务端输入流  
            InputStream inputStream=socket.getInputStream();  
            byte b[]=new byte[1024];  
            StringBuffer sbf=new StringBuffer();  
            for(int n;(n=inputStream.read(b))!=-1;){  
                sbf.append(new String(b,0,n));                
            }  
            System.out.println("服务器端反馈进来的信息为："+sbf.toString());  
            socket.shutdownInput();  
              
            //关闭资源  
            printWriter.close();  
            outputStream.close();  
              
            inputStream.close();  
            socket.close();  
        } catch (UnknownHostException e) {    
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}

}
