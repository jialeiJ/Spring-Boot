package spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import spring.boot.pojo.TableUser;
import spring.boot.pojo.TableUserExample;
@Mapper
public interface TableUserMapper {
    long countByExample(TableUserExample example);

    int deleteByExample(TableUserExample example);

    int insert(TableUser record);

    int insertSelective(TableUser record);

    List<TableUser> selectByExample(TableUserExample example);

    int updateByExampleSelective(@Param("record") TableUser record, @Param("example") TableUserExample example);

    int updateByExample(@Param("record") TableUser record, @Param("example") TableUserExample example);
}