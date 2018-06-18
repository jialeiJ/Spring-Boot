package spring.boot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import spring.boot.mapper.SysRoleMapper;
import spring.boot.pojo.SysRole;
import spring.boot.pojo.SysRoleExample;
import spring.boot.service.SysRoleService;

@Component
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

	@Override
	public long countByExample(SysRoleExample example) {
		return sysRoleMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysRoleExample example) {
		return sysRoleMapper.deleteByExample(example);
	}

	@Override
	public int insert(SysRole record) {
		return sysRoleMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRole record) {
		return sysRoleMapper.insertSelective(record);
	}

	@Override
	public List<SysRole> selectByExample(SysRoleExample example) {
		return sysRoleMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SysRole record, SysRoleExample example) {
		return sysRoleMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysRole record, SysRoleExample example) {
		return sysRoleMapper.updateByExample(record, example);
	}
	
}
