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
    <img src="./img/calendar.png">
    <p>目標達成まで 歩 </p><br>
    <div id="date"></div>
    <label>消費カロリー</label><progress id="file" max="${ result.goalKcal }" value="${ result.resultKcal }"></progress>
    <p>${ result.resultKcal }/${ result.goalKcal}</p>
    
    <p>comment</p>
    <img src="./img/chara1.png" width="100px">
    <p>level</p>
    <p>map</p>
    <p>今日の記録</p>
    <p> ランニング　${ result.value }㎞　${ result.kcal }kcal</p>
    <img src="./img/gomi.png" >
    
    <script type="text/javascript" src="./js/result.js"></script>
</body>
</html>