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
import dao.impl.MarriageDaoMySQLImpl;
import dao.impl.StaffDaoMySQLImpl;
import entity.Department;
import entity.Staff;

/**
 * Servlet implementation class staff_delete
 */
@WebServlet("/staff_delete")
public class staff_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staff_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("siNum");
		StaffDaoMySQLImpl daoStaff=new StaffDaoMySQLImpl();
		MarriageDaoMySQLImpl daoMar=new MarriageDaoMySQLImpl();
		EducationDaoMySQLImpl daoEdu=new EducationDaoMySQLImpl();
		DepartmentDaoMySQLImpl daoDe=new DepartmentDaoMySQLImpl();
		daoStaff.deleteStaff(num);
		daoMar.deleteMar(num);
		daoEdu.deleteEdu(num);
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

		response.sendRedirect("/hrSys_web/Copy of list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
