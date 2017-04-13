package dao;

import java.util.List;

import entity.Department;



public interface DepartmentDao {
	public void addEdu(Department d);//添加
	public void updateDe(Department d);//修改
	public void deleteDe(String num);//按编号删除
	public List<Department> findAll();  //查询所有
	
}
