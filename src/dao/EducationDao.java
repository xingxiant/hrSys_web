package dao;

import java.util.List;

import entity.Education;


public interface EducationDao {
	public void addEdu(Education e);//���
	public void updateEdu(Education e);//�޸�
	public void deleteEdu(String num);//�����ɾ��
	public List<Education> findAll();  //��ѯ����
}
