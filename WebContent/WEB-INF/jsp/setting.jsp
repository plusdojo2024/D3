<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>プロフィール設定 | たけのこーちんぐ</title>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/setting.css">



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
    <main>
    <h2>【プロフィール設定】</h2>

        <form name="setting" method="post" id="data_form" action="./SettingServlet">
            名前 &nbsp;
            <input type ="text" class="text" id="name" name="name" value="${name}" size="20" required><br>
            身長 &nbsp;
            <input type ="number" class="text" id="height" name="height" value="${height}" size="10" step="0.1" required>&nbsp; cm
            <br>
            体重 &nbsp;
            <input type ="number" class="text" id="weight" name="weight" value="${weight}" size="10" step="0.1" required>&nbsp; kg
            <br>
            BMI &nbsp;
            <input type="number" class="text" id="bmi" name="bmi" value="${bmi}" size="10" step="0.1" readonly>
        	<p>${result.message}</p><br>
            <div class="newer">
            	<input type="hidden" name="number" value="${number}"><br>
            	<p id="nameErrorObj"></p>
            	<p id="heightErrorObj"></p>
            	<p id="weightErrorObj"></p>
                <input type="submit" class="button" id="updateButton" value="更新" onclick="if(!confirm('上記の内容で更新しますか？'))return false">

            </div>
        </form>

    </main>

        </div>
	</div>

    <script>
        "use strict";

        document.getElementById("weight").addEventListener('change' , function (){
            let height = parseFloat(document.setting.elements[1].value);
            let weight = parseFloat(document.setting.elements[2].value);

            height = height/100;
            let bmi = weight/height/height;

            let BmiObj = document.getElementById("bmi");
            bmi = Math.round(bmi*10)/10;
            BmiObj.value = bmi;
        });

    </script>
</body>
</html>