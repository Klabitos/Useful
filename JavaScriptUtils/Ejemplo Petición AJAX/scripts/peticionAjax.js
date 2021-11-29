window.onload = () => {
    document.getElementById("botonPeticion").addEventListener("click", realizarPeticionesAjax, false);
    document.getElementById("botonPeticionErrores").addEventListener("click", realizarPeticionesAjaxErrores, false);
    document.getElementById("botonPeticionPost").addEventListener("click", realizarPeticionPost, false);
    document.getElementById("ejercicio3").addEventListener("click", realizarPeticionEjercicio3EliminarCosis, false); //IR CAMBIANDO DEPENDIENDO DE LO QUE QUIERAS
};


/**
 * Función para crear una petición Ajax y enviarla al servidor.
 * Para las prueba se va a utilizar la API REST jsonplaceholder, que gestiona tareas, 
 * se pueden obtener todas las tareas existentes, 
 * obtener una tarea utilizando su identificador, añadir una nueva tarea, 
 * actualizar una tarea o eliminar una tarea existente.
 */
function realizarPeticionesAjax() {
    let request = new XMLHttpRequest();
    //Indicamos  la función que se va a ejecutar cada vez que 
    //cambie el estado de la petición
    request.onreadystatechange = accionEstado;
    console.log(request.readyState);
    //Se establece la comunicación con el servidor
    request.open("GET", "https://jsonplaceholder.typicode.com/users", true);
    console.log(request.readyState);
    //Por último se envía la petición
    request.send();

    /*
    Si se tratara de una petición POST, podría ser como sigue:
        Establecer conexión:
            request.open("POST", "https://jsonplaceholder.typicode.com/users", true);
        *Añadir la cabecera que informará al servidor del formato en que van los datos enviados
            request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        *Enviar la petición:
            request.send("nombre=Sonia&apellido=Gutierrez");
    */
}

/**
 * Función que se va a ejecutar cada vez que se produzca un cambio de estado en la petición.
 * La situación de la resupesta mas interesante de cara a ejecutar código adicional:
 *      readyState = 4 y
 *      status = 200
 */
function accionEstado() {
    if (this.readyState == 4 && this.status == 200) {   
        console.log(this.readyState);
        //Cuando ya se ha procesado la petición, el servidor ha devuelto los datos pedidos
        //y el resultado de la petición es OK (200), realizamos los cambios pertinentes
        let parrafo = document.getElementById("parrafo1");
        let persona = JSON.parse(this.responseText);
        console.log(persona);
        for(let i=0; i<persona.length; i++){
            parrafo.innerHTML+=`Nombre: ${persona[i].name}, email: ${persona[i].email} <br>`;
        }
    }
}


function realizarPeticionPost(){
    console.log("entra");
    let request = new XMLHttpRequest();
    request.onreadystatechange=obtenerDatosPersona; 
    request.open("POST", "https://jsonplaceholder.typicode.com/posts", false); //es sincrona si true
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); //'application/json' Si queremos en JSON
    let data = JSON.stringify(
        {
            "userId": "3",
            "title": "prueba1",
            "body": "Cuerpo de la prueba"
        }
        );
        //.sen(data);
    request.send("userId = 3&title = “prueba1”&body = “Cuerpo de la prueba”");
}


function obtenerDatosPersona(){
    if(this.status==201 && this.readyState == 4){
        let parrafo = document.getElementById("parrafo1");
        console.log(this.responseText); //ek responseText en post de añadir es el objeto
        let post = JSON.parse(this.responseText);
        for(let i=0; i<post.length; i++){
            parrafo.innerHTML+=`Nombre: ${post[i].title}, email: ${post[i].body} <br>`;
        }
        alert(`id: ${post.id}`);
    }

}
//////////////////////////////////////////////////////////////////
function realizarPeticionEjercicio3(){
    let request = new XMLHttpRequest();
    request.onreadystatechange=tareaID55; 
    request.open("GET", "https://jsonplaceholder.typicode.com/todos?id=201", false); //?id=55
    request.send();
}
function realizarPeticionEjercicio3enviarCosis(){
    let request = new XMLHttpRequest();
    request.onreadystatechange=enviarCosis; 
    request.open("POST", "https://jsonplaceholder.typicode.com/todos", false); 
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
    request.send("userId=5&title=Prueba de Post&completed=false");
}
function realizarPeticionEjercicio3modificarCosis(){
    let request = new XMLHttpRequest();
    request.onreadystatechange=enviarCosis; 
    request.open("PUT", "https://jsonplaceholder.typicode.com/todos/76", false); //el id 76 es con barra y no se especifica que es el 76
    request.setRequestHeader("Content-type", "application/json"); 
    let datos = JSON.stringify({"title":"Tarea Modificada"});
    request.send(datos);
}
function realizarPeticionEjercicio3EliminarCosis(){
    let request = new XMLHttpRequest();
    request.onreadystatechange=enviarCosis; 
    request.open("DELETE", "https://jsonplaceholder.typicode.com/todos/32", false); //el id 76 es con barra y no se especifica que es el 76
    request.send(); //devolverá vacio porque elimina
}




function devolverTodasTareas(){
    let parrafo = document.getElementById("parrafo1");
    if(this.status==200 && this.readyState==4){
        let objetos = JSON.parse(this.responseText);
        for(let i=0; i<objetos.length; i++){
            parrafo.innerHTML+=`UserId: ${objetos[i].userId}, title: ${objetos[i].title} <br>`;
        }
    }
}
function tareaID55(){
    let parrafo = document.getElementById("parrafo1");
    if(this.status==200 && this.readyState==4){
        let objetos = JSON.parse(this.responseText); //con get da un array
        //for(let i=0; i<objetos.length; i++){
            //if(objetos[i].id==55){
                if(objetos.length==0){
                    alert("error");
                }else{
                    parrafo.innerHTML+=`UserId: ${objetos[0].userId}, title: ${objetos[0].title} <br>`; //cambiar 0 por i para hacerlo de la otra manera
                }
                
            //}
        //}
        
    }
}

function enviarCosis(){
    console.log(`Status: ${this.status}, state: ${this.readyState}`);
    if(this.status==200 &&this.readyState==4){ //201 con POST, lo demas 200
        let parrafo = document.getElementById("parrafo1");
        let objeto = JSON.parse(this.responseText);
        console.log(objeto);
        parrafo.innerHTML+=`UserId: ${objeto.userId}, title: ${objeto.title}, id: ${objeto.id} <br>`; //Con post solo da un dato
    }
}