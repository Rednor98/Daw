window.onload = function () {

    // Botons
    document.getElementById('ex1_btn').addEventListener('click', ex1_validarData);
    document.getElementById('ex2_btn').addEventListener('click', ex2_mostrarAvui);
    document.getElementById('ex3_btn').addEventListener('click', ex3_diferencia);
    document.getElementById('ex4_btn').addEventListener('click', ex4_diaSetmana);
    document.getElementById('ex5_btn').addEventListener('click', ex5_comparar);
    document.getElementById('ex6_btn').addEventListener('click', ex6_mostrarHora);
    document.getElementById('ex7_btn').addEventListener('click', ex7_comprovarTraspas);

    // =============================
    // EX1: Validació de data (DD/MM/AAAA)
    // =============================
    function ex1_validarData() {
        let date = document.getElementById("ex1_data").value;
        if (!date) {
            alert("Informa una data en format DD/MM/AAAA");
            return;
        }

        if (validatFormat(date)) {
            alert("Data correcta!");
        } else {
            alert("Data incorrecta!");
        }


    }

    // =============================
    // EX2: Data actual
    // =============================
    function ex2_mostrarAvui() {
        let d = new Date();
        let text = d.toLocaleDateString('es-ES', {
            day: '2-digit',
            month: '2-digit',
            year: 'numeric'
        });


        document.getElementById("ex2_out").innerHTML = text;

    }

    // =============================
    // EX3: Diferència de dies
    // =============================
    function ex3_diferencia() {
        let date1 = new Date(document.getElementById("ex3_a").value);
        let date2 = new Date(document.getElementById("ex3_b").value);
        let result = document.getElementById("ex3_out");

        if (date1 > date2) {
            result.innerHTML = "La data A ha de ser menor a la data B";
        }
        if (date1.value && date2.value) {
            let diferencia = Math.abs(date2 - date1);
            let dias = diferencia / (1000 * 60 * 60 * 24);

            result.innerHTML = dias;
        } else {
            result.innerHTML = "Si us plau, informa les dues dates";
        }


    }

    // =============================
    // EX4: Dia de la setmana
    // =============================
    function ex4_diaSetmana() {
        let date = new Date(document.getElementById("ex4_data").value);
        let array = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
        let result = document.getElementById("ex4_out");

        if (!date.value) {
            result.innerHTML = "Introdueix una data correcta.";
        } else {
            result.innerHTML = array[date.getDay()];
        }
    }

    // =============================
    // EX5: Passat / Avui / Futur
    // =============================
    function ex5_comparar() {
        let date = new Date(document.getElementById("ex5_data").value);
        let dateActual = new Date();
        let result = document.getElementById("ex5_out");


        date.setHours(0, 0, 0, 0);
        dateActual.setHours(0, 0, 0, 0)
        if (!date.value) {
            result.innerHTML = "Introdueix una data correcta";
        }
        else if (date > dateActual) {
            result.innerHTML = "Futur";
        } else if (date < dateActual) {
            result.innerHTML = "Pasat";
        } else {
            result.innerHTML = "Avui";
        }
    }

    // =============================
    // EX6: Hora actual 24h / 12h
    // =============================
    function ex6_mostrarHora() {
        let date = new Date();
        let result = document.getElementById("ex6_out");
        let format = document.getElementById("ex6_format").value;

        let h24 = date.getHours();
        let minuts = date.getMinutes().toString().padStart(2, "0");
        let hores;

        if (format == 12) {
            let h12 = h24 % 12;

            if (h12 === 0) {
                h12 = 12;
            }

            let ampm = h24 < 12 ? "AM" : "PM";
            hores = h12;

            result.innerHTML = hores + ":" + minuts + " " + ampm;
        } else {
            hores = h24.toString().padStart(2, "0");
            result.innerHTML = hores + ":" + minuts;
        }
    }

    // =============================
    // EX7: Any de traspàs
    // =============================
    function ex7_comprovarTraspas() {
        let date = document.getElementById("ex7_any").value;

        if (!date || Number.isNaN(Number(date))) {
            alert("Introdueix un any vàlid");
            return;
        }

        let any = Number(date);

        if (any % 4 === 0) {
            alert("És un any de traspàs");
        } else {
            alert("No és un any de traspàs");
        }
    }

    // =============================
    // EX8: Comptador fins a Cap d'Any
    // =============================
    function ex8_ComptadorFinsAnyNou() {
        const countDownDate = new Date("Jan 1, 2027 00:00:00").getTime();

        let date = new Date();
        let result = document.getElementById("ex8_out");
        let timeLeft = countDownDate - date;

        const days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
        const hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        const minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
        const seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);

        result.innerHTML = `${days}d ${hours}h ${minutes}m ${seconds}s`;
    }
    setInterval(ex8_ComptadorFinsAnyNou, 1000);


};
function validaData(data) {
    let arrayData = data.split('/');
    let dia = parseInt(arrayData[0]);
    let mes = parseInt(arrayData[1]);
    let any = parseInt(arrayData[2]);
    let objecteData = new Date(any, mes - 1, dia); //El mes comença per 0 (Gener)
    if (objecteData.getFullYear() === any && objecteData.getMonth() === (mes - 1)
        && objecteData.getDate() === dia) {
        return true;
    } else {
        return false;
    }
}
function validatFormat(data) {
    let regex = /^\d{2}\/\d{2}\/\d{4}$/;
    return regex.test(data);
}