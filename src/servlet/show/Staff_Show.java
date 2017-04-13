package servlet.show;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDao;
import dao.EducationDao;
import dao.JobsDao;
import dao.MarriageDao;
import dao.StaffDao;
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
 * Servlet implementation class Staff_Show
 */
@WebServlet("/Staff_Show")
public class Staff_Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Staff_Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffDao daoStaff=new StaffDaoMySQLImpl();
		MarriageDao daoMar=new MarriageDaoMySQLImpl();
		EducationDao daoEdu=new EducationDaoMySQLImpl();
		JobsDao daocj=new JobsDaoMySQLImpl();
		DepartmentDao daoDe=new DepartmentDaoMySQLImpl();
		
		List<Staff> liststaff=null;
		List<Marriage> listMarriage=null;
		List<Education> listEdu=null;
		List<Jobs> listCj=null;
		List<Department> listDe=null;
		
		liststaff=daoStaff.findAll();
		listMarriage=daoMar.findAll();
		listEdu=daoEdu.findAll();
		listCj=daocj.findAll();
		listDe=daoDe.findAll();
		//Ìø×ªÒ³Ãæ
		request.setAttribute("staffs", liststaff);
		request.setAttribute("marriages", listMarriage);
		request.setAttribute("educations", listEdu);
		request.setAttribute("cj", listCj);
		request.setAttribute("de", listDe);
		
		
		request.getRequestDispatcher("/show_staff.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
