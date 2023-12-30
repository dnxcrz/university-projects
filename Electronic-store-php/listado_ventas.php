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
    </style>
</head>
<body>
<?php
// Conexión a la base de datos
$conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

// Verificar la conexión
if (!$conn) {
    die("Error al conectar a la base de datos: " . mysqli_connect_error());
}
?>
<nav>
    <?php include 'Menu.php'; ?>
</nav>
<div class="container">
    <div class="row">
        <h1>Electronic Art</h1>
        <div class="container">
            <div class="row">
                <h2>Listado de Ventas</h2>
            </div>
        </div>
        <?php
        $query = "SELECT * From procventa;";
        $result = mysqli_query($conn, $query);
        ?>
        <table class="table table-striped table-hover table-bordered">
            <tr>
                <th>ID Venta</th>
                <th>SubTotal</th>
                <th>Impuesto</th>
                <th>Total</th>
            </tr>
            <?php
            while ($row = mysqli_fetch_assoc($result)) {
                // Buscar valores de los campos en la base de datos y guardarlos en variables.
                $idventa = $row['idVenta'];
                $subtotal = $row['SubTotal'];
                $impuesto = $row['Impuesto'];
                $total = $row['Total'];
                ?>
                <tr>
                    <td><a href="detalle-venta.php?Getid=<?php echo $idventa; ?>"><?php echo $idventa; ?></a></td>
                    <td><?php echo $subtotal; ?></td>
                    <td><?php echo $impuesto; ?></td>
                    <td><?php echo $total; ?></td>
                </tr>
                <?php
            }
            ?>
        </table>
    </div>
</div>
</body>
</html>
