package dao;

import java.util.List;

import entity.Jobs;



public interface JobsDao {
	public void addJob(Jobs j);//���
	public void updateEdu(Jobs j);//�޸�
	public void deleteEdu(String num);//�����ɾ��
	public List<Jobs> findAll();  //��ѯ����
	
}
