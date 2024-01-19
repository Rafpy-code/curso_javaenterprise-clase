$(document).ready(function () {
  // Detecto que radio button está seleccionado y muestro el formulario correspondiente
  $("input[name='radioB']").change(function () {
    //
    $("input[name='radioB']").change(function () {
      // Oculto todos los formularios
      $("#formDuracion, #formPrecio").hide();

      // Limpio la tabla de resultados
      $("#tablaCursos").empty();
      // Oculto la tabla de resultados
      $("#tablaResultados").hide();

      // Verifico cuál de los radio buttons está seleccionado
      if ($("#porDuracion").is(":checked")) {
        $("#formDuracion").show();
        // LLamo a la función para verificar que solo ingresen números
        $("#duracionMin").addEventListener("keypress", verificarNumero);
        $("#duracionMax").addEventListener("keypress", verificarNumero);
        $("#btnBuscarDuracion").click(lanzarPeticionDuracion);
      } else if ($("#porPrecio").is(":checked")) {
        $("#formPrecio").show();

        // LLamo a la función para verificar que solo ingresen números
        $("#precioMaximo").addEventListener("keypress", verificarNumero);
        $("#btnBuscarPrecio").click(lanzarPeticionPrecio);
      }
    });

    // Para limitar los inputs a solo numeros
    function verificarNumero(e) {
      // tabla ASCII  números
      if (e.key < 48 || e.key > 57) {
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
          let tabla = `<table><thead><th>NOMBRE</th><th>DURACIÓN</th><th>PRECIO</th></thead><tbody>`;
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
          let tabla = `<table><thead><th>NOMBRE</th><th>DURACIÓN</th><th>PRECIO</th></thead><tbody>`;
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
});

/*
        $("#duracionMaxima").keypress(function (e) {
          // tabla ASCII nullo, retroceso, punto y números
          if (
            e.which != 8 &&
            e.which != 0 &&
            e.which != 46 &&
            (e.which < 48 || e.which > 57)
          ) {
            return false;
          }
        });
        //Para limitar los inputs a solo numeros
        $("#precioMaximo").keypress(function (e) {
          // tabla ASCII nullo, retroceso y números
          if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
            return false;
          }
        });
*/
