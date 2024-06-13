<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グループ管理</title>
<link rel="stylesheet" type="text/css" href="gstyle.css">

</head>
<body>
    
    <h2>【グループ管理】</h2>
    <form>
        <label>作成
            <input type="text" mame="groupName" id="groupName" value="グループ名">
        </label>
        <input type="submit" id="addButton" value="追加" onclick="createMessage()">
    </form>
    <form>
        <label>参加
            <input type="text" id="groupId" value="グループID">
        </label>
        <input type="submit" id="joinButton" value="参加">
    </form>

    <script src="./group_manager.js">
    </script>
</body>
</html>