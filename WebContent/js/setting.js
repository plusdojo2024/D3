 'use strict';

let formObj = document.getElementById("data_form");
    let nameErrorObj = document.getElementById("name_error");
    let heightErrorObj = document.getElementById("height_error");
    let weightErrorObj = document.getElementById("weight_error");

    formObj.onsubmit = function() {
        if (!formObj.name.value) {
            nameErrorObj.textContent = '名前を入力してください';
            return false;
        }

        if (!formObj.height.value) {
            heightErrorObj.textContent = '身長を入力してください';
            return false;
        }

        if (!formObj.weight.value) {
            weightErrorObj.textContent = '体重を入力してください';
            return false;
        }
    }