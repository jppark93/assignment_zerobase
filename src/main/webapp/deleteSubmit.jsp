<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="assignment.insertData" %>
<%@ page import="assignment.deleteData" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
  
  String dataValue = request.getParameter("orderNum");
  
  
  
%>
</body>
<script type="text/javascript">

 function al(){

	<%deleteData.deleteBookmarkGroup(dataValue);%>

	alert("�ϸ�ũ �׷� ������ �����Ͽ����ϴ�.");
	window.location.href = "bookmarkGroup.jsp";
}
window.onload = al;
</script>
</html>