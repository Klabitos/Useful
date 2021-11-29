function realizarPeticionesAjaxErrores() {
    let request = new XMLHttpRequest();
    request.onreadystatechange = accionEstado2;
    //https://jsonplaceholder.typicode.com/uses (users mal escrito) para provocar un error
    request.open("GET", "https://jsonplaceholder.typicode.com/uses", true);
    request.send();
}

function muestraError(status) {
    alert("Se ha producido un error: " + status);
}

function accionEstado2() {
    if (this.readyState == 4) {
        if (this.status == 200) {
            let parrafo = document.getElementById("parrafo1");
            parrafo.innerHTML = this.responseText;
        } else {
            muestraError(this.status);
        }
    }
}