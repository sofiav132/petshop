-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 08, 2021 at 10:18 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `petshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `email`, `password`, `created_at`) VALUES
(1, 'Boy', 'Boy123@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '2021-10-06 00:39:46'),
(2, 'Group 8', 'Group8@yahoo.co.id', '25d55ad283aa400af464c76d713c07ad', '2021-10-08 09:07:27');

-- --------------------------------------------------------

--
-- Table structure for table `divisi`
--

CREATE TABLE `divisi` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `divisi`
--

INSERT INTO `divisi` (`id`, `name`, `description`, `created_at`) VALUES
(3, 'Cashier', NULL, '2021-10-07 21:47:38'),
(4, 'Salesperson', NULL, '2021-10-07 21:47:38'),
(5, 'Vet', NULL, '2021-10-07 21:47:38'),
(6, 'Officeboy', NULL, '2021-10-07 21:47:38');

-- --------------------------------------------------------

--
-- Table structure for table `tbcustomer`
--

CREATE TABLE `tbcustomer` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `telephone1` varchar(14) DEFAULT NULL,
  `telephone2` varchar(14) DEFAULT NULL,
  `address` varchar(1000) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbcustomer`
--

INSERT INTO `tbcustomer` (`id`, `name`, `telephone1`, `telephone2`, `address`, `created_at`) VALUES
(7, 'nih ya', '09876543210', '23456789012', 'JL.Gatau No 34', '2021-10-06 20:41:16');

-- --------------------------------------------------------

--
-- Table structure for table `tbemployee`
--

CREATE TABLE `tbemployee` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `divisi_id` int(11) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `telephone` varchar(14) DEFAULT NULL,
  `address` varchar(1000) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbemployee`
--

INSERT INTO `tbemployee` (`id`, `name`, `divisi_id`, `gender`, `telephone`, `address`, `admin_id`, `created_at`) VALUES
(2, 'Boy', 5, 'Male', '0812345678910', 'Jl.Manalagi No.100', 2, '2021-10-08 09:08:33'),
(3, 'Boy', 5, 'Male', '0812345678910', 'Jl.Rumah No.10, Jakarta Timur', 1, '2021-10-08 11:43:42');

-- --------------------------------------------------------

--
-- Table structure for table `tbproduct`
--

CREATE TABLE `tbproduct` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `stock` varchar(255) DEFAULT NULL,
  `price` int(20) DEFAULT NULL,
  `description` varchar(1000) NOT NULL,
  `expired` date NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbproduct`
--

INSERT INTO `tbproduct` (`id`, `name`, `stock`, `price`, `description`, `expired`, `supplier_id`, `admin_id`, `created_at`) VALUES
(1, 'Whiskas', '10', 8000, 'Makanan Kucing', '2022-10-01', 3, 1, '2021-10-08 12:08:24'),
(2, 'Pedigree', '10', 30000, 'Makanan anjing', '2022-10-08', 5, 1, '2021-10-08 14:58:44');

-- --------------------------------------------------------

--
-- Table structure for table `tbsupplier`
--

CREATE TABLE `tbsupplier` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `telephone` varchar(14) DEFAULT NULL,
  `address` varchar(1000) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbsupplier`
--

INSERT INTO `tbsupplier` (`id`, `name`, `telephone`, `address`, `created_at`) VALUES
(3, 'PT Unilever', '0213456789', 'Jl.Gudang No.100-110, Bekasi', '2021-10-08 11:44:47'),
(4, 'PT Kino', '0215678930', 'Jl.Saluran No.100, Jakarta Selatan', '2021-10-08 11:46:21'),
(5, 'Mars,Inc', '021345678', 'Jl.Melayu No.11, Bandung', '2021-10-08 14:56:44');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `divisi`
--
ALTER TABLE `divisi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbcustomer`
--
ALTER TABLE `tbcustomer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbemployee`
--
ALTER TABLE `tbemployee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `divisi_id` (`divisi_id`),
  ADD KEY `admin_id` (`admin_id`);

--
-- Indexes for table `tbproduct`
--
ALTER TABLE `tbproduct`
  ADD PRIMARY KEY (`id`),
  ADD KEY `supplier_id` (`supplier_id`),
  ADD KEY `admin_id` (`admin_id`);

--
-- Indexes for table `tbsupplier`
--
ALTER TABLE `tbsupplier`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `divisi`
--
ALTER TABLE `divisi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbcustomer`
--
ALTER TABLE `tbcustomer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbemployee`
--
ALTER TABLE `tbemployee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbproduct`
--
ALTER TABLE `tbproduct`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbsupplier`
--
ALTER TABLE `tbsupplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbemployee`
--
ALTER TABLE `tbemployee`
  ADD CONSTRAINT `tbemployee_ibfk_1` FOREIGN KEY (`divisi_id`) REFERENCES `divisi` (`id`),
  ADD CONSTRAINT `tbemployee_ibfk_2` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`);

--
-- Constraints for table `tbproduct`
--
ALTER TABLE `tbproduct`
  ADD CONSTRAINT `tbproduct_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `tbsupplier` (`id`),
  ADD CONSTRAINT `tbproduct_ibfk_2` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
