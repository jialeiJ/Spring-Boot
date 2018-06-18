package spring.boot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import spring.boot.mapper.UserInfoMapper;
import spring.boot.pojo.UserInfo;
import spring.boot.pojo.UserInfoExample;
import spring.boot.service.UserInfoService;

@Component
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
    private UserInfoMapper userInfoMapper;

	@Override
	public long countByExample(UserInfoExample example) {
		return userInfoMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(UserInfoExample example) {
		return userInfoMapper.deleteByExample(example);
	}

	@Override
	public int insert(UserInfo record) {
		return userInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(UserInfo record) {
		return userInfoMapper.insertSelective(record);
	}

	@Override
	public List<UserInfo> selectByExample(UserInfoExample example) {
		return userInfoMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(UserInfo record, UserInfoExample example) {
		return userInfoMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(UserInfo record, UserInfoExample example) {
		return userInfoMapper.updateByExample(record, example);
	}
	
}
