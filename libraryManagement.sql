-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 22, 2021 at 08:24 AM
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
-- Database: `libraryManagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `BookHistory`
--

CREATE TABLE `BookHistory` (
  `id` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `dateIn` varchar(255) DEFAULT NULL,
  `dateOut` varchar(255) DEFAULT NULL,
  `readerId` int(11) NOT NULL,
  `readerName` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `BookHistory`
--

INSERT INTO `BookHistory` (`id`, `bookId`, `dateIn`, `dateOut`, `readerId`, `readerName`) VALUES
(3, 2, '2021-40-22 12:40:22', '2021-40-22 12:40:58', 201, NULL),
(10, 2, '2021-47-22 12:47:50', '', 101, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Books`
--

CREATE TABLE `Books` (
  `id` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `availability` varchar(255) NOT NULL,
  `bookName` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `currentIdReader` int(11) NOT NULL,
  `genre` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Books`
--

INSERT INTO `Books` (`id`, `author`, `availability`, `bookName`, `comments`, `currentIdReader`, `genre`) VALUES
(1, 'James Gosling', 'Yes', 'Java', 'Best Programming Book', 0, 'Programming'),
(2, 'Eric', 'Yes', 'Python', 'Python Programming Book', 0, 'Programming');

-- --------------------------------------------------------

--
-- Table structure for table `Reader`
--

CREATE TABLE `Reader` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `place` varchar(255) DEFAULT NULL,
  `readerEmail` varchar(255) DEFAULT NULL,
  `readerName` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Reader`
--

INSERT INTO `Reader` (`id`, `age`, `place`, `readerEmail`, `readerName`) VALUES
(201, 25, 'Bhopal', 'neha19w@gmail.com', 'Neha'),
(202, 22, 'Indore', 'pooja09d@gmail.com', 'Pooja');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `BookHistory`
--
ALTER TABLE `BookHistory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Books`
--
ALTER TABLE `Books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Reader`
--
ALTER TABLE `Reader`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `BookHistory`
--
ALTER TABLE `BookHistory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `Books`
--
ALTER TABLE `Books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Reader`
--
ALTER TABLE `Reader`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=203;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
