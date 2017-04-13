package dao;

import java.util.List;

import entity.Marriage;
import entity.Staff;

public interface MarriageDao {
	public void addMar(Marriage mar);//添加
	public void updateMar(Marriage mar);//修改
	public void deleteMar(String num);//按编号删除
	public List<Marriage> findAll();  //查询所有
}
