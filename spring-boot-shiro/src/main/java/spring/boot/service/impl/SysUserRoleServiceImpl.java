package spring.boot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import spring.boot.mapper.SysUserRoleMapper;
import spring.boot.pojo.SysUserRole;
import spring.boot.pojo.SysUserRoleExample;
import spring.boot.service.SysUserRoleService;

@Component
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public long countByExample(SysUserRoleExample example) {
		return sysUserRoleMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysUserRoleExample example) {
		return sysUserRoleMapper.deleteByExample(example);
	}

	@Override
	public int insert(SysUserRole record) {
		return sysUserRoleMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUserRole record) {
		return sysUserRoleMapper.insertSelective(record);
	}

	@Override
	public List<SysUserRole> selectByExample(SysUserRoleExample example) {
		return sysUserRoleMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SysUserRole record, SysUserRoleExample example) {
		return sysUserRoleMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysUserRole record, SysUserRoleExample example) {
		return sysUserRoleMapper.updateByExample(record, example);
	}
	
}
