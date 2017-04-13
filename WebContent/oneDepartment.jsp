<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,entity.*,dao.impl.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%
	JobsDaoMySQLImpl daocj=new JobsDaoMySQLImpl();
	DepartmentDaoMySQLImpl daoDe=new DepartmentDaoMySQLImpl();
	//查询
	
	String siNum=(String)session.getAttribute("siNum");
	String deNum=siNum.substring(0, 2);
	Department d=daoDe.findById(deNum);
	List<Jobs> jobs=daocj.findAll();
	List<Jobs> jobs1=new ArrayList<Jobs>();
	for(Jobs job:jobs)
	{
		if(job.getCjJobNum().substring(0, 2).equals(deNum))
		{
			jobs1.add(job);
		}
	}
%>
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
<body>
<table class="table table-striped text-center">
    <caption>岗位介绍</caption>
    <thead>
    <tr>
        <th>部门名称</th>
        <th>部门编号</th>
        <th>部门经理</th>
        <th>岗位名称</th>
        <th>岗位号</th>
        <th>岗位薪资</th>
        
        <th>部门人数</th>
        <th>部门电话</th>
       
    </tr>
    </thead>
    <tbody>
    <%for(Jobs j:jobs1) {%>
    <tr>
        <td><%=d.getCdName() %></td>
        <td><%=d.getCdDepNum() %></td>
        <td><%=d.getCdBoss()%></td>
        <td><%=j.getCjName() %></td>
        <td><%=j.getCjJobNum() %></td>
        <td><%=j.getCjMoney() %></td>
        <td><%=d.getCdPNum() %></td>
        <td><%=d.getCdTel()%></td>
        
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>