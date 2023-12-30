<!DOCTYPE html>
<html>
<head>
<title>Electronic Art</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
#thumb{
	width: 100px;
	height: auto;
}
</style>
<?php
                // Conexión a la base de datos
                $conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

                // Verificar la conexión
                if (!$conn) {
                    die("Error al conectar a la base de datos: " . mysqli_connect_error());
                }
?>
<?php
$query1 = "SELECT * From cliente;";
$resultset1 = mysqli_query($conn,$query1);
?>
<?php
$query2 = "SELECT * From articulos;";
$resultset2 = mysqli_query($conn,$query2);
?>
</head>
<body>
<nav>
    <?php include('Menu.php');?>
</nav>
<div class="container">
    <div class="row">
        <h1>Electronic Art</h1>
        <div class="container">
            <div class="row">
                <h4>Hacer una Venta</h4>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <form method="get" action="carrito_total.php" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2">Cliente</label>
                        <select name="idCliente" class="form-control">
                            <option value="" selected>Seleccionar Cliente</option>
                            <?php 
                                while($row = $resultset1 -> fetch_assoc())
                                {
                                    $id_cl = $row['idCliente'];
                                    $name_cliente = $row['Nombre'];
                                    $apellido_cliente = $row['Apellidos'];
                                    echo "<option value='$id_cl'>$id_cl.&nbsp;$name_cliente&nbsp;$apellido_cliente</option>";
                                }
                            ?>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2">Artículo</label>
                        <select name="idArt" class="form-control">
                            <option value="" selected>Seleccionar Artículo</option>
                            <?php 
                                while($row = $resultset2 -> fetch_assoc())
                                {
                                    $id_art = $row['idArt'];
                                    $name_art = $row['NombreArt'];
                                    $precio = $row['Precio'];
                                    echo "<option value='$id_art'>$id_art.&nbsp;$name_art&nbsp;Precio($ $precio)</option>";
                                }
                            ?>
                        </select>
                    </div>
                    <div class="form-group">
    								<label class="col-sm-2">Fecha Venta:</label>
    								<div class="col-sm-10">
        						<input type="text" value="<?php echo date('Y-m-d'); ?>" readonly class="form-control">
    								</div>
															</div>

                    <div class="form-group">
                        <label class="col-sm-2">Cantidad:</label>
                        <input type="number" name="Cantidad" class="form-control " step="1" style="width:80px;">
                    </div>
                    <div class="form-group">
                        <input type="submit" name="submit" class="btn btn-success"                         value="Continuar">
                        <input type="button" value="Regresar" onclick="history.back()" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

