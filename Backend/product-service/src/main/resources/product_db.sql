CREATE DATABASE `product_db`;

USE `product_db`;

CREATE TABLE `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `productCode` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255),
  `price` DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `product` (productCode, name, description, price) VALUES ('P001', 'Product A', 'Description for Product A', 10.00);
INSERT INTO `product` (productCode, name, description, price) VALUES ('P002', 'Product B', 'Description for Product B', 15.50);
