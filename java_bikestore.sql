-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 24, 2019 at 04:57 PM
-- Server version: 5.7.26-0ubuntu0.18.04.1
-- PHP Version: 7.2.17-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_bikestore`
--

-- --------------------------------------------------------

--
-- Table structure for table `Bikes`
--

CREATE TABLE `Bikes` (
  `BikeId` int(11) DEFAULT NULL,
  `BikeBrand` varchar(255) DEFAULT '',
  `BikeType` varchar(255) DEFAULT '',
  `RimSize` double DEFAULT '0',
  `NumberOfGears` varchar(255) DEFAULT '0',
  `DateLastTask` date DEFAULT NULL,
  `BikeBag` varchar(10) NOT NULL DEFAULT 'false',
  `BikePower` float DEFAULT '0',
  `BikeSuspension` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Bikes`
--

INSERT INTO `Bikes` (`BikeId`, `BikeBrand`, `BikeType`, `RimSize`, `NumberOfGears`, `DateLastTask`, `BikeBag`, `BikePower`, `BikeSuspension`) VALUES
(1, 'Gazelle', 'CityBike', 26, '3', NULL, 'true', NULL, ''),
(2, 'Gazelle', 'CityBike', 26, '3', '2019-05-24', 'false', NULL, ''),
(3, 'Gazelle', 'CityBike', 26, '3', NULL, 'true', NULL, ''),
(4, 'Gazelle', 'CityBike', 26, '3', NULL, 'false', NULL, ''),
(5, 'Gazelle', 'CityBike', 26, '3', NULL, 'true', NULL, ''),
(6, 'Gazelle', 'CityBike', 26, '3', NULL, 'false', NULL, ''),
(7, 'Gazelle', 'CityBike', 26, '3', NULL, 'true', NULL, ''),
(8, 'Gazelle', 'CityBike', 26, '3', NULL, 'false', NULL, ''),
(9, 'Gazelle', 'CityBike', 26, '3', NULL, 'true', NULL, ''),
(10, 'Gazelle', 'CityBike', 26, '3', NULL, 'false', NULL, ''),
(11, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 48, ''),
(12, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 32, ''),
(13, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 48, ''),
(14, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 32, ''),
(15, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 48, ''),
(16, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 32, ''),
(17, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 48, ''),
(18, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 32, ''),
(19, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 48, ''),
(20, 'Batavus', 'ElectricBike', 28, '7', NULL, '', 32, ''),
(21, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Hardtail'),
(22, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Full-suspension'),
(23, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Hardtail'),
(24, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Full-suspension'),
(25, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Hardtail'),
(26, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Full-suspension'),
(27, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Hardtail'),
(28, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Full-suspension'),
(29, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Hardtail'),
(30, 'Yeti', 'MountainBike', 36, '21', NULL, '', NULL, 'Full-suspension');

-- --------------------------------------------------------

--
-- Table structure for table `Customers`
--

CREATE TABLE `Customers` (
  `CustomerId` int(11) NOT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Address` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Customers`
--

INSERT INTO `Customers` (`CustomerId`, `FirstName`, `LastName`, `Address`, `City`, `Email`) VALUES
(0, 'Madison', 'Bailey', '565 Kaylin Via', 'Nicolastown', 'vprosacco@example.net'),
(1, 'Louisa', 'Murazik', '278 Mikayla Mountain Suite 522', 'Lake Reecechester', 'herbert65@example.org'),
(2, 'Tom', 'Steuber', '84115 Koss Prairie', 'New Mikayla', 'clovis.purdy@example.net'),
(3, 'Lennie', 'Goodwin', '705 Austin Ramp Suite 350', 'North Akeem', 'skylar24@example.org'),
(4, 'Austyn', 'Baumbach', '894 Friesen Junction', 'Stiedemannborough', 'malika83@example.org'),
(5, 'Jacinto', 'Funk', '1576 Josefa Canyon Suite 341', 'Lake Phoebe', 'hkerluke@example.com'),
(6, 'Alberto', 'McLaughlin', '2736 Leatha Courts', 'Hillsside', 'lgoodwin@example.net'),
(7, 'Coby', 'Barrows', '31602 Kuhic Oval', 'VonRuedenmouth', 'nellie.thiel@example.net'),
(8, 'Anderson', 'Hartmann', '65987 Bernier Road Suite 409', 'Haleyville', 'georgianna.reichert@example.net'),
(9, 'Bernardo', 'Turner', '981 Eryn Throughway', 'Jaskolskiton', 'marlene.hudson@example.com'),
(10, 'Tremayne', 'Huels', '94459 Pacocha Pines', 'Madysonside', 'guillermo.fisher@example.com'),
(11, 'Moshe', 'Schulist', '9580 Douglas Expressway Suite 335', 'Port Kolby', 'lonny58@example.org'),
(12, 'Rolando', 'Russel', '9369 Schulist Flat', 'East Marguerite', 'braden21@example.org'),
(13, 'Jeramie', 'Ritchie', '4508 Dayana Estate', 'Bogisichside', 'iblick@example.com'),
(14, 'Rhett', 'Kulas', '79132 Ruth Stream Apt. 051', 'Minatown', 'ckertzmann@example.net'),
(15, 'Kaley', 'Swaniawski', '531 Mueller Coves Suite 899', 'Murraybury', 'hardy92@example.com'),
(16, 'Rory', 'Dickinson', '6930 Abdul Coves Suite 250', 'New Mattburgh', 'stan76@example.org'),
(17, 'Erich', 'Keebler', '25614 Dibbert Causeway', 'Caspershire', 'damian.nienow@example.org'),
(18, 'Elwin', 'Ryan', '6874 Crona Valley', 'West Carmel', 'winifred.keeling@example.org'),
(19, 'Troy', 'Hickle', '523 Schoen Vista Apt. 347', 'New Norma', 'olson.naomi@example.com'),
(20, 'Alexys', 'Maggio', '090 Sylvester Plaza', 'West Antoinetteborough', 'rosenbaum.philip@example.com'),
(21, 'Keegan', 'Gleichner', '76628 Peggie Causeway Apt. 775', 'Medhurstville', 'alfredo.hessel@example.net'),
(22, 'Monroe', 'Walter', '93227 Anthony Prairie', 'South Santino', 'hettinger.harold@example.com'),
(23, 'Rashawn', 'Bergstrom', '9069 Schuppe Vista', 'Port Audreannechester', 'west.esperanza@example.org'),
(24, 'Emanuel', 'Huels', '36532 Oscar Wall Apt. 050', 'New Turnerland', 'macejkovic.daren@example.org'),
(25, 'Stephon', 'Borer', '404 Johnston Mills Apt. 260', 'Prosaccoshire', 'jalen.kuphal@example.org'),
(26, 'Philip', 'Schulist', '236 Annalise Run', 'Cristobalchester', 'abner12@example.com'),
(27, 'Dallin', 'Hilpert', '7030 Waters Ridges', 'Aimeeside', 'joshua.glover@example.org'),
(28, 'Okey', 'Lehner', '7568 Leannon Locks', 'Lake Uriah', 'whomenick@example.org'),
(29, 'Mitchell', 'Friesen', '3622 Adrian Fall Suite 263', 'East Noeliafurt', 'mattie36@example.org'),
(30, 'Mitchell', 'Kessler', '2006 Lera Fall Suite 563', 'Bartellburgh', 'durward.douglas@example.net'),
(31, 'Kristopher', 'Waters', '15154 Marco Turnpike', 'Lake Amiraland', 'vidal60@example.net'),
(32, 'Reginald', 'Sawayn', '550 Blick Fort', 'Kristinhaven', 'alfreda15@example.net'),
(33, 'Ezekiel', 'Kiehn', '789 Eichmann Divide', 'Funkmouth', 'kshlerin.dayne@example.com'),
(35, 'Jayce', 'O\'Kon', '1487 Violette View Apt. 182', 'East Heatherhaven', 'casper.jedediah@example.com'),
(36, 'Salvador', 'Hessel', '69167 Crona Courts', 'North Flavie', 'champlin.janiya@example.com'),
(37, 'Jaron', 'Bechtelar', '18553 Langosh Shoals', 'Sylviabury', 'abel51@example.net'),
(38, 'Jay', 'Kautzer', '4728 Gleichner Dale Suite 936', 'North Clement', 'ashton.rowe@example.com'),
(39, 'Jayce', 'Goodwin', '14777 Kunde Hollow Apt. 851', 'South Cristina', 'estrella.luettgen@example.com'),
(40, 'Owen', 'Boyer', '6787 Kyla Flats Apt. 117', 'Eliseburgh', 'green.cassie@example.net'),
(41, 'Isaias', 'Zemlak', '8676 Abshire Station Apt. 832', 'Riceborough', 'robel.arielle@example.com'),
(42, 'Rahul', 'Medhurst', '17559 Johnson Junction Apt. 346', 'South Elnora', 'baylee42@example.org'),
(43, 'Lon', 'Rosenbaum', '87695 Christiana Harbor Apt. 047', 'McGlynnbury', 'priscilla61@example.org'),
(44, 'Ezekiel', 'Klein', '8694 Jacobson Via Suite 852', 'New Jenniferborough', 'kschoen@example.net'),
(45, 'Israel', 'Stanton', '334 Anderson Ferry', 'Flatleyfort', 'xo\'keefe@example.com'),
(46, 'Kamryn', 'Prohaska', '53231 Walker Green', 'Dakotamouth', 'bfay@example.net'),
(47, 'Jess', 'Haley', '40783 Carter Canyon', 'Zoefort', 'euna29@example.com'),
(48, 'Bryon', 'Gusikowski', '686 Hahn Ports Suite 392', 'Framibury', 'akeem91@example.org'),
(49, 'Sid', 'Beahan', '327 Hilpert Falls Apt. 158', 'Fernton', 'madaline.marquardt@example.org'),
(50, 'Nick', 'Corwin', '926 Zulauf Spur Suite 615', 'Jakubowskiville', 'creola.bayer@example.net');

-- --------------------------------------------------------

--
-- Table structure for table `Tasks`
--

CREATE TABLE `Tasks` (
  `TaskId` int(11) NOT NULL,
  `CustomerId` int(11) DEFAULT NULL,
  `BikeId` int(11) DEFAULT NULL,
  `Indication` varchar(255) DEFAULT NULL,
  `TaskDate` date DEFAULT NULL,
  `TaskReadyDate` date DEFAULT NULL,
  `Description` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Bikes`
--
ALTER TABLE `Bikes`
  ADD UNIQUE KEY `BikeId_2` (`BikeId`),
  ADD KEY `BikeId` (`BikeId`,`BikeBrand`,`BikeType`,`RimSize`,`NumberOfGears`,`DateLastTask`);

--
-- Indexes for table `Customers`
--
ALTER TABLE `Customers`
  ADD PRIMARY KEY (`CustomerId`),
  ADD UNIQUE KEY `CustomerId` (`CustomerId`),
  ADD KEY `CustomerId_2` (`CustomerId`,`FirstName`,`LastName`,`Email`),
  ADD KEY `CustomerId_3` (`CustomerId`,`FirstName`,`LastName`,`Email`);

--
-- Indexes for table `Tasks`
--
ALTER TABLE `Tasks`
  ADD PRIMARY KEY (`TaskId`),
  ADD KEY `TaskId` (`TaskId`,`CustomerId`,`BikeId`,`Indication`,`TaskDate`,`TaskReadyDate`),
  ADD KEY `BikeId` (`BikeId`),
  ADD KEY `CustomerId` (`CustomerId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Tasks`
--
ALTER TABLE `Tasks`
  ADD CONSTRAINT `Tasks_ibfk_2` FOREIGN KEY (`CustomerId`) REFERENCES `Customers` (`CustomerId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;