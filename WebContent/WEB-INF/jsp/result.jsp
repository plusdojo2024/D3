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

			<div class="calendar">
		    	<a href="/D3/CalendarServlet"><img src="./img/calendar.png" id="calendar"></a>
		    </div>
		    <p>目標達成まで</p><div id = "steps"></div><p>歩</p><br>
		    <div id="date"></div>
		    <label>消費カロリー</label><progress id="file" max="${ result.goalKcal }" value="${ result.resultKcal }"></progress>
		    <p>${ result.resultKcal }/${ result.goalKcal}kcal</p>
		    
		    <p>comment${ requestScope.random }</p>
		    <img src="./img/chara1.png" width="100px">
		    <p>level.${loginUser.userLevel}</p>
		    <p>map</p>
		    <p>今日の記録</p>
		    <p>ランニング　${ result.value }㎞　${ result.kcal }kcal</p>
		    
		    
			<c:forEach var="e" items="${recordList}" >
			    <form action="./ResultServlet" method="post">
			    	<input type="hidden" name="y" value="${ e.y }">
			    	<input type="hidden" name="m" value="${ e.m }">
			    	<input type="hidden" name="d" value="${ e.d }">
			    	<input type="text" name="record_number" value="${ e.recordNumber }"><!-- textをhiddenにすると画面表示されない -->
			    	<input type="text" name="redist_date" value="${ e.registDate }"><!-- textをhiddenにすると画面表示されない -->
			    	<input type="text" name="kind" value="${ e.kind }">
			    	<input type="text" name="value" value="${ e.value }">
			    	<input type="text" name="unit" value="${ e.unit }">
			    	<input type="text" name="kcal" value="${ e.kcal }">
			    	<label>label</label>
			    	<input type="image" name="submit" src="./img/gomi.png" value="削除1" onclick="deleteMessage()">
			    </form>
		    </c:forEach>
		    
 			<c:forEach var="r" items="${routeRecordList}" >
			    <form action="./ResultServlet" method="post">
			    	<input type="hidden" name="y" value="${ r.y }">
			    	<input type="hidden" name="m" value="${ r.m }">
			    	<input type="hidden" name="d" value="${ r.d }">
			    	<input type="text" name="route_number" value="${ r.routeNumber }">
			    	<input type="text" name="redist_date" value="${ r.registDate }">
			    	<input type="text" name="move_kind" value="${ r.moveKind }">
			    	<input type="text" name="distance" value="${ r.distance }">
			    	<input type="text" name="kcal" value="${ r.kcal }">
			    	<label>label</label>
			    	<input type="image" name="submit" src="./img/gomi.png" value="削除2" onclick="deleteMessage()">
			    </form>
		    </c:forEach>  
    
    	</div>
    </div>
    
    
    <script type="text/javascript" src="./js/result.js"></script>
    <script>
    makeDay(${requestScope.y}, ${requestScope.m}, ${requestScope.d});
    
    let gapkcal = ${dayResult.goalKcal} - ${dayResult.resultKcal};
    let steps = gapkcal * 1000000 / (${loginUser.height}* ${loginUser.weight} * 0.45 * 1.05);
    
    document.getElementById("steps").textContent = steps;
    </script>
</body>
</html>