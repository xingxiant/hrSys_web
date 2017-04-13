package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import dao.JobsDao;
import entity.Education;
import entity.Jobs;

public class JobsDaoMySQLImpl implements JobsDao {

	@Override
	public void addJob(Jobs j) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "INSERT INTO company_jobs(cjJobNum, cdDepNum, cjName, cjMoney)"
					+ "VALUES(?,?,?,?)";


			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			//String id = UUID.randomUUID().toString().replace("-", "");
			//设置参数
			stmt.setString(1, j.getCjJobNum());
			stmt.setString(2, j.getCdDepNum());
			stmt.setString(3, j.getCjName());
			stmt.setString(4, j.getCjMoney());


			
			//执行
			stmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			JdbcUtil.close(conn, stmt);
		}

	}
	public boolean checkJobs(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM company_jobs where cjJobNum=?";
			
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
	public void updateEdu(Jobs j) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "UPDATE  company_jobs SET cjJobNum=?,cdDepNum=?,cjName=?,cjMoney=? WHEREcjJobNum=?";
			
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			//设置参数

			
			stmt.setString(1, j.getCjJobNum());
			stmt.setString(2, j.getCdDepNum());
			stmt.setString(3, j.getCjName());
			stmt.setString(4, j.getCjMoney());
			stmt.setString(5, j.getCjJobNum());

			
			
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
	public void deleteEdu(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "DELETE FROM company_jobs WHERE cjJobNum=?";
			
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

	@Override
	public List<Jobs> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM company_jobs";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
	
			//执行
			rs = stmt.executeQuery();
			List<Jobs> list = new ArrayList<Jobs>();
			while(rs.next()){
				Jobs c = new Jobs();
				c.setCjJobNum(rs.getString("cjJobNum"));
				c.setCdDepNum(rs.getString("cdDepNum"));
				c.setCjName(rs.getString("cjName"));
				c.setCjMoney(rs.getString("cjMoney"));




	
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
	public Jobs findById(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM company_jobs where cjJobNum=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, num);

			//执行
			rs = stmt.executeQuery();
			Jobs c = null;
			if(rs.next()){
				c = new Jobs();

				c.setCjJobNum(rs.getString("cjJobNum"));
				c.setCdDepNum(rs.getString("cdDepNum"));
				c.setCjName(rs.getString("cjName"));
				c.setCjMoney(rs.getString("cjMoney"));

				
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
