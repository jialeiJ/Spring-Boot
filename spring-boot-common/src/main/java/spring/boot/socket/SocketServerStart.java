package spring.boot.socket;

/**
 * @Company:  Jaray.com
 *  @Author:  JiaLei
 *    @Date:  2018年5月18日
 */
public class SocketServerStart {

	public static void main(String[] args) throws InterruptedException {
		while(true) {
			new SocketServer();
		}

	}

}
