DROP TABLE IF EXISTS `cuadro`;
DROP table IF EXISTS  `tienda`;

CREATE TABLE `tienda` (
  `id_tienda` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) NOT NULL DEFAULT 'Collar Blanco',
  `capacidad` int(11) NOT NULL DEFAULT 10,
  PRIMARY KEY (`id_tienda`)
);

CREATE TABLE `cuadro` (
  `id_cuadro` int(11) NOT NULL AUTO_INCREMENT,
  `id_tienda` int(11) NOT NULL,
  `nombre` varchar(250) NOT NULL,
  `autor` varchar(250) NOT NULL DEFAULT 'Anonimo',
  `precio` decimal(15,2) NOT NULL DEFAULT 0.00,
  `fecha_entrada` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_cuadro`),
  CONSTRAINT `cuadro_fk` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id_tienda`)
);
