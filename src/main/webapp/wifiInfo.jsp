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
  out.write("�������� ����");
  %></h1>
  <div id ="nav" style="margin-bottom: 15px;">
  	<%
  		String[] arr = {"Ȩ | "," ��ġ �����丮 ��� | "," Open API �������� ���� �������� | "," �ϸ�ũ ���� |"," �ϸ�ũ �׷� ����"}; 
  		String[] routeArr ={"mainPage.jsp","history.jsp","loadWifi.jsp","bookmarkList.jsp","bookmarkGroup.jsp"};
  		String[] x = {"�Ÿ�(Km)","������ȣ","��ġ��","�������̸�","���θ��ּ�","���ּ�","��ġ��ġ(��)","��ġ����","��ġ���","���񽺱���","������","��ġ�⵵","�ǳ��ܱ���","WIFI����ȯ��","X��ǥ","Y��ǥ","�۾�����"};
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
 	<option value="0" selected>�ϸ�ũ �׷� �̸� ����</option>
  <%for(int i =0; i<bList.size(); i++){ %>
  
  	<option value=<%=String.valueOf(bList.get(i).getId())+"|"+String.valueOf(bList.get(i).getBookmarkName())+"|"+String.valueOf(mgrNo) %> ><%=bList.get(i).getBookmarkName()%></option>
  <%}%>  
  </select>
  
  <button type="submit">�ϸ�ũ �߰��ϱ�</button>
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
      alert("�ϸ�ũ �׷� �̸��� �������ּ���.");
      return false; 
    }

    
    return true; // ���� ����
  }
</script>
</html>