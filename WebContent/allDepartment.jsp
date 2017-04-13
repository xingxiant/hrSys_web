<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,entity.*,dao.impl.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%
	JobsDaoMySQLImpl daocj=new JobsDaoMySQLImpl();
	DepartmentDaoMySQLImpl daoDe=new DepartmentDaoMySQLImpl();
	//查询

	
	List<Department> departments=daoDe.findAll();

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
    <caption>部门介绍</caption>
    <thead>
    <tr>
        <th>部门名称</th>
        <th>部门编号</th>
        <th>部门经理</th>

        
        <th>部门人数</th>
        <th>部门电话</th>
       
    </tr>
    </thead>
    <tbody>
    <%for(Department d:departments) {%>
    <tr>
        <td><%=d.getCdName() %></td>
        <td><%=d.getCdDepNum() %></td>
        <td><%=d.getCdBoss()%></td>

        <td><%=d.getCdPNum() %></td>
        <td><%=d.getCdTel()%></td>
        
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>