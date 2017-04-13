package dao;

import entity.Staff;

import java.util.List;

/**
 * 鍛樺伐鐨凞AO鎺ュ彛
 * @author XXt
 *
 */
public interface StaffDao {
	public void addStaff(Staff staff);//娣诲姞鍛樺伐
	public void updateStaff(Staff staff);//淇敼鍛樺伐
	public void deleteStaff(String num);//鎸夌紪鍙峰垹闄ゅ憳宸�	
	public List<Staff> findAll();  //鏌ヨ鎵�湁鍛樺伐
}
