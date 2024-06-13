<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/calendar.css">
<title>Insert title here</title>
</head>
<body>
	<h1 id="record">記録カレンダー</h1>
	<div class="yearmonth">

		<!--xx月を表示 -->
		<div id="next-prev-button">
			<button id="prev" onclick="prev()"></button>
			<h2 id="cal">6月</h2>
			<button id="next" onclick="next()"></button>
		</div>
		<div id="calendar">
		</div>
	</div>
	<script type="text/javascript" src="./js/calendar.js"></script>
</body>
</html>