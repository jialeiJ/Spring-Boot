package spring.boot.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class HelloWorld {
	
	private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);
    
	public static void main(String[] args) {
		log.info("我们正在测试Log4j....");
		/**
		 * 1、获取安全管理器
		 * 2、获取用户
		 * 3、用户登录验证
		 * 4、权限管理
		 * 5、角色管理
		 * 6、session:
		 */
		
        /**JavaSE环境Shiro的搭建及常用API*/
		//1、获取安全管理器
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		//2、需要设置安全管理器
		SecurityUtils.setSecurityManager(securityManager);
		
		//3、获取subject对象，即将登录的用户
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		
		session.setAttribute("name", "贾雷");
		
		String value = (String) session.getAttribute("name");
		if(value != null){
			log.info("shiro已经帮我们获取到了session会话对象当中指定的值： "+value);
		}
		
		
		/**JavaSE环境Shiro认证过程及API*/
		if(currentUser.isAuthenticated()==false){//判断是否登录过
			//UsernamePasswordToken
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jialei","123456");//指定用户名和密码(必须是shiro中存在的)
			usernamePasswordToken.setRememberMe(true);//记住我
			
			try {
				currentUser.login(usernamePasswordToken);//可能出现异常
				log.info("用户名和密码正确，登陆成功");
			} catch (UnknownAccountException e) {
				log.info("账户不存在");
			}catch (IncorrectCredentialsException e) {
				log.info("密码错误");	
			}catch (LockedAccountException e) {
				log.info("用户已经锁死");
			}catch (AuthenticationException e) {
				log.info("认证异常");			}
			
		}
		
		
		/**Shiro角色、权限认证过程及API*/
		if(currentUser.hasRole("goodguy")){//判断是否拥有指定的角色
			log.info("拥有指定的角色");
		}else{
			log.info("不拥有指定的角色");
		}
		if(currentUser.isPermitted("winnebago:driver:eagle5")){//判断是否具有指定的权限
			log.info("具有指定的权限");
		}else{
			log.info("不具有指定的权限");
		}
		
		log.info("用户的状态      登录： "+currentUser.isAuthenticated());
		/**退出*/
		currentUser.logout();
		log.info("用户的状态      退出： "+currentUser.isAuthenticated());
		
		System.exit(0);;	
	}
}