-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Jun 11, 2024 at 05:00 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `storehub`
--

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

CREATE TABLE `checkout` (
  `id_produk` int(11) NOT NULL,
  `user_id` int(25) NOT NULL,
  `kategori` varchar(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `harga` double NOT NULL,
  `deskripsi` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`id_produk`, `user_id`, `kategori`, `nama`, `harga`, `deskripsi`) VALUES
(27, 0, 'Elektronik', 'testElektronik', 100, 'test'),
(28, 33660, 'Elektronik', 'testLapotp', 28, 'yes'),
(29, 33660, 'Elektronik', 'stupid', 1000000, 'sfsdfssfsd');

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE `keranjang` (
  `id_produk` int(11) NOT NULL,
  `user_id` int(25) NOT NULL,
  `kategori` varchar(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `harga` double NOT NULL,
  `deskripsi` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `keranjang`
--

INSERT INTO `keranjang` (`id_produk`, `user_id`, `kategori`, `nama`, `harga`, `deskripsi`) VALUES
(34, 66227, 'Elektronik', 'stupid', 1000000, 'sfsdfssfsd'),
(35, 66227, 'Pakaian', 'test', 10, 'testsettestset'),
(37, 0, 'Buku', 'Sample Buku', 19.99, 'Sample Description'),
(38, 0, 'Pakaian', 'testPakaian', 10000, 'ini pakaian');

-- --------------------------------------------------------

--
-- Table structure for table `tb_produk`
--

CREATE TABLE `tb_produk` (
  `id_produk` int(11) NOT NULL,
  `kategori` varchar(10) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `harga` double NOT NULL,
  `deskripsi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_produk`
--

INSERT INTO `tb_produk` (`id_produk`, `kategori`, `nama`, `harga`, `deskripsi`) VALUES
(1, 'Buku', 'Sample Buku', 19.99, 'Sample Description'),
(2, 'Pakaian', 'testPakaian', 10000, 'ini pakaian'),
(3, 'Elektronik', 'testElektronik', 100, 'test'),
(4, 'Elektronik', 'testLapotp', 28, 'yes'),
(5, 'Elektronik', 'helo', 100, 'test'),
(6, 'Buku', 'BukuGila', 100000, 'gila'),
(7, 'Pakaian', 'test', 10, 'testsettestset'),
(8, 'Elektronik', 'stupid', 1000000, 'sfsdfssfsd'),
(9, 'Buku', 'eleceed', 9000, 'barang bekas');

-- --------------------------------------------------------

--
-- Table structure for table `tb_wishlist`
--

CREATE TABLE `tb_wishlist` (
  `id_produk` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `kategori` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `deskripsi` varchar(50) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(25) NOT NULL,
  `Nama` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `Nama`, `Password`, `balance`) VALUES
(18615, 'galang312', 'qwerty', 0),
(33660, 'test', 'test123', 73000),
(36968, 'galang312', 'qwerty', 0),
(66227, 'salman', '123', 0),
(69549, 'afzaal', '1231313', 14945.01999999999);

-- --------------------------------------------------------

--
-- Table structure for table `wishlist`
--

CREATE TABLE `wishlist` (
  `id_produk` int(25) NOT NULL,
  `user_id` int(25) NOT NULL,
  `kategori` varchar(25) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `harga` double NOT NULL,
  `deskripsi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `wishlist`
--

INSERT INTO `wishlist` (`id_produk`, `user_id`, `kategori`, `nama`, `harga`, `deskripsi`) VALUES
(2, 69549, 'Elektronik', 'stupid', 1000000, 'sfsdfssfsd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `checkout`
--
ALTER TABLE `checkout`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indexes for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indexes for table `tb_produk`
--
ALTER TABLE `tb_produk`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indexes for table `tb_wishlist`
--
ALTER TABLE `tb_wishlist`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`id_produk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `keranjang`
--
ALTER TABLE `keranjang`
  MODIFY `id_produk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `tb_produk`
--
ALTER TABLE `tb_produk`
  MODIFY `id_produk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tb_wishlist`
--
ALTER TABLE `tb_wishlist`
  MODIFY `id_produk` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `id_produk` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
