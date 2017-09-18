<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style>
div#loginhead {
	position: relative;
	text-align: centre;
	left: 45%;
}

div#loginMain {
	position: relative;
	top: 5%;
	left: 11%;
	border: 2px solid aqua;
	text-align: centre;
	width: 48.5%;
	border: 4px solid #aadafd;
	background-color: #dceffe;
	padding-left: 40%;
	padding: 20px 0% 40px 40%;
}

div#loginMain label {
	font-weight: bold;
	font-size: 17px;
	'
}
</style>
<body>
	<div id="loginhead">
		<h1>Login</h1>
	</div>

	<div id="loginMain">

		<form:form action="loginForm" modelAttribute="loginForm">
			<!-- 			<div id="error"> -->
			<%-- 				<FONT color="blue" font-family="sans-serif"><form:errors --%>
			<%-- 						path="userName" /></FONT> <br> <FONT color="blue"><form:errors --%>
			<%-- 						path="password" /></FONT><br> --%>
			<!-- 			</div> -->
			<table class="loginTable">
				<tr>
					<td colspan="2"><FONT color="blue" font-family="sans-serif"><form:errors
								path="userName" /></FONT></td>
					<td></td>
				</tr>
				<tr>
					<td height="30px"><label>User Name:</label><FONT color="red"></FONT></td>

					<td height="30px"><form:input path="userName" /></td>
				</tr>
				<tr>
					<td colspan="2"><FONT color="blue"><form:errors
								path="password" /></FONT></td>
					<td></td>
				</tr>
				<tr>
					<td height="30px"><label>Password:</label></td>

					<td height="30px"><form:password path="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td height="30px"><label>Login As :-</label></td>
					<td height="30px"><form:select path="userType"
							itemLabel="Login As :-">
							<form:option value="user">User</form:option>
							<form:option value="admin">Admin</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>