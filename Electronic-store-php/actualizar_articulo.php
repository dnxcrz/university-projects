<!DOCTYPE html>
<html>
<head>
    <title>Electronic Art</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #thumb {
            width: 100px;
            height: auto;
        }
        .message {
            font-weight: bold;
            text-align: center;
            margin-top: 50px;
            font-size: 24px;
        }
    </style>
</head>
<body>
<nav>
    <?php include 'Menu.php'; ?>
</nav>
<?php
// Conexión a la base de datos
$conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

// Verificar la conexión
if (!$conn) {
    die("Error al conectar a la base de datos: " . mysqli_connect_error());
}

// Obtener los datos del formulario
$idArticulo = $_POST['idArticulo'];
$nombreArticulo = $_POST['nombreArticulo'];
$descripcionArticulo = $_POST['descripcionArticulo'];
$imagenArticulo = $_POST['imagenArticulo'];
$categoriaArticulo = $_POST['categoria'];
$precioArticulo = $_POST['precio'];

// Actualizar el artículo en la base de datos
$query = "UPDATE articulos SET NombreArt = '$nombreArticulo', DescripcionArt = '$descripcionArticulo', ImageArt = '$imagenArticulo', IdCat = '$categoriaArticulo', Precio = '$precioArticulo' WHERE idArt = $idArticulo";

if (mysqli_query($conn, $query)) {
    echo "<div class='message'>El artículo se actualizó correctamente.</div>";
} else {
    echo "<div class='message'>Error al actualizar el artículo: " . mysqli_error($conn) . "</div>";
}

// Cerrar la conexión a la base de datos
mysqli_close($conn);
?>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
