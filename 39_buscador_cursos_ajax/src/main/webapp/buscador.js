$("#btnBuscarPrecio").click(lanzarPeticionPrecio);
$("#btnBuscarDuracion").click(lanzarPeticionDuracion);

function lanzarPeticionPrecio() {
    let url="FrontController";
    $.get(url, {"operation":"doBuscarPorPrecio", "precioMaximo":$("#precioMaximo").val()} , function(data){
        let tabla=`<table><thead><th>NOMBRE</th><th>PRECIO</th></thead><tbody>`;
        $.each(data, function (i, producto){
          tabla += `<tr><td>${producto.nombre}</td><td>${producto.precio}</td></tr>`;
        });
        tabla += `</tbody></table>`;
        $("#tbProductos").html(tabla);
        $("#categoria").val("");
    });
}

function lanzarPeticionDuracion() {
    let url="FrontController";
    $.get(url, {"operation":"doBuscarPorDuracion", "categoria":$("#categoria").val()} , function(data){
        let tabla=`<table><thead><th>NOMBRE</th><th>PRECIO</th></thead><tbody>`;
        $.each(data, function (i, producto){
          tabla += `<tr><td>${producto.nombre}</td><td>${producto.precio}</td></tr>`;
        });
        tabla += `</tbody></table>`;
        $("#tbProductos").html(tabla);
        $("#categoria").val("");
    });
}
