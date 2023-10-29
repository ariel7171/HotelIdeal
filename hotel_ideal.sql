-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2023 a las 23:19:27
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel_ideal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
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
(1, 1, 0, 1, 1, 1),
(2, 2, 0, 1, 1, 1),
(3, 3, 0, 1, 1, 1),
(4, 4, 0, 1, 1, 1),
(5, 5, 0, 1, 1, 1),
(6, 6, 0, 1, 1, 1),
(7, 7, 0, 1, 1, 1),
(8, 8, 0, 1, 1, 1),
(9, 9, 0, 1, 1, 1),
(10, 10, 0, 1, 2, 1),
(11, 11, 0, 1, 2, 1),
(12, 12, 0, 1, 2, 1),
(13, 13, 0, 1, 2, 1),
(14, 14, 0, 1, 2, 1),
(15, 15, 0, 1, 2, 1),
(16, 16, 0, 1, 2, 1),
(17, 17, 0, 1, 2, 1),
(18, 18, 0, 1, 2, 1),
(19, 19, 0, 1, 3, 1),
(20, 20, 0, 1, 3, 1),
(21, 21, 0, 1, 3, 1),
(22, 22, 0, 1, 3, 1),
(23, 23, 0, 1, 3, 1),
(25, 25, 0, 1, 3, 1),
(26, 26, 0, 1, 3, 1),
(27, 27, 0, 1, 3, 1),
(28, 28, 0, 1, 3, 1),
(29, 29, 0, 1, 3, 1),
(30, 30, 0, 1, 3, 1),
(31, 31, 0, 1, 4, 1),
(32, 32, 0, 1, 4, 1),
(33, 33, 0, 1, 4, 1),
(34, 34, 0, 1, 4, 1),
(35, 35, 0, 1, 4, 1),
(36, 36, 0, 1, 4, 1),
(37, 37, 0, 1, 4, 1),
(38, 38, 0, 1, 4, 1),
(39, 39, 0, 1, 4, 1),
(40, 40, 0, 1, 4, 1),
(41, 41, 0, 1, 5, 1),
(42, 42, 0, 1, 5, 1),
(43, 43, 0, 1, 5, 1),
(44, 44, 0, 1, 5, 1),
(45, 45, 0, 1, 5, 1),
(46, 46, 0, 1, 5, 1),
(47, 47, 0, 1, 5, 1),
(48, 48, 0, 1, 5, 1),
(49, 49, 0, 1, 5, 1),
(50, 50, 0, 1, 5, 1),
(51, 51, 0, 1, 6, 1),
(52, 52, 0, 1, 6, 1),
(53, 53, 0, 1, 6, 1),
(54, 54, 0, 1, 6, 1),
(55, 55, 0, 1, 6, 1),
(56, 56, 0, 1, 6, 1),
(57, 57, 0, 1, 6, 1),
(58, 58, 0, 1, 6, 1),
(59, 59, 0, 1, 6, 1),
(60, 60, 0, 1, 6, 1),
(61, 61, 0, 1, 7, 1),
(62, 62, 0, 1, 7, 1),
(63, 63, 0, 1, 7, 1),
(64, 64, 0, 1, 7, 1),
(65, 65, 0, 1, 7, 1),
(66, 66, 0, 1, 7, 1),
(67, 67, 0, 1, 7, 1),
(68, 68, 0, 1, 7, 1),
(69, 69, 0, 1, 7, 1),
(70, 70, 0, 1, 7, 1),
(71, 71, 0, 1, 8, 1),
(72, 72, 0, 1, 8, 1),
(73, 73, 0, 1, 8, 1),
(74, 74, 0, 1, 8, 1),
(75, 75, 0, 1, 8, 1),
(76, 76, 0, 1, 8, 1),
(77, 77, 0, 1, 8, 1),
(78, 78, 0, 1, 8, 1),
(79, 79, 0, 1, 8, 1),
(80, 80, 0, 1, 8, 1),
(81, 81, 0, 1, 9, 1),
(82, 82, 0, 1, 9, 1),
(83, 83, 0, 1, 9, 1),
(84, 84, 0, 1, 9, 1),
(85, 85, 0, 1, 9, 1),
(86, 86, 0, 1, 9, 1),
(87, 87, 0, 1, 9, 1),
(88, 88, 0, 1, 9, 1),
(89, 89, 0, 1, 9, 1),
(90, 90, 0, 1, 9, 1),
(91, 91, 0, 1, 10, 1),
(92, 92, 0, 1, 10, 1),
(93, 93, 0, 1, 10, 1),
(94, 94, 0, 1, 10, 1),
(95, 95, 0, 1, 10, 1),
(96, 96, 0, 1, 10, 1),
(97, 97, 0, 1, 10, 1),
(98, 98, 0, 1, 10, 1),
(99, 99, 0, 1, 10, 1),
(100, 100, 0, 1, 10, 1),
(101, 101, 0, 2, 11, 1),
(102, 102, 0, 2, 11, 1),
(103, 103, 0, 2, 11, 1),
(104, 104, 0, 2, 11, 1),
(105, 105, 0, 2, 11, 1),
(106, 106, 0, 2, 12, 1),
(107, 107, 0, 2, 12, 1),
(108, 108, 0, 2, 12, 1),
(109, 109, 0, 2, 12, 1),
(110, 110, 0, 2, 12, 1),
(111, 111, 0, 2, 13, 1),
(112, 112, 0, 2, 13, 1),
(113, 113, 0, 2, 13, 1),
(114, 114, 0, 2, 13, 1),
(115, 115, 0, 2, 13, 1),
(116, 116, 0, 2, 14, 1),
(117, 117, 0, 2, 14, 1),
(118, 118, 0, 2, 14, 1),
(119, 119, 0, 2, 14, 1),
(120, 120, 0, 2, 14, 1),
(121, 121, 0, 2, 15, 1),
(122, 122, 0, 2, 15, 1),
(123, 123, 0, 2, 15, 1),
(124, 124, 0, 2, 15, 1),
(125, 125, 0, 2, 15, 1),
(126, 126, 0, 3, 16, 1),
(127, 127, 0, 3, 16, 1),
(128, 128, 0, 3, 16, 1),
(129, 129, 0, 1, 16, 1),
(130, 130, 0, 3, 17, 1),
(131, 131, 0, 3, 17, 1),
(132, 132, 0, 3, 17, 1),
(133, 133, 0, 1, 17, 1),
(134, 134, 0, 3, 18, 1),
(135, 135, 0, 3, 18, 1),
(136, 136, 0, 3, 18, 1),
(137, 137, 0, 2, 18, 1),
(138, 138, 0, 4, 19, 1),
(139, 139, 0, 4, 19, 1),
(140, 140, 0, 2, 19, 1),
(141, 141, 0, 4, 20, 1),
(142, 142, 0, 4, 20, 1),
(143, 143, 0, 2, 20, 1),
(306, 24, 0, 1, 3, 1),
(307, 308, 0, 4, 3, 1),
(308, 309, 0, 4, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

DROP TABLE IF EXISTS `huesped`;
CREATE TABLE `huesped` (
  `id_huesped` int(11) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `domicilio` varchar(255) NOT NULL,
  `celular` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`id_huesped`, `dni`, `apellido`, `nombre`, `domicilio`, `celular`, `correo`, `estado`) VALUES
(1, '38765432', 'Gómez', 'María', 'Avenida 456', '221-5672345', 'maria@gmail.com', 1),
(2, '42077123', 'Nelida', 'Ana', 'Avenida 78', '221598732', 'Ana@gmail.com', 1),
(3, '42077343', 'Ramirez', 'Matias', 'Avenida 624', '221598745', 'Matias@gmail.com', 1),
(4, '38765472', 'Musso', 'Gabriel', 'Poralla 1140', '0217232526', 'mussoGabriel@gmail.com', 1),
(5, '38765474', 'Fernandez', 'Mariano', '1800 inexistente', '2234567895', 'fernandez@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `id_habitacion` int(11) NOT NULL,
  `id_huesped` int(11) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `ingreso` tinyint(1) NOT NULL,
  `fechaSalida` date NOT NULL,
  `salida` date NOT NULL,
  `precio` double NOT NULL,
  `cant_personas` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `id_habitacion`, `id_huesped`, `fechaIngreso`, `ingreso`, `fechaSalida`, `salida`, `precio`, `cant_personas`, `estado`) VALUES
(1, 1, 2, '2022-07-19', 1, '2022-07-28', '2022-07-28', 90, 1, 0),
(2, 142, 2, '2023-08-12', 1, '2023-08-19', '2023-08-19', 3500, 4, 0),
(3, 112, 3, '2023-08-12', 1, '2023-08-19', '2023-08-19', 160, 2, 0),
(4, 8, 2, '2023-10-16', 1, '2023-10-28', '2023-10-28', 120, 1, 0),
(5, 14, 3, '2023-10-16', 0, '2023-10-21', '0001-01-01', 50, 1, 0),
(6, 10, 1, '2023-10-19', 1, '2023-10-31', '2023-10-28', 150, 1, 0),
(7, 10, 4, '2023-11-05', 1, '2023-11-15', '2023-10-28', 280, 1, 0),
(8, 9, 1, '2023-10-28', 1, '2023-10-31', '2023-10-28', 30, 1, 0),
(10, 8, 2, '2023-10-28', 1, '2023-10-31', '2023-10-28', 60, 1, 0),
(13, 8, 2, '2023-10-28', 1, '2023-10-31', '2023-10-28', 30, 1, 0),
(14, 9, 2, '2023-10-28', 1, '2023-10-31', '2023-10-28', 30, 1, 0),
(15, 10, 2, '2023-10-28', 1, '2023-10-31', '2023-10-28', 30, 1, 0),
(16, 5, 2, '2023-10-28', 1, '2023-10-31', '2023-10-28', 60, 1, 0),
(17, 12, 2, '2023-10-28', 1, '2023-10-31', '2023-10-28', 60, 1, 0),
(19, 9, 2, '2023-10-28', 1, '2023-10-31', '0001-01-01', 30, 1, 1),
(20, 5, 2, '2023-10-28', 1, '2023-10-31', '2023-10-28', 0, 1, 0),
(22, 7, 2, '2023-10-28', 1, '2023-10-31', '0001-01-01', 30, 1, 1),
(23, 10, 2, '2023-10-28', 1, '2023-10-31', '0001-01-01', 30, 1, 1),
(24, 2, 2, '2023-10-28', 1, '2023-10-31', '0001-01-01', 30, 1, 1),
(25, 16, 2, '2023-10-28', 1, '2023-10-31', '0001-01-01', 30, 1, 1),
(26, 13, 2, '2023-10-28', 1, '2023-10-31', '2023-10-29', 10, 1, 0),
(27, 12, 2, '2023-10-28', 1, '2023-10-31', '0001-01-01', 30, 1, 1),
(28, 11, 2, '2023-10-28', 1, '2023-10-31', '2023-10-30', 20, 1, 0),
(30, 11, 3, '2023-10-29', 1, '2023-11-10', '0001-01-01', 120, 1, 1),
(31, 18, 3, '2023-10-31', 0, '2023-11-10', '0001-01-01', 100, 1, 1),
(32, 10, 3, '2023-10-29', 1, '2023-10-31', '0001-01-01', 20, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodehabitacion`
--

DROP TABLE IF EXISTS `tipodehabitacion`;
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
(1, 'Simple', 10, 0, 0, 1, 1, 1),
(2, 'Doble', 20, 0, 1, 0, 2, 1),
(3, 'Triple', 30, 0, 1, 1, 3, 1),
(4, 'Suite Lujo', 50, 1, 0, 2, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
CREATE TABLE `tipousuario` (
  `idtipousuario` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL DEFAULT '',
  `admin` tinyint(1) NOT NULL DEFAULT 0,
  `crud` tinyint(1) NOT NULL DEFAULT 0,
  `queries` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`idtipousuario`, `descripcion`, `admin`, `crud`, `queries`) VALUES
(1, 'Administracion', 1, 0, 0),
(2, 'DataEntry', 0, 1, 0),
(3, 'Consultas', 0, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(80) NOT NULL DEFAULT '',
  `apellido` varchar(80) NOT NULL DEFAULT '',
  `genero` varchar(45) NOT NULL DEFAULT '0',
  `idtipousuario` int(11) NOT NULL DEFAULT 0,
  `usuario` varchar(60) NOT NULL DEFAULT '',
  `password` varchar(60) NOT NULL DEFAULT '',
  `remember` tinyint(1) NOT NULL DEFAULT 0,
  `dark` tinyint(1) NOT NULL DEFAULT 1,
  `accent` varchar(45) NOT NULL DEFAULT 'App.accent.default',
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `genero`, `idtipousuario`, `usuario`, `password`, `remember`, `dark`, `accent`, `estado`) VALUES
(1, 'Juan', 'Perez', '1', 1, 'admin', '12345', 1, 0, 'App.accent.default', 1);

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
  ADD PRIMARY KEY (`id_huesped`);

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
-- Indices de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`idtipousuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `idtipousuario` (`idtipousuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `id_habitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=309;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `id_huesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `tipodehabitacion`
--
ALTER TABLE `tipodehabitacion`
  MODIFY `id_tipoDeHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  MODIFY `idtipousuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idtipousuario`) REFERENCES `tipousuario` (`idtipousuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
