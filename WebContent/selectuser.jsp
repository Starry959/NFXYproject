<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<div title="查询用户" style="padding: 20px">
		<table class="easyui-datagrid" title="员工信息表"
			style="width: 100%; height: 400px"
			data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
			<thead>
				<tr>
					<th data-options="field:'itemid',align:'center',resizable:false"
						width="10%">编号</th>
					<th data-options="field:'productid',align:'center',resizable:false"
						width="20%">用户名</th>
					<th data-options="field:'listprice',align:'center',resizable:false"
						width="20%">密码</th>
				
				</tr>
			</thead>
			<tr>
				<c:forEach var="c" items="${requestScope.list}"
					varStatus="status">
					<td>${c.id}</td>
					<td>${c.username}</td>
					<td>${c.password}</td>
					
			</tr>
			</c:forEach>
		</table>

</body>
<script type="text/javascript">
    	function gotopage(currentpage){
    		if(currentpage<1 || currentpage!=parseInt(currentpage) || currentpage>'${pagebean.totalpage}'){
    			alert("请输入有效值！！");
    			document.getElementById("pagenum").value = '';
    		}else{
	    		var pagesize = document.getElementById("pagesize").value;
	    		window.location.href = '${pageContext.request.contextPath}/SelectUserServlet?currentpage=' + currentpage + '&pagesize=' + pagesize;
    		}
    	}
    	
    	function changesize(pagesize,oldvalue){
    		if(pagesize<0 || pagesize!=parseInt(pagesize)){
    			alert("请输入合法值！！");
    			document.getElementById("pagesize").value = oldvalue;
    		}else{
    			window.location.href = '${pageContext.request.contextPath}/SelectUserServlet?pagesize=' + pagesize;
    		}
}
    </script>
</html>