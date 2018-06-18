package spring.boot.service;

import java.util.List;

import spring.boot.pojo.TableUser;
import spring.boot.pojo.TableUserExample;

public interface TableUserService {

	public long countByExample(TableUserExample example);

	public int deleteByExample(TableUserExample example);

	public int insert(TableUser record);

	public int insertSelective(TableUser record);

	public List<TableUser> selectByExample(TableUserExample example);

	public int updateByExampleSelective(TableUser record, TableUserExample example);

	public int updateByExample(TableUser record, TableUserExample example);

}
