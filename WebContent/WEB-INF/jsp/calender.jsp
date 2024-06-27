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
  <title><%=mc.getMonth() %>月カレンダー | たけのこーちんぐ</title>
  <link rel="stylesheet"  href="css/calendar.css">
  <link rel="stylesheet"  href="css/style.css">
</head>
<body>
	<div class="wrapper">
        <div class="sidebar">
            <h2>Menu</h2>
        	<ul>
           	 	<li><a href="/D3/ResultServlet?y=${year}&m=${month}&d=${day}" class="js-header-nav-link">ホーム<i></i></a></li>
            	<li><a href="/D3/RouteRegistServlet"class="js-header-nav-link">入力<i></i></a></li>
       			<ul class="drop1" ontouchstart="1">
	                <li class="category" >グループ</li>
	                <li class="category1"><a href="/D3/MyScheduleServlet">個人</a></li>
	                <li class="category2"><a href="/D3/GroupManagerServlet">グループ管理</a></li>


	                <li class="category3">
	                <div><a href="/D3/GroupScheduleServlet">グループ1</a></div>
	                <div><a href="/D3/GroupScheduleServlet">グループ2</a></div>
	                <div><a href="/D3/GroupScheduleServlet">グループ3</a></div>
	                <div><a href="/D3/GroupScheduleServlet">グループ4</a></div>
	                <div><a href="/D3/GroupScheduleServlet">グループ5</a></div>
	                <div><a href="#">グループ6</a></div>
	                <div><a href="#">グループ7</a></div>
	                <div><a href="#">グループ8</a></div>
	                <div><a href="#">グループ9</a></div>
	                <div><a href="#">グループ10</a></div>
	                <div><a href="#">グループ11</a></div>
	                <div><a href="#">グループ12</a></div>
	                </li>

            	</ul>

                <li class="setting"><a href="/D3/SettingServlet">設定</a></li>
                <li><a href="/D3/LogoutServlet" onclick="if(!confirm('本当にログアウトしますか？'))return false">ログアウト</a></li>
       		</ul>
		</div>
	<div class="main_content">
	<!--ヘッダー-->
		<div id="container">
			<div id="move-button">
				<a href="?year=<%=mc.getYear()%>&month=<%=mc.getMonth()-1%>"><img src="img/hidari.png" class="migi-hidari" width= 50 height= 40></a>
				<h1 id="month"><%=mc.getYear() %>年<%=mc.getMonth() %>月</h1>
				<a href="?year=<%=mc.getYear()%>&month=<%=mc.getMonth()+1%>"><img src="img/migi.png"  class="migi-hidari" width= 50 height= 40></a>
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
						<%if(col.endsWith("@")){ %>
							<td class="today hanamaru"><a href = "./ResultServlet?y=${mc.getYear()}&m=${mc.getMonth()}&d=<%=col.substring(1,col.length()-1)%>"><%=col.substring(1,col.length()-1)%></a></td>
						<%}else{ %>
							<td class="today"><a href = "./ResultServlet?y=${mc.getYear()}&m=${mc.getMonth()}&d=<%=col.substring(1)%>"><%=col.substring(1)%></a></td>
						<%} %>
					<%}else if (col.startsWith("#")){ %>
						<td class="dayafter"><%=col.substring(1)%></td>
					<%}else if (col.startsWith("$")){ %>
						<td class="after"><%=col.substring(1)%></td>
					<%}else { %>
						<%if(col.endsWith("@")){ %>
							<td class="before hanamaru"><a href = "./ResultServlet?y=${mc.getYear()}&m=${mc.getMonth()}&d=<%=col.substring(0,col.length()-1)%>"><%=col.substring(0,col.length()-1)%></a></td>
					<%}else{ %>
							<td class="before"><a href = "./ResultServlet?y=${mc.getYear()}&m=${mc.getMonth()}&d=<%=col %>"><%=col %></a></td>
					<%} %>
					<%} %>
				<%} %>
			</tr>
		<%} %>
		</table>
			</div>
		</div>
	</div>
</body>
</html>