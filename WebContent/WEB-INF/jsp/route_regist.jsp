<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ルート登録|たけのこーちんぐ</title>
   		<link rel="stylesheet" href="./css/style_regist.css">
    	<link rel="stylesheet" href="./css/setting2.css">
		<link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css" />
		<link rel="stylesheet" href="https://unpkg.com/leaflet-routing-machine@3.2.12/dist/leaflet-routing-machine.css" />
		<link rel="stylesheet" href="./style/leaflet.css" />
    </head>
    <style>
        button {
            text-align: center;
        }
    </style>
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
			<div class="header">
				【マップ入力】 | <a href="/D3/ActiveRegistServlet" class="move">【その他の入力】</a>
			</div>
			<main>
				<!--確認メッセージ-->
				<p class ="errorMessage">${result.message}</p>
				<!--確認メッセージ-->
				<div id="my_leaflet">ここに地図が表示される</div>
				<form id="my_form" action="/D3/RouteRegistServlet" method="post">
						<!--（見えない）身長体重フォーム-->
					<input type="hidden" id ="weight" name="weight" placeholder="体重" value="${weight}">
		            <select class="text" id="moveKind" name="moveKind" onchange="kcalCalc()">

		                <option value="0">---</option>
		                <option value="1">ウォーキング</option>
		                <option value="2">ランニング</option>
		                <option value="3">自転車</option>

		            </select>
		            <input type="number" class="text" name="my_distance" id="my_distance" value="" onchange="kcalCalc()"> m    &nbsp;
		            <input type="text" class="text" name="kcal" id="kcalOutput" value=""> kcal<br>
					<input type="hidden" name="my_lat1" id="my_lat1">
					<input type="hidden" name="my_lng1" id="my_lng1">
					<input type="hidden" name="my_lat2" id="my_lat2">
					<input type="hidden" name="my_lng2" id="my_lng2">
					<input type="hidden" name="my_route" id="my_route">
		    		<input type="submit" class="button" name="regist" value="登録"><br>
		        	<input type="reset" class="button" name="reset" value="リセット"><br>

		            直近の記録<br>
		            <c:if test="${history.moveKind == 1}">
				    	<label>ウォーキング</label>
			    	</c:if>
			    	<c:if test="${history.moveKind == 2}">
				    	<label>ランニング</label>
			    	</c:if>
			    	<c:if test="${history.moveKind == 3}">
				    	<label>自転車</label>
			    	</c:if>
		            <label>${history.distance}m</label>
		            <label>${history.kcal}kcal</label>
		    		<input type="button" class="button" name="regist" value="インポート">
		        </form>
		    </main>
    	</div>
    </div>

<script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>
<script src="https://unpkg.com/leaflet-routing-machine@3.2.12/dist/leaflet-routing-machine.js"></script>
<script src="./script/leaflet.js"></script>
        <script>
        const layers = [];
        leafletMap.on('click', function(e) {
        	if (layers.length === 0) {
                // クリック位置にピンを立てる
                const mark = L.marker(e.latlng).addTo(leafletMap);
        		//レイヤー情報に始点を追加
                layers.push(mark);
        	} else if (layers.length === 1) {
                // クリック位置にピンを立てる
                const mark = L.marker(e.latlng).addTo(leafletMap);
        		//レイヤー情報に終点を追加
                layers.push(mark);
                // ピンとピンのルートを表示する
                const startLatLng = layers[0].getLatLng();
                const goalLatLng = layers[1].getLatLng();
                const line = leafletLine(startLatLng, goalLatLng, function(e) {
        			//ここで経路情報をHTML上のフォームに書き込む

        			//始点のマーカー位置（緯度経度）
        			const myLat1 = document.getElementById("my_lat1");
        			myLat1.value = startLatLng.lat;
        			const myLng1 = document.getElementById("my_lng1");
        			myLng1.value = startLatLng.lng;

        			//終点のマーカー位置（緯度経度）
        			const myLat2 = document.getElementById("my_lat2");
        			myLat2.value = goalLatLng.lat;
        			const myLng2 = document.getElementById("my_lng2");
        			myLng2.value = goalLatLng.lng;

        			//始点～終点の経路（緯度経度の配列）
        			const routeLatLng = e.routes[0].coordinates;
        			const myRoute = document.getElementById("my_route");
        			//データベースに格納しやすいように単純な配列に変換してみる
        			const arrayPoint = [];
        			for (let i = 0; i < routeLatLng.length; i++) {
        				const latLng = routeLatLng[i];
        				const point = [latLng.lat, latLng.lng];
        				arrayPoint.push(point);
        			}
        			myRoute.value = arrayPoint.join(" - ");//緯度経度の組み合わせが後でわかるように区切り方を工夫しないといけない

        			//始点～終点の距離（実数）
        			const totalDistance = e.routes[0].summary.totalDistance;
        			const myDistance = document.getElementById("my_distance");
        			myDistance.value = totalDistance;

        			//開発者画面にログ出力
        			console.log("移動距離は " + totalDistance + " mです。");
        			console.log("移動経路は " + routeLatLng + " です。");

        		});
        		//レイヤー情報に経路を追加
                layers.push(line);
        	} else {
        		//マーカー削除
        		leafletMap.removeLayer(layers[0]);
        		leafletMap.removeLayer(layers[1]);
        		//経路削除
        		leafletMap.removeControl(layers[2]);
        		//レイヤー情報をクリア
        		layers.length = 0;
        	}
        });

  		const kcalCalc =() => {
            let weight = document.getElementById	("weight");			// 体重が入力されたフォームから値を取得
            let distance = document.getElementById	("my_distance");	// 距離が入力されたフォームから値を取得
            let moveKind = document.getElementById	("moveKind");		// 移動手段が入力されたフォームから値を取得
            let myWeight = weight.value ||0;
            let myDistance = distance.value ||0;
            myDistance = myDistance / 1000;
			let myMoveKind = moveKind.value ||0;
            let kcal = 0;
            let time = 0;
            // ウォーキング消費カロリー計算
            if((myMoveKind) === "1"){
            	time = myDistance / 4.9;
                kcal = myWeight * time * 3.3 * 1.05;		// 消費カロリー＝体重×時間×メッツ値×1.05
                kcal = Math.round(kcal * 100) / 100;							//小数第２位で切り捨て
            }
            // ランニング消費カロリー計算
            else if((myMoveKind) === "2"){
            	time = myDistance / 8.3;
                kcal = myWeight * time * 9.0 * 1.05;		// 消費カロリー＝体重×時間×メッツ値×1.05
                kcal = Math.round(kcal * 100) / 100;							//小数第２位で切り捨て
            }
            // サイクリング消費カロリー計算
            else if((myMoveKind) === "3"){
            	time = myDistance / 15.0;
                kcal = myWeight * time * 8.0 * 1.05;		// 消費カロリー＝体重×時間×メッツ値×1.05
                kcal = Math.round(kcal * 100) / 100;							//小数第２位で切り捨て
            } else {
            	kcal = 0;
            }

            let kcalOutput = document.getElementById("kcalOutput");			// id="kcalOutput"から値を取得
            kcalOutput.value = (kcal === 0) ? "" : kcal;					// kcalフォームに値を出力
		};
    </script>
    </body>
</html>