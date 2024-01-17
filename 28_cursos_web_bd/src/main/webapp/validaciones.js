const validarNuevo = ()=>{
    let nombre = document.getElementById("nombre").value;
    let duracion = document.getElementById("duracion").value;
    let precio = document.getElementById("precio").value;

    if (validarCurso(nombre)) {
        alert('curso no admitido');
    }
    if (validarNumeros(duracion)) {
        alert('duracion no es un numero');
    }
    if (validarEntero(duracion)) {
        alert('duración no es un entero');
    }
    if (validarNumeros(precio)) {
        alert('precio no es un numero');
    }
    if (validarEntero(precio)) {
        alert('precio no es un entero');
    }


}

const validarNumeros = (numero)=>{
    if (isNaN(numero)) {
        return true;
    } else {
        return false;
    }
}

const validarCurso = (txt)=>{
    if (txt == "php") {
        return false;
    }
    return true;
}

const validarEntero = (num)=>{
    if(num.includes('.')){
    return false
    }else{
        return true;
    }

}