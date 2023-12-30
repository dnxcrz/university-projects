<?php
// Conexión a la base de datos
$conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

// Verificar la conexión
if (!$conn) {
    die("Error al conectar a la base de datos: " . mysqli_connect_error());
}

// Consulta para obtener las categorías
$query = "SELECT * FROM categoria";
$result = mysqli_query($conn, $query);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir Artículo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <?php include 'menu.php'; ?>

        <h1>Añadir Artículo</h1>

        <form action="guardar_articulo.php" method="POST">
            <div class="mb-3">
                <label for="nombreArticulo" class="form-label">Nombre del Artículo</label>
                <input type="text" class="form-control" id="nombreArticulo" name="nombreArticulo" required>
            </div>
            <div class="mb-3">
                <label for="descripcionArticulo" class="form-label">Descripción del Artículo</label>
                <textarea class="form-control" id="descripcionArticulo" name="descripcionArticulo" rows="3" required></textarea>
            </div>
            <div class="mb-3">
                <label for="imagenArticulo" class="form-label">Imagen del Artículo</label>
                <input type="text" class="form-control" id="imagenArticulo" name="imagenArticulo" required>
            </div>
            <div class="mb-3">
                <label for="categoria" class="form-label">Categoría</label>
                <select class="form-select" id="categoria" name="categoria" required>
                    <option value="" selected>Seleccionar Categoría</option>
                    <?php
                    // Consulta para obtener las categorías
                    $query = "SELECT * FROM categoria";
                    $result = mysqli_query($conn, $query);

                    // Iterar sobre los resultados de las categorías
                    while ($row = mysqli_fetch_assoc($result)) {
                        $idCat = $row['idCat'];
                        $nombreCat = $row['NombreCat'];
                        echo "<option value='$idCat'>$idCat. $nombreCat</option>";
                    }
                    ?>
                </select>
            </div>
            <div class="mb-3">
                <label for="precio" class="form-label">Precio</label>
                <input type="number" class="form-control" id="precio" name="precio" step="0.01" required>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
            <input type="button" value="Regresar" onclick="history.back()" class="btn btn-primary">
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
