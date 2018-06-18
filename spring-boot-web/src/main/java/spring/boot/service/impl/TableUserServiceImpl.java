package spring.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.mapper.TableUserMapper;
import spring.boot.pojo.TableUser;
import spring.boot.pojo.TableUserExample;
import spring.boot.service.TableUserService;

@Service
public class TableUserServiceImpl implements TableUserService {
	
	@Autowired
    private TableUserMapper tableUserMapper;

	@Override
	public long countByExample(TableUserExample example) {
		return tableUserMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TableUserExample example) {
		return tableUserMapper.deleteByExample(example);
	}

	@Override
	public int insert(TableUser record) {
		return tableUserMapper.insert(record);
	}

	@Override
	public int insertSelective(TableUser record) {
		return tableUserMapper.insertSelective(record);
	}

	@Override
	public List<TableUser> selectByExample(TableUserExample example) {
		return tableUserMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(TableUser record, TableUserExample example) {
		return tableUserMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TableUser record, TableUserExample example) {
		return tableUserMapper.updateByExample(record, example);
	}

}
