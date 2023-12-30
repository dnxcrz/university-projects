<?php
// Conexión a la base de datos
$conn = mysqli_connect('localhost', 'root', 'Gigabyte01', 'electroart');

// Verificar la conexión
if (!$conn) {
    die("Error al conectar a la base de datos: " . mysqli_connect_error());
}

$idventa = $_GET['Getid'];
$subtotal = $_POST['SubTotal'];
$impuesto = $_POST['Impuesto'];
$total = $_POST['Total'];
$sql = "INSERT INTO procventa (idVenta, SubTotal, Impuesto, Total)
VALUES ('$idventa', '$subtotal', '$impuesto', '$total')";
?>
<html>
 <head>
 <meta charset="UTF-8">
 <title>Modificar usuario</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 </head>
<body>
<header>
</header>
<nav>
<?php include('Menu.php');?>
</nav>
<?php
if ($conn->query($sql) === TRUE) {
 echo "<h2>New record created successfully</h2>";
} else {
 echo "Error: " . $sql . "<br>" . $conn->error;
}
?>

<?php
mysqli_close($conn);
?>
 </body>
</html>