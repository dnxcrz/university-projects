<?php
// Conexión a la base de datos
$conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

// Verificar la conexión
if (!$conn) {
    die("Error al conectar a la base de datos: " . mysqli_connect_error());
}

// Verificar si se ha enviado el formulario
if (isset($_POST['submit'])) {
    // Obtener los datos del formulario
    $nombreCliente = $_POST['nombreCliente'];
    $apellidosCliente = $_POST['apellidosCliente'];
    $tel = $_POST['telefonoCliente'];
    $emailCliente = $_POST['emailCliente'];

    // Insertar el nuevo cliente en la base de datos
    $query = "INSERT INTO cliente (Nombre, Apellidos, Tel, Email) VALUES ('$nombreCliente', '$apellidosCliente', '$tel', '$emailCliente')";
    if (mysqli_query($conn, $query)) {
        // Mostrar alerta en JavaScript
        echo "<script>alert('Cliente agregado correctamente.');</script>";
    } else {
        echo "Error al agregar el cliente: " . mysqli_error($conn);
    }
}

// Cerrar la conexión a la base de datos
mysqli_close($conn);
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Añadir Cliente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        #thumb {
            width: 100px;
            height: auto;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.php"style="color: black;">Portada</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addarticulo.php"style="color: black;">Entrar Articulo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="crear_cliente.php"style="color: black;">Añadir Cliente</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="crear_venta.php"style="color: black;">Crear Venta</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listado_ventas.php"style="color: black;">Listado de Ventas</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <h1>Añadir Cliente</h1>
    </div>
    <div class="row">
        <form method="post" action="crear_cliente.php" class="col-md-6 offset-md-3">
            <div class="mb-3">
                <label for="nombreCliente" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombreCliente" name="nombreCliente" required>
            </div>
            <div class="mb-3">
                <label for="apellidosCliente" class="form-label">Apellidos</label>
                <input type="text" class="form-control" id="apellidosCliente" name="apellidosCliente" required>
            </div>
            <div class="mb-3">
                <label for="telefonoCliente" class="form-label">Teléfono</label>
                <input type="text" class="form-control" id="telefonoCliente" name="telefonoCliente" required>
            </div>
            <div class="mb-3">
                <label for="emailCliente" class="form-label">Email</label>
                <input type="email" class="form-control" id="emailCliente" name="emailCliente" required>
            </div>
            <div class="mb-3">
                <button type="submit" name="submit" class="btn btn-primary">Agregar Cliente</button>
<input type="button" value="Regresar" onclick="history.back()" class="btn btn-primary">

</div>
</form>
</div>
</div>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>
</body>
</html>