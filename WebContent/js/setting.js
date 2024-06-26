 'use strict';

/* document.getElementById("form").onsubmit = function() {
	const nameObj = document.getElementById("name").word.value;
	if (nameObj == null) {

	}
 }; */

let formObj = document.getElementById("data_form");
    let nameErrorObj = document.getElementById("name_error");
    let heightErrorObj = document.getElementById("height_error");
    let weightErrorObj = document.getElementById("weight_error");

formObj.onsubmit = function() {
    if (formObj.name.value == null) {
            nameErrorObj.textContent = '名前を入力してください';
            return false;
        }

        if (formObj.height.value == null) {
            heightErrorObj.textContent = '身長を入力してください';
            return false;
        }

        if (formObj.weight.value == null) {
            weightErrorObj.textContent = '体重を入力してください';
            return false;
        }
    }