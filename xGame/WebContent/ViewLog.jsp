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
			<h3>[${sessionScope.userid }] &nbsp;&nbsp;&nbsp;&nbsp; 错误日志查看</h3>

			<div>
				<a href="<s:url action="ViewLogAuto.action"/>">开启监控</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<%-- <a href="<s:url action="LogTeamHanderMain.action"/>">协同管理</a>&nbsp;&nbsp;&nbsp;&nbsp; --%>
				<a href="<s:url action="deleteLookUp.action"/>">Delete已解决</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<s:url action="goHome.action"/>">到首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
	</div>

	<s:iterator value="logList" status="st" id="list1">

		<s:if test="%{#list1.deleteflg == 1}">
			<div style="background-color: gray">
				<div>
					<hr />
					<font color="blue">${time}</font> <br>
				</div>
				<div>${content}</div>
			</div>
		</s:if>
		<s:else>
			<div style="background-color: white">
				<div>
					<hr />
					<font color="blue">${time}</font> <br>
				</div>
				<div>${content}</div>
			</div>
		</s:else>





	</s:iterator>
	<hr />

	<p>© CopyRight DiyalTech Support</p>
</body>
</html>