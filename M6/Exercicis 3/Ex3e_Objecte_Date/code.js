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
            alert("Data incorrecta");
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

        let diferencia = Math.abs(date2 - date1);
        let dias = diferencia / (1000 * 60 * 60 * 24);

        document.getElementById("ex3_out").innerHTML = dias;
    }

    // =============================
    // EX4: Dia de la setmana
    // =============================
    function ex4_diaSetmana() {
        let date = new Date(document.getElementById("ex4_data").value);
        let array = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];

        document.getElementById("ex4_out").innerHTML = array[date.getDay()];

    }

    // =============================
    // EX5: Passat / Avui / Futur
    // =============================
    function ex5_comparar() {
        let date = new Date(document.getElementById("ex5_data").value);
        let dateActual = new Date();
        let result = document.getElementById("ex5_out");

        console.log(date);
        console.log(dateActual);
        date.setHours(0, 0, 0, 0);
        dateActual.setHours(0, 0, 0, 0)
        if (date > dateActual) {
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

        console.log(format)

        console.log(date.getHours());
        result.innerHTML = date.getHours();



    }

    // =============================
    // EX7: Any de traspàs
    // =============================
    function ex7_comprovarTraspas() {







    }

    // =============================
    // EX8: Comptador fins a Cap d'Any
    // =============================



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