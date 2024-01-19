const formulario = document.getElementById("formulario");

const validarNombre = () => {
	//solo letras
	const expRegNombre = /^[a-zA-ZÀ-ÿ\s]/;

	// Obtenemos el input
	const inputNombre = formulario.nombre;

	// Comprobamos que el nombre sea correcto.
	if (!expRegNombre.test(inputNombre.value)) {
		inputNombre.classList.add('formulario__input--error');
		return false;
	} else {
		inputNombre.classList.remove('formulario__input--error');
		return true;
	}
};

const validarDuracion = () => {
	// Aceptamos cualquier digito (0-9), y un punto con decimales (opcional)
	const expRegDuracion = /^\d+/;

	// Obtenemos el input cantidad
	const inputDuracion = formulario.duracion;

	// Transformamos la cantidad de una cadena de texto a numero.
	// y comprobamos si es una cantidad correcta
	if (expRegDuracion.test(inputDuracion.value)) {
		inputDuracion.classList.remove('formulario__input--error');
		return true;
	} else {
		inputDuracion.classList.add('formulario__input--error');
		return false;
	}
};

const validarPrecio = () => {
	// Aceptamos cualquier digito (0-9), y un punto con decimales (opcional)
	const expRegPrecio = /^\d+(\.\d+)?$/;

	// Obtenemos el input cantidad
	const inputPrecio = formulario.precio;

	// Transformamos la cantidad de una cadena de texto a numero con decimales.
	// y comprobamos si es una cantidad correcta
	if (expRegPrecio.test(inputPrecio.value)) {
		inputPrecio.classList.remove('formulario__input--error');
		return true;
	} else {
		inputPrecio.classList.add('formulario__input--error');
		return false;
	}
};


formulario.addEventListener('keyup', (e) => {
	if (e.target.tagName === 'INPUT') {
		if (e.target.id === 'nombre') {
			validarNombre();
		} else if (e.target.id === 'duracion') {
			validarDuracion();
		} else if (e.target.id === 'precio') {
			validarPrecio();
		}
	}
});

	// Nos aseguramos de que el texto del boton sea siguiente.
	const btnFormulario = document.getElementById('formulario__btn');

	btnFormulario.addEventListener('click', (e) => {
		e.preventDefault();
		// Agregamos la clase que deshabilita el boton.
		btnFormulario.classList.add('formulario__btn--disabled');
		// Eventlistener para comprobar los campos de formulario cuando el usuario corrige.
		
		});


/*
// Pasar para validar los formularios registro y login 
const validarCorreo = () => {
	// Expresion regular para validar un correo.
	const expRegCorreo = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;

	// Obtenemos los inputs
	const inputUsuario = formulario['usuario'];

	// Comprobamos que el nombre y correo sean correctos.
	if (!expRegCorreo.test(inputCorreo.value)) {
		inputCorreo.classList.add('formulario__input--error');
		return false;
	} else {
		inputCorreo.classList.remove('formulario__input--error');
		return true;
	}
};
*/