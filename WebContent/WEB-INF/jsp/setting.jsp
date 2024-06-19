<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SettingTest</title>
    <link rel="stylesheet" href="/Users/User/Downloads/setting.css">
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


        </div>
	</div>

    <h2>【プロフィール設定】</h2>

    <main>
        <p>${ActionResult.message}</p>
        <form name="setting">
            名前 &nbsp;
            <input type ="text" id="name" name="name" value="佐藤太郎" size="20"><br>
            身長 &nbsp;
            <input type ="text" id="height" name="height" value="170" size="10">&nbsp; cm
            <br>
            体重 &nbsp;
            <input type ="text" id="weight" name="weight" value="63" size="10">&nbsp; kg
            <br>
            BMI &nbsp;
            <input type="text" id="bmi" name="bmi" size="10">
            <br>
            <div class="newer">
                <input type="button" id="updateButton" value="更新" onclick="calc()">
            </div>
            <style>
                .newer {
                    text-align: right;
                    width: 25em;
                    padding: 10px;
                }
            </style>
        </form>

    </main>

    <script>
        "use strict";

        function calc(){

            let height = parseFloat(document.setting.elements[1].value);
            let weight = parseFloat(document.setting.elements[2].value);

            height = height/100;
            let bmi = weight/height/height;

            alert(toPrecision());
        }

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