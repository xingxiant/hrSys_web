package servlet.show;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.StaffDaoMySQLImpl;
import entity.Staff;

/**
 * Servlet implementation class Login_Servlet
 */
@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获得参数
		String num =request.getParameter("siNum");
		String password=request.getParameter("siPwd");
		StaffDaoMySQLImpl daoStaff=new StaffDaoMySQLImpl();
		if(daoStaff.checkContact(num)){
			Staff staff=daoStaff.findById(num);
			if(!password.equals(staff.getSiPwd()))
			{
				response.sendRedirect("/hrSys_web/login.jsp?flag=1");
				return ;
			}
			HttpSession session=request.getSession();
			String name=staff.getSiName();
			String siNum=staff.getSiNum();
			session.setAttribute("name", name);
			session.setAttribute("siNum", siNum);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
		}
		else{
			response.sendRedirect("/hrSys_web/login.jsp?flag=1");
			return ;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
