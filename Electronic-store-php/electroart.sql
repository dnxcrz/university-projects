-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2023 at 02:44 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electroart`
--

-- --------------------------------------------------------

--
-- Table structure for table `articulos`
--

CREATE TABLE `articulos` (
  `idArt` int(10) NOT NULL,
  `NombreArt` varchar(50) NOT NULL,
  `DescripcionArt` text NOT NULL,
  `ImageArt` varchar(500) NOT NULL,
  `IdCat` int(10) NOT NULL,
  `Precio` decimal(13,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `articulos`
--

INSERT INTO `articulos` (`idArt`, `NombreArt`, `DescripcionArt`, `ImageArt`, `IdCat`, `Precio`) VALUES
(1, 'Dell Latitude', 'Computadora Laptop', 'https://cdn0.tnwcdn.com/wp-content/blogs.dir/1/files/2019/01/1-2.jpg', 1, '999.99'),
(2, 'Apple Ipad Pro', 'Tableta Apple 14', 'https://images-na.ssl-images-amazon.com/images/I/61ovkSA9p4L._AC_SL1500_.jpg', 1, '999.99'),
(3, 'Iphone 11 pro', 'Smartphone Apple 11', 'https://i.blogs.es/1a4e70/iphone-11-pro-trasera-02/1366_2000.jpg', 2, '999.95'),
(4, 'Samsung TV OLED 75', 'Televisor pantalla plana de 75', 'https://cdn.pocket-lint.com/r/s/970x/assets/images/137516-tv-news-samsung-says-no-to-oled-tvs-for-2017-something-else-is-coming-image1-yVo8OTFXl6.jpg?', 3, '1295.95'),
(5, 'Desktop Dell Precision', 'Computadora de Escritorio', 'https://images-na.ssl-images-amazon.com/images/I/71bhh2K2E3L._AC_SL1500_.jpg', 1, '999.99'),
(10, 'Google Pixel 7', 'Telefono Inteligente', 'https://lh3.googleusercontent.com/HHGNtOSLNrgQY8SeYQOIhlSCxKxnKyWoZZk_4fkVhfy-KVgktEFJzVgWDrmbKjiO4DXDPrj6os9XnhR4U484GZh2qym6Lm1Avw=rw-e365-w2880', 2, '599.99'),
(12, 'Apple Watch Ultra', 'Reloj Inteligente', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/watch-ultra-digitalmat-gallery-3-202209_GEO_US?wid=364&hei=333&fmt=png-alpha&.v=1661557390611', 2, '499.99');

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `idCat` int(10) NOT NULL,
  `NombreCat` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`idCat`, `NombreCat`) VALUES
(1, 'Computadora'),
(2, 'Phones'),
(3, 'TV');

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(10) NOT NULL,
  `Nombre` varchar(60) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Tel` varchar(15) NOT NULL,
  `Email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`idCliente`, `Nombre`, `Apellidos`, `Tel`, `Email`) VALUES
(1, 'Sunchine', 'Logroño', '787-838-8838', 'suchine@wapa.tv'),
(2, 'José', 'Agrelot', '787-232-6738', 'jagrelot@wapa.tv'),
(3, 'Raymond', 'Arrieta', '939-123-4567', 'arrieta@wapa.tv'),
(4, 'Jossué', 'Morales', '7878910925', 'jomorales@ag.inter.edu'),
(6, 'Dayna', 'Salguero Aguiar', '7878888888', 'daynammia@hotmail.com'),
(7, 'dionix', 'cruz', '', 'dionixcruz@gmail.com'),
(8, 'Dionix', 'Cruz', '7873255430', 'dionixcruz@gmail.com'),
(9, 'Vilmarie', 'Maestre', '787-222-6792', 'vilmariemaestre@gmail.com'),
(10, 'Flash', 'Gordon', '7873235698', 'flashgordon@gmail.com'),
(11, 'Bruce', 'banner', '7873549997', 'thehulk@gmail.com'),
(12, 'Steve', 'Jobs', '99999999', 'sjobs@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `procventa`
--

CREATE TABLE `procventa` (
  `idProceso` int(10) NOT NULL,
  `idVenta` int(10) NOT NULL,
  `SubTotal` decimal(13,2) NOT NULL,
  `Impuesto` decimal(13,2) NOT NULL,
  `Total` decimal(13,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `procventa`
--

INSERT INTO `procventa` (`idProceso`, `idVenta`, `SubTotal`, `Impuesto`, `Total`) VALUES
(14, 134, '999.95', '114.99', '1114.94'),
(18, 138, '2999.97', '345.00', '3344.97'),
(19, 139, '1295.95', '149.03', '1444.98'),
(20, 140, '1999.98', '230.00', '2229.98'),
(21, 141, '1999.90', '229.99', '2229.89'),
(22, 142, '999.95', '114.99', '1114.94'),
(23, 143, '999.99', '115.00', '1114.99'),
(24, 143, '999.99', '115.00', '1114.99'),
(25, 143, '999.99', '115.00', '1114.99'),
(26, 144, '999.99', '115.00', '1114.99'),
(27, 145, '999.99', '115.00', '1114.99'),
(28, 174, '4999.95', '574.99', '5574.94'),
(29, 174, '4999.95', '574.99', '5574.94'),
(30, 176, '2999.95', '344.99', '3344.94'),
(31, 177, '4999.90', '574.99', '5574.89');

-- --------------------------------------------------------

--
-- Table structure for table `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(10) NOT NULL,
  `FechaCompra` date NOT NULL,
  `idArt` int(10) NOT NULL,
  `idCliente` int(10) NOT NULL,
  `Cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `venta`
--

INSERT INTO `venta` (`idVenta`, `FechaCompra`, `idArt`, `idCliente`, `Cantidad`) VALUES
(134, '2019-11-10', 4, 3, 1),
(138, '2019-11-10', 1, 1, 3),
(139, '2019-11-11', 4, 4, 1),
(140, '2019-11-12', 3, 2, 2),
(141, '2019-11-16', 1, 3, 2),
(142, '2019-11-23', 4, 3, 1),
(143, '2019-11-10', 4, 2, 1),
(144, '2019-11-10', 4, 2, 1),
(145, '2019-11-10', 1, 2, 1),
(146, '0000-00-00', 0, 0, 0),
(147, '2023-05-15', 1, 1, 1),
(148, '2023-05-15', 1, 1, 1),
(149, '2023-05-15', 1, 1, 1),
(150, '2023-05-15', 1, 1, 1),
(151, '2023-05-15', 1, 1, 1),
(152, '0000-00-00', 2, 1, 1),
(153, '0000-00-00', 2, 1, 1),
(154, '0000-00-00', 2, 1, 1),
(155, '0000-00-00', 2, 1, 1),
(156, '0000-00-00', 2, 1, 1),
(157, '0000-00-00', 2, 1, 1),
(158, '0000-00-00', 2, 1, 1),
(159, '0000-00-00', 2, 1, 1),
(160, '2023-05-15', 2, 1, 1),
(161, '2023-05-15', 2, 1, 1),
(162, '2023-05-15', 2, 1, 1),
(163, '2023-05-15', 2, 1, 1),
(164, '2023-05-15', 2, 1, 1),
(165, '2023-05-15', 2, 1, 1),
(166, '2023-05-15', 2, 1, 1),
(167, '2023-05-15', 2, 1, 1),
(168, '2023-05-15', 2, 1, 1),
(169, '2023-05-15', 1, 1, 1),
(170, '2023-05-16', 2, 2, 2),
(171, '2023-05-16', 1, 1, 1),
(172, '2023-05-16', 0, 0, 0),
(173, '2023-05-16', 1, 1, 1),
(174, '2023-05-16', 1, 1, 5),
(175, '2023-05-16', 9, 10, 2),
(176, '2023-05-16', 10, 11, 5),
(177, '2023-05-16', 12, 12, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`idArt`);

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCat`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indexes for table `procventa`
--
ALTER TABLE `procventa`
  ADD PRIMARY KEY (`idProceso`);

--
-- Indexes for table `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articulos`
--
ALTER TABLE `articulos`
  MODIFY `idArt` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCat` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `procventa`
--
ALTER TABLE `procventa`
  MODIFY `idProceso` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=178;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
