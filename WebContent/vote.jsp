<%@page import="com.gmail.tyi.Questionnaire"%>
<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Questionnaire questionare = (Questionnaire)request.getAttribute("data");%>
	
	<form method="post" action="VotingServlet">
		Ім'я Прізвище: <input name="fullName" />
		<% for(int i=1; i <= questionare.getQuestionIdNum(); i++) { %> 
			<br> <%=questionare.getQuestionByID(i) %>: 
			<input type="radio" name=<%=i %> value="Yes">Yes</input>
			<input type="radio" name=<%=i %> value="No">No</input>
		<%} %>
			<input type="submit" />

	</form>

</body>
</html>