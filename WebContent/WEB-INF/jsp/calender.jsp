<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.MyCalendar"%>
<%
	MyCalendar mc=(MyCalendar)request.getAttribute("mc");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title><%=mc.getMonth() %>月カレンダー</title>
  <link rel="stylesheet"  href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
  <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
  <link rel="stylesheet"  href="css/calendar.css">
</head>
<body>
  <div id="container">
	<div id="move-button">
		<a href="?year=<%=mc.getYear()%>&month=<%=mc.getMonth()-1%>"><img src="img/hidari.png" class="migi-hidari" width= 30 height= 20></a>
    	<h1 id="month"><%=mc.getYear() %>年<%=mc.getMonth() %>月</h1>
    	<a href="?year=<%=mc.getYear()%>&month=<%=mc.getMonth()+1%>"><img src="img/migi.png"  class="migi-hidari" width= 30 height= 20></a>
   	</div>
    <table class="caltable">
      <tr>
        <th>日</th>
        <th>月</th>
        <th>火</th>
        <th>水</th>
        <th>木</th>
        <th>金</th>
        <th>土</th>
      </tr>
      <!-- マイカレンダーの日付をrow配列に格納 -->
      <%for(String[] row: mc.getData()){ %>
      <tr>
      	<%for(String col:row) {%>
      		<%if (col.startsWith("*")){ %>
      			<td class="today"><a href = "./ResultServlet?y=${mc.getYear}&m=${mc.getMonth}&d=${date}"><%=col.substring(1)%></a></td>
      		<%}else if (col.startsWith("#")){ %>
      			<td class="dayafter"><%=col.substring(1)%></td>
      		<%}else if (col.startsWith("$")){ %>
      			<td class="after"><%=col.substring(1)%></td>
      		<%}else { %>
      			<td class="before"><a href = "./ResultServlet?y=${mc.getYear}&m=${mc.getMonth}&d=${date}"><%=col %></a></td>
      		<%} %>

			<%if(col.endswith("@")){%>

      		<%} %>
      	<%} %>
     	 </tr>
       <%} %>
    </table>
  </div><!-- end container-->
</body>
</html>