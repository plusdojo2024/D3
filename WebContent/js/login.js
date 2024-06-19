"use strict";

let formObj = document.getElementById("login_form");
let errorIdObj = document.getElementById("error_id");
let errorPassObj = document.getElementById("error_password");
// let errorMessageObj = document.getElementById("error_message");

formObj.onsubmit = function(){
    if(!formObj.id.value || !formObj.password.value){
        if(!formObj.id.value && formObj.password.value){
            errorIdObj.textContent = "IDが未入力です";
            errorPassObj.textContent = null;
        }
        else if(formObj.id.value && !formObj.password.value){
            errorIdObj.textContent = null;
            errorPassObj.textContent = "パスワードが未入力です";
        }
        else{
            errorIdObj.textContent = "IDが未入力です";
            errorPassObj.textContent = "パスワードが未入力です";
        }

        //サーバーに送信しない処理
        return false;
    }
    errorIdObj.textContent = null;
    errorPassObj.textContent = null;
};

// formObj.onreset = function(){
//     //errorMessageObj.textContent = null;
//     errorIdObj.textContent = null;
//     errorPassObj.textContent = null;
// };

//パスワードを表示/非表示にする
function pushHideButton() {
    var txtPass = document.getElementById("password");
    var btnEye = document.getElementById("buttonEye");
    if (txtPass.type === "text") {
        txtPass.type = "password";
        btnEye.className = "fa fa-eye-slash";
    } else {
        txtPass.type = "text";
        btnEye.className = "fa fa-eye";
    }
}