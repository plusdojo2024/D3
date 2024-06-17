/**
 *
 */
// 初期表示
window.onload = function() {
	showProcess(today, calendar);
};

// 前月の表示
function prev() {
	showDate.setMonth(showDate.getMonth() - 1);
	showProcess(showDate);
}

// 翌月の表示
function next() {
	showDate.setMonth(showDate.getMonth() + 1);
	showProcess(showDate);
}
