<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加员工</title>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/change.css">
</head>
<body>
<div id="form">
    <p id="start">添加员工</p>
    <form role="form" method="post" action="/hrSys_web/staff_add">
    	<div class="input-group">
            <span class="input-group-addon">员工编号</span>
            <input type="text" class="form-control inputType inputss" placeholder="员工编号" name="siNum">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">姓名</span>
            <input type="text" class="form-control inputType inputss" placeholder="姓名" name="siName">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">密码</span>
            <input type="password" class="form-control inputType inputss" placeholder="密码" name="siPwd">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">性别</span>
            <select class="form-control inputType inputss" name="siSex">
                <option selected="selected" value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">年龄</span>
            <input type="text" class="form-control inputType inputss" placeholder="年龄" name="siAge">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">电话</span>
            <input type="text" class="form-control inputType inputss" placeholder="电话" name="siPhone">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">电子邮箱</span>
            <input type="text" class="form-control inputType inputss" placeholder="电子邮箱" name="siMail">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">通信地址</span>
            <input type="text" class="form-control inputType inputss" placeholder="通信地址" name="siAdress">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">教育程度</span>
            <select class="form-control inputType inputss" name="seDegree">
                <option selected="selected"value="本科">本科</option>
                <option value="专科">专科</option>
                <option value="博士">博士</option>
                <option value="硕士">硕士</option>
            </select>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">英语水平</span>
            <select class="form-control inputType inputss" name="seLan">
                <option selected="selected" value="四级">四级</option>
                <option value="六级">六级</option>
                <option value="八级">八级</option>
            </select>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">部门</span>
            <select class="form-control inputType inputss" name="cdNum">
                <option selected="selected" value="01">部门1</option>
                <option value="02">部门2</option>
                <option value="03">部门3</option>
                <option value="04">部门4</option>
            </select>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">部门电话</span>
            <input type="text" class="form-control inputType inputss" placeholder="部门电话" name="cdTel">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">职位</span>
            <input type="text" class="form-control inputType inputss" placeholder="职位" name="cjName">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">毕业学校</span>
            <input type="text" class="form-control inputType inputss" placeholder="毕业学校" name="seSchool">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">专业</span>
            <input type="text" class="form-control inputType inputss" placeholder="专业" name="seMajor">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">毕业时间</span>
            <input type="text" class="form-control inputType inputss" placeholder="毕业时间" name="seGTime">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">入职时间</span>
            <input type="text" class="form-control inputType inputss" placeholder="入职时间" name="">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">婚姻状况</span>
            <select class="form-control inputType inputss" name="isMar" id="isMar">
                <option selected="selected" value="未婚">未婚</option>
                <option value="已婚">已婚</option>
            </select>
        </div>
        <div id="marridList">
            <br>
            <div class="input-group">
                <span class="input-group-addon">配偶姓名</span>
                <input type="text" class="form-control inputType ins" placeholder="配偶姓名" name="smName">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">配偶年龄</span>
                <input type="text" class="form-control inputType ins" placeholder="配偶年龄" name="smAge">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">配偶电话</span>
                <input type="text" class="form-control inputType ins" placeholder="配偶联系方式" name="smPhone">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">配偶职业</span>
                <input type="text" class="form-control inputType ins" placeholder="配偶职业" name="smJob">
            </div>
        </div>
        <br><br>
        <div class="input-group">
            <input id="subBtn" type="submit" class="form-control btn-primary" value="存在未填项目">
        </div>
    </form>
</div>
<script type="text/javascript">
    window.onload = function () {
        var isMarried = document.getElementById("isMar");
        var marridList = document.getElementById("marridList");
        var subBtn = document.getElementById("subBtn");
        var ins = document.getElementsByClassName("ins");
        var inputss = document.getElementsByClassName("inputss");
        var isMarVlu = isMarried.selectedIndex;
        subBtn.disabled = true;
        if (isMarVlu == 0) {
            marridList.style.display = "none";
            for (var i=0;i<inputss.length;i++){
           		inputss[i].onkeyup=function(){
           			var inFlag = 1;
           			for (var j=0;j<inputss.length;j++){
           				if(this.value==""){
               				inFlag = 0;
                       		break;
                       	}
           			}
           			if (inFlag==0){
       	               	subBtn.disabled = true;
       	           		subBtn.value="存在未填项目";
       	           		subBtn.style.color="#000000";
       	            }else{
       	               	subBtn.disabled = false;
       	           		subBtn.value="提交";
       	           		subBtn.style.color="#ffffff";
       	            }
               	}
            }
        } else {
            marridList.style.display = "block";
        }
        isMarried.onchange = function () {
        	for	(var i = 0;i<ins.length;i++){
        		ins[i].value = "";
        	}
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