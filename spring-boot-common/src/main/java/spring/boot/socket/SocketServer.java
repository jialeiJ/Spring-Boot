package spring.boot.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Company:  Jaray.com
 *  @Author:  JiaLei
 *    @Date:  2018年5月18日
 */
public class SocketServer {
	static ServerSocket serverSocket;
	static {
	    try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SocketServer() throws InterruptedException {
		try {  
            //创建服务器端的 Socket,0-65535,其中0-1023是知名端口 
			//ServerSocket serverSocket=new ServerSocket(8888);
			//serverSocket.setSoTimeout(50000);
            //开始监听服务器端的 Socket,一旦客户端调用 socket 就被实例化  
            Socket socket=serverSocket.accept();  
              
            //获取客户端输入流  
            InputStream inputStream=socket.getInputStream();  
            byte b[]=new byte[1024];  
            StringBuffer sbf=new StringBuffer();  
            for(int n;(n=inputStream.read(b))!=-1;){  
                sbf.append(new String(b,0,n));                
            }
            int falg = 0;
            int l = 5;
            for (int i = 0; i < l; i++) {
            	if(falg == 0) {
            		try {
            			falg++;
						throw new Exception();
					} catch (Exception e) {
						e.printStackTrace();
					}
            	}
				System.out.println(i+" --- "+i);
				//Thread.currentThread();
				Thread.sleep(3000);
			}
            System.out.println("客户端传递进来的信息为："+sbf.toString());  
            socket.shutdownInput();  
              
            //向客户端反馈信息  
            OutputStream outputStream=socket.getOutputStream();  
            PrintWriter printWriter=new PrintWriter(outputStream);  
            printWriter.write("我是服务端");  
            printWriter.flush();  
            socket.shutdownOutput();  
              
            //关闭资源  
              
            inputStream.close();  
            printWriter.close();  
            outputStream.close();  
              
            socket.close();  
            //serverSocket.close();  
              
        } catch (IOException e) {
            e.printStackTrace();  
        }
	}

}
