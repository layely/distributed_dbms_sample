-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 09 Mars 2017 à 10:56
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `locationdakar`
--

-- --------------------------------------------------------

--
-- Structure de la table `table_appartemet`
--

CREATE TABLE IF NOT EXISTS `table_appartemet` (
  `numAppartement` int(5) NOT NULL,
  `etage` int(5) DEFAULT NULL,
  PRIMARY KEY (`numAppartement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `table_appartemet`
--

INSERT INTO `table_appartemet` (`numAppartement`, `etage`) VALUES
(1, 2),
(2, 1),
(3, 2),
(4, 2),
(5, 2),
(6, 4);

-- --------------------------------------------------------

--
-- Structure de la table `table_chambre`
--

CREATE TABLE IF NOT EXISTS `table_chambre` (
  `numChambre` int(11) NOT NULL,
  `nombreBalcon` int(11) DEFAULT NULL,
  `nombreToilette` int(11) DEFAULT NULL,
  PRIMARY KEY (`numChambre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `table_chambre`
--

INSERT INTO `table_chambre` (`numChambre`, `nombreBalcon`, `nombreToilette`) VALUES
(1, 2, 1),
(2, 2, 1),
(3, 2, 1),
(4, 2, 2),
(5, 2, 2),
(6, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `table_logement`
--

CREATE TABLE IF NOT EXISTS `table_logement` (
  `numLogement` int(5) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `prix` int(5) DEFAULT NULL,
  `nomVille` varchar(50) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `numProprietaire` int(5) DEFAULT NULL,
  `surface` int(5) DEFAULT NULL,
  PRIMARY KEY (`numLogement`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `table_logement`
--

INSERT INTO `table_logement` (`numLogement`, `description`, `prix`, `nomVille`, `address`, `numProprietaire`, `surface`) VALUES
(1, 'bedroom', 25000, 'dakar', 'sapco', 1, 123),
(2, 'desk', 25000, 'thies', 'sapco', 2, 13),
(3, 'cut', 30000, 'dakar', 'medina', 3, 23),
(4, 'err', 12500, 'dakar', 'tilene', 1, 18),
(5, 'exp', 27500, 'thies', 'Mbour1', 3, 123),
(6, 'part', 35000, 'thies', 'cite lamine', 6, 15);

-- --------------------------------------------------------

--
-- Structure de la table `table_maison`
--

CREATE TABLE IF NOT EXISTS `table_maison` (
  `numMaison` int(5) NOT NULL,
  `nombreEtage` int(5) DEFAULT NULL,
  `nombreParking` int(5) DEFAULT NULL,
  `dateConstruction` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`numMaison`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `table_maison`
--

INSERT INTO `table_maison` (`numMaison`, `nombreEtage`, `nombreParking`, `dateConstruction`) VALUES
(1, 3, 2, 'mars 2001'),
(2, 2, 1, 'fevrier 2000'),
(3, 1, 2, 'mai 203'),
(4, 5, 3, 'août 2016'),
(5, 2, 1, 'janvier 2017'),
(6, 2, 2, 'decembre 2000');

-- --------------------------------------------------------

--
-- Structure de la table `table_multipiece`
--

CREATE TABLE IF NOT EXISTS `table_multipiece` (
  `numMultiPiece` int(5) NOT NULL,
  `nombreBalcon` int(5) DEFAULT NULL,
  `nombreChambre` int(5) DEFAULT NULL,
  `nombreToilette` int(5) DEFAULT NULL,
  `nombreCuisine` int(5) DEFAULT NULL,
  PRIMARY KEY (`numMultiPiece`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `table_multipiece`
--

INSERT INTO `table_multipiece` (`numMultiPiece`, `nombreBalcon`, `nombreChambre`, `nombreToilette`, `nombreCuisine`) VALUES
(1, 2, 4, 3, 1),
(2, 3, 3, 2, 1),
(3, 2, 3, 2, 1),
(4, 3, 3, 2, 1),
(5, 2, 2, 1, 1),
(6, 2, 2, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `table_proprietaire`
--

CREATE TABLE IF NOT EXISTS `table_proprietaire` (
  `numProprietaire` int(5) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`numProprietaire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `table_proprietaire`
--

INSERT INTO `table_proprietaire` (`numProprietaire`, `nom`, `prenom`, `address`, `tel`, `mail`) VALUES
(1, 'diallo', 'mamadou', 'sapco', '77 077 75 20', 'mamadou@master.inf'),
(2, 'ly ', 'ablaye', 'new york', '77 821 21 21', 'ablayely@master.inf'),
(3, 'diakhoumpa', 'matar', 'pikine', '77 098 00 01', 'matardiakoumpa@master.inf'),
(4, 'dia', 'ibrahim', 'tilene', '77 878 99 09', 'diai@master.inf'),
(5, 'diop', 'saliou', 'medina', '70 098 76 89', 'saliou@master.inf'),
(6, 'leye', 'soxna', 'thialy', '77 890 14 23', 'soxna@master.inf');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
