<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@page import="assignment.deleteData"%>
 <%@page import="assignment.history"%>
 <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	 <%String dataValue = request.getParameter("id"); %>
</body>
<script type="text/javascript">

 function al(){

	<%deleteData.deleteHistory(dataValue);%>

	alert("�����丮 ����� �����Ͽ����ϴ�.");
	window.location.href = "history.jsp";
}
window.onload = al;
</script>
</html>