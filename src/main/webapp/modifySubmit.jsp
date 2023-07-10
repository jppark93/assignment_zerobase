<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="assignment.getData"%>
    <%@ page import="assignment.dataModify" %>
      <%@page import="java.util.*"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String bname = request.getParameter("bname");
String orderNum = request.getParameter("orderNum");
String num = request.getParameter("id");
System.out.println(bname);
System.out.println(orderNum);
System.out.println(num);
%>
</body>
<script  >


function al(){

	<%if(dataModify.updateBookmarkGroup(orderNum,bname,num)==1){%>

		alert("북마크 그룹 정보를 수정하였습니다.");
		window.location.href = "bookmarkGroup.jsp";	
	<%}else{%>
	alert("중복된 순서입니다.");
	window.location.href = "bookmarkGroup.jsp";
	<%}%>

}
window.onload = al;
</script>
</html>