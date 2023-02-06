-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-12-2022 a las 21:59:01
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `web_proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `codigoDetalle` varchar(30) NOT NULL,
  `codigoPlato` varchar(30) NOT NULL,
  `codigoReserva` varchar(30) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE `mesa` (
  `codigoMesa` varchar(30) NOT NULL,
  `tipoMesa` varchar(30) NOT NULL,
  `estadoMesa` varchar(30) NOT NULL,
  `cantidadMesa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`codigoMesa`, `tipoMesa`, `estadoMesa`, `cantidadMesa`) VALUES
('MF3817', 'Familiar', 'Libre', 7),
('MG3539', 'Grupal', 'Libre', 5),
('MP4361', 'Personal', 'Libre', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plato`
--

CREATE TABLE `plato` (
  `codigoPlato` varchar(30) NOT NULL,
  `nombrePlato` varchar(30) NOT NULL,
  `origen` varchar(30) NOT NULL,
  `foto` varchar(100) NOT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `cantidadPlato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `plato`
--

INSERT INTO `plato` (`codigoPlato`, `nombrePlato`, `origen`, `foto`, `precio`, `cantidadPlato`) VALUES
('PA2361', 'Aji de Langostinos', 'Tumbes', '/resources/imagen/aji-langostinos.jpg', '16.50', 15),
('PC1035', 'Causa de Pescado', 'Chimbote', '/resources/imagen/causa-pescado.jpg', '15.90', 16),
('PC1242', 'Chicharrón de Mote', 'Cajamarca', '/resources/imagen/chicharron-mote.jpg', '15.90', 20),
('PC1974', 'Cebiche de Conchas', 'Tumbes', '/resources/imagen/cebiche-conchas.jpg', '30.90', 20),
('PC1975', 'Chupe de Cangrejo', 'Tumbes', '/resources/imagen/chupe-cangrejo.jpg', '30.40', 15),
('PC2585', 'Caldo de Jeta', 'Chimbote', '/resources/imagen/caldo-jeta.jpg', '12.30', 15),
('PC259', 'Caldo de Bolas', 'Tumbes', '/resources/imagen/caldo-bolas.jpg', '15.90', 10),
('PC2625', 'Cebiche Trujillano', 'Trujillo', '/resources/imagen/cebiche-trujillano.jpg', '30.00', 20),
('PC3367', 'Cabrito a la Norteña', 'Piura', '/resources/imagen/cabrito-nortena.jpg', '20.00', 12),
('PC346', 'Caldo de Cordero', 'Cajamarca', '/resources/imagen/caldo-cordero.jpg', '20.00', 20),
('PC4125', 'Cuy Frito', 'Cajamarca', '/resources/imagen/cuy frito.jpg', '16.50', 20),
('PC468', 'Cebiche Chimbotano', 'Chimbote', '/resources/imagen/cebiche-chimbotano.jpg', '20.30', 10),
('PC847', 'Cebiche de Mero', 'Piura', '/resources/imagen/cebiche-mero.jpg', '30.50', 30),
('PE3929', 'El Shambar', 'Trujillo', '/resources/imagen/el-shambar.jpg', '13.00', 20),
('PF2226', 'Frejolado de Pato', 'Chimbote', '/resources/imagen/frejolado-pato.jpg', '16.50', 8),
('PF2558', 'Frito Cajamarquino', 'Cajamarca', '/resources/imagen/frito-cajamarquino.jpg', '15.90', 20),
('PF48', 'Frito Trujillano', 'Trujillo', '/resources/imagen/frito-trujillano.jpg', '17.40', 14),
('PL155', 'La Malarrabia', 'Piura', '/resources/imagen/la-malarrabia.jpg', '28.00', 15),
('PM3437', 'Majarico', 'Tumbes', '/resources/imagen/majarico.jpg', '15.40', 12),
('PP733', 'Puchero', 'Cajamarca', '/resources/imagen/puchero.jpg', '17.40', 24),
('PS1246', 'Sudado de Cachema', 'Piura', '/resources/imagen/sudado-cachema.jpg', '26.00', 17),
('PS3905', 'Seco de Chabelo', 'Piura', '/resources/imagen/seco-chabelo.jpg', '16.50', 15),
('PS712', 'Seco de Cabrito', 'Trujillo', '/resources/imagen/seco-cabrito.jpg', '17.40', 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `codigoReserva` varchar(30) NOT NULL,
  `codigoUsuario` varchar(30) NOT NULL,
  `codigoMesa` varchar(30) NOT NULL,
  `cantidadPersona` int(11) NOT NULL,
  `fecha` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `codigoUsuario` varchar(30) NOT NULL,
  `nombreUsuario` varchar(30) NOT NULL,
  `apellidoUsuario` varchar(30) NOT NULL,
  `telefono` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codigoUsuario`, `nombreUsuario`, `apellidoUsuario`, `telefono`, `correo`, `contraseña`) VALUES
('UHS22112368', 'Hugo', 'Sanchez', 123459, 'Hugo@gmail.com', '15986'),
('USP22112220', 'Sebastian', 'Palomino', 962372377, 'sebastianpalomino912@gmail.com', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`codigoDetalle`),
  ADD KEY `codigoPlato` (`codigoPlato`),
  ADD KEY `codigoReserva` (`codigoReserva`);

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`codigoMesa`);

--
-- Indices de la tabla `plato`
--
ALTER TABLE `plato`
  ADD PRIMARY KEY (`codigoPlato`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`codigoReserva`),
  ADD KEY `codigoUsuario` (`codigoUsuario`),
  ADD KEY `codigoMesa` (`codigoMesa`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigoUsuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `detalle_ibfk_1` FOREIGN KEY (`codigoPlato`) REFERENCES `plato` (`codigoPlato`),
  ADD CONSTRAINT `detalle_ibfk_2` FOREIGN KEY (`codigoReserva`) REFERENCES `reserva` (`codigoReserva`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`codigoUsuario`) REFERENCES `usuario` (`codigoUsuario`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`codigoMesa`) REFERENCES `mesa` (`codigoMesa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
