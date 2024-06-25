<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>運動記録 | たけのこーちんぐ</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/result.css">
	<link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css" />
	<link rel="stylesheet" href="https://unpkg.com/leaflet-routing-machine@3.2.12/dist/leaflet-routing-machine.css" />
	<link rel="stylesheet" href="./style/leaflet.css" />

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
		    <div class="hosu">
			    <p>目標達成まで</p><div id = "steps"></div><p>歩</p><br>
		    </div>
		    <div id="date"></div>
		    <label>消費カロリー</label><progress id="file" max="${ requestScope.goalKcal }" value="${ requestScope.resultKcal }"></progress>
		    <p class="tasseido">${ requestScope.resultKcal }/${ requestScope.goalKcal}kcal</p>

		    <p class="randomcomment">${ requestScope.randomcom }</p>
		    <div class="chara">
		    	<img src="./img/chara1.png" width=120px>
		    </div>
		    <p class="nowlv">level. ${ requestScope.userLevel}</p>
		    <p class="map" id="my_leaflet">map</p>
		    <p class="todayrecord">今日の記録</p>

		    <p class="resultmessage">${ResultMessage.message}</p>

		    <!-- <p class="actrec">ランニング　${ result.value }㎞　${ result.kcal }kcal</p> -->

			<c:forEach var="e" items="${record}">
			    <form action="./ResultServlet" method="post" class="actrec">
					<input type="hidden" name="type" value="1"><!-- textをhiddenにすると画面表示されない -->
			    	<input type="hidden" name="record_number" value="${ e.recordNumber }"><!-- textをhiddenにすると画面表示されない -->
			    	<input type="hidden" name="redist_date" value="${ e.registDate }"><!-- textをhiddenにすると画面表示されない -->
			    	<input type="hidden" name="kind" value="${ e.kind }">
			    	<label>${ e.name }  </label>
			    	<label>${ e.value }</label>
			    	<label>${ e.unit }  </label>
			    	<label>${ e.kcal }kcal</label>
			    	<input type="image" name="submit" src="./img/gomi.png" alt="削除" onclick="deleteMessage()">
			    	
			    </form>
		    </c:forEach>

 			<c:forEach var="r" items="${routerecord}" >
			    <form action="./ResultServlet" method="post" class="routerec">
			    	<input type="hidden" name="type" value="2">
			    	<input type="hidden" name="route_number" value="${ r.routeNumber }">
			    	<input type="hidden" name="redist_date" value="${ r.registDate }">
			    	<input type="hidden" name="move_kind" value="${ r.moveKind }">
			    	<label>${ r.moveKind }  </label>
			    	<label>${ r.distance }m  </label>
			    	<label>${ r.kcal }kcal</label>
			    	<input type="image" name="submit" src="./img/gomi.png" alt="削除" onclick="deleteMessage()">
			    	
			    </form>
		    </c:forEach>

    	</div>
    </div>

	<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>
	<script src="https://unpkg.com/leaflet-routing-machine@3.2.12/dist/leaflet-routing-machine.js"></script>
	<script src="./script/leaflet.js"></script>

    <script type="text/javascript" src="./js/result.js"></script>
	<script>
		<c:forEach var="item" items="${routerecord}">
			var st = [${item.startIdo}, ${item.startKeido}];
			var ed = [${item.endIdo}, ${item.endKeido}];
			var sp = "${item.spot}".split(" - ");
			var route = [];
			for(let idokeido of sp){
				route.push(idokeido.split(","));
			}
		        L.marker(st).addTo(leafletMap);//スタート地点
		        L.marker(ed).addTo(leafletMap);//ゴール地点
		        //すでに登録されている2つのマーカーで経路を表示（緯度経度はDBから読み込まれる？？）
		        L.polyline(
		        	route
		        	,{ color: "blue", weight: 8, opacity: 0.5 }).addTo(leafletMap);
		</c:forEach>
	</script>

    <script>
    //日付表示
    makeDay(${requestScope.y}, ${requestScope.m}, ${requestScope.d});


	//歩数計算
	let gapKcal = ${requestScope.goalKcal} - ${requestScope.resultKcal};
	gapKcal= Math.round(gapKcal * 100) / 100;

	let height = ${loginUser.height};
	let weight = ${loginUser.weight};

	let time = gapKcal / (1.05 * 3.3 * weight);
	let distance = 4.9 * time;
	distance = distance * 1000 * 100;
	let stepLength = height * 0.45;
	let steps = distance / stepLength;
	steps = Math.round(steps);
    if(steps <= 0){
    	steps = 0;
    }
    document.getElementById("steps").textContent = steps;
    
    
  //運動種類(0～2)に応じて運動名を表示
    let kind = document.getElementById("move_kind").value ;
    let name = document.getElementById("name");
    if(kind === "0"){
    	name.value = "ウォーキング";
    }else if(kind === "1"){
    	name.value = "ランニング";
    }else{
    	name.value = "自転車";
    }
    </script>
</body>
</html>