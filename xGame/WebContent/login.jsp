<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head class="header">
		<title>xGame FrameWork</title>
		<link rel="stylesheet" href="css/default.css">
	</head>
	<body>
		<div align="center">
			<h1>xGame FrameWork</h1>
		</div>

		<div align="center">
			<s:form action="Login" method="POST" id="loginForm" validate="false">
				<div>
					<s:fielderror cssStyle="color:red;" />
				</div>
				<div>
					&nbsp;&nbsp;
					<s:textfield name="userid" id="userid" size="20" label="用户账号"
						cssClass="inputStyleX1" />
				</div>
				<div>
					&nbsp;&nbsp;
					<s:password name="password" size="20" label="密  码"
						cssClass="inputStyleX1" />
				</div>
				<!-- 
				<div>
					&nbsp;&nbsp;
					<s:textfield name="checkcode" size="20" label="验证码"
						cssClass="inputStyleX1" />
				</div>
				 -->
				<div>
					<s:submit value="确认" id="btn" theme="xhtml"
						cssClass="buttonStyleCom" />
				</div>
			</s:form>
		</div>
	</body>
    <br>
	<!-- footer -->
<footer class="footer wrap">
	<p><a href="#">申请账号</a> | <a href="#">找回密码</a> | <a href="#">关于我们</a> | <a href="#">联系我们</a></p>
	<p>Copyright © 2014-2015 DiyalTech Corporation, All Rights Reserved</p>
</footer>
	</div>
</html>
