package dao;

import java.util.List;

import entity.Department;



public interface DepartmentDao {
	public void addEdu(Department d);//���
	public void updateDe(Department d);//�޸�
	public void deleteDe(String num);//�����ɾ��
	public List<Department> findAll();  //��ѯ����
	
}
