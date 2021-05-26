-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host:
-- Generation Time: Apr 17, 2021 at 03:39 PM
-- Server version: 10.5.8-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `roche_gsbv2`
--

-- --------------------------------------------------------

--
-- Table structure for table `donnee`
--

CREATE TABLE `donnee` (
  `id` int(45) NOT NULL,
  `employe` varchar(200) NOT NULL,
  `region` varchar(200) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `present` varchar(255) NOT NULL,
  `compte` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `produit` varchar(255) NOT NULL,
  `echantillon` varchar(255) NOT NULL,
  `nbdon` varchar(255) NOT NULL,
  `rdv` varchar(255) NOT NULL,
  `lieu` varchar(255) NOT NULL,
  `comm` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donnee`
--

INSERT INTO `donnee` (`id`, `employe`, `region`, `contact`, `present`, `compte`, `adresse`, `produit`, `echantillon`, `nbdon`, `rdv`, `lieu`, `comm`) VALUES
(26537, '210', '74', '06.00.00.00.00', 'Louis Jean', 'Laboratoire OFIS', 'Paris, France', 'Test PCR + Antigénique', 'Test PCR + Antigénique', '5', '2020-12-25', 'Paris, France', 'Proposer un nouveau rdv pour reconvaincre le client.'),
(37590, '213', '14', '06.00.00.00.00', 'Luc Lacroix', 'LaboLab', 'Toulouse, France', 'Test PCR', 'Aucun', '0', '2021-03-10', 'Toulouse, France', 'R.A.S'),
(23476, '210', '75', '06.00.00.00.00', 'Gabriel', 'Vers la Lune', '15 rue de Paris, Paris 75001', 'Oxymètre', '1 (retours)', '0', '2021-03-15', 'Paris', 'Le client a été ravi concernant la qualité et la précision du matériel.\r\nCommande à réaliser avant fin Mars.\r\nExpédition à prévoir pour mi-Mai 2021.\r\nPrix négocié à l\'unité 15,25\r\nQuantité 55\r\nPrix de la commande 838,75 par virement'),
(18467, '202', '75', '06.00.00.00.00', 'Pierre DeLaCrois', 'Pfizer', 'New York, États-Unis', 'seringue', 'seringue', '50', '2021-01-20', 'New York, États-Unis', 'Commande future à conclure');

-- --------------------------------------------------------

--
-- Table structure for table `maj`
--

CREATE TABLE `maj` (
  `id` int(45) NOT NULL,
  `num_disp` varchar(200) NOT NULL,
  `date` varchar(100) NOT NULL,
  `new` varchar(250) NOT NULL,
  `os` varchar(222) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maj`
--

INSERT INTO `maj` (`id`, `num_disp`, `date`, `new`, `os`) VALUES
(1, '2.0.0', '2021-04-25', 'Simplification du fonctionnement de l\'application.', 'windows'),
(2, '2.0.0', '2021-04-25', 'Simplification du fonctionnement de l\'application.', 'macos'),
(3, 'IMPORTANT UPDATE', '2021-03-29', 'Mise à jour importante pour GSB sur macOS et Windows. Téléchargez la version correspondant à votre sytème.', '');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(45) NOT NULL,
  `login` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `fonction` varchar(255) NOT NULL,
  `region` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `mdp`, `fonction`, `region`) VALUES
(201, 'pierre', 'dvd', 'deleguer', '77'),
(202, 'pierre', 'chris', 'deleguer', '65'),
(203, 'francois', 'aln', 'deleguer', '45'),
(204, 'pierre', 'dvc', 'responsable', '23'),
(205, 'henry', 'jean', 'responsable', '45'),
(206, 'sophie', 'lal', 'responsable', '67'),
(210, 'lvillachane', 'jux7g', 'visiteur', '23'),
(211, 'cbedos', 'gmhxd', 'visiteur', '77'),
(212, 'ltusseau', 'ktp3s', 'visiteur', '75'),
(213, 'pbentot', 'doyw1', 'visiteur', '74'),
(214, 'lbioret', 'hrjfs', 'visiteur', '12'),
(215, 'fbunisset', '4vbnd', 'visiteur', '23'),
(216, 'dbunisset', 's1y1r', 'visiteur', '12'),
(217, 'admin', 'admin', 'admin', '75'),
(218, 'admin1', 'admin1', 'admin', '77');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `donnee`
--
ALTER TABLE `donnee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `maj`
--
ALTER TABLE `maj`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `donnee`
--
ALTER TABLE `donnee`
  MODIFY `id` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98565;

--
-- AUTO_INCREMENT for table `maj`
--
ALTER TABLE `maj`
  MODIFY `id` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=219;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
