<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表汇报系统</title>
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
	<div style="margin-left:5%; margin-right:5%; margin-top:40px;">
		<p><font style="font-weight:bold; font-size:20px;">恭喜您成功进入报表系统!</font></p>
		<p><font style="font-weight:bold; font-size:20px;">需要填写的内容项数：${column_count}</font></p>
		<form action="submitReport.action" method="post">
			<table border=1px; cellSpacing=0px; style="padding:0;  width:100%; margin:auto;">
				<caption style="margin-bottom: 20px; margin-top: 10px;"><font style="font-weight:bold; font-size:24px;">${report_name}</font></caption>
				<s:iterator value="volumnsMap" id="column"> <!-- 循环显示表格结构   -->
					<tr>
			   			<td style="text-align:center;"><s:property value="value"/></td>
			   			<td><input type="text" name=<s:property value="key"/>></input></td>
					</tr>
		 		</s:iterator>
		 		<tr style="display:none;"><td>表名</td><td><input type="text" name="report_name" value=${report_name}></input></td></tr><!-- 表名使用隐藏域提交 -->
		 		<tr><td colspan="2" align = "center"><input type="submit" value="提交" style="padding:0;  width: 10%; margin:auto;"/></td></tr>
			</table>
		</form>
	</div>
</body>
</html>