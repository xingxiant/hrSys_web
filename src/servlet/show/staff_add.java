package servlet.show;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/**
 * Servlet implementation class staff_add
 */
@WebServlet("/staff_add")
public class staff_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staff_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		StaffDaoMySQLImpl daoStaff=new StaffDaoMySQLImpl();
		MarriageDaoMySQLImpl daoMar=new MarriageDaoMySQLImpl();
		EducationDaoMySQLImpl daoEdu=new EducationDaoMySQLImpl();
		JobsDaoMySQLImpl daocj=new JobsDaoMySQLImpl();
		DepartmentDaoMySQLImpl daoDe=new DepartmentDaoMySQLImpl();
		//查询
		Staff staff = new Staff();
		Marriage marriage=new Marriage();
		Education edu=new Education();
		Jobs job=new Jobs();
		Department de=new Department();
		//
		String str=(request.getParameter("siNum")).substring(0, 4);
		staff.setCjJobNum(str);
		staff.setSiAdress(request.getParameter("siAdress"));
		staff.setSiAge(Integer.parseInt(request.getParameter("siAge")));
		if("未婚".equals(request.getParameter("isMar")))
		{
			staff.setSiIsMar(0);
		}
		if("已婚".equals(request.getParameter("isMar")))
		{
			staff.setSiIsMar(1);
		}
		
		staff.setSiMail(request.getParameter("siMail"));
		staff.setSiName(request.getParameter("siName"));
		staff.setSiNum(request.getParameter("siNum"));
		staff.setSiPhone(request.getParameter("siPhone"));
		staff.setSiPwd(request.getParameter("siPwd"));
		staff.setSiSex(request.getParameter("siSex"));
		staff.setSiTime(5);
		if(staff.getSiIsMar()==1)
		{
		marriage.setSmAge(Integer.parseInt(request.getParameter("smAge")));
		marriage.setSmJob(request.getParameter("smJob"));
		marriage.setSmName(request.getParameter("smName"));
		marriage.setSmNum(request.getParameter("siNum"));
		marriage.setSmPhone(request.getParameter("smPhone"));
		}else{
			marriage.setSmAge(0);
			marriage.setSmJob(" ");
			marriage.setSmName(" ");
			marriage.setSmNum(request.getParameter("siNum"));
			marriage.setSmPhone(" ");
		}
		edu.setSeDegree(request.getParameter("seDegree"));
		edu.setSeGraTime(Integer.parseInt(request.getParameter("seGTime")));
		edu.setSeLanLevel(request.getParameter("seLan"));
		edu.setSeMajor(request.getParameter("seMajor"));
		edu.setSeNum(request.getParameter("siNum"));
		edu.setSeSchool(request.getParameter("seSchool"));
		job.setCdDepNum(request.getParameter("cdNum"));
		//
		
		job.setCjJobNum(str);
		//薪资固定
		job.setCjMoney("10000");
		job.setCjName(request.getParameter("cjName"));
		if("01".equals(request.getParameter("cdNum")))
		{
			de.setCdBoss(request.getParameter("张总"));
		}
		if("02".equals(request.getParameter("cdNum")))
		{
			de.setCdBoss(request.getParameter("李总"));
		}
		if("03".equals(request.getParameter("cdNum")))
		{
			de.setCdBoss(request.getParameter("王总"));
		}
		if("04".equals(request.getParameter("cdNum")))
		{
			de.setCdBoss(request.getParameter("赵总"));
		}
		
		de.setCdDepNum(request.getParameter("cdNum"));
		if("01".equals(request.getParameter("cdNum")))
		{
			de.setCdName("部门1");
		}
		if("02".equals(request.getParameter("cdNum")))
		{
			de.setCdName("部门2");
		}
		if("03".equals(request.getParameter("cdNum")))
		{
			de.setCdName("部门3");
		}
		if("04".equals(request.getParameter("cdNum")))
		{
			de.setCdName("部门4");
		}
		de.setCdPNum("100");
		if("01".equals(request.getParameter("cdNum")))
		{
			de.setCdTel("83138134");
		}
		if("02".equals(request.getParameter("cdNum")))
		{
			de.setCdTel("10086");
		}
		if("03".equals(request.getParameter("cdNum")))
		{
			de.setCdTel("10010");
		}
		if("04".equals(request.getParameter("cdNum")))
		{
			de.setCdTel("10010");
		}
		daoStaff.addStaff(staff);
		daoEdu.addEdu(edu);
		daoMar.addMar(marriage);
		//daoDe.addEdu(de);
		if(!daocj.checkJobs(job.getCjJobNum())){
			daocj.addJob(job);
		}
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

		response.sendRedirect("/hrSys_web/operate/staff_show.jsp?siNum="+staff.getSiNum());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
