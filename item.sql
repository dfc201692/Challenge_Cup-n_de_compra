-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2024 a las 23:51:00
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cupon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item`
--

CREATE TABLE `item` (
  `Item_Id` bigint(20) NOT NULL,
  `description` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `favorite_count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `item`
--

INSERT INTO `item` (`Item_Id`, `description`, `price`, `quantity`, `favorite_count`) VALUES
(1, 'Smartphone Android', 299.99, 20, 17),
(2, 'Laptop de última generación', 899.99, 10, 0),
(3, 'Televisor LED de 55 pulgadas', 699.99, 15, 0),
(4, 'Cámara DSLR profesional', 599.99, 8, 23),
(5, 'Altavoces Bluetooth portátiles', 79.99, 25, 0),
(6, 'Pantalón vaquero de color azul', 29.99, 15, 2),
(7, 'Zapatos deportivos de marca', 9.99, 20, 25),
(8, 'Bolso de cuero sintético', 9.99, 20, 3),
(9, 'Camiseta de algodón de manga corta', 19.99, 10, 27),
(10, 'Gorra de béisbol ajustable', 49.99, 12, 1),
(12, 'Maleta de viaje', 30.86, 540, 50);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`Item_Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `item`
--
ALTER TABLE `item`
  MODIFY `Item_Id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
