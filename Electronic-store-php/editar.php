<?php
// Conexión a la base de datos
$conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

// Verificar la conexión
if (!$conn) {
    die("Error al conectar a la base de datos: " . mysqli_connect_error());
}

// Obtener el ID del artículo a editar
$idArticulo = $_GET['id'];

// Consulta para obtener la información del artículo a editar
$query = "SELECT * FROM articulos WHERE idArt = $idArticulo";
$result = mysqli_query($conn, $query);

// Verificar si se encontró el artículo
if (mysqli_num_rows($result) == 0) {
    echo "No se encontró el artículo.";
    exit;
}

// Obtener los datos del artículo
$row = mysqli_fetch_assoc($result);
$nombreArticulo = $row['NombreArt'];
$descripcionArticulo = $row['DescripcionArt'];
$imagenArticulo = $row['ImageArt'];
$categoriaArticulo = $row['IdCat'];
$precioArticulo = $row['Precio'];

// Consulta para obtener las categorías
$queryCategorias = "SELECT * FROM categoria";
$resultCategorias = mysqli_query($conn, $queryCategorias);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Artículo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <?php include 'menu.php'; ?>

        <h1>Editar Artículo</h1>

        <form action="actualizar_articulo.php" method="POST">
            <input type="hidden" name="idArticulo" value="<?php echo $idArticulo; ?>">
            <div class="mb-3">
                <label for="nombreArticulo" class="form-label">Nombre del Artículo</label>
                <input type="text" class="form-control" id="nombreArticulo" name="nombreArticulo" value="<?php echo $nombreArticulo; ?>" required>
            </div>
            <div class="mb-3">
                <label for="descripcionArticulo" class="form-label">Descripción del Artículo</label>
                <textarea class="form-control" id="descripcionArticulo" name="descripcionArticulo" rows="3" required><?php echo $descripcionArticulo; ?></textarea>
            </div>
            <div class="mb-3">
                <label for="imagenArticulo" class="form-label">Imagen del Artículo</label>
                <input type="text" class="form-control" id="imagenArticulo" name="imagenArticulo" value="<?php echo $imagenArticulo; ?>" required>
            </div>
            <div class="mb-3">
                <label for="categoria" class="form-label">Categoría</label>
                <select class="form-select" id="categoria" name="categoria" required>
                    <option value="" selected>Seleccionar Categoría</option>
                    <?php
                    // Iterar sobre los resultados de las categorías
                    while ($rowCategoria = mysqli_fetch_assoc($resultCategorias)) {
                        $idCat = $rowCategoria['idCat'];
                        $nombreCat = $rowCategoria['NombreCat'];
                        $selected =                        ($idCat == $categoriaArticulo) ? "selected" : "";
                        echo "<option value='$idCat' $selected>$idCat. $nombreCat</option>";
                    }
                    ?>
                </select>
            </div>
            <div class="mb-3">
                <label for="precio" class="form-label">Precio</label>
                <input type="number" class="form-control" id="precio" name="precio" step="0.01" value="<?php echo $precioArticulo; ?>" required>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
            <input type="button" value="Regresar" onclick="history.back()" class="btn btn-primary">
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>

