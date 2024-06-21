<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>その他の入力|たけのこーちんぐ</title>
 <link rel = "stylesheet" href="/D3/css/style.css">
</head>
<body>
	<div class="wrapper">
 <div class="sidebar">
    <h2>Menu</h2>
    <ul>
      <li><a href="/D3/ResultServlet" class="js-header-nav-link">ホーム<i></i></a></li>
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

       <!-- <li class="category7">グループ 5</li>
        <li class="category8"><a href="#"></a>グループ 6</li>
        <li class="category9">グループ 7</li>
        <li class="category10"><a href="#"></a>グループ 8</li>-->
      </ul>
      <li class="setting"><a href="/D3/SettingServlet">設定</a></li>
      <li><a href="/D3/LogoutServlet" onclick="if(!confirm('本当にログアウトしますか？'))return false">ログアウト</a></li>
    </ul>
  </div>
		<div class="main_content">
			<!--ヘッダー-->
			<div class="header">
				<a href="/D3/RouteRegistServlet" class="move">【マップ入力】</a> | 【その他の入力】
			</div>
			<div class="info"></div>
			<!--確認メッセージ-->
			<p>${result.message}</p>
			<!--確認メッセージ-->

			<!--（見えない）身長フォーム-->

			<input type="hidden" id = "height" name="height" placeholder="身長"  value="${height}" >
			<!--（見えない）体重フォーム-->

			<input type="hidden" id = "weight" name="weight" placeholder="体重"  value="${weight}" >

			<!--（見えない）メッツ値セレクトボックス（active_numberと連動）-->
			<!-- 	<div id= "mets">
					 <select  name="mets"  value="" onchange="" class="metsSelect">
					<option value="0"></option>
					<option value="${a1.metsValue}">${a1.metsValue}</option>
					<option value="${a2.metsValue}">${ a2.metsValue }</option>
					<option value="${a3.metsValue}">${ a3.metsValue }</option>
					<option value="${a4.metsValue}">${ a4.metsValue }</option>
					<option value="${a5.metsValue}">${ a5.metsValue }</option>
					<option value="${a6.metsValue}">${ a6.metsValue }</option>
					<option value="${a7.metsValue}">${ a7.metsValue }</option>
					<option value="${a8.metsValue}">${ a8.metsValue }</option>
					<option value="${a9.metsValue}">${ a9.metsValue }</option>
					<option value="${a10.metsValue}">${ a10.metsValue }</option>
					<option value="${a11.metsValue}">${ a11.metsValue }</option>
					<option value="${a12.metsValue}">${ a12.metsValue }</option>
					<option value="${a13.metsValue}">${ a13.metsValue }</option>
					<option value="${a14.metsValue}">${ a14.metsValue }</option>
					<option value="${a15.metsValue}">${ a15.metsValue }</option>
					</select>
				</div> -->
			<!--（見えない）メッツ値セレクトボックス（active_numberと連動）-->

			<!--運動の種類フォーム-->
			<form action="./ActiveRegistServlet" method="POST" class="active">

				<input type="checkbox" id="check1" value="1" name="check1"
					onchange="func1()" class="scales" />
										 <!-- 運動種類選択1 -->
					<select name="active_number1" id="active_number1"  onchange="myFunc()" class="active_number"><br>
					<option value="0"></option>
					<option value="${a1.kind}&&${a1.metsValue}"> ${ a1.activeName }</option>
					<option value="${a2.kind}&&${a2.metsValue}"> ${ a2.activeName }</option>
					<option value="${a3.kind}&&${a3.metsValue}"> ${ a3.activeName }</option>
					<option value="${a4.kind}&&${a4.metsValue}"> ${ a4.activeName }</option>
					<option value="${a5.kind}&&${a5.metsValue}"> ${ a5.activeName }</option>
					<option value="${a6.kind}&&${a6.metsValue}"> ${ a6.activeName }</option>
					<option value="${a7.kind}&&${a7.metsValue}"> ${ a7.activeName }</option>
					<option value="${a8.kind}&&${a8.metsValue}"> ${ a8.activeName }</option>
					<option value="${a9.kind}&&${a9.metsValue}"> ${ a9.activeName }</option>
					<option value="${a10.kind}&&${a10.metsValue}"> ${ a10.activeName }</option>
					<option value="${a11.kind}&&${a11.metsValue}"> ${ a11.activeName }</option>
					<option value="${a12.kind}&&${a12.metsValue}"> ${ a12.activeName }</option>
					<option value="${a13.kind}&&${a13.metsValue}"> ${ a13.activeName }</option>
					<option value="${a14.kind}&&${a14.metsValue}"> ${ a14.activeName }</option>
					<option value="${a15.kind}&&${a15.metsValue}"> ${ a15.activeName }</option>

					</select>
										<!-- 運動時間選択1 -->

					 <select name="time1" id="time1"  onchange="kcalCalc()" class="time"> <!-- 時間を選んだら処理 -->

					<option value=""></option>
					<option value="10">10分</option>
					<option value="20">20分</option>
					<option value="30">30分</option>
					<option value="40">40分</option>
					<option value="50">50分</option>
					<option value="60">60分</option>
					<option value="70">70分</option>
					<option value="80">80分</option>
					<option value="90">90分</option>
					<option value="100">100分</option>
					<option value="110">110分</option>
					<option value="120">120分</option>
				</select>
					<!-- 歩数入力フォーム1 -->
					<input type="text" id = "step1" name="step1" placeholder="歩数"  onKeyup="kcalCalc()">
					<!-- 消費カロリー表示フォーム1 -->
					<input type="text" id = "kcalOutput" name="kcal1" placeholder="消費カロリー"><br>

					<input type="checkbox" id="check2" value="2" name="check2"
					onchange="func1()" class="scales" />
										 <!-- 運動種類選択2 -->
					 <select name="active_number2" id="active_number2"  onchange="myfunc2()" class="active_number">
					<option value="0"></option>
					<option value="${a1.kind}&&${a1.metsValue}"> ${ a1.activeName }</option>
					<option value="${a2.kind}&&${a2.metsValue}"> ${ a2.activeName }</option>
					<option value="${a3.kind}&&${a3.metsValue}"> ${ a3.activeName }</option>
					<option value="${a4.kind}&&${a4.metsValue}"> ${ a4.activeName }</option>
					<option value="${a5.kind}&&${a5.metsValue}"> ${ a5.activeName }</option>
					<option value="${a6.kind}&&${a6.metsValue}"> ${ a6.activeName }</option>
					<option value="${a7.kind}&&${a7.metsValue}"> ${ a7.activeName }</option>
					<option value="${a8.kind}&&${a8.metsValue}"> ${ a8.activeName }</option>
					<option value="${a9.kind}&&${a9.metsValue}"> ${ a9.activeName }</option>
					<option value="${a10.kind}&&${a10.metsValue}"> ${ a10.activeName }</option>
					<option value="${a11.kind}&&${a11.metsValue}"> ${ a11.activeName }</option>
					<option value="${a12.kind}&&${a12.metsValue}"> ${ a12.activeName }</option>
					<option value="${a13.kind}&&${a13.metsValue}"> ${ a13.activeName }</option>
					<option value="${a14.kind}&&${a14.metsValue}"> ${ a14.activeName }</option>
					<option value="${a15.kind}&&${a15.metsValue}"> ${ a15.activeName }</option>
										 <!-- 運動時間選択2 -->
				</select>
				 <select name="time2" id="time2"  onchange="kcalCalc2()" class="time"><!-- 時間を選んだら処理2 -->
					<option value=""></option>
					<option value="10">10分</option>
					<option value="20">20分</option>
					<option value="30">30分</option>
					<option value="40">40分</option>
					<option value="50">50分</option>
					<option value="60">60分</option>
					<option value="70">70分</option>
					<option value="80">80分</option>
					<option value="90">90分</option>
					<option value="100">100分</option>
					<option value="110">110分</option>
					<option value="120">120分</option>
					 					<!-- 歩数入力2 -->
				</select>
				<input type="text" id ="step2" name="step2" placeholder="歩数"  onKeyup="kcalCalc2()">
				<input type="text" name="kcal2" id="kcalOutput2" placeholder="消費カロリー"> <br>

        		<input type="checkbox" id="check3" value="3" name="check3"  class="scales" />
        	 							<!-- 運動種類選択3 -->
         		<select name="active_number3" id="active_number3" onchange="myfunc3()" class="active_number">
					<option value="0"></option>
					<option value="${a1.kind}&&${a1.metsValue}"> ${ a1.activeName }</option>
					<option value="${a2.kind}&&${a2.metsValue}"> ${ a2.activeName }</option>
					<option value="${a3.kind}&&${a3.metsValue}"> ${ a3.activeName }</option>
					<option value="${a4.kind}&&${a4.metsValue}"> ${ a4.activeName }</option>
					<option value="${a5.kind}&&${a5.metsValue}"> ${ a5.activeName }</option>
					<option value="${a6.kind}&&${a6.metsValue}"> ${ a6.activeName }</option>
					<option value="${a7.kind}&&${a7.metsValue}"> ${ a7.activeName }</option>
					<option value="${a8.kind}&&${a8.metsValue}"> ${ a8.activeName }</option>
					<option value="${a9.kind}&&${a9.metsValue}"> ${ a9.activeName }</option>
					<option value="${a10.kind}&&${a10.metsValue}"> ${ a10.activeName }</option>
					<option value="${a11.kind}&&${a11.metsValue}"> ${ a11.activeName }</option>
					<option value="${a12.kind}&&${a12.metsValue}"> ${ a12.activeName }</option>
					<option value="${a13.kind}&&${a13.metsValue}"> ${ a13.activeName }</option>
					<option value="${a14.kind}&&${a14.metsValue}"> ${ a14.activeName }</option>
					<option value="${a15.kind}&&${a15.metsValue}"> ${ a15.activeName }</option>
										 <!-- 時間3 -->
         		</select>
         		<select name="time3" id="time3"  onchange="kcalCalc3()" class="time">
         		<option value=""></option>
					<option value="10">10分</option>
					<option value="20">20分</option>
					<option value="30">30分</option>
					<option value="40">40分</option>
					<option value="50">50分</option>
					<option value="60">60分</option>
					<option value="70">70分</option>
					<option value="80">80分</option>
					<option value="90">90分</option>
					<option value="100">100分</option>
					<option value="110">110分</option>
					<option value="120">120分</option>
        								 <!-- 歩数3 -->
        		   </select>
        		    <input type="text" id ="step3" name="step3" placeholder="歩数" onKeyup="kcalCalc3()">

       				<input type="text" id ="kcalOutput3" name="kcal3" placeholder="消費カロリー"> <br>

					<input type="submit" name="submit" value="登録" class="button">



			</form>
		</div>
		</div>

		<script type="text/javascript" src="D3/active_regist.js"></script>
		<script>

		let time1  =   document.getElementById("time1");
		let step1  =   document.getElementById("step1");
		step1.disabled = true;
		time1.disabled = true;

		//一列目ウォーキング・ランニングを選択すると歩数フォームが活性になる
		function myFunc() {
			 let select1 =  document.getElementById("active_number1");
			 let step1  =   document.getElementById("step1");
			 let str = active.value.split("&&");
	         let kind = str[0];

			 if(NUmber(kind) === 0){
			  step1.disabled = false;
				//一列目ウォーキング・ランニング以外を選択すると歩数フォームが非活性になる
			}else{
			  time1.disabled = false;
			}

	}


		//二列目ウォーキング・ランニングを選択すると歩数フォームが活性になる。

	function myfunc2(value) {
	let select2 = document.querySelector('select[name="active_number2"]').value;
	let step2  = document.getElementById("step2");
	if(value===0){
	  step2.disabled = false;
		//ウォーキング・ランニングを選択すると歩数フォームが非活性になる。
	}else{
	  step2.disabled = true;
	}
	}
			//三列目ウォーキング・ランニング以外を選択すると歩数フォームが活性になる。
	function myfunc3(value) {
	let select3 = document.querySelector('select[name="active_number3"]').value;
	let step3  = document.getElementById("step3");
	if(value===2){
	  step3.disabled = false;
		//ウォーキング・ランニングを選択すると歩数フォームが非活性になる。
	}else{
	  step3.disabled = true;
	}
	}




	//メッツ値を持ってくるのは、parseInt(${a1.metsValue});
	//一列目の運動計算

	  const kcalCalc =() => {
            let height = document.getElementById	("height");
            let weight = document.getElementById	("weight");
            let steps =  document.getElementById	("step1");
            let timeInput = document.getElementById ("time1");
            let active = document.getElementById	("active_number1");
            let str = active.value.split			("&&");

            let kind = str[0];
            let mets = str[1];


            let time = Number(timeInput.value) / 60;

            if(Number(kind) === 0){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance = stepLength * Number(steps.value);
                time = distance / 4.9;
            }
            /*else if(Number(kind) === 1){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance   = stepLength * Number(steps.value);
                time = distance / 8.3;
            }*/else{
                time = Number(timeInput.value) / 60;
            }

            let kcal = 1.05 * (Number(mets) * time) * Number(weight.value);
            kcal = Math.round(kcal * 100) / 100;


            let kcalOutput = document.getElementById("kcalOutput");


            kcalOutput.value = kcal;
            metsOutput.value = mets;

	}

		//二列目の運動計算
		  const kcalCalc2 =() => {
            let height = document.getElementById	("height");
            let weight = document.getElementById	("weight");
            let steps =  document.getElementById	("step2");
            let timeInput = document.getElementById ("time2");
            let active = document.getElementById	("active_number2");
            let str = active.value.split			("&&");

            let kind = str[0];
            let mets = str[1];


            let time = Number(timeInput.value) / 60;

            if(Number(kind) === 0){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance = stepLength * Number(steps.value);
                time = distance / 4.9;
            }
            /*else if(Number(kind) === 1){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance   = stepLength * Number(steps.value);
                time = distance / 8.3;
            }*/else{
                time = Number(timeInput.value) / 60;
            }

            let kcal = 1.05 * (Number(mets) * time) * Number(weight.value);
            kcal = Math.round(kcal * 100) / 100;


            let kcalOutput = document.getElementById("kcalOutput2");


            kcalOutput.value = kcal;
            metsOutput.value = mets;

	}

		//三列目の運動計算
	 const kcalCalc3 =() => {
            let height = document.getElementById	("height");
            let weight = document.getElementById	("weight");
            let steps =  document.getElementById	("step3");
            let timeInput = document.getElementById ("time3");
            let active = document.getElementById	("active_number3");
            let str = active.value.split			("&&");

            let kind = str[0];
            let mets = str[1];


            let time = Number(timeInput.value) / 60;

            if(Number(kind) === 0){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance = stepLength * Number(steps.value);
                time = distance / 4.9;
            }
            /*else if(Number(kind) === 1){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance   = stepLength * Number(steps.value);
                time = distance / 8.3;
            }*/else{
                time = Number(timeInput.value) / 60;
            }

            let kcal = 1.05 * (Number(mets) * time) * Number(weight.value);
            kcal = Math.round(kcal * 100) / 100;


            let kcalOutput = document.getElementById("kcalOutput3");


            kcalOutput.value = kcal;
            metsOutput.value = mets;

	}

    </script>
</body>
</html>