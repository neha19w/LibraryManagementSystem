-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 19, 2021 at 11:09 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CNatives`
--

-- --------------------------------------------------------

--
-- Table structure for table `Reconcilation_Rule`
--

CREATE TABLE `Reconcilation_Rule` (
  `id` int(11) NOT NULL,
  `isActive` bit(1) DEFAULT NULL,
  `ruleName` varchar(255) DEFAULT NULL,
  `rulePriorityId` int(11) NOT NULL,
  `ruleVersion` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Reconcilation_Rule`
--

INSERT INTO `Reconcilation_Rule` (`id`, `isActive`, `ruleName`, `rulePriorityId`, `ruleVersion`) VALUES
(5, b'1', 'SAP', 0, '01');

-- --------------------------------------------------------

--
-- Table structure for table `Reconcilation_Rule_Rule_Condition`
--

CREATE TABLE `Reconcilation_Rule_Rule_Condition` (
  `Reconcilation_Rule_id` int(11) NOT NULL,
  `ruleConditions_Rule_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Reconcilation_Rule_Rule_Condition`
--

INSERT INTO `Reconcilation_Rule_Rule_Condition` (`Reconcilation_Rule_id`, `ruleConditions_Rule_ID`) VALUES
(5, 10),
(5, 9);

-- --------------------------------------------------------

--
-- Table structure for table `Rule_Condition`
--

CREATE TABLE `Rule_Condition` (
  `Rule_ID` int(11) NOT NULL,
  `Rule_Condition` varchar(255) DEFAULT NULL,
  `field` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Rule_Condition`
--

INSERT INTO `Rule_Condition` (`Rule_ID`, `Rule_Condition`, `field`, `value`) VALUES
(10, 'matches', 'invoiceAmount', 'nearby'),
(9, 'matches', 'invoiceNumber', 'exact');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Reconcilation_Rule`
--
ALTER TABLE `Reconcilation_Rule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Reconcilation_Rule_Rule_Condition`
--
ALTER TABLE `Reconcilation_Rule_Rule_Condition`
  ADD UNIQUE KEY `UK_i0gxvoyj4jm90hxjutgxol7ms` (`ruleConditions_Rule_ID`),
  ADD KEY `FKh6syuouajom4d4uc36ac85gh9` (`Reconcilation_Rule_id`);

--
-- Indexes for table `Rule_Condition`
--
ALTER TABLE `Rule_Condition`
  ADD PRIMARY KEY (`Rule_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Reconcilation_Rule`
--
ALTER TABLE `Reconcilation_Rule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Rule_Condition`
--
ALTER TABLE `Rule_Condition`
  MODIFY `Rule_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
