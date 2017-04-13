package dao;

import java.util.List;

import entity.Jobs;



public interface JobsDao {
	public void addJob(Jobs j);//添加
	public void updateEdu(Jobs j);//修改
	public void deleteEdu(String num);//按编号删除
	public List<Jobs> findAll();  //查询所有
	
}
