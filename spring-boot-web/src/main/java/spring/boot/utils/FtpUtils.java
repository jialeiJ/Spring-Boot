package spring.boot.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;


public class FtpUtils {
	private static FTPClient ftpClient;
	
	private static FTPClient doInit() {
		try {
			//FTP服务器ip地址："127.0.0.1";
			String ip = "172.16.9.125";
			String port = "21";
			//用户名："jaray";
			String username = "administrator";
			//密码："p@ssw0rd";
			String password = "root";
            ftpClient = new FTPClient();  
            ftpClient.connect(ip.trim(), Integer.parseInt(port));// 连接FTP服务器  
            ftpClient.login(username, password);// 登陆FTP服务器  
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {  
                //logger.info("未连接到FTP,用户名或密码错误!");  
                ftpClient.disconnect();  
            } else {
            	System.out.println("FTP连接成功!");
                //logger.info("FTP连接成功!");  
            }  
        } catch (SocketException e) {  
            e.printStackTrace();  
            //logger.info("FTP的IP地址可能错误，请正确配置。");  
        } catch (IOException e) {  
            e.printStackTrace();  
            //logger.info("FTP的端口错误,请正确配置。");  
        }  
        return ftpClient;
	}
	
	
	public static boolean upload(File file, String sign) {
		InputStream is = null;
		try {  
            ftpClient = doInit();
            // 设置PassiveMode传输  
            ftpClient.enterLocalPassiveMode();  
            // 设置以二进制流的方式传输  
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            String remoteFilePath = null;
            Boolean  flag = false;
            //设置上传路径
            if("0".equals(sign)){
            	remoteFilePath="最高人民法院/Upload";
            	flag = ftpClient.changeWorkingDirectory(remoteFilePath);
            	if(!flag){
                    System.out.println("路径："+remoteFilePath+" 不存在");
                }
			}else if("1".equals(sign)){
				remoteFilePath="公安部经侦/Upload";
				flag = ftpClient.changeWorkingDirectory(new String(remoteFilePath.getBytes("GBK"),"ISO-8859-1"));
				if(!flag){
					System.out.println("路径："+remoteFilePath+" 不存在");
                }
			}
            //指定上传路径
            ftpClient.changeWorkingDirectory(new String(remoteFilePath.getBytes("GBK"),"ISO-8859-1"));
            //指定上传文件的类型  二进制文件
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //读取本地文件
            is = new FileInputStream(file);
            //第一个参数是文件名
            Boolean bool = ftpClient.storeFile(new String(file.getName().getBytes("GBK"),"ISO-8859-1"), is);
            if(bool) {
            	System.out.println("上传成功");
            	return true;
            }
		} catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭文件流
                is.close();
                //退出
                ftpClient.logout();
                //断开连接
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return false;
	}
	
	
	public static boolean download(String localPath,String sign) {
		String locaFileName = null;//本地文件名称
		String locaFilePath = localPath;//本地文件名称
		String remoteFilePath = null;
		String remoteFileName = null;//远程文件名称
        try {  
        	FTPClient ftpClient = doInit(); 
        	// 设置PassiveMode传输  
            ftpClient.enterLocalPassiveMode();  
            // 设置以二进制流的方式传输  
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //下载文件  
            //OutputStream outputStream = new FileOutputStream(locaFileName);
            //ftpClient.retrieveFile(remoteFileName, outputStream);
            Boolean  flag = false; 
            //设置上传路径
            if("0".equals(sign)){
            	remoteFilePath="最高人民法院/Upload";
            	flag = ftpClient.changeWorkingDirectory(new String(remoteFilePath.getBytes("GBK"),"ISO-8859-1"));
            	if(!flag){
            		System.out.println("路径："+remoteFilePath+" 不存在");
                }
			}else if("1".equals(sign)){
				remoteFilePath="公安部经侦/Upload";
				flag = ftpClient.changeWorkingDirectory(new String(remoteFilePath.getBytes("GBK"),"ISO-8859-1"));
				if(!flag){
					System.out.println("路径："+remoteFilePath+" 不存在");
                }
			}
            //获取所有文件
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for (FTPFile ftpFile : ftpFiles) {
				if(ftpFile.isFile()) {
					System.out.println(new String(ftpFile.getName().getBytes("ISO-8859-1"),"GBK"));
					locaFileName = new String(ftpFile.getName().getBytes("ISO-8859-1"),"GBK");
					remoteFileName = new String(ftpFile.getName().getBytes("ISO-8859-1"),"GBK");
					OutputStream outputStream = new FileOutputStream(locaFilePath+"/"+remoteFileName);
					ftpClient.retrieveFile(locaFilePath+locaFileName, outputStream);   
					outputStream.close();  
					//退出  
					ftpClient.noop();  
					ftpClient.logout(); 
				}
			}
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally {  
            if (ftpClient.isConnected()) {  
                try {  
                	ftpClient.disconnect();  
                } catch (IOException f) {  
                }  
            }  
        }  
		return false;
	}


	public static void main(String[]args){
		//FtpUtils.upload(new File("C:\\Users\\User\\Desktop\\扣划问题记录.txt"), "1");//OK
		FtpUtils.download("C:\\Users\\User\\Desktop", "1");
	}
}
