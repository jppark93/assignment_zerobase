<%@page import="assignment.data"%>
<%@page import="assignment.getData"%>
<%@page import="java.util.*"%>
<%@ page import="assignment.pbwifi" %>
<%@ page import="assignment.bookmarkVar" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
  	width: 25%;
 	
}
#menus{
	list-style: none;
	display:flex;
	flex-direction: column;
	padding-inline-start: 0;
  	padding: 0px;
	margin:0px;
  	width: 50%;
 	
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
#select{
	display:flex;
	margin-bottom:10px;
}

#route{
 margin-left:10px;
}
</style>
<body>
<h1 id="title"><%
  out.write("와이파이 정보");
  %></h1>
  <div id ="nav" style="margin-bottom: 15px;">
  	<%
  		String[] arr = {"홈 | "," 위치 히스토리 목록 | "," Open API 와이파이 정보 가져오기 | "," 북마크 보기 |"," 북마크 그룹 관리"}; 
  		String[] routeArr ={"mainPage.jsp","history.jsp","loadWifi.jsp","bookmarkList.jsp","bookmarkGroup.jsp"};
  		String[] x = {"거리(Km)","관리번호","자치구","와이파이명","도로명주소","상세주소","설치위치(층)","설치유형","설치기관","서비스구분","망종류","설치년도","실내외구분","WIFI접속환경","X좌표","Y좌표","작업일자"};
  	   	String mgrNo = request.getParameter("mgrno");
  	    List<pbwifi> wifiList = getData.getOData(mgrNo);
  	    List<bookmarkVar> bList = getData.getBookmark();
  		%>
  	<%
  	for(int i =0; i<arr.length; i++){
  		%>
  	     <a href =<%=routeArr[i] %>> <%= arr[i] %> </a>
  		<%
  	  }
  		%>
  </div>
  <form id="select" action="./listSubmit.jsp" accept-charset="utf-8" onsubmit="return validateForm()">
  
  <select name="data">
 	<option value="0" selected>북마크 그룹 이름 선택</option>
  <%for(int i =0; i<bList.size(); i++){ %>
  
  	<option value=<%=String.valueOf(bList.get(i).getId())+"|"+String.valueOf(bList.get(i).getBookmarkName())+"|"+String.valueOf(mgrNo) %> ><%=bList.get(i).getBookmarkName()%></option>
  <%}%>  
  </select>
  
  <button type="submit">북마크 추가하기</button>
  </form>
   <div id="info">
   <ul id="menu">
   	<%
  	for(String str: x){%>
  	     <li id="menuInfo"><%= str %></li>
  		<%
  	  }
  		%>
   </ul>
      <ul id="menus">

  	    
  	     	<li id="detail"><%=wifiList.get(0).getMgrNo() %></li>
  	     	<li id="detail"><%=wifiList.get(0).getMgrNo() %></li>
  	     	<li id="detail"><%=wifiList.get(0).getWrdofc() %></li> 
  		    <li id="detail"><%=wifiList.get(0).getMainNM()%></li>
  		    <li id="detail"><%=wifiList.get(0).getAddress1() %></li> 	 
  			<li id="detail"><%=wifiList.get(0).getAddress2() %></li>
  			<li id="detail"><%=wifiList.get(0).getFloor() %></li>
   			<li id="detail"><%=wifiList.get(0).getTy() %></li>
   			<li id="detail"><%=wifiList.get(0).getMby() %></li>
   			<li id="detail"><%=wifiList.get(0).getSVC() %></li>
   			<li id="detail"><%=wifiList.get(0).getCMCWR() %></li>
   		    <li id="detail"><%=wifiList.get(0).getYear() %></li>
   			<li id="detail"><%=wifiList.get(0).getInOut() %></li>
   	        <li id="detail"><%=wifiList.get(0).getRemars() %></li>
   	        <li id="detail"><%=wifiList.get(0).getLat() %></li>
   	        <li id="detail"><%=wifiList.get(0).getLnt() %></li>
   	        <li id="detail"><%=wifiList.get(0).getDttm() %></li>
   	      
   
   
   </ul>
   </div>
</body>
<script type="text/javascript">
function validateForm() {
    var selectElement = document.getElementById('select');
    var selectedOption = selectElement.options[selectElement.selectedIndex];
    
    if (selectedOption.value === "0") {
      alert("북마크 그룹 이름을 선택해주세요.");
      return false; 
    }

    
    return true; // 제출 진행
  }
</script>
</html>