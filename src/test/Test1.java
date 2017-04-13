package test;

import java.util.List;

import dao.MarriageDao;
import dao.impl.DepartmentDaoMySQLImpl;
import dao.impl.EducationDaoMySQLImpl;
import dao.impl.JobsDaoMySQLImpl;
import dao.impl.MarriageDaoMySQLImpl;
import dao.impl.StaffDaoMySQLImpl;
import entity.Department;
import entity.Education;
import entity.Jobs;
import entity.Marriage;
import entity.Staff;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		MarriageDao dao=new MarriageDaoMySQLImpl();
		MarriageDao dao2=new MarriageDaoMySQLImpl();
		List<Marriage> list = dao.findAll();
		for(Marriage m:list){
			System.out.println(m.getSmName());
		}*/
/*		String num="01010001";
		String str=num;
		str=str.substring(0, 4);
		System.out.println(num);
		System.out.println(str);*/
		StaffDaoMySQLImpl daoStaff=new StaffDaoMySQLImpl();
		MarriageDaoMySQLImpl daoMar=new MarriageDaoMySQLImpl();
		EducationDaoMySQLImpl daoEdu=new EducationDaoMySQLImpl();
		JobsDaoMySQLImpl daocj=new JobsDaoMySQLImpl();
		DepartmentDaoMySQLImpl daoDe=new DepartmentDaoMySQLImpl();
//查询部门人数
		List<Staff> li=daoStaff.findAll();
		int num1=0;
		int num2=0;
		int num3=0;
		int num4=0;
		for(Staff sta:li){
			if((sta.getSiNum()).substring(0,2).equals("01"))
			{
				num1++;
			}
			if((sta.getSiNum()).substring(0,2).equals("02"))
			{
				num2++;
			}
			if((sta.getSiNum()).substring(0,2).equals("03"))
			{
				num3++;
			}
			if((sta.getSiNum()).substring(0,2).equals("04"))
			{
				num4++;
			}
			
		}
		List<Department> depart=daoDe.findAll();
		for(Department dd:depart){
			if(dd.getCdDepNum().equals("01")){
				dd.setCdPNum(Integer.toString(num1));
			}
			if(dd.getCdDepNum().equals("02")){
				dd.setCdPNum(Integer.toString(num2));
			}
			if(dd.getCdDepNum().equals("03")){
				dd.setCdPNum(Integer.toString(num3));
			}
			if(dd.getCdDepNum().equals("04")){
				dd.setCdPNum(Integer.toString(num4));
			}
			daoDe.updateDe(dd);
		}
		depart=daoDe.findAll();
		for(Department dd:depart){
			 System.out.println(dd.getCdPNum());
      
				
		

	    }
	}

}
