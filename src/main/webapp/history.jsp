<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="assignment.getData"%>
    <%@page import="assignment.history"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>
#title{
	font-size:32px;
	font-weight:800;
}
#info{
	display:flex;
	flex-direction: column;

}
#item{
	display:flex;
	margin-bottom:10px;
}
#menu{
	list-style: none;
	display:flex;
	padding-inline-start: 0;
  	padding: 0px;
	margin:0px;
  	width: 100%;
 	
}
#menuInfo{
	display:flex;
	align-items: center;
    flex-direction: column;
    justify-content: center;
	font-size: 13px;
	
 	padding:0px;
	width: 20%;
  	height: 40px;	
  	color: white;
  	background-color:rgb(11, 189, 124);
  	font-weight: 800;
  	border-right: 1px solid white;
  	
}
#detail{
	display:flex;
	align-items: center;
    flex-direction: column;
    justify-content: center;
	font-size: 13px;
	height: 40px;	
 	padding:0px;
	width: 20%;
  	
  	
  	font-weight: 800;
  	border: 1px solid #DCDCDC;
}
#detail2{
	display:flex;
	align-items: center;
    flex-direction: column;
    justify-content: center;
	font-size: 13px;
	height: 40px;	
 	padding:0px;
	width: 100%;	
  	font-weight: 800;
  	border: 1px solid #DCDCDC;
}
/* #menuInfo:nth-child(5),
#menuInfo:nth-child(6) {
	width: 15%; 
}
#detail:nth-child(5),
#detail:nth-child(6) {
	width: 15%; 
} */
#route{
 margin-left:10px;
}
</style>
<body>
<h1 id="title"><%
  out.write("위치 히스토리 목록");
  %></h1>
  <div id ="nav" style="margin-bottom: 15px;">
  	<%
  		String[] arr = {"홈 |"," 위치 히스토리 목록 |"," Open API 와이파이 정보 가져오기 |"," 북마크 보기 |"," 북마크 그룹 관리"}; 
  		String[] routeArr ={"mainPage.jsp","history.jsp","loadWifi.jsp","bookmarkList.jsp","bookmarkGroup.jsp"};
  		String[] x = {"ID","X좌표","Y좌표","조회일자","비고"};
  		
  		%>
  	<%
  	for(int i =0; i<arr.length; i++){
  		%>
  	     <a href =<%=routeArr[i] %>> <%= arr[i] %> </a>
  		<%
  	  }
  		%>
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
<% List<history> hList = getData.getHistory();  
	if(hList.size()!=0){
	for(int i =0; i<hList.size(); i++){
%>

   		<ul id="menu">
    		<li id="detail"><%=hList.get(i).getHid() %></li>
  			<li id="detail"><%=hList.get(i).getLat() %></li>
  			<li id="detail"><%=hList.get(i).getLnt() %></li>
  			<li id="detail"><%=hList.get(i).getNowDate() %></li>
  			<li id="detail"><a href="historyDelete.jsp?id=<%=hList.get(i).getHid()%>"><button type="button">삭제</button></a></li>
  	
   		</ul>
<%}
	}else{ %>
	<ul id="menu">
  		<li id="detail2">위치 정보를 입력한 후에 조회해 주세요.</li>
   </ul>
	<%} %>
   </div>
</body>
</html>