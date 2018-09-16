<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js" type="text/javascript"></script>
<script type="text/javascript">
	function reloadCheckCode(){
		document.getElementById("checkCode").src = "${pageContext.request.contextPath}/checkCode?" + Math.random();
		
	}
</script>

</head>
<body bgcolor="#FFFFFF" onLoad="MM_preloadImages('images/login000_06.jpg','images/loging000_07.jpg')">

	<table width="795" height="475" border="0" align="center"
		cellpadding="0" cellspacing="0" id="__01">
		<tr>
			<td colspan="5"><img src="images/login_01.jpg" width="795"
				height="159" alt=""></td>
		</tr>
		<tr>
			<td rowspan="2"><img src="images/login_02.jpg" width="269"
				height="174" alt=""></td>
			<td bgcolor="#CFE5F2"><img src="images/login_03.jpg" width="66"
				height="115" alt=""></td>
			<td colspan="2" bgcolor="#D0E6F3">
				<table width="100%" height="116" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td colspan="2" align="left" valign="bottom" class="lfield"><INPUT
							NAME="username" id="username" TYPE="text" CLASS="STYLE1"
							STYLE="width: 180px; height: 17px; border: #336699 1px solid"
							tabindex="1" MAXLENGTH="26"></td>
					</tr>
					<tr>
						<td height="32" colspan="2" align="left" valign="bottom"
							class="lfield"><INPUT NAME="password" id="password"
							TYPE="password" CLASS="STYLE1"
							STYLE="width: 180px; height: 17px; border: #336699 1px solid"
							tabindex="1" MAXLENGTH="26"></td>
					</tr>
					<tr>
						<td width="50%" height="29" align="left" valign="bottom"
							class="lfield"><INPUT NAME="checkCodeInput" id="checkCodeInput" TYPE="text"
							CLASS="STYLE1"
							STYLE="width: 100px; height: 17px; border: #336699 1px solid"
							tabindex="1" MAXLENGTH="26"></td>
						<td width="50%" align="left" valign="bottom"><a href="javascript:void(0)" onclick="reloadCheckCode();" onBlur="check()">
						<img src="${pageContext.request.contextPath}/checkCode" id="checkCode"/></a></td>
					</tr>
					<tr>
						<td height="30" colspan="1" align="left" valign="bottom">&nbsp;</td>
					</tr>
				</table>
			</td>
			<td rowspan="2"><img src="images/login_05.jpg" width="262"
				height="174" alt=""></td>
		</tr>
		<tr>
			<td colspan="2"><a onclick="tiJiao();" onMouseOut="MM_swapImgRestore()"
				onMouseOver="MM_swapImage('Image12','','images/loging000_06.jpg',1)"><img
					src="images/login_06.jpg" name="Image12" width="135" height="59"
					border="0"></a></td>
			<td><a href="../signup/signup.jsp" onMouseOut="MM_swapImgRestore()"
				onMouseOver="MM_swapImage('Image13','','images/loging000_07.jpg',1)"><img
					src="images/login_07.jpg" name="Image13" width="129" height="59"
					border="0"></a></td>
		</tr>
		<tr>
		   <td colspan="5"><img src="images/login_08.jpg" width="795"
					height="141" alt=""> <c:if test="${param.status.equals('1')}">
			<div class="alert alert-danger" role="alert">用户名不存在,请重新输入！</div>
				</c:if> <c:if test="${param.status.equals('2')}">
					<div class="alert alert-danger" role="alert">密码错误!</div>
				</c:if>
			</td>
		</tr>
		<tr>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="269"
				height="1" alt=""></td>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="66"
				height="1" alt=""></td>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="69"
				height="1" alt=""></td>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="129"
				height="1" alt=""></td>
			<td><img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="262"
				height="1" alt=""></td>
		</tr>
	</table>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/myvalidate.js"></script>
<script type="text/javascript">

	function check() {
		var codeCheck = $("#checkCode").val();
		var checkCode = $("#checkCode").val();
		if (codeCheck != checkCode) {
			document.getElementById("checkCode").style.display = "";
			document.getElementById("checkCode").innerHTML = "验证码错误！";
			return false;
		} else {
			document.getElementById("yanzheng").style.display = "none";
		}
	}

	function tiJiao() {
		var username = $("#username").val();
		var password = $("#password").val();
		var checkCodeInput = $("#checkCodeInput").val();
		
		var url ="${pageContext.request.contextPath}/servlet/AdminServlet?method=login&username="+username+'&password='+password;
		
		window.location.href=url;
		
	}
</script>
</body>
</html>