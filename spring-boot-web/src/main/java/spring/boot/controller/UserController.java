package spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.common.Message;
import spring.boot.pojo.TableUser;
import spring.boot.pojo.TableUserExample;
import spring.boot.pojo.TableUserExample.Criteria;
import spring.boot.service.TableUserService;
import spring.boot.utils.RedisUtil;
import spring.boot.utils.SpringUtil;

@RestController
public class UserController {
	
	@Autowired
	private TableUserService tableUserService;
	
	/*增:insert、删delete、改update、查:select*/
	@RequestMapping(value="/insertUser")
	public Message insertUser(@RequestParam String bh, @RequestParam String xm, @RequestParam String sfz, @RequestParam String nl, @RequestParam String mm,@RequestParam String sjh,@RequestParam String jtzz) {
		TableUser user = SpringUtil.getBean(TableUser.class);
		user.setBh(bh);
		user.setXm(xm);
		user.setSfz(sfz);
		user.setNl(nl);
		user.setMm(mm);
		user.setSjh(sjh);
		user.setJtzz(jtzz);
		tableUserService.insertSelective(user);
		return Message.success().add("user", user);
	}
	
	
	@RequestMapping("/getUser")
    @Cacheable(value="user-key")
    public TableUser getUser() {
		TableUserExample example = new TableUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andBhEqualTo("1");
		List<TableUser> userList = tableUserService.selectByExample(example);
    	System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
        return userList.get(0);
    }
    
    @RequestMapping("/getUsers")
    @Cacheable(value="key-Users")
    public List<TableUser> getUsers() {
    	TableUserExample example = new TableUserExample();
    	List<TableUser> userList = tableUserService.selectByExample(example);
    	System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
        return userList;
    }
    
    @RequestMapping("/clear")
    public void clear() {
    	new RedisUtil().clear();
    }

}
