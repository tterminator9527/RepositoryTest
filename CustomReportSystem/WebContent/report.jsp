<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进入报表系统</title>
<style type="text/css">
	html,body{
		height:90%;
		width:90%;
		margin:auto;
	}
	tr{
		height:35px;
	}
	input{
		padding:0;  
		width: 10%; 
		margin:auto; 
		height:35px;
		font-size: 20px;
	}
	caption{
		margin-bottom: 20px; 
		margin-top: 20px;
	}
</style>
</head>
<body style="background-color:#CCFFFF;">
	<!-- 后期利用jQuery ajax实现跳转，这里由于公司网络无法下载jQuery，先使用form表单实现 -->
	<div style="margin-left:5%; margin-right:5%; margin-top:30px;">
		<form action="reportDetail.action" method="post">
			<table  cellSpacing=0px; style="padding:0;  width:100%; margin:auto;">
				<tr>
					<td align="center"><font style="font-weight:bold; font-size:18px;">欢迎使用报表系统,确定进入系统请单击以下按钮~</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="进入报表系统" /></td>
				</tr>
			</table>
		</form>	
	</div>
</body>
</html>