package spring.boot.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DbUtil {
	/**
	 * 功能描述：查询指定表的某一列的值
	 * @param columnName 列名
	 * @param tableName  表名
	 * @param where		 查询条件
	 * @return 列值
	 */
	public static String getColumnValue(String tableName,String columnName,String where){
		try {
			JdbcTemplate jdbcTemplate = SpringUtil.getJdbcTemplate();
			String sql = "select "+columnName+" from "+tableName+" "+where;
			String value = jdbcTemplate.queryForObject(sql,String.class);
			return value;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 功能描述：查询指定表的某几列的值
	 * @param columnsName 列名
	 * @param tableName  表名
	 * @param where		 查询条件
	 * @return 列值
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String,String> getColumnsValue(String tableName,final String[] columnsName,String where){
		JdbcTemplate jt = SpringUtil.getJdbcTemplate();
		String sql = "select ";
		for(int i = 0;i<columnsName.length;i++){
			sql += columnsName[i];
			if(i!=columnsName.length-1){
				sql +=",";
			}
		}
		sql +=  " from "+tableName+" where "+where;
		Map<String,String> value = jt.queryForObject(sql,new RowMapper<Map>(){
			public Map<String,String> mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String,String> info = new HashMap<String,String>();
				for(int i = 0;i<columnsName.length;i++){
					 info.put(columnsName[i],rs.getString(columnsName[i]));
				}
				return info;
			}
			
		});
		return value;
	}
	/**
	 * 功能描述：列表查询
	 * @param sql sql
	 * @return 列值
	 */
	public static List<Map<String,Object>> getList(String sql){
		JdbcTemplate jt = SpringUtil.getJdbcTemplate();
		List<Map<String,Object>> list = jt.query(sql, new RowMapper<Map<String,Object>>(){
			@Override
			public Map<String, Object> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Map<String,Object> map = new HashMap<String,Object>();
				ResultSetMetaData rsm = rs.getMetaData();
				int columnCount = rsm.getColumnCount();
				for(int i = 1;i<=columnCount;i++){
					String val = rs.getString(rsm.getColumnName(i));
					map.put(rsm.getColumnName(i).toLowerCase(),val);
				}
				return map;
			}
		});
		return list;
	}
	/**
	 * 功能描述：查询指定表的某一列的值
	 * @param sql		 查询语句
	 * @return 列值
	 */
	public static String getColumnValueBySql(String sql){
		String value="";
		try {
			JdbcTemplate jt = SpringUtil.getJdbcTemplate();
			value = jt.queryForObject(sql,String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
	public static String getWaterNo(String seqName){
		try {
			JdbcTemplate jt = SpringUtil.getJdbcTemplate();
			String sql = "select "+seqName+".nextval from dual";
			String value = jt.queryForObject(sql,String.class);
			return value;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
