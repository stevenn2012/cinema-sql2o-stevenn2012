-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2016 a las 00:35:54
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `cinema2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE IF NOT EXISTS `funcion` (
`idFuncion` int(11) NOT NULL,
  `idPelicula` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `HoraInicio` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE IF NOT EXISTS `pelicula` (
`idPelicula` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `descripcion` longtext,
  `duracion` int(11) NOT NULL,
  `genero` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE IF NOT EXISTS `sala` (
`idSala` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `filas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala_silla`
--

CREATE TABLE IF NOT EXISTS `sala_silla` (
`idSala_Silla` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `idSilla` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `silla`
--

CREATE TABLE IF NOT EXISTS `silla` (
`idSilla` int(11) NOT NULL,
  `fila` varchar(10) NOT NULL,
  `columna` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
`idTicket` int(11) NOT NULL,
  `idFuncion` int(11) NOT NULL,
  `Vendido` tinyint(1) NOT NULL,
  `horaVenta` datetime DEFAULT NULL,
  `idSala_Silla` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
 ADD PRIMARY KEY (`idFuncion`), ADD KEY `fk_Funcion_Pelicula1_idx` (`idPelicula`), ADD KEY `fk_Funcion_Sala1_idx` (`idSala`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
 ADD PRIMARY KEY (`idPelicula`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
 ADD PRIMARY KEY (`idSala`);

--
-- Indices de la tabla `sala_silla`
--
ALTER TABLE `sala_silla`
 ADD PRIMARY KEY (`idSala_Silla`), ADD KEY `fk_Sala_Silla_Sala1_idx` (`idSala`), ADD KEY `fk_Sala_Silla_Silla1_idx` (`idSilla`);

--
-- Indices de la tabla `silla`
--
ALTER TABLE `silla`
 ADD PRIMARY KEY (`idSilla`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
 ADD PRIMARY KEY (`idTicket`), ADD KEY `fk_Ticket_Funcion1_idx` (`idFuncion`), ADD KEY `fk_Ticket_Sala_Silla1_idx` (`idSala_Silla`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `funcion`
--
ALTER TABLE `funcion`
MODIFY `idFuncion` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
MODIFY `idPelicula` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
MODIFY `idSala` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `sala_silla`
--
ALTER TABLE `sala_silla`
MODIFY `idSala_Silla` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `silla`
--
ALTER TABLE `silla`
MODIFY `idSilla` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
MODIFY `idTicket` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `funcion`
--
ALTER TABLE `funcion`
ADD CONSTRAINT `fk_Funcion_Pelicula1` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Funcion_Sala1` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sala_silla`
--
ALTER TABLE `sala_silla`
ADD CONSTRAINT `fk_Sala_Silla_Sala1` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Sala_Silla_Silla1` FOREIGN KEY (`idSilla`) REFERENCES `silla` (`idSilla`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
ADD CONSTRAINT `fk_Ticket_Funcion1` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Ticket_Sala_Silla1` FOREIGN KEY (`idSala_Silla`) REFERENCES `sala_silla` (`idSala_Silla`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
