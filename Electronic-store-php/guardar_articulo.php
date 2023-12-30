<html>
 <head>
 <meta charset="UTF-8">
 <title>Guardar Articulo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 </head>
<?php include('Menu.php');?>
<?php
// Conexión a la base de datos
$conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

// Verificar la conexión
if (!$conn) {
    die("Error al conectar a la base de datos: " . mysqli_connect_error());
}

// Obtener los datos del formulario
$nombreArticulo = $_POST['nombreArticulo'];
$descripcionArticulo = $_POST['descripcionArticulo'];
$imagenArticulo = $_POST['imagenArticulo'];
$categoriaArticulo = $_POST['categoria'];
$precioArticulo = $_POST['precio'];

// Insertar el nuevo artículo en la base de datos
$query = "INSERT INTO articulos (NombreArt, DescripcionArt, ImageArt, IdCat, Precio) VALUES ('$nombreArticulo', '$descripcionArticulo', '$imagenArticulo', '$categoriaArticulo', '$precioArticulo')";

if (mysqli_query($conn, $query)) {
    echo "El artículo se ha guardado correctamente.";
} else {
    echo "Error al guardar el artículo: " . mysqli_error($conn);
}

// Cerrar la conexión a la base de datos
mysqli_close($conn);
?>