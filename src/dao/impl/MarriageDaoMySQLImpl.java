package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.MarriageDao;
import util.JdbcUtil;
import entity.Marriage;
import entity.Staff;

public class MarriageDaoMySQLImpl implements MarriageDao{
	public void addMar(Marriage mar){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "INSERT INTO staff_marriage (smNum,smName,smAge,smJob,smPhone)"
					+ "VALUES(?,?,?,?,?)";


			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			//String id = UUID.randomUUID().toString().replace("-", "");
			//���ò���
			stmt.setString(1, mar.getSmNum());
			stmt.setString(2, mar.getSmName());
			stmt.setInt(3, mar.getSmAge());
			stmt.setString(4, mar.getSmJob());
			stmt.setString(5, mar.getSmPhone());

			
			//ִ��
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}
	public boolean checkMarriage(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM staff_marriage where smNum=?";
			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, num);
	
			//ִ��
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
	public void deleteMar(String num){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "DELETE FROM staff_marriage WHERE smNum=?";
			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			//���ò���
			stmt.setString(1, num);
			
			//ִ��
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}
	public List<Marriage> findAll(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM staff_marriage";
			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);
	
			//ִ��
			rs = stmt.executeQuery();
			List<Marriage> list = new ArrayList<Marriage>();
			while(rs.next()){
				Marriage c = new Marriage();
				c.setSmNum(rs.getString("smNum"));
				c.setSmPhone(rs.getString("smAge"));
				c.setSmName(rs.getString("smName"));
				c.setSmAge(rs.getInt("smAge"));
				c.setSmJob(rs.getString("smJob"));



	
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
	@Override
	public void updateMar(Marriage mar) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "UPDATE  staff_marriage SET smNum=?,smName=?,smAge=?,smJob=?,smPhone=? WHERE smNum=?";
			
			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);

			//���ò���

			
			stmt.setString(1, mar.getSmNum());
			stmt.setString(2, mar.getSmName());
			stmt.setInt(3, mar.getSmAge());
			stmt.setString(4, mar.getSmJob());
			stmt.setString(5, mar.getSmPhone());
			stmt.setString(6, mar.getSmNum());

			
			
			//ִ��
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
		
		
	}
	public Marriage findById(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM staff_marriage where smNum=?";
			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, num);
	
			//ִ��
			rs = stmt.executeQuery();
			Marriage c = null;
			if(rs.next()){
				c = new Marriage();

				c.setSmNum(rs.getString("smNum"));
				c.setSmName(rs.getString("smName"));
				c.setSmAge(rs.getInt("smAge"));
				c.setSmJob(rs.getString("smJob"));
				c.setSmPhone(rs.getString("smPhone"));
				
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
