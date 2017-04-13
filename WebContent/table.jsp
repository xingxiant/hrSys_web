<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,entity.*,dao.impl.*"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/table.css" rel="stylesheet">
</head>
<%
    request.setCharacterEncoding("utf-8");
	StaffDaoMySQLImpl daoStaff=new StaffDaoMySQLImpl();
	MarriageDaoMySQLImpl daoMar=new MarriageDaoMySQLImpl();
	EducationDaoMySQLImpl daoEdu=new EducationDaoMySQLImpl();
	JobsDaoMySQLImpl daocj=new JobsDaoMySQLImpl();
	DepartmentDaoMySQLImpl daoDe=new DepartmentDaoMySQLImpl();
	//查询
	Staff staff=null;
	Marriage marriage=null;
	Education edu=null;
	Jobs job=null;
	Department de=null;
	
	String num=(String)session.getAttribute("siNum");
	staff=daoStaff.findById(num);
	marriage=daoMar.findById(num);
	edu=daoEdu.findById(num);
	String str=num.substring(0, 4);
	
	job=daocj.findById(str);
	de=daoDe.findById(job.getCdDepNum());
	
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

	
    
%>
<body>
<div style="width:900px;margin:0 auto;">
	<h3 style="width:220px;">个人基本信息<span class="glyphicon glyphicon-minus-sign" href="#table1" data-toggle="collapse"></span></h3>
	<div class="container demoTable collapse in" style="width:100%;" id="table1">
		<div class="row demoTableRow">
			<div class="col-md-2 demoTableTab"><span class="tabTit">员工号</span></div>
			<div class="col-md-3 demoTableTab">
				<span><%=staff.getSiNum() %></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">姓名</span></div>
			<div class="col-md-3 demoTableTab">
				<span><%=staff.getSiName() %></span>
			</div>
			<%!
				String mName ="";
				String mAge="";
				String mJob="";
				String mPhone="";

				%>
			<%
				if(0==staff.getSiIsMar())
				{
					mName="";
					mAge="";
					mJob="";
					mPhone="";
			%>
			<div class="col-md-2 demoTableTab"><span class="tabTit">婚姻状况</span></div>
			<div class="col-md-1 demoTableTab">
				<span>未婚</span>
			</div>
			</div>
			<%}else {
				
				mName =marriage.getSmName();
				mAge=Integer.toString(marriage.getSmAge());
				mJob=marriage.getSmJob();
				mPhone=marriage.getSmPhone();   

				
			%>
			
					
			<div class="col-md-2 demoTableTab"><span class="tabTit">婚姻状况</span></div>
			<div class="col-md-1 demoTableTab">
				<span>已婚</span>
			</div>
			</div>
			<%
			}
			%>
		
		<div class="row demoTableRow">
			<div class="col-md-1 demoTableTab"><span class="tabTit">年龄</span></div>
			<div class="col-md-1 demoTableTab">
				<span><%=staff.getSiAge() %></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">性别</span></div>
			<div class="col-md-1 demoTableTab">
				<span><%=staff.getSiSex() %></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">手机</span></div>
			<div class="col-md-3 demoTableTab">
				<span><%=staff.getSiPhone() %></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">邮箱</span></div>
			<div class="col-md-3 demoTableTab">
				<span><%=staff.getSiMail()%></span>
			</div>
		</div>
		<div class="row demoTableRow">
			<div class="col-md-2 demoTableTab"><span class="tabTit">家庭住址</span></div>
			<div class="col-md-6 demoTableTab">
				<span><%=staff.getSiAdress() %></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">部门</span></div>
			<div class="col-md-1 demoTableTab">
				<span><%=de.getCdName() %></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">职位</span></div>
			<div class="col-md-1 demoTableTab">
				<span><%=job.getCjName() %></span>
			</div>
	  	</div>
	</div>
    <hr>
</div>


<div style="width:900px;margin:0 auto;">
	<h3 style="width:220px;">配偶信息<span class="glyphicon glyphicon-minus-sign" href="#table2" data-toggle="collapse"></span></h3>
	<div class="container demoTable collapse in" style="width:100%;" id="table2">
		<div class="row demoTableRow">
			<div class="col-md-1 demoTableTab"><span class="tabTit">姓名</span></div>
			<div class="col-md-2 demoTableTab">
				<span><%=mName %></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">年龄</span></div>
			<div class="col-md-2 demoTableTab">
				<span><%=mAge%></span>
			</div>
			<div class="col-md-2 demoTableTab"><span class="tabTit">工作类型</span></div>
			<div class="col-md-1 demoTableTab">
				<span><%=mJob%></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">手机</span></div>
			<div class="col-md-2 demoTableTab">
				<span><%=mPhone%></span>
			</div>
		</div>
	</div>
    <hr>
</div>

<div style="width:900px;margin:0 auto;">
	<h3 style="width:220px;">受教育程度<span class="glyphicon glyphicon-minus-sign" href="#table3" data-toggle="collapse"></span></h3>
	<div class="container demoTable collapse in" style="width:100%;" id="table3">
		<div class="row demoTableRow">
			<div class="col-md-1 demoTableTab"><span class="tabTit">学历</span></div>
			<div class="col-md-1 demoTableTab">
				<span><%=edu.getSeDegree()%></span>
			</div>
			<div class="col-md-2 demoTableTab"><span class="tabTit">毕业时间</span></div>
			<div class="col-md-2 demoTableTab">
				<span><%=edu.getSeGraTime()%></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">专业</span></div>
			<div class="col-md-2 demoTableTab">
				<span><%=edu.getSeMajor()%></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">学校</span></div>
			<div class="col-md-2 demoTableTab">
				<span>	<span><%=edu.getSeSchool()%></span></span>
			</div>
		</div>
		<div class="row demoTableRow">
		<div class="col-md-2 demoTableTab"><span class="tabTit">外语水平</span></div>
			<div class="col-md-2 demoTableTab">
				<span>	<span><%=edu.getSeLanLevel()%></span></span>
			</div>
		</div>
	</div>
    <hr>
</div>

<div style="width:900px;margin:0 auto;">
	<h3 style="width:220px;">工作状况<span class="glyphicon glyphicon-minus-sign" href="#table4" data-toggle="collapse"></span></h3>
	<div class="container demoTable collapse in" style="width:100%;" id="table4">
		<div class="row demoTableRow">
			<div class="col-md-2 demoTableTab"><span class="tabTit">所属部门</span></div>
			<div class="col-md-1 demoTableTab">
				<span><%=de.getCdName() %></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">薪水</span></div>
			<div class="col-md-2 demoTableTab">
				<span><%=job.getCjMoney() %></span>
			</div>
			<div class="col-md-1 demoTableTab"><span class="tabTit">职位</span></div>
			<div class="col-md-1 demoTableTab">
				<span><%=job.getCjName()%></span>
			</div>
			<div class="col-md-2 demoTableTab"><span class="tabTit">入职时间</span></div>
			<div class="col-md-2 demoTableTab">
				<span><%=edu.getSeGraTime()%></span>
			</div>
		</div>
	</div>
    <hr>
</div>

<script src="./js/jquery-2.1.4.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script type="text/javascript">
    window.onload = function () {
        $("div>h3>span").click(function () {
        	if ($(this).hasClass("glyphicon-minus-sign")){
				$(this).removeClass("glyphicon-minus-sign");
                $(this).addClass("glyphicon-plus-sign");
			}else {
				$(this).removeClass("glyphicon-plus-sign");
                $(this).addClass("glyphicon-minus-sign");
			}
        });
    };
</script>
</body>
</html>
