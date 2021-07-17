-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-07-2021 a las 03:51:38
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sis_validacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activos`
--

CREATE TABLE `activos` (
  `ID_ACT` int(11) NOT NULL,
  `CED_USU_PER` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NOM_ACT` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `OBS_ACT` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `activos`
--

INSERT INTO `activos` (`ID_ACT`, `CED_USU_PER`, `NOM_ACT`, `OBS_ACT`) VALUES
(1, '0932131972', 'COMPUTADOR', 'NUEVO'),
(2, '0932131973', 'IMPRESORA01', NULL),
(3, '0932131974', 'CAMARA01', NULL),
(4, '1804816104', 'COMPUTADOR02', NULL),
(5, '1804816104', 'MESA01', NULL),
(6, '1804816104', 'CAMARA01', NULL),
(7, '0932131972', 'LLAVE01', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `CED_USU` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NOM_USU` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `APE_USU` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`CED_USU`, `NOM_USU`, `APE_USU`) VALUES
('0932131972', 'LUIS', 'ZERNA'),
('0932131973', 'JENIFFER', 'YAGUANA'),
('0932131974', 'JOSE', 'PASMIÑO'),
('1804816104', 'SILVIA', 'VILLACRES');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activos`
--
ALTER TABLE `activos`
  ADD PRIMARY KEY (`ID_ACT`),
  ADD KEY `CED_USU_PER` (`CED_USU_PER`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`CED_USU`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `activos`
--
ALTER TABLE `activos`
  MODIFY `ID_ACT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `activos`
--
ALTER TABLE `activos`
  ADD CONSTRAINT `activos_ibfk_1` FOREIGN KEY (`CED_USU_PER`) REFERENCES `usuario` (`CED_USU`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
