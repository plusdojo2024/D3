<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン | たけのこーちんぐ</title>
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="/D3/css/login.css">
</head>
<body>
    <header>
        <h1 class="logo"><img src="/D3/img/takelogo.png" alt="たけのこーちんぐ"></h1>
    </header>
    <main>
        <div class="loginError_space">
            <!-- ログインできなかった際のエラーメッセージ -->
			<span id="error_message">${loginError.message}</span>
        </div>
        <div class="login_screen">
			<form id="login_form" method="post" action="/D3/LoginServlet">
				<table>
					<tr>
						<td>
							<label for="id">ユーザーID</label><br>
							<input type="text" name="id" placeholder="Your ID" id="id"><br>
							<span id="error_id"></span>
						</td>
					</tr>
					<tr>
						<td>
							<label for="password">パスワード</label><br>
                            <!-- <div class="password_wrapper"> -->
							    <input type="password" name="password" placeholder="Your Password" id="password">
							    <span id="buttonEye" class="fa fa-eye-slash" onclick="pushHideButton()"></span><br>
                            <!-- </div> -->
							<span id="error_password"></span>
						</td>
					</tr>
					<tr >
						<td>
							<input type="submit" class="submit" name="login" value="ログイン">
							<input type="reset" class="reset" name="reset" value="リセット">
						</td>
					</tr>
				</table>
			</form>
		</div>
    </main>
    <footer>

    </footer>
    <script src="/D3/js/login.js"></script>
</body>
</body>
</html>