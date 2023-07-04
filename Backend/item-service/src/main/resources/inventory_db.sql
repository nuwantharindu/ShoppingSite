CREATE DATABASE `inventory_db`;

USE `inventory_db`;

CREATE TABLE `inventory` (
  `productCode` VARCHAR(255) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`productCode`)
);

INSERT INTO `inventory` (productCode, quantity) VALUES ('P001', 10);
INSERT INTO `inventory` (productCode, quantity) VALUES ('P002', 5);
