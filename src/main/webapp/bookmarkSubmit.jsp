<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="assignment.insertData" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String orderNum = request.getParameter("orderNum");
%>

</body>
<script  >


function al(){

	<%if(insertData.bookmarkInsert(orderNum,name)==1){%>

		alert("북마크 그룹 정보를 추가하였습니다.");
		window.location.href = "bookmarkGroup.jsp";	
	<%}else{%>
	alert("중복된 데이터입니다.");
	window.location.href = "bookmarkAdd.jsp";
	<%}%>
}
window.onload = al;
</script>
</html>