window.onload = function () {
    document.getElementById('btn1').addEventListener('click', abrirVentana);
    document.getElementById('btn2').addEventListener('click', cerrarVentana);
    document.getElementById('btn3').addEventListener('click', redimensionar);
    document.getElementById('btn4').addEventListener('click', moverVentana);

    document.getElementById('randomLink').addEventListener('click', locationRandom);
    showDatesWindows();
    checkNavegator();
    showInfo();


    let ventana;
    let isCreate = false;

    function abrirVentana() {
        if (!isCreate) {
            ventana = open("", "_blank", "width=500px,height=500px");
            ventana.focus();
            isCreate = true;
        }

    }
    function cerrarVentana() {
        if (isCreate) {
            ventana.close();
            isCreate = false;
        }
    }
    function redimensionar() {
        ventana.resizeTo(1000, 1000);
        ventana.focus();
    }
    function moverVentana() {
        ventana.focus();
        ventana.moveTo(50, 50);
    }

    function showDatesWindows() {
        let divOut = document.getElementById('screenProp')

        divOut.innerHTML += `<p> availHeight: ${screen.availHeight}</p>`;
        divOut.innerHTML += `<p> availWidth: ${screen.availWidth}</p>`;
        divOut.innerHTML += `<p> Height: ${screen.Height}</p>`;
        divOut.innerHTML += `<p> Width: ${screen.Width}</p>`;
    }

    function locationRandom() {
        let randomNum = Math.floor(Math.random() * 3);
        switch (randomNum) {
            case 0:
                window.location = "https://www.microsoft.com/es-es/microsoft-365/outlook/email-and-calendar-software-microsoft-outlook";
                break;
            case 1:
                window.location = "https://mail.google.com/"
                break;

            case 2:
                window.location = "https://es.search.yahoo.com/?fr2=p:fprd,mkt:es"
                break;
            default:
                break;
        }

    }
    function checkNavegator() {
        let divOut = document.getElementById("colorDiv");
        let info = navigator.userAgent;
        console.log(info);
        if (info.includes("Chrome")) {
            divOut.style.backgroundColor = "red";
        }
        if (info.includes("Firefox")) {
            divOut.style.backgroundColor = "green";
        }
    }
    function showInfo() {
        let divOut = document.getElementById("navigatorProp");

        divOut.innerHTML += `<p> appCodeName: ${navigator.appCodeName}</p>`;
        divOut.innerHTML += `<p> appName: ${navigator.appName}</p>`;
        divOut.innerHTML += `<p> appVersion: ${navigator.appVersion}</p>`;
        divOut.innerHTML += `<p> cookieEnabled: ${navigator.cookieEnabled}</p>`;
        divOut.innerHTML += `<p> platform: ${navigator.platform}</p>`;
        divOut.innerHTML += `<p> userAgent: ${navigator.userAgent}</p>`;
    }
};
