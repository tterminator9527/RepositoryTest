<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表查询结果</title>
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
	<div style="margin-left:5%; margin-right:5%;">
		<table border=1px; cellSpacing=0px; style="padding:0;  width:100%; margin:auto;">
		<caption style="margin-bottom: 20px; margin-top: 20px;"><font style="font-weight:bold; font-size:24px;">${reportName}</font></caption>
		<tr>
			<s:iterator value="headersMap" id="column"> <!-- 循环显示表格结构   -->
		   		<td style="text-align:center;"><s:property value="value"/></td>
	 		</s:iterator>
        </tr>
        <s:iterator value="#request.list_data" id="nm"><!-- 利用request属性实现条目内容显示 -->
        <tr>
     		<s:iterator value="#request.nm" id="t" status="status">
     			<td style="text-align:center;"><s:property value="value"/><br/></td>
     		</s:iterator>
     	</tr>
 		</s:iterator>
	</table>
	</div>
</body>
</html>