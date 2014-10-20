<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P>
	<c:if test="${not empty skills}">
		<ul>
			<c:forEach var="listValue" items="${skills}">
				<li>${listValue.employeeSkillRating}</li>
				<li>${listValue.employee.employeeName}</li>
			</c:forEach>
		</ul>
	</c:if>
<img alt="Google Pie Chart" src=${chart} />
<form action="/mvcchart/search/sourav" name="mentee" method="get">
<input type="submit" value="submit" />
	<img alt="Google Pie Chart" src=${chart1} />
</form>
</body>
</html>
