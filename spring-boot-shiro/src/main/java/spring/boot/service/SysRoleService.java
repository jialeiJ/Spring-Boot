package spring.boot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import spring.boot.pojo.SysRole;
import spring.boot.pojo.SysRoleExample;
@Service
public interface SysRoleService {
	long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);
}
