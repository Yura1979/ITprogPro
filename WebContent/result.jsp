<%@page import="com.gmail.tyi.Questionnaire"%>
<%@page import="com.gmail.tyi.VotingServlet"%>
<%@page import="com.gmail.tyi.QuestionareTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<head>
<meta charset="ISO-8859-1">
<title>Результати опитування</title>
</head>
<body>
<% Questionnaire questionare = (Questionnaire)request.getAttribute("data");%>
<!--Table-->
<table id="tablePreview" class="table table-bordered">
<!--Table head-->
  <thead>
    <tr>
      <th>Номер запитання</th>
      <th>Запитання</th>
      <th>Так</th>
      <th>Ні</th>
    </tr>
  </thead>
  <!--Table head-->
  <!--Table body-->
  <tbody>
  <% for(int i = 1; i <= questionare.getQuestionIdNum(); i++) { %>
    <tr>
      <td><%=i %></td>
      <td><%=questionare.getQuestionByID(i) %></td>
      <td><%=questionare.getYesUnswers(i) %></td>
      <td><%=questionare.getNoUnswers(i) %></td>
    </tr>
    <%} %>
    
    
    </tbody>
  <!--Table body-->
</table>
<!--Table-->
<a href="http://localhost:8080/Voting/VotingServlet">Голосування</a>
</body>
</html>