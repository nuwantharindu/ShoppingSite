CREATE DATABASE `payment_db`;

USE `payment_response_db`;

CREATE TABLE `payment_response` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `paymentType` VARCHAR(255) NOT NULL,
  `amount` DECIMAL(10, 2) NOT NULL,
  `message` VARCHAR(255),
  PRIMARY KEY (`id`)
);

INSERT INTO `payment_response` (paymentType, amount, message) VALUES ('Credit Card', 100.00, 'Payment successful');
INSERT INTO `payment_response` (paymentType, amount, message) VALUES ('PayPal', 50.00, 'Payment pending');
