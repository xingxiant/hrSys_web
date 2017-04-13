<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*,entity.*,dao.impl.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>right</title>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <style type="text/css">
    	body{
    		background-image: url("./images/headBg.jpg");
    		background-position: 61% 43%;
    	}
    	h3{
    		color: #333333;
    		width: 100px;
    		display: inline-block;
    		padding-bottom:6px;
    		margin-bottom: 20px;
    		border-bottom: 2px solid #ABCDEF;
    	}
    	li p{
    		font-family: "微软雅黑";
    		display:block;
    		font-size: 18px;
    		height: 30px;
    		line-height: 30px;
    		cursor: pointer;
    		transition: all 0.3s ease-in-out;
       	}
    	li p:hover{
    		color: #3366CC;
    	}
    	li span{
    		display: none;
    	}
    	.content{
    		margin-top:50px;
    		width: 400px;
    		height: 400px;
    		border-radius: 10px;
    		background: rgba(255,255,200,0.5);
    		border: 1px solid #FFFF66;
    	}
    	#mask{
    		display:none;
    		position:fixed;
    		width: 1000px;
    		height: 500px;
    		top: 50px ;
    		left: 160px;
    		background: #FFFFCC;
    		border-radius: 20px;
    		text-align:center;
    		padding: 30px 100px;
    	}
    	#mask h4{
    		font-size: 20px;
    		padding-bottom: 20px;
    		border-bottom:3px solid #9f9f9f;
    		font-family: "微软雅黑";
    	}
    	#mask p{
    		font-size: 16px;
    		font-family: "微软雅黑";
    		text-indent: 2em;
    	}
    	.glyphicon{
    		cursor: pointer;
    		display: inline-block;
    		position:absolute;
    		font-size:30px;
    		right: 10px;
    		top: 10px;
    		transition: all 0.3s ease-in-out;
    	}
    	.glyphicon:hover{
    		color: #ff0000;
    		transform:rotate(90deg);
    	}
    </style>
</head>
<body>
	<div id="left" class="content col-md-5 col-md-offset-2">
		<h3>通知公告</h3>
		<ul>
			<li><p class="title">标题1</p><span class="con"><p>aaaaaaaaaaaaaaaaaaaaaaaaaaaa</p></span></li>
			<li><p class="title">标题2</p><span class="con"><p>vvvvvvvvvvvvvvvvvvvvvvvvvv<p></span></li>
			<li><p class="title">标题3</p><span class="con"><p>ssssssssssssssssssssssss<p></span></li>
			<li><p class="title">标题4</p><span class="con"><p>ffffffffffffffffffffffffffffff<p></span></li>
			<li><p class="title">标题5</p><span class="con"><p>ttttttttttttttttttttttttttttt<p></span></li>
		</ul>
	</div>
	<div id="right" class="content col-md-5 col-md-offset-1">
		<h3>新闻事件</h3>
		<ul>
			<li><p class="title">标题1</p><span class="con"><p>wwwwwwwwwwwwwwwwwwwwwwwwww<p></span></li>
			<li><p class="title">标题2</p><span class="con"><p>hhhhhhhhhhhhhhhhhhhhhhhhhh<p></span></li>
			<li><p class="title">标题3</p><span class="con"><p>jjjjjjjjjjjjjjjjjjjjjjjjjjj<p></span></li>
			<li><p class="title">标题4</p><span class="con"><p>kkkkkkkkkkkkkkkkkkkkkkkkk<p></span></li>
			<li><p class="title">标题5</p><span class="con"><p>lllllllllllllllllllllllllll<p></span></li>
		</ul>
	</div>
	<div id="mask">
		<span class="glyphicon glyphicon-remove"></span>
		<h4></h4>
		<div></div>
	</div>
<script src="./js/jquery-2.1.4.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script>
	window.onload = function(){
		var titles = $(".title");
		var mask = $("#mask");
		var maskH = $("#mask>h4");
		var maskC = $("#mask>div");
		var close = $(".glyphicon");
		titles.click(function(){
			maskH.html($(this).html());
			var con = $(this).next(".con");
			maskC.html(con.html());
			mask.fadeIn();
		});
		close.click(function(){
			mask.fadeOut();
		});
	}
</script>
</body>
</html>