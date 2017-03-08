-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 08, 2017 at 02:21 PM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `central`
--

-- --------------------------------------------------------

--
-- Table structure for table `ConnectionInfo`
--

CREATE TABLE `ConnectionInfo` (
  `site` varchar(100) NOT NULL,
  `ip_addr` text NOT NULL,
  `db_name` varchar(100) NOT NULL,
  `port` int(11) NOT NULL DEFAULT '3306',
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ConnectionInfo`
--

INSERT INTO `ConnectionInfo` (`site`, `ip_addr`, `db_name`, `port`, `username`, `password`) VALUES
('DAKAR', 'localhost', 'locationdakar', 3306, 'gl', 'gl'),
('THIES', 'localhost', 'locationthies', 3306, 'gl', 'gl');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ConnectionInfo`
--
ALTER TABLE `ConnectionInfo`
  ADD PRIMARY KEY (`site`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
