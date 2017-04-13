package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import dao.DepartmentDao;
import entity.Department;
import entity.Jobs;

public class DepartmentDaoMySQLImpl implements DepartmentDao {

	@Override
	public void addEdu(Department d) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "INSERT INTO company_department(cdDepNum, cdName, cdPNum, cdBoss, cdTel)"
					+ "VALUES(?,?,?,?,?)";


			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			//String id = UUID.randomUUID().toString().replace("-", "");
			//设置参数
			stmt.setString(1, d.getCdDepNum());
			stmt.setString(2, d.getCdName());
			stmt.setString(3, d.getCdPNum());
			stmt.setString(4, d.getCdBoss());
			stmt.setString(5, d.getCdTel());


			
			//执行
			stmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			JdbcUtil.close(conn, stmt);
		}

	}

	@Override
	public void updateDe(Department d) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "UPDATE  company_department SET cdDepNum=?,cdName=?,cdPNum=?,cdBoss=?,cdTel=? WHERE cdDepNum=?";
			
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			//设置参数

			
			stmt.setString(1, d.getCdDepNum());
			stmt.setString(2, d.getCdName());
			stmt.setString(3, d.getCdPNum());
			stmt.setString(4, d.getCdBoss());
			stmt.setString(5, d.getCdTel());
			stmt.setString(6, d.getCdDepNum());

			
			
			//执行
			stmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			JdbcUtil.close(conn, stmt);
		}


	}

	@Override
	public void deleteDe(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "DELETE FROM company_department WHERE cdDepNum=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			//设置参数
			stmt.setString(1, num);
			
			//执行
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}



	}
	public boolean checkDepartment(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM company_department where cdDepNum=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, num);
	
			//执行
			rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}
	}

	@Override
	public List<Department> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM company_department";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
	
			//执行
			rs = stmt.executeQuery();
			List<Department> list = new ArrayList<Department>();
			while(rs.next()){
				Department c = new Department();
				c.setCdDepNum(rs.getString("cdDepNum"));
				c.setCdName(rs.getString("cdName"));
				c.setCdPNum(rs.getString("cdPNum"));
				c.setCdBoss(rs.getString("cdBoss"));
				c.setCdTel(rs.getString("cdTel"));




	
				list.add(c);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}
	}
	public Department findById(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM company_department where cdDepNum=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, num);

			//执行
			rs = stmt.executeQuery();
			Department c = null;
			if(rs.next()){
				c = new Department();

				c.setCdDepNum(rs.getString("cdDepNum"));
				c.setCdName(rs.getString("cdName"));
				c.setCdPNum(rs.getString("cdPNum"));
				c.setCdBoss(rs.getString("cdBoss"));
				c.setCdTel(rs.getString("cdTel"));

				
			}
			return c;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}
	}



}
