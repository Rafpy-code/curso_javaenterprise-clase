$(document).ready(function() {

	$("#listaLibros")

	function lanzarPeticionLibros() {
    let url = "FrontController";
    let params = {"operation": "doLibros","isbn": $("#isbn").val()};
    $.get(url, params,function (data) {
        let tabla = `<table class="table table-success table-striped"><thead><tr><th>ISBN</th><th>TÍTULO</th><th>PÁGINAS</th><th>PRECIO</th></tr></thead><tbody>`;
        $.each(data, function (i, libro) {
          tabla += `<tr><td>${libro.isbn}</td><td>${libro.titulo}</td><td>${libro.paginas}</td><td>${libro.precio}</td></tr>`;
        });
        tabla += `</tbody></table>`;
        $("#tablaCursos").html(tabla);
      }
    );
  }
});