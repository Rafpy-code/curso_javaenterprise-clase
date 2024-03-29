function agregarCarrito(isbn) {
		$("#carritoVista").show();
		var params = { "operation": "doAgregarCarrito", "isbn": isbn };
		pintarCarrito(params);
	}

	function quitarCarrito(posicion) {
		var params = { "operation": "doQuitarCarrito", "posicion": posicion };
		pintarCarrito(params);
	}

	function pintarCarrito(params) {
		var url = "FrontController";
		$.get(url, params, function(data) {
			var tabla = `<table class="table-fixed rounded-md mx-auto w-full"><thead class="border-2 text-white text-right p-2"><tr><th>ISBN</th><th>TÍTULO</th><th>PÁGINAS</th><th>PRECIO</th><th>COMPRAR</th></tr></thead><tbody class="text-right p-2">`;
			$.each(data, function(i, libro) {
				tabla += "<tr class='border-2 p-2'><td>" + libro.isbn + "</td><td>" + libro.titulo + "</td><td>" + libro.paginas + "</td><td>" + libro.precio + "</td><td><a href='#' class='text-white text-center' onclick='quitarCarrito(" + i + ")'>QUITAR</a></td></tr>";
			});
			tabla += `</tbody></table>`;
			$("#listaLibrosComprados").html(tabla);
		});
	}
	function lanzarPeticionLibros() {
		var url = "FrontController";
		var params = { "operation": "doLibros", "seleccionado": $("#idTema").val() };
		//console.log(params);
		$.get(url, params, function(data) {
			//console.log(data);
			var tabla = "<table class='table-fixed rounded-md mx-auto w-full'><thead class='border-2 text-white text-right p-2'><tr><th>ISBN</th><th>TÍTULO</th><th>PÁGINAS</th><th>PRECIO</th><th>COMPRAR</th></tr></thead><tbody class='text-right p-2'>";
			$.each(data, function(i, libro) {
				//console.log(i + ".-" + isbn);
				tabla += "<tr class='border-2 p-2'><td>" + libro.isbn + "</td><td>" + libro.titulo + "</td><td>" + libro.paginas + "</td><td>" + libro.precio + "</td><td><a href='#' class='text-white text-center' onclick='agregarCarrito(" + libro.isbn + ")'>AGREGAR</a></td></tr>";
			});
			tabla += "</tbody></table>";
			$("#listaLibros").html(tabla);
		});
	}


$(document).ready(function() {
	$("select[name='seleccion']").change(function() {
		$("#carritoVista").hide();
		lanzarPeticionLibros();
	});

});
