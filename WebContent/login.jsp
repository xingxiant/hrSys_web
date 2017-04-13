<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/login.css">
</head>
<%		
if(session!=null){
	session.removeAttribute("siNum");
	session.removeAttribute("name");
}
String flag="0";//登录失败标志
if("1".equals(request.getParameter("flag"))){
	flag="1";
}

%>
<body>
<div id="form">
    <p id="start">人员管理系统</p>
    <form class="" role="form" method="post" action="/hrSys_web/Login_Servlet">
        <div class="input-group">
            <span class="input-group-addon">员工号</span>
            <input type="text" name="siNum" class="form-control inputType" placeholder="员工号">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">密码</span>
            <input type="password" name="siPwd" class="form-control inputType" placeholder="密码">
        </div>
        <%if("1".equals(flag)) {%>
		<div class="input-group" >
            <div id="tip">登陆失败，账号或密码输入有误！ </div>
        </div>
        <%} %>
		<br>
        <div class="input-group" >
            <input id="loginBtn" type="submit" class="form-control btn-primary" value="登陆">
            <!--<a href="reg.html"><button id="regBtn" class="btn" type="button">注册入口</button></a>-->
        </div>
    </form>
</div>
</body>
</html>
