<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果 | 名刺管理</title>
<link rel="stylesheet" href="/simpleBC/css/mstyle.css">
</head>
<body>

    <!-- ヘッダー（ここから） -->
    <header class="header">
        <h1 id="text">
            <a href="/simpleBC/MenuServlet"><img src="pic/logo1.png" width="90" height="30" alt="名刺管理"></a>
        </h1>
    
    </header>

  <!-- ヘッダー（ここまで） -->
  <!-- メイン（ここから） -->
  <main>
	<h1 id="logo">
		<a><img src="pic/taimen_acrylic_business.png" width="260" height="200" alt="名刺管理"></a>
	</h1>
	<ul id="nav">
            <li><a href="/simpleBC/MenuServlet">ホーム</a></li>
            <li><a href="/simpleBC/RegistServlet">登録</a></li>
            <li><a href="/simpleBC/SearchServlet">検索</a></li>
            <li><a href="/simpleBC/ListServlet">一覧</a></li>
            <li><a href="/simpleBC/LogoutServlet" id="logout">ログアウト</a></li>
	</ul>

<h1  style="color: #946c45">${result.title}</h1>
<hr  >
<p>${result.message}</p>
<!--  <a href="${result.backTo}">戻る</a>-->
<a href="/simpleBC/ListServlet" style="color: #946c45">一覧へ</a>

  </main>
  <!-- メイン（ここまで） -->
  <!-- フッター（ここから） -->
  <div id="footer">
    <div class="gotop">
        <a href="#top"><img src="pic/up.png" alt="トップへ戻る"></a>
    </div>
    <p class="copyright">&copy; NISK</p>
  </div>
  <!-- フッター（ここまで） -->
<script>
    "use strict";
//ログアウト時の確認ダイアログ
    document.addEventListener('DOMContentLoaded', function() {
        const linkConfirms = Array.prototype.slice.call(document.querySelectorAll('#logout'));
        linkConfirms.forEach(function(linkConfirm) {
            linkConfirm.addEventListener('click', function(event) {
                const resultConfirm = confirm('ログアウトします。よろしいですか？');
                if(!resultConfirm) {
                    event.preventDefault();
                }
            });
        });
    }, false);
    
</script>


</body>
</html>
