package dao;

import java.util.List;

import entity.Marriage;
import entity.Staff;

public interface MarriageDao {
	public void addMar(Marriage mar);//���
	public void updateMar(Marriage mar);//�޸�
	public void deleteMar(String num);//�����ɾ��
	public List<Marriage> findAll();  //��ѯ����
}
