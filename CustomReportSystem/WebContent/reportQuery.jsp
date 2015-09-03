<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表查询</title>
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
		width: 99.8%; 
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
	<div style="margin-left:5%; margin-right:5%; margin-top:30px;">
		<p style="align:center;text-align: center;"><font style="font-weight:bold; font-size:20px; padding:0;  width:100%; margin:auto;">欢迎使用报表查询功能!</font></p>
		<form action="reportQuery.action" method="post" >
			<table border=1px; cellSpacing=0px; style="padding:0;  width:100%; margin:auto;">
				<tr>
					<td style="text-align:center;">查询表名</td>
					<td><input type="text" name="reportName" style="padding:0;  width: 99.8%; margin:auto;"></input></td>
				</tr>
				<tr><td colspan="2" align="center"><input type="submit" value="查询" style="padding:0;  width: 10%; margin:auto;"></input></td></tr>
			</table>
		</form>
	</div>
</body>
</html>