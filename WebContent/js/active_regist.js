		//時間・歩数フォーㇺを非活性にする。
 			let time1  =   document.getElementById("time1");
			let step1  =   document.getElementById("step1");
			step1.disabled = true;
			time1.disabled = true;

		//ウォーキング・ランニングを選択すると歩数フォームが活性になる(一列目)
			const myFunc =() => {
            let active = document.getElementById("active_number1");
            let str = active.value.split("&&");

            let kind = str[0];

            let steps = document.getElementById("step1");
            let timeInput = document.getElementById("time1");

            if(kind !== "2"){
                steps.disabled = false;
                timeInput.disabled = true;
            }else{
                steps.disabled = true;
                timeInput.disabled = false;
            }
        }

			//時間・歩数フォーㇺを非活性にする。（２列目）

		let time2  =   document.getElementById("time2");
		let step2  =   document.getElementById("step2");
		step2.disabled = true;
		time2.disabled = true;
		//ウォーキング・ランニングを選択すると歩数フォームが活性になるメソッド(二列目)
			const myFunc2 =() => {
            let active = document.getElementById("active_number2");
            let str = active.value.split("&&");

            let kind = str[0];

            let steps = document.getElementById("step2");
            let timeInput = document.getElementById("time2");

            if(kind !== "2"){
                steps.disabled = false;
                timeInput.disabled = true;
            }else{
                steps.disabled = true;
                timeInput.disabled = false;
            }
        }

			//三列目ウォーキング・ランニングを選択すると歩数フォームが活性になる。

			let time3  =   document.getElementById("time3");
			let step3  =   document.getElementById("step3");
			step3.disabled = true;
			time3.disabled = true;

			const myFunc3 =() => {
	            let active = document.getElementById("active_number3");
	            let str = active.value.split("&&");

	            let kind = str[0];

	            let steps = document.getElementById("step3");
	            let timeInput = document.getElementById("time3");

	            if(kind !== "2"){
	                steps.disabled = false;
	                timeInput.disabled = true;
	            }else{
	                steps.disabled = true;
	                timeInput.disabled = false;
	            }
	        }


			//メッツ値を持ってくるのは、parseInt(${a1.metsValue});
			//一列目の運動計算

	  		const kcalCalc =() => {
            let height = document.getElementById	("height");			//身長が入力されたフォームから値を取得
            let weight = document.getElementById	("weight");			//体重が入力されたフォームから値を取得
            let steps =  document.getElementById	("step1");			//歩数が入力されたフォームから値を取得
            let timeInput = document.getElementById ("time1");			//時間が入力されたフォームから値を取得
            let active = document.getElementById	("active_number1");	//運動種類が入力されたフォームから値を取得
            let str = active.value.split			("&&");				//&&でsplitする

            let kind = str[0];
            let mets = str[1];


            let time = Number(timeInput.value) / 60;						//時間を分単位にする
            //ウォーキング消費カロリー計算
            if(Number(kind) === 0){											//kindが0だった場合
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;	//歩幅＝身長×0.45×100/1000
                let distance = stepLength * Number(steps.value);			//距離＝歩幅×歩数
                time = distance / 4.9;										//時間＝距離×時速
            }
            //ランニング消費カロリー計算
            else if(Number(kind) === 1){									//kindが１だった場合
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;	//歩幅＝身長×0.45×100/1000
                let distance   = stepLength * Number(steps.value);			//距離＝歩幅×歩数
                time = distance / 8.3;										//時間＝距離×時速
            }else{
                time = Number(timeInput.value) / 60;						//時間を分単位にするs
            }

            let kcal = 1.05 * (Number(mets) * time) * Number(weight.value);	//消費カロリー＝1.05×(メッツ値×時間)×体重
            kcal = Math.round(kcal * 100) / 100;							//小数第２位で切り捨て


            let kcalOutput = document.getElementById("kcalOutput");			//id="kcalOutput"から値を取得


            kcalOutput.value = kcal;										//kcalフォームに値を出力
            metsOutput.value = mets;

	}

		    //二列目の運動計算
		    const kcalCalc2 =() => {
            let height = document.getElementById	("height");
            let weight = document.getElementById	("weight");
            let steps =  document.getElementById	("step2");
            let timeInput = document.getElementById ("time2");
            let active = document.getElementById	("active_number2");
            let str = active.value.split			("&&");

            let kind = str[0];
            let mets = str[1];


            let time = Number(timeInput.value) / 60;

            if(Number(kind) === 0){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance = stepLength * Number(steps.value);
                time = distance / 4.9;
            }
            else if(Number(kind) === 1){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance   = stepLength * Number(steps.value);
                time = distance / 8.3;
            }else{
                time = Number(timeInput.value) / 60;
            }

            let kcal = 1.05 * (Number(mets) * time) * Number(weight.value);
            kcal = Math.round(kcal * 100) / 100;


            let kcalOutput = document.getElementById("kcalOutput2");


            kcalOutput.value = kcal;
            metsOutput.value = mets;

	}

		    //三列目の運動計算
	 	    const kcalCalc3 =() => {
            let height = document.getElementById	("height");
            let weight = document.getElementById	("weight");
            let steps =  document.getElementById	("step3");
            let timeInput = document.getElementById ("time3");
            let active = document.getElementById	("active_number3");
            let str = active.value.split			("&&");

            let kind = str[0];
            let mets = str[1];


            let time = Number(timeInput.value) / 60;

            if(Number(kind) === 0){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance = stepLength * Number(steps.value);
                time = distance / 4.9;
            }
            else if(Number(kind) === 1){
                let stepLength = Number(height.value) * 0.45 / 100 / 1000;
                let distance   = stepLength * Number(steps.value);
                time = distance / 8.3;
            }else{
                time = Number(timeInput.value) / 60;
            }

            let kcal = 1.05 * (Number(mets) * time) * Number(weight.value);
            kcal = Math.round(kcal * 100) / 100;


            let kcalOutput = document.getElementById("kcalOutput3");


            kcalOutput.value = kcal;
            metsOutput.value = mets;

	}