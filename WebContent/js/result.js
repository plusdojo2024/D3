'use strict';

function makeDay(y, m, d){
	/*var day = new Date(document.lastModified);
	var y = day.getFullYear();
	var m = day.getMonth() + 1;
	var d = day.getDate();*/
	const date = new Date(y, m-1, d);
	var week = new Array("日", "月", "火", "水", "木", "金", "土");
	var w = week[date.getDay()];
	if (m < 10) m = "0" + m;
	if (d < 10) d = "0" + d;
	document.getElementById("date").innerHTML += y + "年" + m + "月" + d + "日 (" + w + ")" ;
}

function deleteMessage(){
	if(confirm("本当に削除しますか？")) {
		return true;
	} else{
		alert('キャンセルしました');
		event.preventDefault();
	}
}




