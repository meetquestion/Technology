<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>河北省重大技术需求征集清单</title>
<style type="text/css">
body {
	background-color: #DCF0FC;
}
<!--
.STYLE1 {
	font-size: x-large
}
-->
</style>
<script
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
<script
	src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body onload='document.getElementById("name").focus();'>
		<div class="container-fulid">
		<div class="col-md-12">
			<h1 align="center">管理需求</h1>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-10">
		<!-- 	<div class="row-fluid">
			<div class="col-md-4">
				<h1>问卷查询</h1>
			</div>
		</div> -->
		<%-- 		<div class="col-md-6">
			<form class="navbar-form navbar-left" role="search"
				action="${pageContext.request.contextPath }/DemandServlet?method=selectList"
				method="post">
				<div class="form-group">
					<input id="JSXQMC" type="text" class="form-control"
						placeholder="技术需求名称" name="JSXQMC" list="JSXQMCs">
					<datalist id="JSXQMCs"> <c:forEach items="${demandBeans }"
						var="item" varStatus="status">
						<option value="${item.JSXQMC }"></option>
					</c:forEach> </datalist>
				</div>
				<button type="submit" class="btn btn-primery">点击查询</button>
			</form>
		</div> --%>


		<%-- <p>&nbsp;</p>
		<c:if test="${param.status.equals('1')}">
			<div class="alert alert-danger" role="alert">抱歉！查询不到！</div>
		</c:if> --%>
		<c:if test="${demandBeans!=null }">
			<table class="table table-striped">
				<tr>
					<td width="113">调查问卷编号</td>
					<td width="162">技术需求名称</td>
					<td width="206">提交日期</td>
					<td width="206">审核状态</td>
				</tr>
				<c:forEach items="${demandBeans }" var="item" varStatus="status">
					<tr>
						<td>${item.WJID }</td>
						<td>
						<c:if test="${item.SFSH==0 }">
						<a
							href="${pageContext.request.contextPath }/DemandServlet?method=myDetails&WJID=${item.WJID }">${item.JSXQMC }</a>
							</c:if>
							<c:if test="${item.SFSH==1 }">${item.JSXQMC }</c:if>
							</td>
						<td>${item.createDate }</td>
						<td><c:if test="${item.SFSH==0 }">还未审核</c:if> 	<!-- 未通过可以进行修改 --> 
						<c:if test="${item.SFSH==1 }">已通过网络审核</c:if>
						<c:if test="${item.SFSH==2 }">未通过网络审核</c:if></td>

					</tr>
				</c:forEach>
			</table>

		</c:if>

		<p>&nbsp;</p>


</div>
		<div class="col-md-1"></div>
		<div class="col-md-12"></div>
	</div>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.validate.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/myValidate.js"
		type="text/javascript"></script>
</body>

</html>