window.onload = function () {


    // 1) Dau 1..6
    document.getElementById('btnDice').onclick = function () {
        let randomNum = Math.floor(Math.random() * 7);
        let divOut = document.getElementById("diceOut");
        divOut.innerHTML = randomNum;

    };

    // 2) Cara o Creu
    document.getElementById('btnCoin').onclick = function () {
        let randomNum = Math.floor(Math.random() * 2);
        let divOut = document.getElementById("coinOut");
        if (randomNum == 0) {
            divOut.innerHTML = "Cara";
        } else {
            divOut.innerHTML = "Creu";
        }

    };

    // 3) Potències
    document.getElementById('btnPow').onclick = function () {
        let powBase = parseFloat(document.getElementById("powBase").value);
        let powExp = parseFloat(document.getElementById("powExp").value);
        let powOut = document.getElementById("powOut");
        let res = Math.pow(powBase, powExp);
        console.log(res);
        powOut.innerHTML = res;
    };

    // 3b) Arrels
    document.getElementById('btnSqrt').onclick = function () {
        let sqrtNum = parseFloat(document.getElementById("sqrtNum").value);
        let sqrtOut = document.getElementById("sqrtOut");
        let res = Math.sqrt(sqrtNum);
        console.log(res);
        sqrtOut.innerHTML = res;

    };

    // 4) Mínim i Màxim
    document.getElementById('btnMinMax').onclick = function () {
        let minMaxA = parseInt(document.getElementById("minmaxA").value);
        let minMaxB = parseInt(document.getElementById("minmaxB").value);
        let minMaxC = parseInt(document.getElementById("minmaxC").value);
        let minmaxOut = document.getElementById("minmaxOut");

        let min = 0;
        let max = 0;
        min = Math.min(minMaxA, minMaxB, minMaxC);
        max = Math.max(minMaxA, minMaxB, minMaxC);

        minmaxOut.innerHTML = `<p>Min: ${min} | Max: ${max}</p>`


    };

};