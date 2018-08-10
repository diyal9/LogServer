<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>xGame FrameWork</title>
<link rel="stylesheet" href="css/default.css">
</head>
<body>
	<div>
		<div align="left">
			<h2>xGame FrameWork</h2>
		</div>
		<div align="right">登录用户 : ${sessionScope.userid }</div>
	</div>
	<hr />
	<div>
		<ul>
			<li>
				<div>
					<a href="<s:url action="ViewLog.action"/>" title="根据xGame编号或用户ID来查询">日志查看</a>
				</div> <br>
			</li>

			<li>
				<div>
					<a href="<s:url action="ViewLogAuto.action"/>" title="自动查看日志，每5秒刷新一次">Error监控</a>
				</div> <br>
			</li>

			<li>
				<div>
					<a href="<s:url action="ViewLogAuto.action"/>" title="统计日志类型，日志相关的统计">日志统计</a>
				</div>
			</li>

			<br>
		</ul>
	</div>
	<br>

	<!-- footer -->
	<footer class="footer wrap">
		<p>
			<a href="#">成员管理</a> | <a href="#">清空日志</a> | <a href="#">错误统计</a> |
			<a href="#">联系我们</a>
		</p>
		<p>Copyright © 2014-2015 DiyalTech Corporation, All Rights
			Reserved</p>
	</footer>
	</div>

</body>
</html>
