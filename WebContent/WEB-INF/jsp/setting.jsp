<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SettingTest</title>
    <link rel="stylesheet" href="/Users/User/Downloads/setting.css">
</head>
<body>
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
                <input type="button" value="更新" onclick="calc()">
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