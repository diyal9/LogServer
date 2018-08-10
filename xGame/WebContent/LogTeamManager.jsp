<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>xGame查看Log</title>
<link rel="stylesheet" href="css/default.css">

<script language="JavaScript">
</script>
</head>
<body>
	<div id="form">
		<div>
			<h3>[${sessionScope.userid }] &nbsp;&nbsp;&nbsp;&nbsp;协同管理</h3>
		</div>
		<div><a href="<s:url action="ClearMyLog.action"/>">标记为解决</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<s:url action="ViewLog.action"/>">停止并查看</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<s:url action="goHome.action"/>">到首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</div>
	<div>
		<s:iterator value="logList" status="st" id="list1">
			<div>
				<hr />
				<font color="blue">${time}</font> <br>
			</div>
			<div>${content}</div>
		</s:iterator>
		<hr />
	</div>

	<p>© CopyRight DiyalTech Support</p>
</body>
</html>