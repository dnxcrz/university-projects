<?php
// Conexión a la base de datos
$conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

// Verificar la conexión
if (!$conn) {
    die("Error al conectar a la base de datos: " . mysqli_connect_error());
}

//Variables
$fecha = $_POST['fechaVenta'];
$idcliente = $_POST['cliente'];
$idart = $_POST['articulo'];
$cantidad = $_POST['cantidad'];

//SQL
$sql = "INSERT INTO venta (FechaCompra, idArt, idCliente, Cantidad)
VALUES ('$fecha', '$idart', '$idcliente', '$cantidad')";

// Ejecutar la consulta
if (mysqli_query($conn, $sql)) {
    $last_id = mysqli_insert_id($conn);
    echo "New record created successfully. Last inserted ID is: " . $last_id;
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

// Buscar todos los campos en la tabla articulos donde el id es igual al artículo seleccionado en la compra.
$sql2 = "SELECT * FROM articulos WHERE idArt = $idart";
$result = mysqli_query($conn, $sql2);
while ($row = mysqli_fetch_assoc($result)) {
    $nombreart = $row['NombreArt'];
    $descr = $row['DescripcionArt'];
    $imagen = $row['ImageArt'];
    $precio = $row['Precio'];
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Electronic Art</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #thumb {
            width: 100px;
            height: auto;
        }
    </style>
</head>
<body>
<nav>
    <?php include('Menu.php'); ?>
</nav>
<div class="container">
    <div class="row">
        <h1>Electronic Art</h1>
        <div class="container">
            <div class="row">
                <h2>Carrito de Compra</h2>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <h2>Producto</h2>
                <div class="container">
                    <div class="row">
                        <h4><?php echo $nombreart; ?></h4>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <img src="<?php echo $imagen; ?>" class="rounded" style="width:400px; height:auto;">
                    </div>
                </div>
            </div>
        </div>
        <form name="ventatotal" method="POST" action="ventatotal.php?Getid=<?php echo $last_id; ?>"
              class="form-horizontal">
            <input type="hidden" name="idVenta" value="<?php echo $last_id; ?>">
            <div class="form-group">
<label class="col-sm-2">Cantidad: </label> <output class="form-control"><?php echo $cantidad; ?></output>
</div>
<div class="form-group">
<label class="col-sm-2">SubTotal: </label><span class="input-group-text">$</span><input type="text" name="SubTotal" class="form-control Currency" style="width:200px;"
                                                                                                            value="<?php $subtotal = $precio * $cantidad;
                                                                                                            $subtotal = number_format($subtotal, 2, '.', '');
                                                                                                            echo $subtotal; ?>" readonly>
</div>
<div class="form-group">
<label class="col-sm-2">Impuesto (IVU): </label><span class="input-group-text">$</span><input type="text" name="Impuesto" class="form-control Currency" style="width:200px;"
                                                                                                              value="<?php $impuesto = $subtotal * .115;
                                                                                                              $impuesto = number_format($impuesto, 2, '.', '');
                                                                                                              echo $impuesto; ?>" readonly>
</div>
<div class="form-group">
<label class="col-sm-2">Total: </label><span class="input-group-text">$</span><input type="text" name="Total" class="form-control Currency" style="width:200px;" value="<?php
             $total = $subtotal + $impuesto;
             $total = number_format($total, 2, '.', '');
             echo $total; ?>" readonly>
</div>
<div class="form-group">
<input type="submit" name="submit" class="btn btn-success" value="Comprar">
<input type="button" value="Regresar" onclick="history.back()" class="btn btn-primary">
</div>
</form>
</div>

</div>
<?php
$conn->close();
?>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
