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
	<div class="wrapper">	<!-- 全体 -->
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
			<p class ="errorMessage">${result.message}</p>
			<!--確認メッセージ-->

			<!--（見えない）身長フォーム-->

			<input type="hidden" id = "height" name="height" placeholder="身長"  value="${height}" >
			<!--（見えない）体重フォーム-->

			<input type="hidden" id = "weight" name="weight" placeholder="体重"  value="${weight}" >
			<input type="hidden" id = "kind1">
			<input type="hidden" id = "kind2">
			<input type="hidden" id = "kind3">
			<!--運動の種類フォーム-->
	<!-- 1行目 -->
			<form action="./ActiveRegistServlet" method="POST" class="active">
					<!-- チェックボックス(1行目) -->
					<input type="checkbox" id="check1" value="1" name="check1" onchange="func1()" class="scales" />
					<!-- 運動種類選択(1行目)-->
					<select name="active_number1" id="active_number1"  onchange="myFunc()" class="active_number"><br>
					<option value=""></option>
					<option value="${a1.kind}&&${a1.metsValue}"> ${ a1.activeName }</option> <!--valueの中に運動種類とメッツ値が&&で区切られて入っている。-->
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
					<!-- 運動時間選択(1行目） -->
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
					<!-- 歩数入力(1行目) -->
					<input type="text" id = "step1" name="step1" placeholder="歩数"  value="" onKeyup="kcalCalc()">
					<!-- 消費カロリー表示(2行目) -->
					<input type="text" id = "kcalOutput" name="kcal1" placeholder="消費カロリー"><br>
	<!-- 2行目 -->
					<!--チェックボックス(2行目)-->
					<input type="checkbox" id="check2" value="2" name="check2" onchange="func1()" class="scales" />
					<!-- 運動種類選択(2行目) -->
					<select name="active_number2" id="active_number2"  onchange="myFunc2()" class="active_number">
					<option value=""></option>
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
					<!-- 運動時間選択(2行目) -->
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
				</select>
				<!-- 歩数入力(2行目) -->
				<input type="text" id ="step2" name="step2" placeholder="歩数"  onKeyup="kcalCalc2()">
				<!-- 消費カロリー表示(2行目) -->
				<input type="text" name="kcal2" id="kcalOutput2" placeholder="消費カロリー"> <br>
	<!-- 3行目 -->
				<!--チェックボックス(3行目)-->
        		<input type="checkbox" id="check3" value="3" name="check3"  class="scales" />
        	 							<!-- 運動種類選択3 -->
        	 	<!-- 運動種類選択(3行目)-->
         		<select name="active_number3" id="active_number3" onchange="myFunc3()" class="active_number">
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
         		<!--運動時間選択(3行目)-->
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
        		    <!--歩数入力(3行目)-->
        		    <input type="text" id ="step3" name="step3" placeholder="歩数" onKeyup="kcalCalc3()">
					<!--消費カロリー表示(3行目)-->
       				<input type="text" id ="kcalOutput3" name="kcal3" placeholder="消費カロリー"> <br>
					<!--登録ボタン-->
					<input type="submit" name="submit" value="登録" class="button">

			</form>
		</div>
		</div>

		<script type="text/javascript" src="D3/active_regist.js"></script>
		<script>
		//ページを開くと時間・歩数フォーㇺを非活性にする。(1列目)
 			let time1  =   document.getElementById("time1");			//時間選択ボックスから要素を取得
			let step1  =   document.getElementById("step1");			//歩数入力フォームから要素を取得
			step1.disabled = true;										//歩数入力フォームに非活性(disabled)を付与
			time1.disabled = true;										//時間選択ボックスに非活性(disabled)を付与

		//ウォーキング・ランニングを選択すると歩数フォームが活性になる(1列目)
			const myFunc =() => {										//運動種類が選択された瞬間に起動するメソッド
            let active = document.getElementById("active_number1");		//運動種類選択ボックスから要素を取得
            let str = active.value.split("&&");							//valueのkindとactive_numberを&&で分割し、それぞれ個別の値として取得できるようにする。

            let kind = str[0];											//kindのみ取得
			let kindOutput = document.getElementById("kind1");
            kindOutput.value = kind;
            let steps = document.getElementById("step1");				//歩数入力フォームから要素を取得
            let timeInput = document.getElementById("time1");			//時間選択ボックスから要素を取得

            if(kind !== "2"){											//kindの値が2(歩行しない運動)の場合
                steps.disabled = false;									//歩数入力フォームの非活性(disabled)をオフにする
                timeInput.disabled = true;								//時間選択ボックスの非活性(disabled)をオフにする
         //上記以外をを選択すると歩数フォームが非活性になり、時間選択フォームが活性になる(1列目)
            }else{
                steps.disabled = true;									//歩数入力フォームに非活性(disabled)を付与
                timeInput.disabled = false;								//時間選択ボックスに非活性(disabled)を付与
            }
        }

			//ページを開くと時間・歩数フォーㇺを非活性にする。(2列目)
 			let time2  =   document.getElementById("time2");			//時間選択ボックスから要素を取得
			let step2  =   document.getElementById("step2");			//歩数入力フォームから要素を取得
			step2.disabled = true;										//歩数入力フォームに非活性(disabled)を付与
			time2.disabled = true;										//時間選択ボックスに非活性(disabled)を付与

		//ウォーキング・ランニングを選択すると歩数フォームが活性になる(2列目)
			const myFunc2 =() => {										//運動種類が選択された瞬間に起動するメソッド
            let active = document.getElementById("active_number2");		//運動種類選択ボックスから要素を取得
            let str = active.value.split("&&");							//valueのkindとactive_numberを&&で分割し、それぞれ個別の値として取得できるようにする。

            let kind = str[0];											//kindのみ取得

            let steps = document.getElementById("step2");				//歩数入力フォームから要素を取得
            let timeInput = document.getElementById("time2");			//時間選択ボックスから要素を取得

            if(kind !== "2"){											//kindの値が2(歩行しない運動)の場合
                steps.disabled = false;									//歩数入力フォームの非活性(disabled)をオフにする
                timeInput.disabled = true;								//時間選択ボックスの非活性(disabled)をオフにする
         //上記以外をを選択すると歩数フォームが非活性になり、時間選択フォームが活性になる(2列目)
            }else{
                steps.disabled = true;									//歩数入力フォームに非活性(disabled)を付与
                timeInput.disabled = false;								//時間選択ボックスに非活性(disabled)を付与
            }
        }

			//ページを開くと時間・歩数フォーㇺを非活性にする。(3列目)
 			let time3  =   document.getElementById("time3");			//時間選択ボックスから要素を取得
			let step3  =   document.getElementById("step3");			//歩数入力フォームから要素を取得
			step3.disabled = true;										//歩数入力フォームに非活性(disabled)を付与
			time3.disabled = true;										//時間選択ボックスに非活性(disabled)を付与

		//ウォーキング・ランニングを選択すると歩数フォームが活性になる(3列目)
			const myFunc3 =() => {										//運動種類が選択された瞬間に起動するメソッド
            let active = document.getElementById("active_number3");		//運動種類選択ボックスから要素を取得
            let str = active.value.split("&&");							//valueのkindとactive_numberを&&で分割し、それぞれ個別の値として取得できるようにする。

            let kind = str[0];											//kindのみ取得

            let steps = document.getElementById("step3");				//歩数入力フォームから要素を取得
            let timeInput = document.getElementById("time3");			//時間選択ボックスから要素を取得

            if(kind !== "2"){											//kindの値が2(歩行しない運動)の場合
                steps.disabled = false;									//歩数入力フォームの非活性(disabled)をオフにする
                timeInput.disabled = true;								//時間選択ボックスの非活性(disabled)をオフにする
         //上記以外をを選択すると歩数フォームが非活性になり、時間選択フォームが活性になる(3列目)
            }else{
                steps.disabled = true;									//歩数入力フォームに非活性(disabled)を付与
                timeInput.disabled = false;								//時間選択ボックスに非活性(disabled)を付与
            }
        }


			//メッツ値を持ってくるのは、parseInt(${a1.metsValue});
			//一列目の運動計算

	  		const kcalCalc =() => {
            let height = document.getElementById	("height");			//身長が入力されたフォームから値を取得
            let weight = document.getElementById	("weight");			//体重が入力されたフォームから値を取得
            let steps =  document.getElementById	("step1");			//歩数が入力されたフォームから値を取得
            let timeInput = document.getElementById ("time1");			//時間が入力されたフォームから値を取得
            let active = document.getElementById	("active_number1");	//運動種類が入力されたフォームから値を取得
            let str = active.value.split			("&&");				//&&でsplitする

            let kind = str[0];
            let mets = str[1];


            let time = Number(timeInput.value) / 60;						//時間を分単位にする
            //ウォーキング消費カロリー計算
            if(Number(kind) === 0){											//kindが0だった場合
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;	//歩幅＝身長×0.45×100/1000
                let distance = stepLength * Number(steps.value);			//距離＝歩幅×歩数
                time = distance / 4.9;										//時間＝距離×時速
            }
            //ランニング消費カロリー計算
            else if(Number(kind) === 1){									//kindが１だった場合
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;	//歩幅＝身長×0.45×100/1000
                let distance   = stepLength * Number(steps.value);			//距離＝歩幅×歩数
                time = distance / 8.3;										//時間＝距離×時速
            }else{
                time = Number(timeInput.value) / 60;						//時間を分単位にするs
            }

            let kcal = 1.05 * (Number(mets) * time) * Number(weight.value);	//消費カロリー＝1.05×(メッツ値×時間)×体重
            kcal = Math.round(kcal * 100) / 100;							//小数第２位で切り捨て


            let kcalOutput = document.getElementById("kcalOutput");			//id="kcalOutput"から値を取得


            kcalOutput.value = kcal;										//kcalフォームに値を出力
            metsOutput.value = mets;

	}

		    //二列目の運動計算
	  		const kcalCalc2 =() => {
            let height = document.getElementById	("height");			//身長が入力されたフォームから値を取得
            let weight = document.getElementById	("weight");			//体重が入力されたフォームから値を取得
            let steps =  document.getElementById	("step2");			//歩数が入力されたフォームから値を取得
            let timeInput = document.getElementById ("time2");			//時間が入力されたフォームから値を取得
            let active = document.getElementById	("active_number2");	//運動種類が入力されたフォームから値を取得
            let str = active.value.split			("&&");				//&&でsplitする

            let kind = str[0];
            let mets = str[1];


            let time = Number(timeInput.value) / 60;						//時間を分単位にする
            //ウォーキング消費カロリー計算
            if(Number(kind) === 0){											//kindが0だった場合
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;	//歩幅＝身長×0.45×100/1000
                let distance = stepLength * Number(steps.value);			//距離＝歩幅×歩数
                time = distance / 4.9;										//時間＝距離×時速
            }
            //ランニング消費カロリー計算
            else if(Number(kind) === 1){									//kindが１だった場合
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;	//歩幅＝身長×0.45×100/1000
                let distance   = stepLength * Number(steps.value);			//距離＝歩幅×歩数
                time = distance / 8.3;										//時間＝距離×時速
            }else{
                time = Number(timeInput.value) / 60;						//時間を分単位にするs
            }

            let kcal = 1.05 * (Number(mets) * time) * Number(weight.value);	//消費カロリー＝1.05×(メッツ値×時間)×体重
            kcal = Math.round(kcal * 100) / 100;							//小数第２位で切り捨て


            let kcalOutput = document.getElementById("kcalOutput2");		//id="kcalOutput2"から値を取得


            kcalOutput.value = kcal;										//kcalフォームに値を出力
            metsOutput.value = mets;

	}

		    //三列目の運動計算
	  		const kcalCalc3 =() => {
            let height = document.getElementById	("height");			//身長が入力されたフォームから値を取得
            let weight = document.getElementById	("weight");			//体重が入力されたフォームから値を取得
            let steps =  document.getElementById	("step3");			//歩数が入力されたフォームから値を取得
            let timeInput = document.getElementById ("time3");			//時間が入力されたフォームから値を取得
            let active = document.getElementById	("active_number3");	//運動種類が入力されたフォームから値を取得
            let str = active.value.split			("&&");				//&&でsplitする

            let kind = str[0];
            let mets = str[1];


            let time = Number(timeInput.value) / 60;						//時間を分単位にする
            //ウォーキング消費カロリー計算
            if(Number(kind) === 0){											//kindが0だった場合
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;	//歩幅＝身長×0.45×100/1000
                let distance = stepLength * Number(steps.value);			//距離＝歩幅×歩数
                time = distance / 4.9;										//時間＝距離×時速
            }
            //ランニング消費カロリー計算
            else if(Number(kind) === 1){									//kindが１だった場合
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;	//歩幅＝身長×0.45×100/1000
                let distance   = stepLength * Number(steps.value);			//距離＝歩幅×歩数
                time = distance / 8.3;										//時間＝距離×時速
            }else{
                time = Number(timeInput.value) / 60;						//時間を分単位にするs
            }

            let kcal = 1.05 * (Number(mets) * time) * Number(weight.value);	//消費カロリー＝1.05×(メッツ値×時間)×体重
            kcal = Math.round(kcal * 100) / 100;							//小数第２位で切り捨て


            let kcalOutput = document.getElementById("kcalOutput3");		//id="kcalOutput3"から値を取得


            kcalOutput.value = kcal;										//kcalフォームに値を出力
            metsOutput.value = mets;

	}

    </script>
</body>
</html>