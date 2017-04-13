<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,entity.*,dao.impl.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加员工</title>
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/change.css">
</head>
<%
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
	
	String num=request.getParameter("siNum");
	staff=daoStaff.findById(num);
	marriage=daoMar.findById(num);
	edu=daoEdu.findById(num);
	String str=num.substring(0, 4);
	
	job=daocj.findById(str);
	de=daoDe.findById(job.getCdDepNum());
%>
<body>
<div id="form">
    <p id="start">添加员工</p>
    <form role="form" method="post" action="/hrSys_web/staff_update">
    	<div class="input-group">
            <span class="input-group-addon">员工编号</span>
            <input value=<%=staff.getSiNum() %> readonly="readonly" class="form-control inputType" placeholder="员工编号" name="siNum">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">姓名</span>
            <input value=<%=staff.getSiName() %> type="text" class="form-control inputType" placeholder="姓名" name="siName">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">密码</span>
            <input value=<%=staff.getSiPwd() %> type="password" class="form-control inputType" placeholder="密码" name="siPwd">
        </div>
        <br>

        <div class="input-group">
            <span class="input-group-addon">性别</span>
            <select class="form-control inputType" name="siSex">
	        <%
	        if("男".equals(staff.getSiSex()))
	        {
	        %>
                <option selected="selected" value="男">男</option>
                <option value="女">女</option>
                <%}else{ %>
                <option  value="男">男</option>
                <option selected="selected" value="女">女</option>
                <%} %>
            </select>
            
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">年龄</span>
            <input value=<%=staff.getSiAge() %> type="text" class="form-control inputType" placeholder="年龄" name="siAge">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">电话</span>
            <input value=<%=staff.getSiPhone() %> type="text" class="form-control inputType" placeholder="电话" name="siPhone">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">电子邮箱</span>
            <input value=<%=staff.getSiMail() %> type="text" class="form-control inputType" placeholder="电子邮箱" name="siMail">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">通信地址</span>
            <input value=<%=staff.getSiAdress() %>  type="text" class="form-control inputType" placeholder="通信地址" name="siAdress">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">教育程度</span>
            <select class="form-control inputType" name="seDegree">
                <%if("本科".equals(edu.getSeDegree())){ %>
                <option selected="selected"value="本科">本科</option>
                <option value="专科">专科</option>
                <option value="博士">博士</option>
                <option value="硕士">硕士</option>
                <%} %>
                <%if("专科".equals(edu.getSeDegree())){ %>
                <option value="本科">本科</option>
                <option selected="selected" value="专科">专科</option>
                <option value="博士">博士</option>
                <option value="硕士">硕士</option>
                <%} %>
                <%if("博士".equals(edu.getSeDegree())){ %>
                <option value="本科">本科</option>
                <option value="专科">专科</option>
                <option selected="selected" value="博士">博士</option>
                <option value="硕士">硕士</option>
                <%} %>
                <%if("硕士".equals(edu.getSeDegree())){ %>
                <option value="本科">本科</option>
                <option value="专科">专科</option>
                <option value="博士">博士</option>
                <option selected="selected" value="硕士">硕士</option>
                <%} %>
            </select>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">英语水平</span>
            <select class="form-control inputType" name="seLan">
            <% if("四级".equals(edu.getSeLanLevel())){%>
                <option selected="selected" value="四级">四级</option>
                <option value="六级">六级</option>
                <option value="八级">八级</option>
            <%} %>
            <% if("六级".equals(edu.getSeLanLevel())){%>
                <option value="四级">四级</option>
                <option selected="selected" value="六级">六级</option>
                <option value="八级">八级</option>
            <%} %>
             <% if("八级".equals(edu.getSeLanLevel())){%>
                <option  value="四级">四级</option>
                <option value="六级">六级</option>
                <option  selected="selected" value="八级">八级</option>
            <%} %>
            </select>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">部门</span>
            <select class="form-control inputType" name="cdNum">
            <%if("部门1".equals(de.getCdName())){ %>
                <option selected="selected" value="01">部门1</option>
                <option value="02">部门2</option>
                <option value="03">部门3</option>
                <option value="04">部门4</option>
                <%} %>
                <%if("部门2".equals(de.getCdName())){ %>
                <option value="01">部门1</option>
                <option selected="selected"  value="02">部门2</option>
                <option value="03">部门3</option>
                <option value="04">部门4</option>
                <%} %>
                <%if("部门3".equals(de.getCdName())){ %>
                <option  value="01">部门1</option>
                <option value="02">部门2</option>
                <option  selected="selected" value="03">部门3</option>
                <option value="04">部门4</option>
                <%} %>
                <%if("部门4".equals(de.getCdName())){ %>
                <option  value="01">部门1</option>
                <option value="02">部门2</option>
                <option value="03">部门3</option>
                <option selected="selected" value="04">部门4</option>
                <%} %>
            </select>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">部门电话</span>
            <input value=<%=de.getCdTel() %> readonly="readonly" type="text" class="form-control inputType" placeholder="部门电话" name="cdTel">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">职位</span>
            <input value=<%=job.getCjName() %>  type="text" class="form-control inputType" placeholder="职位" name="cjName">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">毕业学校</span>
            <input value=<%=edu.getSeSchool() %>  type="text" class="form-control inputType" placeholder="毕业学校" name="seSchool">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">专业</span>
            <input value=<%=edu.getSeMajor() %> type="text" class="form-control inputType" placeholder="专业" name="seMajor">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">毕业时间</span>
            <input value=<%=edu.getSeGraTime() %> type="text" class="form-control inputType" placeholder="毕业时间" name="seGTime">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">入职时间</span>
            <input value=<%=edu.getSeGraTime() %> type="text" class="form-control inputType" placeholder="入职时间" name="">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">婚姻状况</span>
            <select class="form-control inputType" name="isMar" id="isMar">
            <%if(0==staff.getSiIsMar()) {%>
                <option selected="selected" value="未婚">未婚</option>
                <option value="已婚">已婚</option>
                <%} %>
                <%if(1==staff.getSiIsMar()) {%>
                <option  value="未婚">未婚</option>
                <option  selected="selected" value="已婚">已婚</option>
                <%} %>
            </select>
        </div>
        <div id="marridList">
            <br>
            <div class="input-group">
                <span class="input-group-addon">配偶姓名</span>
                <input value=<%=marriage.getSmName() %> type="text" class="form-control inputType" placeholder="配偶姓名" name="smName">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">配偶年龄</span>
                <input value=<%=marriage.getSmAge() %> type="text" class="form-control inputType" placeholder="配偶年龄" name="smAge">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">配偶电话</span>
                <input value=<%=marriage.getSmPhone() %> type="text" class="form-control inputType" placeholder="配偶联系方式" name="smPhone">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">配偶职业</span>
                <input value=<%=marriage.getSmJob() %>  type="text" class="form-control inputType" placeholder="配偶职业" name="smJob">
            </div>
        </div>
        <br><br>
        <div class="input-group">
            <input id="subBtn" type="submit" class="form-control btn-primary" value="提交">
        </div>
    </form>
</div>
<script type="text/javascript">
    window.onload = function () {
        var isMarried = document.getElementById("isMar");
        var marridList = document.getElementById("marridList");
        var isMarVlu = isMarried.selectedIndex;
        if (isMarVlu == 0) {
            marridList.style.display = "none";
        } else {
            marridList.style.display = "block";
        }
        isMarried.onchange = function () {
            isMarVlu = isMarried.selectedIndex;
            if (isMarVlu == 0) {
                marridList.style.display = "none";
            } else {
                marridList.style.display = "block";
            }
        };
    }
</script>
</body>
</html>