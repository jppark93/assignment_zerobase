<%@page import="assignment.data"%>
<%@page import="assignment.getData"%>
<%@page import="java.util.*"%>
<%@ page import="assignment.pbwifi" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>
#main{
	display:flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
<body>
<% 
List<pbwifi> wifiList = getData.getD1();

 %>
<div id="main">
<h1 id="title"><%
out.print(wifiList.size() + "개의 WIFI 정상적으로 저장하였습니다.");
%>
</h1>
<span><a href="mainPage.jsp">홈으로</a></span>
</div>
</body>
</html>