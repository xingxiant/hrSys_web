<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,entity.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv='statent-Type' statent='text/html; charset=utf-8' />
<title>查询所有员工</title>
<style type='text/css'>
	table td{
		/*文字居中*/
		text-align:center;
	}
	
	/*合并表格的边框*/
	table{
		border-collapse:collapse;
	}
</style>
</head>
<body>
<center><h3>查询所有联系人</h3></center>
<table align='center' border='1' width='900px'>
<%
	//从request域中去接收参数
	List<Staff> listStaff=(List<Staff>)request.getAttribute("staffs");
	List<Marriage> listMarriage=(List<Marriage>)request.getAttribute("marriages");
	List<Education> listEdu=(List<Education>)request.getAttribute("educations");
	List<Jobs> listCj=(List<Jobs>)request.getAttribute("cj");
	List<Department> listDe=(List<Department>)request.getAttribute("de");

%>
	<tr>
    	<th>编号</th>
    	<th>密码</th>
        <th>姓名</th>
        <th>岗位号</th>
        <th>性别</th>
        <th>年龄</th>
        <th>婚姻</th>
        <th>地址</th>
        <th>毕业年份</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <%
    	for(Staff sta:listStaff){
    %>
    <tr>
    	<td><%=sta.getSiNum() %></td>
    	<td><%=sta.getSiPwd() %></td>
        <td><%=sta.getSiName() %></td>
        <td><%=sta.getCjJobNum()%></td>
        <td><%=sta.getSiSex()%></td>
        <td><%=sta.getSiAge() %></td>
        <td><%=sta.getSiIsMar() %></td>
        <td><%=sta.getSiAdress() %></td>
        
        <td><%=sta.getSiTime() %></td>
        <td><%=sta.getSiPhone() %></td>
        <td><%=sta.getSiMail() %></td>
     
        <td><a href=''>修改</a>&nbsp;<a href=''>删除</a></td>
    </tr>
    <%} %>
    <tr>
    	<td colspan='12' align='center'><a href='add.jsp'>[添加联系人]</a></td>
    </tr>
</table>
<table align='center' border='1' width='900px'>
<%
	//从request域中去接收参数
	
%>
	<tr>
    	<th>编号</th>
    	<th>配偶姓名</th>
        <th>配偶年龄</th>
        <th>配偶工作</th>
        <th>配偶电话</th>

        
        <th>操作</th>
    </tr>
    <%
    	for(Marriage m : listMarriage){
    %>
    <tr>
    	<td><%=m.getSmNum() %></td>
    	<td><%=m.getSmName() %></td>
        <td><%=m.getSmAge() %></td>
        <td><%=m.getSmJob() %></td>
        <td><%=m.getSmPhone() %></td>

     
        <td><a href=''>修改</a>&nbsp;<a href=''>删除</a></td>
    </tr>
    <%} %>
    <tr>
    	<td colspan='12' align='center'><a href='add.jsp'>[添加联系人]</a></td>
    </tr>
</table>
<table align='center' border='1' width='900px'>
<%
	//从request域中去接收参数
	
%>
	<tr>
    	<th>编号</th>
    	<th>学历</th>
        <th>专业</th>
        <th>毕业院校</th>
        <th>毕业时间</th>
        <th>英语水平</th>

        
        <th>操作</th>
    </tr>
    <%
    	for(Education edu : listEdu){
    %>
    <tr>
    	<td><%=edu.getSeNum() %></td>
		<td><%=edu.getSeDegree()%></td>
        <td><%=edu.getSeMajor() %></td>
        <td><%=edu.getSeSchool() %></td>
        <td><%=edu.getSeGraTime() %></td>
        <td><%=edu.getSeLanLevel() %></td>
		
     
        <td><a href=''>修改</a>&nbsp;<a href=''>删除</a></td>
    </tr>
    <%} %>
    <tr>
    	<td colspan='7' align='center'><a href='add.jsp'>[添加联系人]</a></td>
    </tr>
</table>
<table align='center' border='1' width='900px'>
<%
	//从request域中去接收参数
	
%>
	<tr>
    	<th>岗位编号</th>
    	<th>部门号</th>
        <th>职位</th>
        <th>薪资</th>


        
        <th>操作</th>
    </tr>
    <%
    	for(Jobs cj : listCj){
    %>
    <tr>
    	<td><%=cj.getCjJobNum() %></td>
		<td><%=cj.getCdDepNum()%></td>
        <td><%=cj.getCjName() %></td>
        <td><%=cj.getCjMoney() %></td>

		
     
        <td><a href=''>修改</a>&nbsp;<a href=''>删除</a></td>
    </tr>
    <%} %>
    <tr>
    	<td colspan='5' align='center'><a href='add.jsp'>[添加联系人]</a></td>
    </tr>
</table>
<table align='center' border='1' width='900px'>
<%
	//从request域中去接收参数
	
%>
	<tr>
    	<th>部门号</th>
    	<th>部门名称</th>
    	<th>部门人数</th>
        
        <th>部门经理</th>
        <th>部门电话</th>


        
        <th>操作</th>
    </tr>
    <%
    	for(Department de : listDe){
    %>
    <tr>
    	<td><%=de.getCdDepNum() %></td>
		<td><%=de.getCdName()%></td>
        <td><%=de.getCdPNum() %></td>
        <td><%=de.getCdBoss() %></td>
        <td><%=de.getCdTel() %></td>

		
     
        <td><a href=''>修改</a>&nbsp;<a href=''>删除</a></td>
    </tr>
    <%} %>
    <tr>
    	<td colspan='6' align='center'><a href='add.jsp'>[添加联系人]</a></td>
    </tr>
</table>
</body>
</html>