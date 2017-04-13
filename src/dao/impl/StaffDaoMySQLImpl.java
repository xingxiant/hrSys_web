package dao.impl;

import dao.StaffDao;
import entity.Staff;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StaffDaoMySQLImpl implements StaffDao {

	/**
	 * ���Ա��
	 */
	public void addStaff(Staff staff) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "INSERT INTO staff_information (siNum,siPwd,siName,siSex,siAge,siPhone,siMail,siAdress,siIsMar,cjJobNum,siTime)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";


			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			//String id = UUID.randomUUID().toString().replace("-", "");
			//���ò���
			stmt.setString(1, staff.getSiNum());
			stmt.setString(2, staff.getSiPwd());
			stmt.setString(3, staff.getSiName());
			stmt.setString(4, staff.getSiSex());
			stmt.setInt(5, staff.getSiAge());
			stmt.setString(6, staff.getSiPhone());
			stmt.setString(7, staff.getSiMail());
			stmt.setString(8, staff.getSiAdress());
			stmt.setInt(9, staff.getSiIsMar());
			stmt.setString(10, staff.getCjJobNum());
			stmt.setInt(11, staff.getSiTime());
			
			//ִ��
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}

	public boolean checkContact(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM staff_information where siNum=?";
			
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

	public void deleteStaff(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "DELETE FROM staff_information WHERE siNum=?";
			
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

	public List<Staff> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM staff_information";
			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);
	
			//ִ��
			rs = stmt.executeQuery();
			List<Staff> list = new ArrayList<Staff>();
			while(rs.next()){
				Staff c = new Staff();
		  
				c.setSiNum(rs.getString("siNum"));
				c.setSiPwd(rs.getString("siPwd"));
				c.setSiName(rs.getString("siName"));
				c.setCjJobNum(rs.getString("CjJobNum"));
				c.setSiSex(rs.getString("siSex"));
				c.setSiAge(rs.getInt("siAge"));
				c.setSiIsMar(rs.getInt("siIsMar"));
				c.setSiAdress(rs.getString("siAdress"));
				c.setSiTime(rs.getInt("siTime"));
				c.setSiPhone(rs.getString("siPhone"));
				c.setSiMail(rs.getString("siMail"));
	
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

	public Staff findById(String num) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM staff_information where siNum=?";
			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, num);
	
			//ִ��
			rs = stmt.executeQuery();
			Staff c = null;
			if(rs.next()){
				c = new Staff();

				c.setSiNum(rs.getString("siNum"));
				c.setSiPwd(rs.getString("siPwd"));
				c.setSiName(rs.getString("siName"));
				c.setCjJobNum(rs.getString("CjJobNum"));
				c.setSiSex(rs.getString("siSex"));
				c.setSiAge(rs.getInt("siAge"));
				c.setSiIsMar(rs.getInt("siIsMar"));
				c.setSiAdress(rs.getString("siAdress"));
				c.setSiTime(rs.getInt("siTime"));
				c.setSiPhone(rs.getString("siPhone"));
				c.setSiMail(rs.getString("siMail"));
			}
			return c;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt ,rs);
		}
	}

	/**
	 * �޸�
	 */
	public void updateStaff(Staff staff) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			//��ȡ����
			conn = JdbcUtil.getConnection();
			
			String sql = "UPDATE  staff_information SET siNum=?,siPwd=?,siName=?,siSex=?,siAge=?,siPhone=?,"+
			"siMail=?,siAdress=?,siIsMar=?,cjJobNum=?,siTime=? WHERE siNum=?";
			
			//����PreparedStatement
			stmt = conn.prepareStatement(sql);

			//���ò���

			
			stmt.setString(1, staff.getSiNum());
			stmt.setString(2, staff.getSiPwd());
			stmt.setString(3, staff.getSiName());
			stmt.setString(4, staff.getSiSex());
			stmt.setInt(5, staff.getSiAge());
			stmt.setString(6, staff.getSiPhone());
			stmt.setString(7, staff.getSiMail());
			stmt.setString(8, staff.getSiAdress());
			stmt.setInt(9, staff.getSiIsMar());
			stmt.setString(10, staff.getCjJobNum());
			stmt.setInt(11, staff.getSiTime());
			stmt.setString(12, staff.getSiNum());
			
			
			//ִ��
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}

	}


}
