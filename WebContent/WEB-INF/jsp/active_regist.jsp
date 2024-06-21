<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>その他の入力</title>
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
			<p>${ActiveResult.message}</p>
			<!--運動の種類フォーム-->

			<form action="./ActiveRegistServlet" method="POST" class="active">

				<input type="checkbox" id="check1" value="1" name="check1"
					onchange="func1()" class="scales" />
										 <!-- 運動種類1 -->
					 <select name="active_number1" id="active_number1" onchange="myfunc(this.value)">
					<option value="0"></option>
					<option value="${ a1.activeName }">ウォーキング</option>
					<option value="2">ランニング</option>
					<option value="3">野球</option>
					<option value="4">バスケットボール</option>
					<option value="5">ドッジボール</option>
					<option value="6">バレーボール</option>
					<option value="7">サッカー</option>
										<!-- 時間1 -->
				</select> <select name="time1" id="time1" class="leave"value="" onchange="calc()"> <!-- 時間を選んだら処理 -->

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
									<!-- 歩数1 -->
				</select> <input type="text" id = "step1" name="step1" placeholder="歩数"  value="" onKeyup="calc2()">

							<input type="text" name="kcal1" placeholder="消費カロリー"> <br>

							<input type="checkbox" id="check2" value="2" name="check2"
					onchange="func1()" class="scales" />
										 <!-- 運動種類2 -->
					 <select name="active_number2" id="active_number2" onchange="myfunc2(this.value)">
					<option value="0"></option>
					<option value="1">ウォーキング</option>
					<option value="2">ランニング</option>
					<option value="3">野球</option>
					<option value="4">バスケットボール</option>
					<option value="5">ドッジボール</option>
					<option value="6">バレーボール</option>
					<option value="7">サッカー</option>
										 <!-- 時間2 -->
				</select> <select name="time2" id="time2" class="leave" value="" onchange="calc3()"><!-- 時間を選んだら処理2 -->
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
					 					<!-- 歩数2 -->
				</select> <input type="text" id ="step2" name="step2" placeholder="歩数" value="" onKeyup="calc4()">
				<input type="text" name="kcal2" placeholder="消費カロリー"> <br>

        <input type="checkbox" id="check3" value="3" name="check3"
        onchange="func1()" class="scales" />
        	 							<!-- 運動種類3 -->
         <select name="active_number3" id="active_number3" onchange="myfunc3(this.value)">
					<option value="0"></option>
					<option value="1">ウォーキング</option>
					<option value="2">ランニング</option>
					<option value="3">野球</option>
					<option value="4">バスケットボール</option>
					<option value="5">ドッジボール</option>
					<option value="6">バレーボール</option>
					<option value="7">サッカー</option>
										 <!-- 時間3 -->
         </select> <select name="time3" id="time3" class="leave" value="" onchange="calc5()">
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
       </select> <input type="text" id ="step3" name="step3" placeholder="歩数" onKeyup="calc6()">
      <input type="text" name="kcal3" placeholder="消費カロリー"> <br>

								<input type="submit" name="submit" value="登録" class="button">



			</form>
		</div>
		</div>

		<script type="text/javascript" src="D3/active_regist.js">

		</script>
</body>
</html>