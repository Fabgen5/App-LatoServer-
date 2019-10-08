-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Creato il: Ott 08, 2019 alle 15:11
-- Versione del server: 5.7.19
-- Versione PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myunivaqmobile`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `appelli`
--

DROP TABLE IF EXISTS `appelli`;
CREATE TABLE IF NOT EXISTS `appelli` (
  `id_appello` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_appello` datetime(6) NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `tipologia_esame` varchar(255) DEFAULT NULL,
  `id_insegnamento` bigint(20) NOT NULL,
  PRIMARY KEY (`id_appello`),
  KEY `FKblbv0dlccd45a1ko8d0b82uu5` (`id_insegnamento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `appelli`
--

INSERT INTO `appelli` (`id_appello`, `data_appello`, `descrizione`, `tipologia_esame`, `id_insegnamento`) VALUES
(1, '2019-10-24 16:05:48.197000', '1 appello giugno', 'ORALE', 1),
(2, '2019-09-19 23:03:01.010000', '2 appello giugno', 'ORALE', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `appelli_studenti`
--

DROP TABLE IF EXISTS `appelli_studenti`;
CREATE TABLE IF NOT EXISTS `appelli_studenti` (
  `id_appello` bigint(20) NOT NULL,
  `id_studente` bigint(20) NOT NULL,
  PRIMARY KEY (`id_appello`,`id_studente`),
  KEY `FKf71t85xkghlhugi0g4de31oxv` (`id_studente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `corsi_di_laurea`
--

DROP TABLE IF EXISTS `corsi_di_laurea`;
CREATE TABLE IF NOT EXISTS `corsi_di_laurea` (
  `id_corso_di_laurea` bigint(20) NOT NULL AUTO_INCREMENT,
  `classe` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_corso_di_laurea`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `corsi_di_laurea`
--

INSERT INTO `corsi_di_laurea` (`id_corso_di_laurea`, `classe`, `nome`) VALUES
(1, 'L-31', 'Informatica'),
(2, 'L-32', 'Master Web Technology');

-- --------------------------------------------------------

--
-- Struttura della tabella `insegnamenti`
--

DROP TABLE IF EXISTS `insegnamenti`;
CREATE TABLE IF NOT EXISTS `insegnamenti` (
  `id_insegnamento` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfu` int(11) NOT NULL,
  `codice` varchar(255) NOT NULL,
  `denominazione` varchar(255) NOT NULL,
  `lingua` varchar(255) DEFAULT NULL,
  `periodo_insegnamento` int(11) NOT NULL,
  `tipologia_credito` varchar(255) DEFAULT NULL,
  `id_corso_di_laurea` bigint(20) NOT NULL,
  `id_docente` bigint(20) NOT NULL,
  PRIMARY KEY (`id_insegnamento`),
  KEY `FKqgabfjpcei6mlg46im3n8rrfh` (`id_corso_di_laurea`),
  KEY `FKniqqnbb5f8jo04xfn1gn177s6` (`id_docente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `insegnamenti`
--

INSERT INTO `insegnamenti` (`id_insegnamento`, `cfu`, `codice`, `denominazione`, `lingua`, `periodo_insegnamento`, `tipologia_credito`, `id_corso_di_laurea`, `id_docente`) VALUES
(1, 6, 'F1081', 'Applicazioni per Dispositivi Mobili', 'ITA', 2, 'b', 1, 1),
(2, 5, 'F7W027', 'Programmazione avanzata Java', 'ITA', 1, 'b', 2, 1),
(3, 6, 'F7W021', 'Piattaforma JEE', 'ITA', 2, 'b', 2, 1),
(4, 6, 'F1I021', 'Laboratorio di Sistemi Operativi', 'ITA', 1, 'b', 1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `negozio`
--

DROP TABLE IF EXISTS `negozio`;
CREATE TABLE IF NOT EXISTS `negozio` (
  `id_negozio` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `giorniapertura` varchar(255) NOT NULL,
  `immagineprofilo` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `orario` varchar(255) NOT NULL,
  `piva` varchar(255) NOT NULL,
  PRIMARY KEY (`id_negozio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `negozio`
--

INSERT INTO `negozio` (`id_negozio`, `categoria`, `descrizione`, `giorniapertura`, `immagineprofilo`, `nome`, `orario`, `piva`) VALUES
(1, 'Freeway', 'Freeway', 'Lun-Ven', 'Negozio0.jpg', 'Freeway', '9:00-18:00', 'Freeway');

-- --------------------------------------------------------

--
-- Struttura della tabella `notizie`
--

DROP TABLE IF EXISTS `notizie`;
CREATE TABLE IF NOT EXISTS `notizie` (
  `id_notizia` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_pubblicazione` datetime(6) NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `immagine` varchar(255) NOT NULL,
  `titolo` varchar(255) NOT NULL,
  `id_negozio` bigint(20) NOT NULL,
  `id_tipologia_notizia` bigint(20) NOT NULL,
  PRIMARY KEY (`id_notizia`),
  KEY `FKbq9phv3sdtmn522bjnu37f5r9` (`id_negozio`),
  KEY `FKr82qyxjvtugtm92wsopix0r11` (`id_tipologia_notizia`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `notizie`
--

INSERT INTO `notizie` (`id_notizia`, `data_pubblicazione`, `descrizione`, `immagine`, `titolo`, `id_negozio`, `id_tipologia_notizia`) VALUES
(1, '2019-10-04 16:05:47.537000', 'Sconti di 0% su tutta la collezione ', 'image0.jpg', 'Annuncio 0', 1, 1),
(2, '2019-10-03 16:05:47.789000', 'Sconti di 1% su tutta la collezione ', 'image1.jpg', 'Annuncio 1', 1, 1),
(3, '2019-10-02 16:05:47.830000', 'Sconti di 2% su tutta la collezione ', 'image2.jpg', 'Annuncio 2', 1, 1),
(4, '2019-10-01 16:05:47.841000', 'Sconti di 3% su tutta la collezione ', 'image3.jpg', 'Annuncio 3', 1, 1),
(5, '2019-09-30 16:05:47.852000', 'Sconti di 4% su tutta la collezione ', 'image4.jpg', 'Annuncio 4', 1, 1),
(6, '2019-09-29 16:05:47.867000', 'Sconti di 5% su tutta la collezione ', 'image5.jpg', 'Annuncio 5', 1, 1),
(7, '2019-09-28 16:05:47.877000', 'Sconti di 6% su tutta la collezione ', 'image6.jpg', 'Annuncio 6', 1, 1),
(8, '2019-09-27 16:05:47.889000', 'Sconti di 7% su tutta la collezione ', 'image7.jpg', 'Annuncio 7', 1, 1),
(9, '2019-09-26 16:05:47.903000', 'Sconti di 8% su tutta la collezione ', 'image8.jpg', 'Annuncio 8', 1, 1),
(10, '2019-09-25 16:05:47.917000', 'Sconti di 9% su tutta la collezione ', 'image9.jpg', 'Annuncio 9', 1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `tipologie_notizia`
--

DROP TABLE IF EXISTS `tipologie_notizia`;
CREATE TABLE IF NOT EXISTS `tipologie_notizia` (
  `id_tipologia_notizia` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_tipologia_notizia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `tipologie_notizia`
--

INSERT INTO `tipologie_notizia` (`id_tipologia_notizia`, `nome`) VALUES
(1, 'Didattica'),
(2, 'Lavoro');

-- --------------------------------------------------------

--
-- Struttura della tabella `utente_notizia`
--

DROP TABLE IF EXISTS `utente_notizia`;
CREATE TABLE IF NOT EXISTS `utente_notizia` (
  `id_notizia` bigint(20) NOT NULL,
  `id_utente` bigint(20) NOT NULL,
  PRIMARY KEY (`id_notizia`,`id_utente`),
  KEY `FKt5nh2is3p7a23vx1hnab5741m` (`id_utente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utente_notizia`
--

INSERT INTO `utente_notizia` (`id_notizia`, `id_utente`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

DROP TABLE IF EXISTS `utenti`;
CREATE TABLE IF NOT EXISTS `utenti` (
  `tipologia_utente` varchar(31) NOT NULL,
  `id_utente` bigint(20) NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(16) NOT NULL,
  `id_negozio` bigint(20) DEFAULT NULL,
  `id_corso_di_laurea` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_utente`),
  UNIQUE KEY `UK_tn8mwk6h2wn28yyj7fco65gls` (`username`),
  KEY `FKjq4f4d2rwqfc17byfdtdjpqsd` (`id_negozio`),
  KEY `FKb2y9crdkqdqktrjn6nc0bojqe` (`id_corso_di_laurea`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`tipologia_utente`, `id_utente`, `cognome`, `email`, `nome`, `password`, `username`, `id_negozio`, `id_corso_di_laurea`) VALUES
('docente', 1, 'Di Salle', 'amleto.disalle@univaq.it', 'Amleto', '$2a$10$DpXQ6ljpG7DAJMa2qdL9vOR/Uw55eN3FV6BRaPjPAOM68vtylDhjK', 'amleto', NULL, NULL),
('negoziante', 2, 'Autili', 'marco.autili@univaq.it', 'Marco', '$2a$10$7bvo23eOc2ZkKVw2vscqPuJnMbib7PSfmUKmFRIMWAHAcWVRNGW8m', 'marco', 1, NULL),
('studente', 3, 'Studente', 'studente.studente@student.univaq.it', 'Studente', '$2a$10$cDQ8v82beILZEYnz8rmJC.4.psHMgOJdy9OReURjAtDM6DFK/97Ai', 'studente', NULL, 1);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `appelli`
--
ALTER TABLE `appelli`
  ADD CONSTRAINT `FKblbv0dlccd45a1ko8d0b82uu5` FOREIGN KEY (`id_insegnamento`) REFERENCES `insegnamenti` (`id_insegnamento`);

--
-- Limiti per la tabella `appelli_studenti`
--
ALTER TABLE `appelli_studenti`
  ADD CONSTRAINT `FKf71t85xkghlhugi0g4de31oxv` FOREIGN KEY (`id_studente`) REFERENCES `utenti` (`id_utente`),
  ADD CONSTRAINT `FKsbv4am8lgsb9n553i3il3sfpy` FOREIGN KEY (`id_appello`) REFERENCES `appelli` (`id_appello`);

--
-- Limiti per la tabella `insegnamenti`
--
ALTER TABLE `insegnamenti`
  ADD CONSTRAINT `FKniqqnbb5f8jo04xfn1gn177s6` FOREIGN KEY (`id_docente`) REFERENCES `utenti` (`id_utente`),
  ADD CONSTRAINT `FKqgabfjpcei6mlg46im3n8rrfh` FOREIGN KEY (`id_corso_di_laurea`) REFERENCES `corsi_di_laurea` (`id_corso_di_laurea`);

--
-- Limiti per la tabella `notizie`
--
ALTER TABLE `notizie`
  ADD CONSTRAINT `FKbq9phv3sdtmn522bjnu37f5r9` FOREIGN KEY (`id_negozio`) REFERENCES `negozio` (`id_negozio`),
  ADD CONSTRAINT `FKr82qyxjvtugtm92wsopix0r11` FOREIGN KEY (`id_tipologia_notizia`) REFERENCES `tipologie_notizia` (`id_tipologia_notizia`);

--
-- Limiti per la tabella `utente_notizia`
--
ALTER TABLE `utente_notizia`
  ADD CONSTRAINT `FK9i55v8q42jruqe4n0w2q5cc5o` FOREIGN KEY (`id_notizia`) REFERENCES `notizie` (`id_notizia`),
  ADD CONSTRAINT `FKt5nh2is3p7a23vx1hnab5741m` FOREIGN KEY (`id_utente`) REFERENCES `utenti` (`id_utente`);

--
-- Limiti per la tabella `utenti`
--
ALTER TABLE `utenti`
  ADD CONSTRAINT `FKb2y9crdkqdqktrjn6nc0bojqe` FOREIGN KEY (`id_corso_di_laurea`) REFERENCES `corsi_di_laurea` (`id_corso_di_laurea`),
  ADD CONSTRAINT `FKjq4f4d2rwqfc17byfdtdjpqsd` FOREIGN KEY (`id_negozio`) REFERENCES `negozio` (`id_negozio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
