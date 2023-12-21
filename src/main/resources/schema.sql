CREATE DATABASE app_coffee;
USE app_coffee;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) NOT NULL,
  `correo` varchar(75) NOT NULL,
  `contrasena` varchar(32) NOT NULL,
  `permisos` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) NOT NULL,
  `cantidad` int NOT NULL,
  `precio` DECIMAL(10,2),
  PRIMARY KEY (`id`)
);

CREATE TABLE `comprobante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente_id` int NOT NULL,
  `cantidad` int NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `valor_producto` double NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE `linea` (
  `id` int NOT NULL AUTO_INCREMENT,
  `facturacion_id` int NOT NULL,
  `producto_id` int NOT NULL,
  `cantidad_productos` int NOT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_facturacion_id FOREIGN KEY (facturacion_id) REFERENCES facturaciones(id),
  CONSTRAINT fk_producto_id FOREIGN KEY (producto_id) REFERENCES productos(id)
); 