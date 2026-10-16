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
        let date = document.getElementById("ex1_data");
        if (!date.value) {
            alert("Data incorrecta");
            return;
        }

        let dateFormat = new Date();
        dateFormat.


    }

    // =============================
    // EX2: Data actual
    // =============================
    function ex2_mostrarAvui() {






    }

    // =============================
    // EX3: Diferència de dies
    // =============================
    function ex3_diferencia() {







    }

    // =============================
    // EX4: Dia de la setmana
    // =============================
    function ex4_diaSetmana() {







    }

    // =============================
    // EX5: Passat / Avui / Futur
    // =============================
    function ex5_comparar() {






    }

    // =============================
    // EX6: Hora actual 24h / 12h
    // =============================
    function ex6_mostrarHora() {






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