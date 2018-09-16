<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>需求审核</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.css" />

<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.css">

<style type="text/css">
<!--
.STYLE1 {
	font-size: x-large
}
-->
</style>
<script type="text/javascript">
function ch(){
		alert("重置完毕！");
	}

</script>
</head>
<body>
	<div class="container-fulid">
		<div class="col-md-12">
			<h1 align="center">用户管理</h1>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-10">
	<p>&nbsp;</p>
	<c:if test="${adminBeans!=null }">
	<div class="col-md-13">
		<table class="table table-striped">
			<tr>
			<td></td>
				<td>用户名</td>
				<td>姓名</td>
				<td>身份证号</td>
				<td>角色</td>
				<td>重置密码</td>
				<td></td>
			</tr>
			<c:forEach items="${adminBeans }" var="item" varStatus="status">
<form name="form1" method="post"
		action="${pageContext.request.contextPath }/AdminServlet?method=updatePassword&username=${item.username }">
				<tr>
				<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">详情 ▷</button></td>
					<td>${item.username }</td>
					<td>${item.name }</td>
					<td>${item.id_number }</td>
				  <td><c:if test="${item.status==0}">管理员</c:if>
				  <c:if test="${item.status==1}">网络审核员</c:if><c:if test="${item.status==2}">注册用户</c:if>
									<c:if test="${item.status==3}">此用户还未通过审核</c:if>	</td>
						<td><input id="password" name="password" type="password" class="form-control" value="${item.password }"></td>
					<td><input class="btn btn-default btn-sm" type="submit" onClick="ch()" value="确认重置"></td>
				</tr>
				</form>
			</c:forEach>
		</table>
		</div>
	</c:if>
	</div>
		<div class="col-md-1"></div>
		<div class="col-md-12"></div>
	</div>
	
	
	
	
	
	
	
	
	<!-- 
	<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<div class="modal-body">
				在这里添加一些文本
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div>/.modal-content
	</div>/.modal
</div> -->
	<p>&nbsp;</p>
</body>

</html>