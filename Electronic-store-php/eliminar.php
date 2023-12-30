<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Guardar Articulo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .confirmation-text {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<?php include('Menu.php');?>
<div class="container">
<?php
// Conexión a la base de datos
$conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

// Verificar la conexión
if (!$conn) {
    die("Error al conectar a la base de datos: " . mysqli_connect_error());
}

// Verificar si se ha proporcionado un ID de artículo válido
if (isset($_GET['id'])) {
    $idArticulo = $_GET['id'];

    // Consulta para obtener los datos del artículo a eliminar
    $query = "SELECT * FROM articulos WHERE idArt = $idArticulo";
    $result = mysqli_query($conn, $query);

    // Verificar si el artículo existe
    if (mysqli_num_rows($result) > 0) {
        // Mostrar una advertencia antes de eliminar el artículo
        echo "¿Estás seguro de eliminar este artículo?<br>";
        echo "<a href='eliminar.php?id=$idArticulo&confirm=true'>Sí, eliminar</a> | ";
        echo "<a href='index.php'>Cancelar</a>";

        // Verificar si se ha confirmado la eliminación del artículo
        if (isset($_GET['confirm']) && $_GET['confirm'] == "true") {
            // Eliminar el artículo de la base de datos
            $deleteQuery = "DELETE FROM articulos WHERE idArt = $idArticulo";
            mysqli_query($conn, $deleteQuery);

            echo "<br>El artículo ha sido eliminado correctamente.";
        }
    } else {
        echo "El artículo no existe.";
    }
} else {
    echo "No se ha proporcionado un ID de artículo válido.";
}

// Cerrar la conexión a la base de datos
mysqli_close($conn);
?>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>