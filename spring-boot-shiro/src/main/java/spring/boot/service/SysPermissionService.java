package spring.boot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import spring.boot.pojo.SysPermission;
import spring.boot.pojo.SysPermissionExample;

@Service
public interface SysPermissionService {
	long countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);
}
