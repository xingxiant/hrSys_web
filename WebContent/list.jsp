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
            text-align: center;
        }
        th,td{
            text-align: center;
        }
        caption{
            text-align: center;
            font-size: 16px;
        }
        #bumen select,#bumen input{
        	display: inline-block;
        	padding: 0;
        	height: 30px;
        	line-height: 30px;
        	width: 80px;
        }
        #bumen input{
        	background: #87cdfe;
        	border: none;
        	color: #fff;
        }
        #bumen input:hover{
        	background: #54bafe;
        }
        #find{
        	margin: 0 auto;
        	text-align:center;
        	border-bottom: 3px solid #ccc;
        }
        .white{
        	width: 30px;	
        }
    </style>
</head>
<%
	request.setCharacterEncoding("utf-8");
	int flag=0;
	List<Staff> liststaff1=(List<Staff>)request.getAttribute("list");
	if(((String)session.getAttribute("name")).equals("00000000")){
		 flag=1;
	}
	
/*  	String de1=new String((request.getParameter("department")).getBytes("iso-8859-1"),"utf-8");
	String sex1=new String((request.getParameter("sex")).getBytes("iso-8859-1"),"utf-8");
	String mar1=new String((request.getParameter("marriage")).getBytes("iso-8859-1"),"utf-8");
	String edu1=new String((request.getParameter("education")).getBytes("iso-8859-1"),"utf-8");  */
	String de1=request.getParameter("department");
	String sex1=request.getParameter("sex");
	String mar1=request.getParameter("marriage");
	String edu1=request.getParameter("education"); 

	StaffDaoMySQLImpl daoStaff=new StaffDaoMySQLImpl();
	MarriageDaoMySQLImpl daoMar=new MarriageDaoMySQLImpl();
	EducationDaoMySQLImpl daoEdu=new EducationDaoMySQLImpl();
	JobsDaoMySQLImpl daocj=new JobsDaoMySQLImpl();
	DepartmentDaoMySQLImpl daoDe=new DepartmentDaoMySQLImpl();
	//查询

	List<Staff> liststaff=null;
	
	if(de1.equals("1")&&sex1.equals("1")&&mar1.equals("1")&&edu1.equals("1")){
		liststaff=daoStaff.findAll();
	}
	else{
		liststaff=liststaff1;
	}
	Marriage marriage=null;
	Education edu=null;
	Jobs job=null;
	Department de=null;
	

%>
<body>
<h3>人员概览</h3>
<form action="/hrSys_web/Staff_Select" method="post" role="form" id="find">
	<table>
		<tr>
			<td>部门:</td>
			<td>
				<div class="form-group" id="bumen">
					<select class="form-control" name="department">
					<%if(de1.equals("1")) {%>
						<option selected="selected" value="1">不限</option>
						<option   value="01">部门1</option>
						<option value="02">部门2</option>
						<option value="03">部门3</option>
						<option value="04">部门4</option>
						<%} %>
					    <%if(de1.equals("01")) {%>
						<option  value="1">不限</option>
						<option selected="selected" value="01">部门1</option>
						<option value="02">部门2</option>
						<option value="03">部门3</option>
						<option value="04">部门4</option>
						<%} %>
						<%if(de1.equals("02")) {%>
						<option value="1">不限</option>
						<option value="01">部门1</option>
						<option selected="selected"  value="02">部门2</option>
						<option value="03">部门3</option>
						<option value="04">部门4</option>
						<%} %>
						<%if(de1.equals("03")) {%>
						<option  value="1">不限</option>
						<option value="01">部门1</option>
						<option value="02">部门2</option>
						<option  selected="selected" value="03">部门3</option>
						<option value="04">部门4</option>
						<%} %>
						<%if(de1.equals("04")) {%>
						<option  value="1">不限</option>
						<option value="01">部门1</option>
						<option value="02">部门2</option>
						<option  value="03">部门3</option>
						<option  selected="selected" value="04">部门4</option>
						<%} %>
					</select>
				</div>
			</td>
			<td class="white"></td>
			<td>性别:</td>
			<td>
				<div class="form-group" id="bumen">
					<select class="form-control" name="sex">
					<%if(sex1.equals("1")){ %>
						<option selected="selected" value="1">不限</option>
						<option value="男">男</option>
						<option value="女">女</option>
						<%} %>
						<%if(sex1.equals("男")){ %>
						<option value="1">不限</option>
						<option selected="selected"  value="男">男</option>
						<option value="女">女</option>
						<%} %>
						<%if(sex1.equals("女")){ %>
						<option value="1">不限</option>
						<option value="男">男</option>
						<option selected="selected"  value="女">女</option>
						<%} %>
					</select>
				</div>
			</td>
			<td class="white"></td>
			<td>学历:</td>
			<td>
				<div class="form-group" id="bumen">
					<select class="form-control" name="education">
					<%if(edu1.equals("1")){ %>
						<option selected="selected" value="1">不限</option>
						<option value="本科">本科</option>
						<option value="专科">专科</option>
						<option value="博士">博士</option>
						<option value="硕士">硕士</option>
						<%} %>
						<%if(edu1.equals("本科")){ %>
						<option  value="1">不限</option>
						<option selected="selected"  value="本科">本科</option>
						<option value="专科">专科</option>
						<option value="博士">博士</option>
						<option value="硕士">硕士</option>
						<%} %>
						<%if(edu1.equals("专科")){ %>
						<option  value="1">不限</option>
						<option value="本科">本科</option>
						<option selected="selected"  value="专科">专科</option>
						<option value="博士">博士</option>
						<option value="硕士">硕士</option>
						<%} %>
						<%if(edu1.equals("博士")){ %>
						<option  value="1">不限</option>
						<option value="本科">本科</option>
						<option value="专科">专科</option>
						<option selected="selected" value="博士">博士</option>
						<option value="硕士">硕士</option>
						<%} %>
						<%if(edu1.equals("硕士")){ %>
						<option  value="1">不限</option>
						<option value="本科">本科</option>
						<option value="专科">专科</option>
						<option value="博士">博士</option>
						<option selected="selected" value="硕士">硕士</option>
						<%} %>
					</select>
				</div>
			</td>
			<td class="white"></td>
			<td >婚姻状况:</td>
			<td>
				<div class="form-group" id="bumen" >
					<select class="form-control" name="marriage">
					<% if(mar1.equals("1")){ %>
						<option selected="selected" value="1">不限</option>
						<option value="已婚">已婚</option>
						<option value="未婚">未婚</option>
						<%} %>
						<% if(mar1.equals("已婚")) {%>
						<option value="1">不限</option>
						<option selected="selected"  value="已婚">已婚</option>
						<option value="未婚">未婚</option>
						<%} %>
						<% if(mar1.equals("未婚")) {%>
						<option value="1">不限</option>
						<option value="已婚">已婚</option>
						<option selected="selected"  value="未婚">未婚</option>
						<%} %>
					</select>
				</div>
			</td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td class="white"></td>
			<td>
				<div class="form-group" id="bumen">
					<input type="submit" value="查询" class="form-control">
				</div>
			</td>
		</tr>
	</table>
</form>
<table class="table table-striped text-center">
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
        <%
    	if(((String)session.getAttribute("siNum")).equals("00000000")){
    		
    	
        %>
         <th>操作</th>
         <% } %>
    </tr>
    </thead>
	<tbody>
    <% for(Staff staff:liststaff){
    String num=staff.getSiNum();
	
	marriage=daoMar.findById(num);
	edu=daoEdu.findById(num);
	String str=num.substring(0, 4);
	
	job=daocj.findById(str);
	de=daoDe.findById(job.getCdDepNum()); %>
    <tr>
        <td><%=staff.getSiNum() %></td>
        <td><%=staff.getSiName() %></td>
        <td><%=staff.getSiSex() %></td>
        <td><%=job.getCjName() %></td>
        <td><%=de.getCdName() %></td>
        <td><%=edu.getSeGraTime() %></td>
        <td><%=staff.getSiPhone() %></td>
        <td><a href="detail.jsp?siNum=<%=staff.getSiNum() %>">详细信息</a></td>
		<% if(((String)session.getAttribute("siNum")).equals("00000000")){ %>
        <td><a href="./operate/staff_update.jsp?siNum=<%=staff.getSiNum() %>">修改</a>
        &nbsp;&nbsp;<a href="/hrSys_web/staff_delete?siNum=<%=staff.getSiNum() %>">删除</a></td>
        <%} %>
    </tr>
    
    <%} %>
    </tbody> 
</table>
</body>
</html>