const validar = ()=>{
    let usuario = document.getElementById("usuario").value;
    let password = document.getElementById("password").value;
    let password1 = document.getElementById("password1").value;

    if (usuario.length >= 3 && password.length >=3) {
       alert('Datos válidos');
       
       return true;
    }else{
        document.getElementById('u_alert').innerText='Datos incorrectos!';
        return false;
    }
}