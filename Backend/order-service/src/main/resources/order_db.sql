CREATE DATABASE `order_db`;

USE `order_db`;

CREATE TABLE `order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `productCode` VARCHAR(255) NOT NULL,
  `price` DECIMAL(10, 2) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `order` (productCode, price, quantity) VALUES ('P001', 10.00, 2);
INSERT INTO `order` (productCode, price, quantity) VALUES ('P002', 15.50, 1);
