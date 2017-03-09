-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 09 Mars 2017 à 17:01
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `projet_collaboratif`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `jeux_de_tests`()
BEGIN
	SET FOREIGN_KEY_CHECKS=0;

	TRUNCATE TABLE PERSONNE;
	TRUNCATE TABLE FORMATEUR;
	TRUNCATE TABLE ETUDIANT_PROMOTION;
	TRUNCATE TABLE ETUDIANT;
    TRUNCATE TABLE EQUIPE;
	TRUNCATE TABLE SESSION;
	TRUNCATE TABLE PROJET;
	TRUNCATE TABLE PARTICIPANT;

	SET FOREIGN_KEY_CHECKS=1;

	BEGIN
		DECLARE EXIT HANDLER FOR SQLSTATE '23000'
		BEGIN
			ROLLBACK;
			-- Afficher l'erreur
			SHOW ERRORS;
		END;

  
		START TRANSACTION;
		INSERT INTO PERSONNE (id_personne, nom,prenom,ville,telephone,email,mot_de_passe,code_postal,rue) VALUES 
	(1, 'Dupont','Pierre','Cachan','0678453423','dpierre','sqddfs','94200','Paul Vaillant'),
	(2, 'Albert','Medhi','Massy','067344523','amedhi','gsgsgsgs','91300','Breton'),
    (3, 'Patrice','Medhi','Massy','067344523','amedhi','gsgsgsgs','91300','Breton'),
	(4, 'Julie','Medhi','Massy','067344523','amedhi','gsgsgsgs','91300','Breton'),
	(5, 'Olivier','Medhi','Massy','067344523','amedhi','gsgsgsgs','91300','Breton'),
	(6, 'Alex','Medhi','Massy','067344523','amedhi','gsgsgsgs','91300','Breton'),
	(7, 'Maximilien','Medhi','Massy','067344523','amedhi','gsgsgsgs','91300','Breton'),
	(8, 'Hela','Arouay','Noisy le Grand','0675576230','h.arouay@feh.fr','gsgsgsgs','93000','Breton'),
    (9, 'Kate','Absalon','Juvisy','067344523','k.absalon@ef.fr','gsgsgsgs','91300','Breton'),
    (10, 'Keidy','Chaffort','Cachan','067344523','k.chaffort@bk.fr','gsgsgsgs','94300','Breton'),
    (11, 'Djiby','Diallo','Cachan','067344523','d.diallo@fjd.fr','gsgsgsgs','94300','Breton'),
    (12, 'Marco','Rodrigez','Massy','067344523','amedhi','gsgsgsgs','91300','Breton'),
    (13, 'Mohamed','Medhi','Massy','067344523','amedhi','gsgsgsgs','91300','Breton'),
    (14, 'Ibrahim','Medhi','Massy','067344523','amedhi','gsgsgsgs','91300','Breton'),
    (15, 'Alain','Medhi','Massy','067344523','a.jhsdjk@njdf.fr','gsgsgsgs','91300','Breton');


		INSERT INTO FORMATEUR (ID_PERSONNE) VALUES
    (1),
    (2),
    (3),
    (4),
    (5),
    (8),
    (9);
    
		INSERT INTO ETUDIANT (ID_PERSONNE) VALUES
    (6),
    (7),
    (10),
    (11),
    (12),
    (13),
    (14),
    (15);
    

		INSERT INTO SESSION (ID_SESSION, TITRE, DESCRIPTION) VALUES
    (1,'Java','blablabla'),
    (2,'Php','blablabla'),
    (3,'Html','blablabla');
    
    
		INSERT INTO PROJET (ID_PROJET, ID_SESSION, ID_CREATEUR, TITRE,SUJET,DATE_CREATION, DATE_LIMITE_RENDU ) VALUES
    (1,1,1,'projet_Java','blablabla','',''),
	(2,1,2,'projet_JEE','blablabla','',''),
    (3,2,2,'projet_php','blablabla','',''),
    (4,1,1,'projet_Java2','blablabla','','');
        
		INSERT INTO EQUIPE (ID_EQUIPE, ID_CREATEUR, ID_PROJET, TITRE,COMMENTAIRE,DATE_CREATION ) VALUES
    (1,6,1,'equipe_java','blablabla',''),
	(2,6,1,'projet_php','blablabla',''),
    (3,10,1,'projet_java2','blablabla','');

    
    
		INSERT INTO PARTICIPANT (ID_PERSONNE,ID_EQUIPE) VALUES
    (10,1),
    (12,1),
    (12,2);

		COMMIT;
	END;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE IF NOT EXISTS `equipe` (
  `ID_EQUIPE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CREATEUR` int(11) NOT NULL,
  `TITRE` varchar(128) NOT NULL,
  `COMMENTAIRE` varchar(128) DEFAULT NULL,
  `DATE_CREATION` date NOT NULL,
  `ID_PROJET` int(11) NOT NULL,
  PRIMARY KEY (`ID_EQUIPE`),
  KEY `I_FK_EQUIPE_ETUDIANT` (`ID_CREATEUR`),
  KEY `fk_EQUIPE_PROJET1_idx` (`ID_PROJET`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `equipe`
--

INSERT INTO `equipe` (`ID_EQUIPE`, `ID_CREATEUR`, `TITRE`, `COMMENTAIRE`, `DATE_CREATION`, `ID_PROJET`) VALUES
(1, 6, 'equipe_java', 'blablabla', '0000-00-00', 1),
(2, 6, 'projet_php', 'blablabla', '0000-00-00', 1),
(3, 10, 'projet_java2', 'blablabla', '0000-00-00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_PERSONNE` int(11) NOT NULL,
  PRIMARY KEY (`ID_PERSONNE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_PERSONNE`) VALUES
(6),
(7),
(10),
(11),
(12),
(13),
(14),
(15);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant_promotion`
--

CREATE TABLE IF NOT EXISTS `etudiant_promotion` (
  `ID_SESSION` int(11) NOT NULL,
  `ID_PERSONNE` int(11) NOT NULL,
  PRIMARY KEY (`ID_SESSION`,`ID_PERSONNE`),
  KEY `I_FK_ETUDIANT_PROMOTION_SESSION` (`ID_SESSION`),
  KEY `I_FK_ETUDIANT_PROMOTION_ETUDIANT` (`ID_PERSONNE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `formateur`
--

CREATE TABLE IF NOT EXISTS `formateur` (
  `ID_PERSONNE` int(11) NOT NULL,
  PRIMARY KEY (`ID_PERSONNE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `formateur`
--

INSERT INTO `formateur` (`ID_PERSONNE`) VALUES
(1),
(2),
(3),
(4),
(5),
(8),
(9);

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

CREATE TABLE IF NOT EXISTS `participant` (
  `ID_PERSONNE` int(11) NOT NULL,
  `ID_EQUIPE` int(11) NOT NULL,
  PRIMARY KEY (`ID_PERSONNE`,`ID_EQUIPE`),
  KEY `I_FK_PARTICIPANT_ETUDIANT` (`ID_PERSONNE`),
  KEY `I_FK_PARTICIPANT_EQUIPE` (`ID_EQUIPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `participant`
--

INSERT INTO `participant` (`ID_PERSONNE`, `ID_EQUIPE`) VALUES
(10, 1),
(12, 1),
(12, 2);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `ID_PERSONNE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(128) NOT NULL,
  `PRENOM` varchar(128) NOT NULL,
  `VILLE` varchar(128) NOT NULL,
  `TELEPHONE` char(10) NOT NULL,
  `EMAIL` varchar(128) NOT NULL,
  `MOT_DE_PASSE` varchar(128) NOT NULL,
  `CODE_POSTAL` varchar(128) NOT NULL,
  `RUE` varchar(128) NOT NULL,
  PRIMARY KEY (`ID_PERSONNE`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`ID_PERSONNE`, `NOM`, `PRENOM`, `VILLE`, `TELEPHONE`, `EMAIL`, `MOT_DE_PASSE`, `CODE_POSTAL`, `RUE`) VALUES
(1, 'Dupont', 'Pierre', 'Cachan', '0678453423', 'dpierre', 'sqddfs', '94200', 'Paul Vaillant'),
(2, 'Albert', 'Medhi', 'Massy', '067344523', 'amedhi', 'gsgsgsgs', '91300', 'Breton'),
(3, 'Patrice', 'Medhi', 'Massy', '067344523', 'amedhi', 'gsgsgsgs', '91300', 'Breton'),
(4, 'Julie', 'Medhi', 'Massy', '067344523', 'amedhi', 'gsgsgsgs', '91300', 'Breton'),
(5, 'Olivier', 'Medhi', 'Massy', '067344523', 'amedhi', 'gsgsgsgs', '91300', 'Breton'),
(6, 'Alex', 'Medhi', 'Massy', '067344523', 'amedhi', 'gsgsgsgs', '91300', 'Breton'),
(7, 'Maximilien', 'Medhi', 'Massy', '067344523', 'amedhi', 'gsgsgsgs', '91300', 'Breton'),
(8, 'Hela', 'Arouay', 'Noisy le Grand', '0675576230', 'h.arouay@feh.fr', 'gsgsgsgs', '93000', 'Breton'),
(9, 'Kate', 'Absalon', 'Juvisy', '067344523', 'k.absalon@ef.fr', 'gsgsgsgs', '91300', 'Breton'),
(10, 'Keidy', 'Chaffort', 'Cachan', '067344523', 'k.chaffort@bk.fr', 'gsgsgsgs', '94300', 'Breton'),
(11, 'Djiby', 'Diallo', 'Cachan', '067344523', 'd.diallo@fjd.fr', 'gsgsgsgs', '94300', 'Breton'),
(12, 'Marco', 'Rodrigez', 'Massy', '067344523', 'amedhi', 'gsgsgsgs', '91300', 'Breton'),
(13, 'Mohamed', 'Medhi', 'Massy', '067344523', 'amedhi', 'gsgsgsgs', '91300', 'Breton'),
(14, 'Ibrahim', 'Medhi', 'Massy', '067344523', 'amedhi', 'gsgsgsgs', '91300', 'Breton'),
(15, 'Alain', 'Medhi', 'Massy', '067344523', 'a.jhsdjk@njdf.fr', 'gsgsgsgs', '91300', 'Breton');

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `ID_PROJET` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SESSION` int(11) NOT NULL,
  `ID_CREATEUR` int(11) NOT NULL,
  `TITRE` varchar(128) NOT NULL,
  `SUJET` varchar(128) NOT NULL,
  `DATE_CREATION` date NOT NULL,
  `DATE_LIMITE_RENDU` date NOT NULL,
  PRIMARY KEY (`ID_PROJET`),
  UNIQUE KEY `ID_SESSION` (`ID_SESSION`,`ID_CREATEUR`,`TITRE`),
  UNIQUE KEY `ID_SESSION_2` (`ID_SESSION`,`ID_CREATEUR`,`TITRE`),
  KEY `I_FK_PROJET_FORMATEUR` (`ID_CREATEUR`),
  KEY `I_FK_PROJET_SESSION` (`ID_SESSION`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `projet`
--

INSERT INTO `projet` (`ID_PROJET`, `ID_SESSION`, `ID_CREATEUR`, `TITRE`, `SUJET`, `DATE_CREATION`, `DATE_LIMITE_RENDU`) VALUES
(1, 1, 1, 'projet_Java', 'blablabla', '0000-00-00', '0000-00-00'),
(2, 1, 2, 'projet_JEE', 'blablabla', '0000-00-00', '0000-00-00'),
(3, 2, 2, 'projet_php', 'blablabla', '0000-00-00', '0000-00-00'),
(4, 1, 1, 'projet_Java2', 'blablabla', '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

CREATE TABLE IF NOT EXISTS `session` (
  `ID_SESSION` int(11) NOT NULL AUTO_INCREMENT,
  `TITRE` varchar(128) NOT NULL,
  `DESCRIPTION` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID_SESSION`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `session`
--

INSERT INTO `session` (`ID_SESSION`, `TITRE`, `DESCRIPTION`) VALUES
(1, 'Java', 'blablabla'),
(2, 'Php', 'blablabla'),
(3, 'Html', 'blablabla');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `equipe_ibfk_1` FOREIGN KEY (`ID_CREATEUR`) REFERENCES `etudiant` (`ID_PERSONNE`),
  ADD CONSTRAINT `fk_EQUIPE_PROJET1` FOREIGN KEY (`ID_PROJET`) REFERENCES `projet` (`ID_PROJET`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`ID_PERSONNE`) REFERENCES `personne` (`ID_PERSONNE`);

--
-- Contraintes pour la table `etudiant_promotion`
--
ALTER TABLE `etudiant_promotion`
  ADD CONSTRAINT `etudiant_promotion_ibfk_1` FOREIGN KEY (`ID_SESSION`) REFERENCES `session` (`ID_SESSION`),
  ADD CONSTRAINT `etudiant_promotion_ibfk_2` FOREIGN KEY (`ID_PERSONNE`) REFERENCES `etudiant` (`ID_PERSONNE`);

--
-- Contraintes pour la table `formateur`
--
ALTER TABLE `formateur`
  ADD CONSTRAINT `formateur_ibfk_1` FOREIGN KEY (`ID_PERSONNE`) REFERENCES `personne` (`ID_PERSONNE`);

--
-- Contraintes pour la table `participant`
--
ALTER TABLE `participant`
  ADD CONSTRAINT `participant_ibfk_1` FOREIGN KEY (`ID_PERSONNE`) REFERENCES `etudiant` (`ID_PERSONNE`),
  ADD CONSTRAINT `participant_ibfk_3` FOREIGN KEY (`ID_EQUIPE`) REFERENCES `equipe` (`ID_EQUIPE`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_1` FOREIGN KEY (`ID_CREATEUR`) REFERENCES `formateur` (`ID_PERSONNE`),
  ADD CONSTRAINT `projet_ibfk_2` FOREIGN KEY (`ID_SESSION`) REFERENCES `session` (`ID_SESSION`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
