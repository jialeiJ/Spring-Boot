package spring.boot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import spring.boot.mapper.SysRolePermissionMapper;
import spring.boot.pojo.SysRolePermission;
import spring.boot.pojo.SysRolePermissionExample;
import spring.boot.service.SysRolePermissionService;

@Component
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

	@Override
	public long countByExample(SysRolePermissionExample example) {
		return sysRolePermissionMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysRolePermissionExample example) {
		return sysRolePermissionMapper.deleteByExample(example);
	}

	@Override
	public int insert(SysRolePermission record) {
		return sysRolePermissionMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRolePermission record) {
		return sysRolePermissionMapper.insertSelective(record);
	}

	@Override
	public List<SysRolePermission> selectByExample(SysRolePermissionExample example) {
		return sysRolePermissionMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SysRolePermission record, SysRolePermissionExample example) {
		return sysRolePermissionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysRolePermission record, SysRolePermissionExample example) {
		return sysRolePermissionMapper.updateByExample(record, example);
	}
	
}
