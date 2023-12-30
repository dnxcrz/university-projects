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
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir Artículo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<?php include 'menu.php'; ?>
    <div class="container">
        

        <h1 class="display-4">Añadir Artículo</h1>

        <form action="guardar_articulo.php" method="POST">
            <div class="row mb-3">
                <label for="nombreArticulo" class="col-sm-2 col-form-label fs-4">Nombre del Artículo</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control form-control-lg" id="nombreArticulo" name="nombreArticulo" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="descripcionArticulo" class="col-sm-2 col-form-label fs-4">Descripción del Artículo</label>
                <div class="col-sm-10">
                    <textarea class="form-control form-control-lg" id="descripcionArticulo" name="descripcionArticulo" rows="3" required></textarea>
                </div>
            </div>
            <div class="row mb-3">
                <label for="imagenArticulo" class="col-sm-2 col-form-label fs-4">Imagen del Artículo</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control form-control-lg" id="imagenArticulo" name="imagenArticulo" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="categoria" class="col-sm-2 col-form-label fs-4">Categoría</label>
                <div class="col-sm-10">
                    <select class="form-select form-select-lg" id="categoria" name="categoria" required>
                        <option value="" selected>Seleccionar Categoría</option>
                        <?php
                        // Iterar sobre los resultados de las categorías
                        while ($row = mysqli_fetch_assoc($result)) {
                            $idCat = $row['idCat'];
                            $nombreCat = $row['NombreCat'];
                            echo "<option value='$idCat'>$idCat. $nombreCat</option>";
                        }
                        ?>
                    </select>
                </div>
            </div>
            <div class="row mb-3">
                <label for="precio" class="col-sm-2 col-form-label fs-4">Precio</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control form-control-lg" id="precio" name="precio" step="0.01" required>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary btn-lg">Guardar</button>
                    <input type="button" value="Regresar" onclick="history.back()" class="btn btn-primary btn-lg">
                </div>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
