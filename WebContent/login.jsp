<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>登录</title>
<!-- CSS文件 easyui-->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<!-- 轮播图片的插件 -->
<link rel="stylesheet" href="login_style/css/supersized.css">
<!-- 自己的css样式 -->
<link rel="stylesheet" href="login_style/css/login.css">
</head>
<body>

	<div id="div_login">
		<p>人事管理Hrm系统</p>
		<div id="div_form">
			<img src="login_style/img/logo2.jpg" alt="找不到图片">
			<form action="${pageContext.request.contextPath}/LoginServlet"
				method="post">
				<table>
					<tr>
						<td class="td1"><img src="login_style/img/memeber.gif" alt=""
							style="width: 16px; text-align: right"></td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td class="td1"><img src="login_style/img/lock.gif" alt=""
							style="width: 16px;"></td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr style="background-color: inherit">

						<td colspan="2">
							<div>
								<input id="input_submit" type="submit" value="登录">
							</div>
						</td>

					</tr>

				</table>
			</form>
		</div>
	</div>
	<!-- Javascript -->
	<script src="login_style/js/supersized.3.2.7.min.js"></script>
	<script src="login_style/js/supersized-init.js"></script>

</body>
<script type="text/javascript">
	$(function() {
		var loginfo = '${loginfo}';
		if (loginfo != "") {
			$.messager.alert('登录失败',loginfo, 'error');
		}
	});
</script>
</html>