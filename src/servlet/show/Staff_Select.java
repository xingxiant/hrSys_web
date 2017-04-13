package servlet.show;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class Staff_Select
 */
@WebServlet("/Staff_Select")
public class Staff_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Staff_Select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String de=request.getParameter("department");
		String sex=request.getParameter("sex");
		String edu=request.getParameter("education");
		String mar=request.getParameter("marriage");


		StaffDaoMySQLImpl daoStaff=new StaffDaoMySQLImpl();
		MarriageDaoMySQLImpl daoMar=new MarriageDaoMySQLImpl();
		EducationDaoMySQLImpl daoEdu=new EducationDaoMySQLImpl();
		JobsDaoMySQLImpl daocj=new JobsDaoMySQLImpl();
		DepartmentDaoMySQLImpl daoDe=new DepartmentDaoMySQLImpl();
		//≤È—Ø
		
		List<Staff> list=null;
		List<Staff> liststaff= new ArrayList<Staff>();
		list=daoStaff.findAll();
		for(Staff s :list)
		{
			Education e=daoEdu.findById(s.getSiNum());
			String de1=(s.getSiNum()).substring(0,2);
			String sex1=s.getSiSex();
			String edu1=e.getSeDegree();
			String mar1=null;
			int is=s.getSiIsMar();
			if(is==0)
			{
				mar1="Œ¥ªÈ";
			}else if(is==1){
				mar1="“—ªÈ";
			}
		    if(de.equals("1")){
				if(sex.equals("1")){
					if(edu.equals("1")){
						if(mar.equals("1")){
							liststaff.add(s);
						}else if(mar.equals(mar1)){
							liststaff.add(s);
						}
					}else if(edu.equals(edu1)){
						if(mar.equals("1")){
							liststaff.add(s);
						}else if(mar.equals(mar1)){
							liststaff.add(s);
						}
					}
				}else if(sex.equals(sex1)){
					if(edu.equals("1")){
						if(mar.equals("1")){
							liststaff.add(s);
						}else if(mar.equals(mar1)){
							liststaff.add(s);
						}
					}else if(edu.equals(edu1)){
						if(mar.equals("1")){
							liststaff.add(s);
						}else if(mar.equals(mar1)){
							liststaff.add(s);
						}
					}
				}
				
		    }else if(de.equals(de1)){
				if(sex.equals("1")){
					if(edu.equals("1")){
						if(mar.equals("1")){
							liststaff.add(s);
						}else if(mar.equals(mar1)){
							liststaff.add(s);
						}
					}else if(edu.equals(edu1)){
						if(mar.equals("1")){
							liststaff.add(s);
						}else if(mar.equals(mar1)){
							liststaff.add(s);
						}
					}
				}else if(sex.equals(sex1)){
					if(edu.equals("1")){
						if(mar.equals("1")){
							liststaff.add(s);
						}else if(mar.equals(mar1)){
							liststaff.add(s);
						}
					}else if(edu.equals(edu1)){
						if(mar.equals("1")){
							liststaff.add(s);
						}else if(mar.equals(mar1)){
							liststaff.add(s);
						}
					}
				}
		    }
				
			
	}
		

		request.setAttribute("list", liststaff);
		request.getRequestDispatcher("/list.jsp"+"?department="+de+"&"+"marriage="+mar+"&"+"education="+edu+"&"+"sex="+sex).forward(request, response);

	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
