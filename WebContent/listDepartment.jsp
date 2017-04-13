<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,entity.*,dao.impl.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <style type="text/css">
        body{
            width: 1200px;
            text-align: center;
            margin: 0 auto;
        }
        th,td{
            text-align: center;
        }
        caption{
            text-align: center;
            font-size: 16px;
        }
    </style>
</head>
<%
	StaffDaoMySQLImpl daoStaff=new StaffDaoMySQLImpl();
	MarriageDaoMySQLImpl daoMar=new MarriageDaoMySQLImpl();
	EducationDaoMySQLImpl daoEdu=new EducationDaoMySQLImpl();
	JobsDaoMySQLImpl daocj=new JobsDaoMySQLImpl();
	DepartmentDaoMySQLImpl daoDe=new DepartmentDaoMySQLImpl();
	//查询
	String siNum=(String)session.getAttribute("siNum");
	
	
	String deNum=siNum.substring(0, 2);
	List<Staff> liststaff=new ArrayList<Staff>();
	List<Staff> allstaff=daoStaff.findAll();
	for(Staff staff:allstaff)
	{
		String str1=staff.getSiNum().substring(0, 2);
		if(deNum.equals(str1))
		{
		liststaff.add(staff);
		}
	}
	
	
	
	Marriage marriage=null;
	Education edu=null;
	Jobs job=null;
	Department de=null;
	

%>
<body>
<table class="table table-striped text-center">
    <caption>部门人员</caption>
    <thead>
    <tr>
        <th>职工号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>职位</th>
        <th>部门</th>
        <th>入职时间</th>
        <th>联系方式</th>
        <th>详细信息</th>
    </tr>
    </thead>
    <tbody>
    <%for(Staff staff :liststaff){
    String num=staff.getSiNum();
	
	marriage=daoMar.findById(num);
	edu=daoEdu.findById(num);
	String str=num.substring(0, 4);
	
	job=daocj.findById(str);
	de=daoDe.findById(job.getCdDepNum());%>
    <tr>
        <td><%=staff.getSiNum() %></td>
        <td><%=staff.getSiName() %></td>
        <td><%=staff.getSiSex() %></td>
        <td><%=job.getCjName() %></td>
        <td><%=de.getCdName() %></td>
        <td><%=edu.getSeGraTime() %></td>
        <td><%=staff.getSiPhone() %></td>
        <td><a href="detail.jsp?siNum=<%=staff.getSiNum() %>">详细信息</a></td>
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>