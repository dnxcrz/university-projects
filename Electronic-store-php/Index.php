<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD de Artículos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<?php include 'menu.php'; ?>
    <div class="container">
        

        <h1>Lista de Artículos</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Imagen</th>
                    <th>Categoría</th>
                    <th>Precio</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php
                // Conexión a la base de datos
                $conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

                // Verificar la conexión
                if (!$conn) {
                    die("Error al conectar a la base de datos: " . mysqli_connect_error());
                }

                // Consulta para obtener todos los artículos
                $query = "SELECT * FROM articulos";
                $result = mysqli_query($conn, $query);

                // Iterar sobre los resultados y mostrar los registros en la tabla
                while ($row = mysqli_fetch_assoc($result)) {
                    echo "<tr>";
                    echo "<td>" . $row['idArt'] . "</td>";
                    echo "<td>" . $row['NombreArt'] . "</td>";
                    echo "<td>" . $row['DescripcionArt'] . "</td>";
                    echo "<td><img src='" . $row['ImageArt'] . "' width='50' height='50'></td>";
                    echo "<td>" . $row['IdCat'] . "</td>";
                    echo "<td>$" . $row['Precio'] . "</td>";
                    echo "<td>";
                    echo "<a href='editar.php?id=" . $row['idArt'] . "' class='btn btn-primary'>Editar</a>";
                    echo " <a href='eliminar.php?id=" . $row['idArt'] . "' class='btn btn-danger' onclick='return confirm(\"¿Estás seguro de eliminar este artículo?\")'>Eliminar</a>";
                    echo "</td>";
                    echo "</tr>";
                }

                // Cerrar la conexión a la base de datos
                mysqli_close($conn);
                ?>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
