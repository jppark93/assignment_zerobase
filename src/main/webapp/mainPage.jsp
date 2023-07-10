<%@page import="assignment.data"%>
<%@page import="assignment.getData"%>
<%@page import="java.util.*"%>
<%@ page import="assignment.pbwifi" %>
<%@ page import="assignment.insertData" %>
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
#nav{
	display:flex;
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
	width: 8%;
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
	height: 60px;	
 	padding:0px;
	width: 8%;
  	
  	
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
#menuInfo:nth-child(5),
#menuInfo:nth-child(6) {
	width: 13%; 
}


#detail:nth-child(5),
#detail:nth-child(6) {
	width: 13%; 
}
#route{
 margin-left:10px;
}
</style>
<meta charset="EUC-KR">
<title><%
  	 out.write("�������� ���� ���ϱ�");
  %></title>
</head>
<body>
  <h1 id="title"><%
  out.write("�������� ���� ���ϱ�");
  %></h1>
  <div id ="nav" style="margin-bottom: 15px;">
  	<%
  		String[] arr = {"Ȩ |"," ��ġ �����丮 ��� |"," Open API �������� ���� �������� |"," �ϸ�ũ ���� |"," �ϸ�ũ �׷� ����"}; 
  		String[] routeArr ={"mainPage.jsp","history.jsp","loadWifi.jsp","bookmarkList.jsp","bookmarkGroup.jsp"};
  		String[] x = {"�Ÿ�(Km)","������ȣ","��ġ��","�������̸�","���θ��ּ�","���ּ�","��ġ��ġ(��)","��ġ����","��ġ���","���񽺱���","������","��ġ�⵵","�ǳ��ܱ���","WIFI����ȯ��","X��ǥ","Y��ǥ","�۾�����"};
  		String lat = request.getParameter("LAT");
  		String lnt = request.getParameter("LNT");
  		
  		%>
  	<%
  	for(int i =0; i<arr.length; i++){
  		if(i==2){
  			%>
  			<div onclick="executeFunction(event)"><a href =<%=routeArr[i] %> > <%= arr[i] %> </a></div>	
  		<%
  		} 		
  		else{%>
  		   <a href =<%=routeArr[i] %>> <%= arr[i] %> </a>
  		<%}
  	  }
  		%>
  </div>
      <form id="wifiForm" >
  
  <div id="item" style="display:flex;">
   
       LAT: <input type="text" id="latInput" name="LAT" value="<%= (lat == null) ? "0.0" : lat %>"> , 
       LNT: <input type="text" id="lntInput" name="LNT" value="<%= (lnt == null) ? "0.0" : lnt %>"> 
    
     <button style="margin-left:5px;" type="button" onclick="getLocation()">�� ��ġ ��������</button> 
     <button style="margin-left:5px;" type="submit" onclick="loc()">��ó WIFI ��������</button>

   </div>
  </form> 
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
   if(lat!= null && lat!=null){
   List<pbwifi> wifiList = getData.getD(lat,lnt);
  
   for (int i = 0; i < wifiList.size(); i++) {
	  
	    pbwifi wifi = wifiList.get(i);
	    Double distance = getData.getDistance(Double.parseDouble(lat), Double.parseDouble(lnt),Double.parseDouble(wifi.getLat()), Double.parseDouble(wifi.getLnt()));
		String result = String.format("%.3f",distance);
	%>
	   <ul id="menu">
	      	<li id="detail" ><%=result %></li>
	      	<li id="detail" ><%=wifi.getMgrNo() %></li>
	      	<li id="detail" ><%=wifi.getWrdofc() %></li>
	  		<li id="detail" ><a href="wifiInfo.jsp?mgrno=<%=wifi.getMgrNo()%>"><%=wifi.getMainNM() %></a></li>
			<li id="detail" ><%=wifi.getAddress1() %></li>
			<li id="detail" ><%=wifi.getAddress2() %></li>
			<li id="detail" ><%=wifi.getFloor() %></li>
			<li id="detail" ><%=wifi.getTy() %></li>
			<li id="detail" ><%=wifi.getMby() %></li>
			<li id="detail" ><%=wifi.getSVC() %></li>
			<li id="detail" ><%=wifi.getCMCWR() %></li>
			<li id="detail" ><%=wifi.getYear() %></li>
		    <li id="detail" ><%=wifi.getInOut() %></li>
		    <li id="detail" ><%=wifi.getRemars() %></li>
		    <li id="detail" ><%=wifi.getLat() %></li>
		    <li id="detail" ><%=wifi.getLnt() %></li>
		    <li id="detail" ><%=wifi.getDttm() %></li> 	
	  	
	   </ul>
	<%
	}
   }else{
	%>
	<ul id="menu">
  	<li id="detail2">��ġ ������ �Է��� �Ŀ� ��ȸ�� �ּ���.</li>
   </ul>
<%}%>
  </div>
</body>

<script>
var isOk = false;
function getLocation() {
    navigator.geolocation.getCurrentPosition(function(pos) {
        var latitude = pos.coords.latitude;
        var longitude = pos.coords.longitude;
        document.getElementById("latInput").value = latitude;
        document.getElementById("lntInput").value = longitude;
        
    });
    
}

function initializeFields() {
    document.getElementById("latInput").value = ""; // �ʱ�ȭ: �� ���ڿ� �Ҵ�
    document.getElementById("lntInput").value = ""; // �ʱ�ȭ: �� ���ڿ� �Ҵ�
}
function loc(){

	<%if(lat != null && lnt != null) insertData.historyInsert(lat,lnt);%>
	
}
<%-- function executeFunction(event) {
	event.preventDefault();
    <% data.datas(); %>
  } --%>
//window.onload = initializeFields; 


</script>
</html>