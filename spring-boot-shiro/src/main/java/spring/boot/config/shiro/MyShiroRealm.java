package spring.boot.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.tomcat.util.security.MD5Encoder;

import spring.boot.pojo.SysPermission;
import spring.boot.pojo.SysPermissionExample;
import spring.boot.pojo.SysRole;
import spring.boot.pojo.SysRoleExample;
import spring.boot.pojo.SysRoleExample.Criteria;
import spring.boot.pojo.SysRolePermission;
import spring.boot.pojo.SysRolePermissionExample;
import spring.boot.pojo.SysUserRole;
import spring.boot.pojo.SysUserRoleExample;
import spring.boot.pojo.UserInfo;
import spring.boot.pojo.UserInfoExample;
import spring.boot.service.SysPermissionService;
import spring.boot.service.SysRolePermissionService;
import spring.boot.service.SysRoleService;
import spring.boot.service.SysUserRoleService;
import spring.boot.service.UserInfoService;

import java.awt.print.Printable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
	@Resource
    private UserInfoService userInfoService;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysUserRoleService sysUserRoleService;
    @Resource
    private SysRolePermissionService sysRolePermissionService;
    @Resource
    private SysPermissionService sysPermissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
        
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        spring.boot.pojo.SysUserRoleExample.Criteria criteria = sysUserRoleExample.createCriteria();
        criteria.andUidEqualTo(userInfo.getUid());
        List<SysUserRole> sysUserRoleList = sysUserRoleService.selectByExample(sysUserRoleExample);
        for(SysUserRole sysUserRole:sysUserRoleList){//userInfo.getRoleList()
        	SysRoleExample sysRoleExample = new SysRoleExample();
            Criteria sysRolecriteria = sysRoleExample.createCriteria();
            sysRolecriteria.andIdEqualTo(sysUserRole.getRid());
            List<SysRole> sysRoleList = sysRoleService.selectByExample(sysRoleExample);
            authorizationInfo.addRole(sysRoleList.get(0).getJs());
            
            SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
            spring.boot.pojo.SysRolePermissionExample.Criteria sysRolePermissionCriteria = sysRolePermissionExample.createCriteria();
            sysRolePermissionCriteria.andRidEqualTo(sysUserRole.getRid());
            List<SysRolePermission> sysRolePermissionList = sysRolePermissionService.selectByExample(sysRolePermissionExample);
            for (SysRolePermission sysRolePermission : sysRolePermissionList) {
				SysPermissionExample sysPermissionExample = new SysPermissionExample();
				spring.boot.pojo.SysPermissionExample.Criteria sysPermissionCriteria = sysPermissionExample.createCriteria();
				sysPermissionCriteria.andIdEqualTo(sysRolePermission.getPid());
				List<SysPermission> sysPermissionList = sysPermissionService.selectByExample(sysPermissionExample);
				for(SysPermission sysPermission:sysPermissionList){
	                authorizationInfo.addStringPermission(sysPermission.getQx());
	            }
			}
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
    	UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        System.out.println(username+"---"+password);
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        //String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        System.out.println("username="+token.getPrincipal());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfoExample userInfoExample = new UserInfoExample();
        spring.boot.pojo.UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andZhEqualTo(username);
        List<UserInfo> userInfoList = userInfoService.selectByExample(userInfoExample);
        UserInfo userInfo = userInfoList.get(0);//唯一性,只能查出一条
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getMm(), //密码
                //ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=xm+salt
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=xm+salt
                getName()  //realm name
        );
        System.out.println("salt="+userInfo.getCredentialsSalt());
        return authenticationInfo;
    }

}