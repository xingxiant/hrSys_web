package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import dao.EducationDao;
import entity.Education;
import entity.Marriage;

public class EducationDaoMySQLImpl implements EducationDao {

	@Override
	public void addEdu(Education e) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "INSERT INTO staff_education (seNum,seDegree,seMajor,seSchool,seGraTime,seLanLevel)"
					+ "VALUES(?,?,?,?,?,?)";


			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			//String id = UUID.randomUUID().toString().replace("-", "");
			//设置参数
			stmt.setString(1, e.getSeNum());
			stmt.setString(2, e.getSeDegree());
			stmt.setString(3, e.getSeMajor());
			stmt.setString(4, e.getSeSchool());
			stmt.setInt(5, e.getSeGraTime());
			stmt.setString(6, e.getSeLanLevel());

			
			//执行
			stmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}
	public boolean checkEducation(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM staff_education where seNum=?";
			
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
	public void updateEdu(Education e) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "UPDATE staff_education SET seNum=?,seDegree=?,seMajor=?,seSchool=?,seGraTime=?,seLanLevel=? WHERE seNum=?";
			
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);

			//设置参数

			
			stmt.setString(1, e.getSeNum());
			stmt.setString(2, e.getSeDegree());
			stmt.setString(3, e.getSeMajor());
			stmt.setString(4, e.getSeSchool());
			stmt.setInt(5, e.getSeGraTime());
			stmt.setString(6, e.getSeLanLevel());
			stmt.setString(7, e.getSeNum());

			
			
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
			
			String sql = "DELETE FROM staff_education WHERE seNum=?";
			
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
	public List<Education> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM staff_education";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
	
			//执行
			rs = stmt.executeQuery();
			List<Education> list = new ArrayList<Education>();
			while(rs.next()){
				Education c = new Education();
				c.setSeNum(rs.getString("seNum"));
				c.setSeDegree(rs.getString("seDegree"));
				c.setSeMajor(rs.getString("seMajor"));
				c.setSeSchool(rs.getString("seSchool"));
				c.setSeGraTime(rs.getInt("seGraTime"));
				c.setSeLanLevel(rs.getString("seLanLevel"));



	
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
	public Education findById(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM staff_education where seNum=?";
			
			//创建PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, num);

			//执行
			rs = stmt.executeQuery();
			Education c = null;
			if(rs.next()){
				c = new Education();

				c.setSeNum(rs.getString("seNum"));
				c.setSeDegree(rs.getString("seDegree"));
				c.setSeMajor(rs.getString("seMajor"));
				c.setSeSchool(rs.getString("seSchool"));
				c.setSeGraTime(rs.getInt("seGraTime"));
				c.setSeLanLevel(rs.getString("seLanLevel"));
				
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
