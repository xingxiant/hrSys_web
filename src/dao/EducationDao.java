package dao;

import java.util.List;

import entity.Education;


public interface EducationDao {
	public void addEdu(Education e);//添加
	public void updateEdu(Education e);//修改
	public void deleteEdu(String num);//按编号删除
	public List<Education> findAll();  //查询所有
}
