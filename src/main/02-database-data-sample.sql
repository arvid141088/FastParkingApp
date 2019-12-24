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

-- Dumping data for table car_park.car_park_location: ~0 rows (approximately)
/*!40000 ALTER TABLE `car_park_location` DISABLE KEYS */;
INSERT INTO `car_park_location` (`id`, `name`, `city`, `gps_latitude`, `gps_longitude`) VALUES
	(1, 'Knocknacarra', 'GALWAY', '', ''),
	(2, 'Briarhill', 'GALWAY', '', ''),
	(3, 'Salthill', 'GALWAY', '', ''),
	(4, 'Center', 'GALWAY', '', ''),
	(5, 'Woodquay', 'GALWAY', '', '');
/*!40000 ALTER TABLE `car_park_location` ENABLE KEYS */;

-- Dumping data for table car_park.car_park_location_slot: ~0 rows (approximately)
/*!40000 ALTER TABLE `car_park_location_slot` DISABLE KEYS */;
INSERT INTO `car_park_location_slot` (`id`, `location_id`, `index`, `name`, `available`, `corner_a_longitude`, `corner_a_latitude`, `corner_b_longitude`, `corner_b_latitude`, `corner_c_longitude`, `corner_c_latitude`, `corner_d_longitude`, `corner_d_latitude`) VALUES
	(1, 1, 1, '', 0, 40.735310, -73.994580, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, 1, 2, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 1, 3, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 1, 4, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, 1, 5, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(6, 2, 1, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(7, 2, 2, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(8, 2, 3, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(9, 3, 1, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(10, 3, 2, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(11, 4, 1, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(12, 4, 2, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(13, 4, 3, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(14, 5, 1, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(15, 5, 2, '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `car_park_location_slot` ENABLE KEYS */;

-- Dumping data for table car_park.car_park_slot_booking: ~0 rows (approximately)
/*!40000 ALTER TABLE `car_park_slot_booking` DISABLE KEYS */;
INSERT INTO `car_park_slot_booking` (`id`, `slot_id`, `location_id`, `user_id`, `vehicle_id`, `start_date_time`, `end_date_time`) VALUES
	(1, 2, 1, 1, 2, '2019-12-23 08:06:54', '2019-12-23 14:06:56'),
	(2, 3, 1, 2, 1, '2019-12-23 10:07:40', '2019-12-23 14:07:55');
/*!40000 ALTER TABLE `car_park_slot_booking` ENABLE KEYS */;

-- Dumping data for table car_park.user_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`id`, `login`, `password_hash`, `first_name`, `last_name`, `phone`, `email`) VALUES
	(1, 'john', 'no-hash', 'John', 'Brown', '+353851234123', 'john@inbox.com'),
	(2, 'lisa', 'no-hash', 'Lisa', 'Smyth', '+353863456123', 'lisa@inbox.com');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

-- Dumping data for table car_park.user_vehicle: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_vehicle` DISABLE KEYS */;
INSERT INTO `user_vehicle` (`user_id`, `vehicle_id`, `active`) VALUES
	(1, 2, 1),
	(2, 1, 1);
/*!40000 ALTER TABLE `user_vehicle` ENABLE KEYS */;

-- Dumping data for table car_park.vehicle: ~0 rows (approximately)
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` (`id`, `registration`, `make`, `model`) VALUES
	(1, '08C40455', 'bmw', '320d'),
	(2, '141D34123', 'ford', 'mondeo');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
