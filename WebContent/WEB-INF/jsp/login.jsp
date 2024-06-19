<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
</head>
<body>
    <header>
        <img src="" alt="たけのこーちんぐ">
    </header>
    <main>
        <div class="login-screen">
			<div class="login-form">
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
								<input type="password" name="password" placeholder="Your Password" id="password">
								<span id="buttonEye" class="fa fa-eye-slash" onclick="pushHideButton()"></span><br>
								<span id="error_password"></span>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" name="login"value="ログイン">
								<input type="reset" name="reset" value="リセット">
							</td>
						</tr>
						<tr>
							<td>
                                <!-- ログインできなかった際のエラーメッセージ -->
								<span id="error_message">${LoginError.message}</span>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
    </main>
    <footer>
        <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
    </footer>
    <script src="/D3/js/login.js"></script>
</body>
</html>