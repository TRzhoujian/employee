<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <s:debug></s:debug>
    <h1>员工信息列表</h1>
    <a href="/oa/employee_input">添加员工</a>
    <table border="1" cellpadding="0" cellspacing="0" width="70%">
    	<tr>
    		<th>序号</th>
    		<th>编号</th>
    		<th>姓名</th>
    		<th>密码</th>
    		<th>邮箱</th>
    		<th>雇用日期</th>
    		<th>操作</th>
    	</tr>
	    <s:iterator value="#list" var="e" status="st">
	    	<tr style="background-color: <s:property value="#st.count%2==0?'red':''"/> ">
	    		<td><s:property value="#st.count"></s:property></td>
	    		<td><s:property value="#e.id"></s:property></td>
	    		<td><s:property value="#e.name"></s:property></td>
	    		<td><s:property value="#e.password"></s:property></td>
	    		<td><s:property value="#e.email"></s:property></td>
	    		<td><s:property value="#e.hireDate"></s:property></td>
	    		<td><a href="/oa/employee_delete?e.id=<s:property value="#e.id"></s:property>">删除</a> | <a href="/oa/employee_input?e.id=<s:property value="#e.id"></s:property>">编辑</a></td>
	    	</tr>
    	</s:iterator>
    	
    	
    </table>
  </body>
</html>
