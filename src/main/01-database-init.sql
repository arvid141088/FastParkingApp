-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.18 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table car_park.car_park_location
CREATE TABLE IF NOT EXISTS `car_park_location` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `city` varchar(50) NOT NULL DEFAULT '',
  `gps_latitude` varchar(50) NOT NULL DEFAULT '',
  `gps_longitude` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table car_park.car_park_location_slot
CREATE TABLE IF NOT EXISTS `car_park_location_slot` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `location_id` int(10) unsigned NOT NULL,
  `index` int(10) unsigned NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '',
  `available` tinyint(4) NOT NULL,
  `corner_a_longitude` decimal(10,6) DEFAULT NULL,
  `corner_a_latitude` decimal(10,6) DEFAULT NULL,
  `corner_b_longitude` decimal(10,6) DEFAULT NULL,
  `corner_b_latitude` decimal(10,6) DEFAULT NULL,
  `corner_c_longitude` decimal(10,6) DEFAULT NULL,
  `corner_c_latitude` decimal(10,6) DEFAULT NULL,
  `corner_d_longitude` decimal(10,6) DEFAULT NULL,
  `corner_d_latitude` decimal(10,6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_location_id_index` (`location_id`,`index`),
  CONSTRAINT `car_park_location_slot_location_fk` FOREIGN KEY (`location_id`) REFERENCES `car_park_location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table car_park.car_park_slot_booking
CREATE TABLE IF NOT EXISTS `car_park_slot_booking` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `slot_id` int(11) unsigned NOT NULL,
  `location_id` int(11) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `vehicle_id` int(10) unsigned NOT NULL,
  `start_date_time` datetime NOT NULL,
  `end_date_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `car_park_slot_booking_slot_fk` (`slot_id`),
  KEY `car_park_slot_booking_location_fk` (`location_id`),
  KEY `car_park_slot_booking_user_fk` (`user_id`),
  KEY `car_park_slot_booking_vehicle_fk` (`vehicle_id`),
  CONSTRAINT `car_park_slot_booking_location_fk` FOREIGN KEY (`location_id`) REFERENCES `car_park_location` (`id`),
  CONSTRAINT `car_park_slot_booking_slot_fk` FOREIGN KEY (`slot_id`) REFERENCES `car_park_location_slot` (`id`),
  CONSTRAINT `car_park_slot_booking_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `car_park_slot_booking_vehicle_fk` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table car_park.user_info
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL DEFAULT '',
  `last_name` varchar(255) NOT NULL DEFAULT '',
  `phone` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_login` (`login`),
  UNIQUE KEY `uq_phone` (`phone`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table car_park.user_vehicle
CREATE TABLE IF NOT EXISTS `user_vehicle` (
  `user_id` int(11) unsigned DEFAULT NULL,
  `vehicle_id` int(11) unsigned DEFAULT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1',
  KEY `user_vehicle_user_fk` (`user_id`),
  KEY `user_vehicle_vehicle_fk` (`vehicle_id`),
  CONSTRAINT `user_vehicle_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`),
  CONSTRAINT `user_vehicle_vehicle_fk` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table car_park.vehicle
CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `registration` varchar(50) NOT NULL DEFAULT '',
  `make` varchar(50) NOT NULL DEFAULT '',
  `model` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_registration` (`registration`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
