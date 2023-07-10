<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="assignment.insertData" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
  String dataValue = request.getParameter("data"); 
  String decodedValue = java.net.URLDecoder.decode(dataValue, "UTF-8");
  String[] parts = decodedValue.split("\\|");

  HttpSession sessions = request.getSession();
  sessions.setAttribute("dataParam1", parts[2]);
  response.sendRedirect("./bookmarkList.jsp");
%>
</body>
<script type="text/javascript">

 function al(){

	<%insertData.bookmarkListInsert(String.valueOf(parts[0]),String.valueOf(parts[1]),String.valueOf(parts[2]));%>

	alert("북마크 그룹 정보를 추가하였습니다.");
	window.location.href = "bookmarkList.jsp";
}
window.onload = al;
</script>
</html>