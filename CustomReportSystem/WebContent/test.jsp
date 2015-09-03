<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP   starting page</title>
     <%  
     List<Map<String,String>> list=new ArrayList<Map<String,String>>(); 
  Map<String,String> map=new HashMap<String,String>();
  map.put("1","壹");
  map.put("2","贰");
  map.put("3","叁");
  list.add(map);
  //map.clear();如果使用这个 会将map指针指向的值栈清空
  map=new HashMap<String,String>();
  map.put("一","壹");
  map.put("二","贰");
  map.put("三","叁");
  list.add(map);
  request.setAttribute("list_data",list);
   %>
  </head>
 
 
  <body> 
 <s:iterator value="#request.list_data" id="nm">
     <s:iterator value="#request.nm" id="t" status="status">
      <s:property value="#request.status.index"/>
      <s:property value="#request.t.key"/>
     <s:property value="value"/><br/>
     </s:iterator>
 </s:iterator>
  </body>
</html>