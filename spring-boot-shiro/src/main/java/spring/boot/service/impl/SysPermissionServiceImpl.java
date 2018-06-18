package spring.boot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import spring.boot.mapper.SysPermissionMapper;
import spring.boot.pojo.SysPermission;
import spring.boot.pojo.SysPermissionExample;
import spring.boot.service.SysPermissionService;
@Component
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

	@Override
	public long countByExample(SysPermissionExample example) {
		return sysPermissionMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysPermissionExample example) {
		return sysPermissionMapper.deleteByExample(example);
	}

	@Override
	public int insert(SysPermission record) {
		return sysPermissionMapper.insert(record);
	}

	@Override
	public int insertSelective(SysPermission record) {
		return sysPermissionMapper.insertSelective(record);
	}

	@Override
	public List<SysPermission> selectByExample(SysPermissionExample example) {
		return sysPermissionMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SysPermission record, SysPermissionExample example) {
		return sysPermissionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysPermission record, SysPermissionExample example) {
		return sysPermissionMapper.updateByExample(record, example);
	}
	
}
