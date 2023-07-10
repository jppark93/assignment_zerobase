<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="assignment.insertData" %>
     <%@ page import="assignment.bookmarkVar" %>
     <%@page import="assignment.getData"%>
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
#detail3{
	display:flex;
	align-items: center;
   
    justify-content: center;
	font-size: 13px;
	height: 40px;	
 	padding:0px;
	width: 20%;
  	
  	
  	font-weight: 800;
  	border: 1px solid #DCDCDC;
}
#add{
	display:flex;
	margin-bottom:10px;
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
#f {
width:100%;
}
</style>
<body>
<h1 id="title"><%
  out.write("북마크 그룹");
  %></h1>
  <div id ="nav" style="margin-bottom: 15px;">
  	<%
  		String[] arr = {"홈 |"," 위치 히스토리 목록 |"," Open API 와이파이 정보 가져오기 |"," 북마크 보기 |"," 북마크 그룹 관리"}; 
  		String[] routeArr ={"mainPage.jsp","history.jsp","loadWifi.jsp","bookmarkList.jsp","bookmarkGroup.jsp"};
  		String[] x = {"ID","북마크 이름","순서","등록일자","수정일자","비고"};
  		
  		%>
  	<%
  	for(int i =0; i<arr.length; i++){
  		%>
  	     <a href =<%=routeArr[i] %>> <%= arr[i] %> </a>
  		<%
  	  }
  		%>
  </div>
 	<div id="add">
 		<a  href="bookmarkAdd.jsp" ><button input="button" >북마크 그룹 이름 추가</button></a>
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
  		<%
      		List<bookmarkVar> bList = getData.getBookmark();
  	if(bList.size()!=0){
       for(int i=0; i<bList.size(); i++){
    	   String bookmarkName = bList.get(i).getBookmarkName();
    	   String encodedBookmarkName = java.net.URLEncoder.encode(bookmarkName, "UTF-8");
  	%>
  		
   <ul id="menu">
    	
  		 <li id="detail"><%=bList.get(i).getId()%></li>
  		 <li id="detail"><%=bList.get(i).getBookmarkName() %></li>
  		 <li id="detail"><%=bList.get(i).getOrderNum() %></li>
  		 <li id="detail"><%=bList.get(i).getDate() %></li>
  		 <%if(!bList.get(i).getUpdateDate().equals("null")){ %>
  		 <li id="detail"><%=bList.get(i).getUpdateDate() %></li>
  		 <%}else{%><li id="detail"></li>
  			<%} %>
  		<li id="detail3">
  			<a href="bookmarkModify.jsp?&num=<%=bList.get(i).getId()%>"><button type="button">수정</button></a>
  			<a href="bookmarkDelete.jsp?bname=<%=encodedBookmarkName%>&orderNum=<%=bList.get(i).getOrderNum()%>"><button type="button">삭제</button></a>
  		</li> 	
  		
  		
  		</ul>
  		<%
  		}
  	}else{
  	
  	%> 
  	<ul id="menu">
  	<li id="detail2">등록된 북마크가 없습니다.</li>
   </ul>
<%}%>
   </div>
</body>

<script type="text/javascript">

</script>
</html>