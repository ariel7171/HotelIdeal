-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-10-2023 a las 00:38:38
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotelideal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `id_habitacion` int(11) NOT NULL,
  `nroHabitacion` int(11) NOT NULL,
  `descripcion` int(11) NOT NULL,
  `id_tipoDeHabitacion` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`id_habitacion`, `nroHabitacion`, `descripcion`, `id_tipoDeHabitacion`, `piso`, `estado`) VALUES
(1, 101, 1, 1, 1, 1),
(2, 102, 1, 2, 1, 1),
(3, 103, 1, 3, 1, 0),
(4, 104, 1, 4, 1, 1),
(5, 105, 1, 5, 1, 0),
(6, 201, 2, 6, 2, 0),
(7, 202, 2, 7, 2, 0),
(8, 203, 2, 8, 2, 1),
(9, 204, 2, 9, 2, 0),
(10, 205, 2, 10, 2, 1),
(11, 301, 3, 11, 3, 1),
(12, 302, 3, 12, 3, 0),
(13, 303, 3, 13, 3, 1),
(14, 304, 3, 14, 3, 0),
(15, 305, 3, 15, 3, 1),
(16, 401, 4, 16, 4, 1),
(17, 402, 4, 17, 4, 0),
(18, 403, 4, 18, 4, 0),
(19, 404, 4, 19, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `id_huesped` int(11) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `domicilio` varchar(30) NOT NULL,
  `celular` varchar(30) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`id_huesped`, `dni`, `apellido`, `nombre`, `domicilio`, `celular`, `correo`, `estado`) VALUES
(1, '12456789', 'Saez', 'Marina', 'calle 1500', '123456578', 'mari@gmail.com', 1),
(2, '111111111', 'Ruiz', 'Juan', 'calle 2300', '111111111', 'ju@gmail.com', 1),
(3, '23456123', 'Perez', 'Lourdes', 'calle 750', '22222222', 'lu@gmail.com', 0),
(4, '65123789', 'Ramires', 'Pamela', 'calle 3200', '33333333', 'pame@gmail.com', 1),
(5, '78456213', 'Flores', 'Martin', 'calle 620', '4444444', 'martin@gmail.com', 0),
(6, '13123456', 'Fuentes', 'Rodrigo', 'calle 4600', '66666666', 'rodri@gmail.com', 1),
(7, '36789123', 'Roa', 'Franco', 'calle 960', '77777777', 'fran@gmail.com', 0),
(8, '45369852', 'Alarse', 'Elisa', 'calle 230', '66666666', 'eli@gmail.com', 0),
(9, '5555555', 'Palillo', 'Laura', 'calle 6050', '121212121', 'lau@gmail.com', 0),
(10, '45456456', 'Ruiz', 'Diego', 'calle 1050', '88888888', 'lau@gmail.com', 1),
(11, '45451278', 'Saavedra', 'Luna', 'calle 951', '131313131', 'luS@gmail.com', 1),
(12, '65451278', 'Alaniz', 'Francisco', 'calle 4021', '787878787', 'pancho@gmail.com', 0),
(13, '45321278', 'Contreras', 'Luana', 'calle 3032', '989898989', 'lua@gmail.com', 0),
(14, '45459635', 'Zaid', 'Catalina', 'calle 222', '656565656', 'cata@gmail.com', 1),
(15, '78941278', 'Romano', 'Daniel', 'calle 658', '454545456', 'dany@gmail.com', 0),
(16, '54455678', 'Martinez', 'Joaquin', 'calle 4577', '232323232', 'joaS@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `id_habitacion` int(11) NOT NULL,
  `id_huesped` int(11) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `precio` double NOT NULL,
  `cant_personas` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `id_habitacion`, `id_huesped`, `fechaIngreso`, `fechaSalida`, `precio`, `cant_personas`, `estado`) VALUES
(1, 2, 1, '2023-10-10', '2023-10-13', 10000, 2, 0),
(2, 4, 2, '2023-10-21', '2023-10-27', 10000, 2, 1),
(3, 6, 3, '2023-10-23', '2023-10-26', 10000, 1, 1),
(4, 8, 4, '2023-10-28', '2023-10-31', 10000, 2, 1),
(5, 10, 5, '2023-11-01', '2023-11-05', 10000, 1, 0),
(6, 1, 6, '2023-11-01', '2023-11-04', 20000, 3, 0),
(7, 3, 7, '2023-11-06', '2023-11-10', 20000, 2, 0),
(8, 5, 8, '2023-10-16', '2023-10-23', 20000, 1, 1),
(9, 7, 9, '2023-10-21', '2023-10-22', 20000, 2, 1),
(10, 9, 10, '2023-10-23', '2023-10-30', 20000, 3, 0),
(11, 13, 11, '2023-11-03', '2023-11-06', 30000, 2, 0),
(12, 11, 12, '2023-11-10', '2023-11-13', 30000, 4, 1),
(13, 12, 13, '2023-10-20', '2023-10-23', 30000, 6, 1),
(14, 17, 14, '2023-10-13', '2023-10-16', 40000, 2, 1),
(15, 19, 15, '2023-10-20', '2023-10-23', 40000, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodehabitacion`
--

CREATE TABLE `tipodehabitacion` (
  `id_tipoDeHabitacion` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `precioNoche` double NOT NULL,
  `cantKing` int(11) NOT NULL,
  `cantQueen` int(11) NOT NULL,
  `cantSimple` int(11) NOT NULL,
  `cantPersonas` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipodehabitacion`
--

INSERT INTO `tipodehabitacion` (`id_tipoDeHabitacion`, `descripcion`, `precioNoche`, `cantKing`, `cantQueen`, `cantSimple`, `cantPersonas`, `estado`) VALUES
(1, 'simple', 10000, 0, 0, 2, 2, 1),
(2, 'simple', 10000, 0, 1, 0, 2, 0),
(3, 'simple', 10000, 1, 0, 0, 2, 0),
(4, 'simple', 10000, 0, 1, 0, 2, 1),
(5, 'simple', 10000, 0, 0, 1, 1, 1),
(6, 'doble', 20000, 0, 1, 2, 4, 0),
(7, 'doble', 20000, 1, 0, 2, 4, 1),
(8, 'doble', 20000, 1, 1, 0, 4, 0),
(9, 'doble', 20000, 0, 1, 1, 3, 1),
(10, 'doble', 20000, 0, 1, 1, 3, 0),
(11, 'triple', 30000, 1, 1, 2, 6, 1),
(12, 'triple', 30000, 1, 0, 2, 4, 1),
(13, 'triple', 30000, 1, 1, 1, 5, 0),
(14, 'triple', 30000, 0, 1, 3, 5, 1),
(15, 'triple', 30000, 1, 0, 3, 5, 1),
(16, 'suite lujo', 40000, 1, 1, 0, 4, 1),
(17, 'suite lujo', 40000, 1, 0, 1, 3, 0),
(18, 'suite lujo', 40000, 1, 0, 0, 2, 0),
(19, 'suite lujo', 40000, 1, 0, 1, 3, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`id_habitacion`),
  ADD KEY `id_tipoDeHabitacion` (`id_tipoDeHabitacion`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`id_huesped`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `id_habitacion` (`id_habitacion`),
  ADD KEY `id_huesped` (`id_huesped`);

--
-- Indices de la tabla `tipodehabitacion`
--
ALTER TABLE `tipodehabitacion`
  ADD PRIMARY KEY (`id_tipoDeHabitacion`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`id_tipoDeHabitacion`) REFERENCES `tipodehabitacion` (`id_tipoDeHabitacion`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_habitacion`) REFERENCES `habitacion` (`id_habitacion`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_huesped`) REFERENCES `huesped` (`id_huesped`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
