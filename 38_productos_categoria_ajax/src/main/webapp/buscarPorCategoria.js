$("#btnMostrar").click(lanzarPeticion);

function lanzarPeticion() {
    //let url="FrontController?operation=doBuscarPorCategoria&categoria="+$("#categoria").val();
    let url="FrontController";
    $.get(url, {"operation":"doBuscarPorCategoria", "categoria":$("#categoria").val()} , function(data){
        let tabla=`<table><thead><th>NOMBRE</th><th>PRECIO</th></thead><tbody>`;
        $.each(data, function (i, producto){
          tabla += `<tr><td>${producto.nombre}</td><td>${producto.precio}</td></tr>`;
        });
        tabla += `</tbody></table>`;
        $("#tbProductos").html(tabla);
        $("#categoria").val("");
    });
}