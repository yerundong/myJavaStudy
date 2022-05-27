DROP DATABASE IF EXISTS `emall`; 
CREATE DATABASE `emall`; 
USE `emall`; 

CREATE TABLE `user`
( 
  `id` INT PRIMARY KEY AUTO_INCREMENT, 
  `name` VARCHAR(50) NOT NULL UNIQUE, 
  `nickName` VARCHAR(50), 
  `email` VARCHAR(50), 
  `password` VARCHAR(200) NOT NULL, 
  `gender` TINYINT CHECK(`gender` = 0 OR `gender` = 1)
); 