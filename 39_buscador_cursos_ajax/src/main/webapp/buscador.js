$(document).ready(function () {
  // Detecto que radio button está seleccionado y muestro el formulario correspondiente
  $("input[name='radioB']").change(function () {
    // Oculto todos los formularios
    $("#formDuracion, #formPrecio").hide(1000);
    // Limpio la tabla de resultados
    $("#tablaCursos").empty();
    // Oculto la tabla de resultados
    $("#tablaResultados").hide(1000);

    // Verifico cuál de los radio buttons está seleccionado
    if ($("#porDuracion").is(":checked")) {
      $("#formDuracion").show();
      $("#btnBuscarDuracion").click(lanzarPeticionDuracion);
    } else if ($("#porPrecio").is(":checked")) {
      $("#formPrecio").show();
      $("#btnBuscarPrecio").click(lanzarPeticionPrecio);
    }
  });
  // LLamo a la función para verificar que solo ingresen números
  $("#precioMaximo").on("keydown", verificarNumero);
  $("#duracionMin").on("keydown", verificarNumero);
  $("#duracionMax").on("keydown", verificarNumero);
  // Para limitar los inputs a solo numeros
  function verificarNumero(e) {
    // Permitir números (ASCII 48-57) y teclas de retroceso (8) y suprimir (46) y tab (9)
    if (
      (e.keyCode < 48 || e.keyCode > 57) &&
      e.keyCode !== 8 &&
      e.keyCode !== 46 &&
      e.keyCode !== 9
    ) {
      // Si no es número, no hace nada
      e.preventDefault();
    }
  }

  function lanzarPeticionPrecio() {
    let url = "FrontController";
    $.get(
      url,
      {
        operation: "doBuscarPorPrecio",
        precioMaximo: $("#precioMaximo").val(),
      },
      function (data) {
        let tabla = `<table class="table table-success table-striped"><thead><tr><th>NOMBRE</th><th>DURACIÓN</th><th>PRECIO</th></tr></thead><tbody>`;
        $.each(data, function (i, curso) {
          tabla += `<tr><td>${curso.nombre}</td><td>${curso.duracion}</td><td>${curso.precio}</td></tr>`;
        });
        tabla += `</tbody></table>`;
        $("#tablaCursos").html(tabla);
        $("#precioMaximo").val("");
      }
    );
  }

  function lanzarPeticionDuracion() {
    let url = "FrontController";
    $.get(
      url,
      {
        operation: "doBuscarPorDuracion",
        duracionMin: $("#duracionMin").val(),
        duracionMax: $("#duracionMax").val(),
      },
      function (data) {
        let tabla = `<table class="table table-success table-striped"><thead><tr><th>NOMBRE</th><th>DURACIÓN</th><th>PRECIO</th></tr></thead><tbody>`;
        $.each(
          data,

          function (i, curso) {
            tabla += `<tr><td>${curso.nombre}</td><td>${curso.duracion}</td><td>${curso.precio}</td></tr>`;
          }
        );
        tabla += `</tbody></table>`;
        $("#tablaCursos").html(tabla);
        $("#duracionMin").val("");
        $("#duracionMax").val("");
      }
    );
  }
});
