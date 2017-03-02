-- phpMyAdmin SQL Dump
-- version 4.6.4deb1
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Jeu 02 Mars 2017 à 13:53
-- Version du serveur :  5.7.17-0ubuntu0.16.10.1
-- Version de PHP :  7.0.15-0ubuntu0.16.10.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `locationthies`
--

-- --------------------------------------------------------

--
-- Structure de la table `table_appartemet`
--

CREATE TABLE `table_appartemet` (
  `numAppartement` int(5) NOT NULL,
  `etage` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `table_chambre`
--

CREATE TABLE `table_chambre` (
  `numChambre` int(11) NOT NULL,
  `nombreBalcon` int(11) DEFAULT NULL,
  `nombreToilette` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `table_logement`
--

CREATE TABLE `table_logement` (
  `numLogement` int(5) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `prix` int(5) DEFAULT NULL,
  `numVille` int(5) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `numProprietaire` int(5) DEFAULT NULL,
  `surface` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `table_maison`
--

CREATE TABLE `table_maison` (
  `numMaison` int(5) NOT NULL,
  `nombreEtage` int(5) DEFAULT NULL,
  `nombreParking` int(5) DEFAULT NULL,
  `dateConstruction` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `table_multiPiece`
--

CREATE TABLE `table_multiPiece` (
  `numMultiPiece` int(5) NOT NULL,
  `nombreBalcon` int(5) DEFAULT NULL,
  `nombreChambre` int(5) DEFAULT NULL,
  `nombreToilette` int(5) DEFAULT NULL,
  `nombreCuisine` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `table_proprietaire`
--

CREATE TABLE `table_proprietaire` (
  `numProprietaire` int(5) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `mail` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `table_ville`
--

CREATE TABLE `table_ville` (
  `numVille` int(5) NOT NULL,
  `superficie` int(15) DEFAULT NULL,
  `population` int(15) DEFAULT NULL,
  `nom` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `table_appartemet`
--
ALTER TABLE `table_appartemet`
  ADD PRIMARY KEY (`numAppartement`);

--
-- Index pour la table `table_chambre`
--
ALTER TABLE `table_chambre`
  ADD PRIMARY KEY (`numChambre`);

--
-- Index pour la table `table_logement`
--
ALTER TABLE `table_logement`
  ADD PRIMARY KEY (`numLogement`);

--
-- Index pour la table `table_maison`
--
ALTER TABLE `table_maison`
  ADD PRIMARY KEY (`numMaison`);

--
-- Index pour la table `table_multiPiece`
--
ALTER TABLE `table_multiPiece`
  ADD PRIMARY KEY (`numMultiPiece`);

--
-- Index pour la table `table_proprietaire`
--
ALTER TABLE `table_proprietaire`
  ADD PRIMARY KEY (`numProprietaire`);

--
-- Index pour la table `table_ville`
--
ALTER TABLE `table_ville`
  ADD PRIMARY KEY (`numVille`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `table_logement`
--
ALTER TABLE `table_logement`
  MODIFY `numLogement` int(5) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
