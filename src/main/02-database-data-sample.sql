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

-- Dumping data for table car_park.car_park_location: ~4 rows (approximately)
/*!40000 ALTER TABLE `car_park_location` DISABLE KEYS */;
INSERT IGNORE INTO `car_park_location` (`id`, `name`, `city`, `gps_latitude`, `gps_longitude`) VALUES
	(1, 'Knocknacarra', 'GALWAY', '53.272344', '-9.097906'),
	(2, 'Briarhill', 'GALWAY', '53.291141', '-8.986317'),
	(3, 'Salthill', 'GALWAY', '53.260267', '-9.073110'),
	(4, 'Center', 'GALWAY', '53.274994', '-9.045973'),
	(5, 'GMIT', 'GALWAY', '53.279127', '-9.010144');
/*!40000 ALTER TABLE `car_park_location` ENABLE KEYS */;

-- Dumping data for table car_park.car_park_location_slot: ~15 rows (approximately)
/*!40000 ALTER TABLE `car_park_location_slot` DISABLE KEYS */;
INSERT IGNORE INTO `car_park_location_slot` (`id`, `location_id`, `index`, `name`, `available`, `corner_a_x`, `corner_a_y`, `corner_b_x`, `corner_b_y`, `corner_c_x`, `corner_c_y`, `corner_d_x`, `corner_d_y`) VALUES
	(1, 1, 1, '', 1, 40.735310, -73.994580, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, 1, 2, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 1, 3, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 1, 4, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, 1, 5, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(6, 2, 1, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(7, 2, 2, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(8, 2, 3, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(9, 3, 1, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(10, 3, 2, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(11, 4, 1, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(12, 4, 2, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(13, 4, 3, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(14, 5, 1, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(15, 5, 2, '', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `car_park_location_slot` ENABLE KEYS */;

-- Dumping data for table car_park.car_park_slot_booking: ~13 rows (approximately)
/*!40000 ALTER TABLE `car_park_slot_booking` DISABLE KEYS */;
INSERT IGNORE INTO `car_park_slot_booking` (`id`, `slot_id`, `location_id`, `user_id`, `vehicle_id`, `start_date_time`, `end_date_time`) VALUES
	(1, 2, 1, 1, 2, '2019-12-23 08:06:54', '2019-12-23 14:06:56'),
	(2, 3, 1, 2, 1, '2019-12-23 10:07:40', '2019-12-23 14:07:55'),
	(3, 2, 1, 1, 2, '2020-02-09 10:27:19', '2020-02-09 10:28:02'),
	(4, 2, 1, 2, 1, '2020-02-09 10:29:15', '2020-02-11 10:01:54'),
	(5, 4, 1, 2, 1, '2020-02-10 20:13:44', '2020-02-11 10:02:18'),
	(6, 4, 1, 2, 1, '2020-02-11 10:07:44', '2020-02-11 10:47:14'),
	(7, 4, 1, 2, 1, '2020-02-11 10:47:43', '2020-02-17 13:07:48'),
	(8, 1, 1, 2, 1, '2020-02-11 10:49:36', '2020-02-17 13:07:43'),
	(9, 2, 1, 3, 3, '2020-02-11 10:58:11', '2020-02-17 13:07:04'),
	(10, 3, 1, 3, 3, '2020-02-11 11:05:26', '2020-02-17 13:06:59'),
	(11, 8, 2, 1, 2, '2020-02-17 12:53:45', '2020-02-17 13:03:44'),
	(12, 9, 3, 1, 2, '2020-02-17 13:02:21', '2020-02-17 13:03:54'),
	(13, 9, 3, 1, 2, '2020-02-17 13:04:07', '2020-02-17 13:04:17'),
	(14, 9, 3, 1, 2, '2020-02-17 13:20:14', '2020-02-17 13:20:51');
/*!40000 ALTER TABLE `car_park_slot_booking` ENABLE KEYS */;

-- Dumping data for table car_park.user_info: ~2 rows (approximately)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT IGNORE INTO `user_info` (`id`, `login`, `password_hash`, `first_name`, `last_name`, `phone`, `email`) VALUES
	(1, 'john', 'no-hash', 'John', 'Brown', '+353851234123', 'john@inbox.com'),
	(2, 'lisa', 'no-hash', 'Lisa', 'Smyth', '+353863456123', 'lisa@inbox.com'),
	(3, 'sarah', 'no-hash', 'Sarah', 'Connor', '+353893367474', 'sarah@inbox.com');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

-- Dumping data for table car_park.user_vehicle: ~3 rows (approximately)
/*!40000 ALTER TABLE `user_vehicle` DISABLE KEYS */;
INSERT IGNORE INTO `user_vehicle` (`user_id`, `vehicle_id`, `active`) VALUES
	(1, 2, 1),
	(2, 1, 1),
	(3, 3, 1);
/*!40000 ALTER TABLE `user_vehicle` ENABLE KEYS */;

-- Dumping data for table car_park.vehicle: ~2 rows (approximately)
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT IGNORE INTO `vehicle` (`id`, `registration`, `make`, `model`) VALUES
	(1, '08C40455', 'bmw', '320d'),
	(2, '141D34123', 'ford', 'mondeo'),
	(3, '06LK3211', 'seat', 'leon');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
