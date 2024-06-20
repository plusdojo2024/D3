<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>ルート登録(仮)</title>
   		<link rel="stylesheet" href="./css/style_regist.css">
    	<link rel="stylesheet" href="./css/setting2.css">
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


        </div>
	</div>
	<main>
		<div class="header">
			【マップ入力】 | <a href="/D3/ActiveRegistServlet" class="move">【その他の入力】</a>
		</div>

        String routeNumber = request.getParameter("routeNumber");
        if (routeNumber == null) {
        	routeNumber
        }

        // 地図から取得開始
        String startIdo = request.getParameter("startIdo");
        String startKeido = request.getParameter("startKeido");
        String endIdo = request.getParameter("endIdo");
        String endKeido = request.getParameter("endKeido");
        spotは実装未定、未実装時は消去対応<br>



            <select class="text" name="moveKind">
                <option value="0">---</option>
                <option value="1">---</option>
                <option value="2">---</option>
                <option value="3">---</option>
                <option value="4">---</option>
                <option value="5">---</option>
            </select>
            <input type="text" class="text" name="distance" value=""> km    &nbsp;
            <input type="text" class="text" name="kcal" value=""> kcal
            <br>
	<div class="header">
    	<input type="button" class="button" name="regist" value="登録">
        <input type="button" class="button" name="reset" value="リセット"><br>
    </div>


            <p>履歴</p>
            経路
            方法
            距離 km
            消費カロリー kcal
    </main>


        <script>

        </script>
    </body>
</html>