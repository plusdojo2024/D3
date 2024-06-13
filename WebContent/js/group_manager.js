'use strict';

/* HTML要素をオブジェクトとして取得する */
let formObj = document.getElementById('regist_form');
let errorMessageObj = document.getElementById('error_message');

/* [実行]ボタンをクリックしたときの処理 */
formObj.onsubmit = function() {
/* 氏名を必須入力項目とします */
if (!formObj.groupName.value) {
errorMessageObj.textContent = '※グループ名を入力してください！';
return false;
}

/* 確認ダイアログボックスを表示します */
if (!window.confirm('この内容で作成します。よろしいですか？')) {
return false;
}

errorMessageObj.textContent = null;
};

/* [リセット]ボタンをクリックしたときの処理 */
formObj.onreset = function() {
errorMessageObj.textContent = null;
};