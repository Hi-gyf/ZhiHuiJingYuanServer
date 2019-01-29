package dao;

import Utils.JDBCUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class AbstractDao {

	public int update(String sql,Object[] values){
		int successCount = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = JDBCUtil.getConn();
			preStmt = conn.prepareStatement(sql);
			if(values != null)
			for(int i = 0; i < values.length; i++){
				preStmt.setObject(i+1, values[i]);
			}
			preStmt.executeUpdate();
			successCount = preStmt.getUpdateCount();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(null, preStmt, conn);
		}
		return successCount;
	}
	
	public int updateall(String sql , Object[][] values){
		int ok  = 0;
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = JDBCUtil.getConn();
			preStmt = conn.prepareStatement(sql);
			if(values != null)
			for(int i = 0; i < values.length; i++){
				for(int j = 0; j < values[i].length; j++){					
					preStmt.setObject(j+1, values[i][j]);
				}
				preStmt.addBatch();
			}
			int[] rows = preStmt.executeBatch();
			ok = rows.length;
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(null, preStmt, conn);
		}
		return ok;
	}
	

	public Vector<Map<String,String>> select(String sql, Object[] values){
		Vector<Map<String,String>> all = new Vector<Map<String,String>>();
		Map<String,String> line = null;
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try{
			conn = JDBCUtil.getConn();
			preStmt = conn.prepareStatement(sql);
			if(values != null)
			{				
				for(int i = 0; i < values.length; i++){
					preStmt.setObject(i+1, values[i]);
				}
			}
			rs = preStmt.executeQuery();
			rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()){
				line = new HashMap<String,String>();
				for(int i = 1; i <= count; i++){
					line.put(rsmd.getColumnName(i),rs.getString(i));
				}
				all.add(line);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(rs, preStmt, conn);
		}
		return all;
	}

	public Map<String,String> find(String sql, Object[] values){
		Map ok = null;
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try{
			conn = JDBCUtil.getConn();
			preStmt = conn.prepareStatement(sql);
			if(values != null)
				for(int i = 0; i < values.length; i++)
				{
					preStmt.setObject(i+1, values[i]);
				}
			rs = preStmt.executeQuery();
			rsmd = rs.getMetaData();
			if(rs.next()){
				ok = new HashMap<String,String>();

				for(int i = 1; i <= rsmd.getColumnCount();i++){
					String columnName = rsmd.getColumnName(i).toLowerCase();//获得表字段名
					String columnValue = rs.getString(i);
					ok.put(columnName,columnValue);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConn(rs, preStmt, conn);
		}
		return ok;
	}
}
