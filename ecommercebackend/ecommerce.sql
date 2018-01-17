-- Adminer 4.2.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `Category`;
CREATE TABLE `Category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `image_url` varchar(50) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Category` (`id`, `name`, `description`, `image_url`, `is_active`) VALUES
(1,	'Laptop',	'This is description for Laptop category!',	'CAT_1.png',	1),
(2,	'Television',	'This is description for Television category!',	'CAT_2.png',	1),
(3,	'Mobile',	'This is description for Mobile category!',	'CAT_3.png',	1);

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7),
(7);

DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `unit_price` decimal(10,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `purchases` int(11) DEFAULT '0',
  `views` int(11) DEFAULT '0',
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category_id` (`category_id`),
  KEY `fk_product_supplier_id` (`supplier_id`),
  CONSTRAINT `fk_product_category_id` FOREIGN KEY (`category_id`) REFERENCES `Category` (`id`),
  CONSTRAINT `fk_product_supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `User_Detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Product` (`id`, `code`, `name`, `brand`, `description`, `unit_price`, `quantity`, `is_active`, `category_id`, `supplier_id`, `purchases`, `views`, `active`) VALUES
(1,	'PRDABC123DEFX',	'iPhone X',	'apple',	'This is one of the best phone available in the market right now!',	98000.00,	5,	1,	3,	2,	0,	13,	CONV('1', 2, 10) + 0),
(2,	'PRDDEF123DEFX',	'Samsung Galaxy Note 8',	'samsung',	'A smart phone by samsung!',	67000.00,	2,	1,	3,	3,	0,	0,	CONV('0', 2, 10) + 0),
(3,	'PRDPQR123WGTX',	'Google Pixel',	'google',	'This is one of the best android smart phone available in the market right now!',	57000.00,	5,	1,	3,	2,	0,	1,	CONV('1', 2, 10) + 0),
(4,	'PRDMNO123PQRX',	' Macbook Pro',	'apple',	'This is one of the best laptops available in the market right now!',	54000.00,	3,	1,	1,	2,	0,	0,	CONV('1', 2, 10) + 0),
(5,	'PRDABCXYZDEFX',	'Acer Aspire VX5-591G',	'acer',	'This is one of the best laptop series from acer that can be used!',	96000.00,	5,	1,	1,	3,	0,	1,	CONV('1', 2, 10) + 0),
(6,	'PRD4DB22D129A',	'Oppo F5',	'Oppo',	'The selfie expert',	25000.00,	4,	1,	3,	3,	0,	1,	CONV('1', 2, 10) + 0);

DROP TABLE IF EXISTS `User_Detail`;
CREATE TABLE `User_Detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_number` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `User_Detail` (`id`, `first_name`, `last_name`, `role`, `enabled`, `password`, `email`, `contact_number`) VALUES
(1,	'Shubham',	'Gupta',	'ADMIN',	1,	'$2a$06$ORtBskA2g5Wg0HDgRE5ZsOQNDHUZSdpJqJ2.PGXv0mKyEvLnKP7SW',	'vk@gmail.com',	'8888888888'),
(2,	'Vaibhav',	'Sharma',	'SUPPLIER',	1,	'$2a$06$bzYMivkRjSxTK2LPD8W4te6jjJa795OwJR1Of5n95myFsu3hgUnm6',	'rj@gmail.com',	'9999999999'),
(3,	'Sharad',	'Singh',	'SUPPLIER',	1,	'$2a$06$i1dLNlXj2uY.UBIb9kUcAOxCigGHUZRKBtpRlmNtL5xtgD6bcVNOK',	'ra@gmail.com',	'7777777777'),
(4,	'Khozema',	'Nullwala',	'USER',	1,	'$2a$06$4mvvyO0h7vnUiKV57IW3oudNEaKPpH1xVSdbie1k6Ni2jfjwwminq',	'kn@gmail.com',	'7777777777');

-- 2018-01-17 11:36:49
