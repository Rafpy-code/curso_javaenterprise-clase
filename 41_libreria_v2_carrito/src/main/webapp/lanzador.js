window.addEventListener('load', animacion);
//Para la animación de inicio
const homeBtn = $("#entrar");
function animacion() {
	const TLFADE = gsap.timeline();
	TLFADE.from(homeBtn, { autoAlpha: 0, y: -500, delay: 0.2 });
}
$(document).ready(function() {
	$("select[name='seleccion']").change(function() {
		//let opcionSeleccionada = $(this).val();
		//console.log("Opción seleccionada:", opcionSeleccionada);
		$("#idTema").click(lanzarPeticionLibros());
	});

	function lanzarPeticionLibros() {
		let url = "FrontController";
		let params = { "operation": "doLibros", "seleccionado": $("#idTema").val() };
		//console.log(params);
		$.get(url, params, function(data) {
			//console.log(data);
			let tabla = `<table class="table-fixed rounded-md mx-auto w-full"><thead class="border-2 text-white text-right p-2"><tr><th>ISBN</th><th>TÍTULO</th><th>PÁGINAS</th><th>PRECIO</th><th>COMPRAR</th></tr></thead><tbody class="text-right p-2">`;
			$.each(data, function(i, libro) {
				var isbn = libro.isbn;
				console.log(i + ".-" + isbn);
				tabla += `<tr class="border-2 p-2"><td>${libro.isbn}</td><td>${libro.titulo}</td><td>${libro.paginas}</td><td>${libro.precio}</td><td><a href="#" onclick="agregarCarrito('${libro.isbn}')" class="text-white text-center">AGREGAR</a></td></tr>`;
			});
			tabla += `</tbody></table>`;
			$("#spinner").hide();
			$("#listaLibros").html(tabla);
		}
		);
	}

	function agregarCarrito(isbn) {
		let params = { "operation": "doAgregarCarrito", "isbn": isbn };
		pintarCarrito(params);
	}


	function quitarCarrito(posicion) {
		let params = { "operation": "doQuitarCarrito", "posicion": posicion };
		pintarCarrito(params);
	}

	function pintarCarrito(params) {
		let url = "FrontController";
		$.get(url, params, function(data) {
			let tabla = `<table class="table-fixed rounded-md mx-auto w-full"><thead class="border-2 text-white text-right p-2"><tr><th>ISBN</th><th>TÍTULO</th><th>PÁGINAS</th><th>PRECIO</th><th>COMPRAR</th></tr></thead><tbody class="text-right p-2">`;
			$.each(data, function(i, libro) {
				console.log(i + ".-" + isbn);
				tabla += `<tr class="border-2 p-2"><td>${libro.isbn}</td><td>${libro.titulo}</td><td>${libro.paginas}</td><td>${libro.precio}</td><td><a href="#" onclick="quitarCarrito('${i}')" class="text-white text-center">AGREGAR</a></td></tr>`;
			});
			tabla += `</tbody></table>`;
			$("#listaLibrosComprados").html(tabla);
		});
	}
});