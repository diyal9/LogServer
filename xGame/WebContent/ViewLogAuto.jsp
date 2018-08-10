<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>xGame查看Log</title>
<link rel="stylesheet" href="css/default.css">

<script language="JavaScript">
	function myrefresh() {
		window.location.reload();
	}
	setTimeout('myrefresh()', 5000); //指定5秒刷新一次
</script>
</head>
<body>
	<div id="form">
		<div>
			<h3>[${sessionScope.userid }] &nbsp;&nbsp;&nbsp;&nbsp;自动刷新监控(最近5条Log/5s)</h3>
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