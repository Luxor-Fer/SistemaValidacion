-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-08-2021 a las 17:28:11
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sisvalidaciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activos`
--

CREATE TABLE `activos` (
  `COD_ACT` varchar(25) NOT NULL,
  `NOM_ACT` varchar(25) NOT NULL,
  `COD_ALT_ACT` varchar(50) DEFAULT NULL,
  `OBS_ACT` varchar(150) DEFAULT NULL,
  `CED_EMP_ACT` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `activos`
--

INSERT INTO `activos` (`COD_ACT`, `NOM_ACT`, `COD_ALT_ACT`, `OBS_ACT`, `CED_EMP_ACT`) VALUES
('ACT001', 'ESCRITORIO', NULL, NULL, '1804293825'),
('ACT0010', 'PARLANTES', NULL, NULL, '1804323028'),
('ACT0011', 'LAPTOP', NULL, NULL, '1804293825'),
('ACT0012', 'ESCRITORIO2', NULL, NULL, '1804293825'),
('ACT0013', 'MONITOR2', NULL, NULL, '1804293825'),
('ACT0014', 'SILLA2', NULL, NULL, '1804293825'),
('ACT0015', 'CPU2', NULL, NULL, '1804304515'),
('ACT0016', 'IMPRESORA2', NULL, NULL, '1804304515'),
('ACT0017', 'COPIADORA2', NULL, NULL, '1804304515'),
('ACT0018', 'ESCANNER2', NULL, NULL, '1804305983'),
('ACT0019', 'TECLADO2', NULL, NULL, '1804305983'),
('ACT002', 'MONITOR', NULL, NULL, '1804304515'),
('ACT0020', 'MOUSE2', NULL, NULL, '1804308318'),
('ACT0021', 'PARLANTES2', NULL, NULL, '1804293825'),
('ACT0022', 'LAPTOP2', NULL, NULL, '1804304515'),
('ACT0023', 'ESCRITORIO3', NULL, NULL, '1804305983'),
('ACT0024', 'MONITOR3', NULL, NULL, '1804308318'),
('ACT0025', 'SILLA3', NULL, NULL, '1804310900'),
('ACT0026', 'CPU3', NULL, NULL, '1804316584'),
('ACT0027', 'IMPRESORA3', NULL, NULL, '1804318614'),
('ACT0028', 'COPIADORA3', NULL, NULL, '1804320297'),
('ACT0029', 'ESCANNER3', NULL, NULL, '1804321659'),
('ACT003', 'SILLA', NULL, NULL, '1804305983'),
('ACT0030', 'TECLADO3', NULL, NULL, '1804323028'),
('ACT0031', 'MOUSE3', NULL, NULL, '1804293825'),
('ACT0032', 'PARLANTES3', NULL, NULL, '1804293825'),
('ACT0033', 'LAPTOP3', NULL, NULL, '1804293825'),
('ACT004', 'CPU', NULL, NULL, '1804308318'),
('ACT005', 'IMPRESORA', NULL, NULL, '1804310900'),
('ACT006', 'COPIADORA', NULL, NULL, '1804316584'),
('ACT007', 'ESCANNER', NULL, NULL, '1804318614'),
('ACT008', 'TECLADO', NULL, NULL, '1804320297'),
('ACT009', 'MOUSE', NULL, NULL, '1804321659');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activosvalidacion`
--

CREATE TABLE `activosvalidacion` (
  `Id` int(11) NOT NULL,
  `ID_EMPV_ACTV` int(11) NOT NULL,
  `ID_ACT_ACTV` varchar(25) NOT NULL,
  `EST_ACTV` tinyint(1) NOT NULL,
  `OBS_ACTV` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `CED_EMP` varchar(15) NOT NULL,
  `NOM_EMP` varchar(15) NOT NULL,
  `APE_EMP` varchar(15) NOT NULL,
  `CAR_EMP` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`CED_EMP`, `NOM_EMP`, `APE_EMP`, `CAR_EMP`) VALUES
('1804293825', 'DIANA', 'OJEDA', 'AUXILIAR'),
('1804304515', 'MAYRA', 'ALDAZ', 'AUXILIAR'),
('1804305983', 'FREDDY', 'CUJANO', 'AUXILIAR'),
('1804308318', 'MARICELA', 'RODRIGUEZ', 'AUXILIAR'),
('1804310900', 'ANA', 'PORRAS', 'AUXILIAR'),
('1804316584', 'PAUL', 'MOPOCITA', 'AUXILIAR'),
('1804318614', 'LUIS', 'CALVOPIÑA', 'AUXILIAR'),
('1804320297', 'JESSICA', 'CASTELLANO', 'AUXILIAR'),
('1804321659', 'EDWIN', 'CHASI', 'AUXILIAR'),
('1804323028', 'NELSON', 'CHAMBA', 'AUXILIAR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleadosvalidacion`
--

CREATE TABLE `empleadosvalidacion` (
  `Id` int(11) NOT NULL,
  `ID_VAL_EMPV` int(11) NOT NULL,
  `CED_EMP_EMPV` varchar(15) NOT NULL,
  `OBS_EMPV` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id` int(11) NOT NULL,
  `NOM_USU` varchar(40) NOT NULL,
  `COR_USU` varchar(40) DEFAULT NULL,
  `PAS_USU` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Id`, `NOM_USU`, `COR_USU`, `PAS_USU`) VALUES
(1, 'LuisZerna', 'lzerna1972@uta.edu.ec', '40bd001563085fc35165329ea1ff5c5ecbdbbeef'),
(2, 'Esthefania', 'svillacres6104@uta.edu.ec', '40bd001563085fc35165329ea1ff5c5ecbdbbeef'),
(3, 'Mauricio', 'dtoapanta1240@uta.edu.ec', '40bd001563085fc35165329ea1ff5c5ecbdbbeef');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `validaciones`
--

CREATE TABLE `validaciones` (
  `Id` int(11) NOT NULL,
  `NOM_VAL` varchar(50) NOT NULL,
  `DES_VAL` varchar(150) NOT NULL,
  `FEC_CRE_VAL` date NOT NULL,
  `FEC_ACT_VAL` date DEFAULT NULL,
  `ID_USU_CVAL` int(11) NOT NULL,
  `ID_USU_AVAL` int(11) DEFAULT NULL,
  `EST_VAL` varchar(25) DEFAULT NULL,
  `OBS_VAL` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `v_cusatodia`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `v_cusatodia` (
`COD_ACT` varchar(25)
,`NOM_ACT` varchar(25)
,`CED_EMP` varchar(15)
,`NOM_EMP` varchar(15)
,`APE_EMP` varchar(15)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `v_cusatodia`
--
DROP TABLE IF EXISTS `v_cusatodia`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_cusatodia`  AS SELECT `act`.`COD_ACT` AS `COD_ACT`, `act`.`NOM_ACT` AS `NOM_ACT`, `emp`.`CED_EMP` AS `CED_EMP`, `emp`.`NOM_EMP` AS `NOM_EMP`, `emp`.`APE_EMP` AS `APE_EMP` FROM (`activos` `act` join `empleados` `emp`) WHERE `act`.`CED_EMP_ACT` = `emp`.`CED_EMP` ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activos`
--
ALTER TABLE `activos`
  ADD PRIMARY KEY (`COD_ACT`),
  ADD KEY `ActEmpleado` (`CED_EMP_ACT`);

--
-- Indices de la tabla `activosvalidacion`
--
ALTER TABLE `activosvalidacion`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `ActValEmpVal` (`ID_EMPV_ACTV`),
  ADD KEY `ActValActivo` (`ID_ACT_ACTV`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`CED_EMP`);

--
-- Indices de la tabla `empleadosvalidacion`
--
ALTER TABLE `empleadosvalidacion`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `EmpValCabecera` (`ID_VAL_EMPV`),
  ADD KEY `EmpValEmpleado` (`CED_EMP_EMPV`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `validaciones`
--
ALTER TABLE `validaciones`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `ValidacionUsuarioCrea` (`ID_USU_CVAL`),
  ADD KEY `ValidacionUsuarioAct` (`ID_USU_AVAL`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `activosvalidacion`
--
ALTER TABLE `activosvalidacion`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleadosvalidacion`
--
ALTER TABLE `empleadosvalidacion`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `validaciones`
--
ALTER TABLE `validaciones`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `activos`
--
ALTER TABLE `activos`
  ADD CONSTRAINT `ActEmpleado` FOREIGN KEY (`CED_EMP_ACT`) REFERENCES `empleados` (`CED_EMP`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `activosvalidacion`
--
ALTER TABLE `activosvalidacion`
  ADD CONSTRAINT `ActValActivo` FOREIGN KEY (`ID_ACT_ACTV`) REFERENCES `activos` (`COD_ACT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ActValEmpVal` FOREIGN KEY (`ID_EMPV_ACTV`) REFERENCES `empleadosvalidacion` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empleadosvalidacion`
--
ALTER TABLE `empleadosvalidacion`
  ADD CONSTRAINT `EmpValCabecera` FOREIGN KEY (`ID_VAL_EMPV`) REFERENCES `validaciones` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `EmpValEmpleado` FOREIGN KEY (`CED_EMP_EMPV`) REFERENCES `empleados` (`CED_EMP`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `validaciones`
--
ALTER TABLE `validaciones`
  ADD CONSTRAINT `ValidacionUsuarioAct` FOREIGN KEY (`ID_USU_AVAL`) REFERENCES `usuario` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ValidacionUsuarioCrea` FOREIGN KEY (`ID_USU_CVAL`) REFERENCES `usuario` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
