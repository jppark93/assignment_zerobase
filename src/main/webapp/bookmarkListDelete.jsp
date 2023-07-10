<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="assignment.getData"%>
    <%@ page import="assignment.bookmarkListVar" %>
      <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
#title{
	font-size:32px;
	font-weight:800;
}
#info{
	display:flex;
	

}
#item{
	display:flex;
	margin-bottom:10px;
}
#menu{
	list-style: none;
	display:flex;
	flex-direction: column;
	padding-inline-start: 0;
  	padding: 0px;
	margin:0px;
  	width: 10%;
 	
}
#menus{
	list-style: none;
	display:flex;
	flex-direction: column;
	padding-inline-start: 0;
  	padding: 0px;
	margin:0px;
  	width: 30%;
 	
}
#menuInfo{
	display:flex;
	align-items: center;
    flex-direction: column;
    justify-content: center;
	font-size: 13px;
	border: 1px solid white;
 	padding:0px;
	width: 100%;
  	height: 40px;	
  	color: white;
  	background-color:rgb(11, 189, 124);
  	font-weight: 800;
  	border-right: 1px solid white;
  	
}
#detail{
	display:flex;
	
    flex-direction: column;
    justify-content: center;
	font-size: 13px;
	height: 40px;	
 	padding-left:20px;
	width: 100%;
  	
  	
  	font-weight: 800;
  	border: 1px solid #DCDCDC;
}
#subm{
	display:flex;
	width:41.5%;
	height:40px;
	border: 1px solid #DCDCDC;
	align-items: center;
    justify-content: center;
}

#route{
 margin-left:10px;
}
</style>
<body>
<h1 id="title"><%
  out.write("북마크 추가");
  %></h1>
  <div id ="nav" style="margin-bottom: 15px;">
  	<%
  		String[] arr = {"홈 | "," 위치 히스토리 목록 | "," Open API 와이파이 정보 가져오기 | "," 북마크 보기 |"," 북마크 그룹 관리"}; 
  		String[] routeArr ={"mainPage.jsp","history.jsp","loadWifi.jsp","bookmarkList.jsp","bookmarkGroup.jsp"};
  		String[] x = {"북마크 이름","와이파이명","등록일자"};
  		String dataValue = request.getParameter("num");
  		  
  		List<bookmarkListVar> bList = getData.getBookmarkList2(dataValue);
  		%>
  	<%
  	for(int i =0; i<arr.length; i++){
  		%>
  	     <a href =<%=routeArr[i] %>> <%= arr[i] %> </a>
  		<%
  	  }
  		%>
  </div>
  <div id="select">
  
  </div>
   <div id="info">
   <ul id="menu">
   	<%

  	for(String str: x){
  		%>
  	     <li id="menuInfo"><%= str %></li>
  		<%
  	  }
  		%>
   </ul>
   
      <ul id="menus">
  	     
     
  	     <li id="detail"><%=bList.get(0).getBookmarkName() %></li>
  	     <li id="detail"><%=bList.get(0).getWifiName() %></li>
     	  <li id="detail"> <%=bList.get(0).getNowDate() %></li>
   </ul>

   </div>
    <div id="subm">
      <a href="bookmarkList.jsp" style="padding-right:15px;">돌아가기</a>
      <span  style="padding-right:15px;">|</span>
   	  <button id="deleteButton" input="button">삭제</button>
   </div>
</body>
<script>
	document.getElementById('deleteButton').addEventListener('click', function() {
    // bname과 orderNum 값을 가져오기
    var num = '<%= dataValue %>';
   
    
    // URL에 쿼리스트링 추가하여 페이지 이동
    var url = 'deleteListSubmit.jsp?num=' + encodeURIComponent(num) ;
    window.location.href = url;
	});
</script>
</html>