function movimientoIzq(evento){
    var topVal = parseInt(window.getComputedStyle(cuadradoQueSeMueve, null).getPropertyValue("left"),10);
    cuadradoQueSeMueve.style.left = (topVal - 100) + "px";
}

//Obtenemos el valor de una propiedad establecida con css