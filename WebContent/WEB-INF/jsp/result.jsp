<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
    <a href="/D3/CalendarServlet.java"><img src="./img/calendar.png"></a>
    <p>目標達成まで ${requestScope.targetHosu} 歩 </p><br>
    <div id="date"></div>
    <label>消費カロリー</label><progress id="file" max="${ result.goalKcal }" value="${ result.resultKcal }"></progress>
    <p>${ result.resultKcal }/${ result.goalKcal}kcal</p>

    <p>comment</p>
    <img src="./img/chara1.png" width="100px">
    <p>level${sessionScope.level}</p>
    <p>map</p>
    <p>今日の記録</p>
    <p>ランニング　${ result.value }㎞　${ result.kcal }kcal</p>

    <form action="./ResultServlet" method="post">
    	<input type="text" name="record_number" value="${ record.recordNumber }"><!-- textをhiddenにすると画面表示されない -->
    	<input type="text" name="redist_date" value="${ record.registDate }"><!-- textをhiddenにすると画面表示されない -->
    	<input type="text" name="kind" value="${ record.kcal }">
    	<input type="text" name="value" value="${ record.value }">
    	<input type="text" name="unit" value="${ record.unit }">
    	<input type="text" name="kcal" value="${ record.kcal }">
    	<label>label</label>
    	<input type="image" name="submit" src="./img/gomi.png" value="削除" onclick="deleteMessage()">
    </form>

    <script type="text/javascript" src="./js/result.js"></script>
</body>
</html>