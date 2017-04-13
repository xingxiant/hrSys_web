package servlet.show;

import java.io.IOException;

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
 * Servlet implementation class staff_update
 */
@WebServlet("/staff_update")
public class staff_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staff_update() {
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
		//��ѯ
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
		if("δ��".equals(request.getParameter("isMar")))
		{
			staff.setSiIsMar(0);
		}
		if("�ѻ�".equals(request.getParameter("isMar")))
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
			marriage.setSmNum(" ");
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
		//н�ʹ̶�
		job.setCjMoney("10000");
		job.setCjName(request.getParameter("cjName"));
		if("01".equals(request.getParameter("cdNum")))
		{
			de.setCdBoss(request.getParameter("����"));
		}
		if("02".equals(request.getParameter("cdNum")))
		{
			de.setCdBoss(request.getParameter("����"));
		}
		if("03".equals(request.getParameter("cdNum")))
		{
			de.setCdBoss(request.getParameter("����"));
		}
		if("04".equals(request.getParameter("cdNum")))
		{
			de.setCdBoss(request.getParameter("����"));
		}
		
		de.setCdDepNum(request.getParameter("cdNum"));
		if("01".equals(request.getParameter("cdNum")))
		{
			de.setCdName("����1");
		}
		if("02".equals(request.getParameter("cdNum")))
		{
			de.setCdName("����2");
		}
		if("03".equals(request.getParameter("cdNum")))
		{
			de.setCdName("����3");
		}
		if("04".equals(request.getParameter("cdNum")))
		{
			de.setCdName("����4");
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
		daoStaff.deleteStaff(staff.getSiNum());
		daoEdu.deleteEdu(edu.getSeNum());
		daoMar.deleteMar(marriage.getSmNum());
	
		daoStaff.addStaff(staff);
		daoEdu.addEdu(edu);
		daoMar.addMar(marriage);
		//daoDe.addEdu(de);
		//daocj.addJob(job);
		response.sendRedirect("/hrSys_web/operate/staff_show.jsp?siNum="+staff.getSiNum());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
