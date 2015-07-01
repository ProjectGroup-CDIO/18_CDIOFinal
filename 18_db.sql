-- MySQL dump 10.13  Distrib 5.5.44, for Win64 (x86)
--
-- Host: localhost    Database: 18_cdio_final
-- ------------------------------------------------------
-- Server version	5.5.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `batch`
--

DROP DATABASE IF EXISTS 18_CDIO_Final;
CREATE DATABASE 18_CDIO_Final;
USE 18_CDIO_Final;

DROP TABLE IF EXISTS `batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batch` (
  `batch_id` int(11) NOT NULL AUTO_INCREMENT,
  `raavare_id` int(11) DEFAULT NULL,
  `raavare` varchar(255) DEFAULT NULL,
  `batchweight` double DEFAULT NULL,
  `tolerance` double DEFAULT NULL,
  PRIMARY KEY (`batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch`
--

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` VALUES (1,1,'tomat',1,0.05),(2,1,'tomat',5,0.05),(3,2,'løg',2.5,0.05);
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coins`
--

DROP TABLE IF EXISTS `coins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coins` (
  `value` double NOT NULL,
  `weight` double NOT NULL,
  `tolerance` double NOT NULL,
  PRIMARY KEY (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coins`
--

LOCK TABLES `coins` WRITE;
/*!40000 ALTER TABLE `coins` DISABLE KEYS */;
INSERT INTO `coins` VALUES (0.5,0.0043,0.01),(1,0.0036,0.01),(2,0.0059,0.01),(5,0.0092,0.01),(10,0.0071,0.01),(20,0.0093,0.01);
/*!40000 ALTER TABLE `coins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `condiments`
--

DROP TABLE IF EXISTS `condiments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `condiments` (
  `id` double NOT NULL,
  `name` varchar(255) NOT NULL,
  `weight` double NOT NULL,
  `tolerance` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condiments`
--

LOCK TABLES `condiments` WRITE;
/*!40000 ALTER TABLE `condiments` DISABLE KEYS */;
INSERT INTO `condiments` VALUES (7,'Salt',0.004,0.02),(8,'Pepper',0.003,0.02),(9,'Cinnamon',0.005,0.02),(10,'Sugar',0.004,0.02),(11,'Chemical X',0.012,0.02);
/*!40000 ALTER TABLE `condiments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fruits`
--

DROP TABLE IF EXISTS `fruits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fruits` (
  `id` double NOT NULL,
  `name` varchar(255) NOT NULL,
  `weight` double NOT NULL,
  `tolerance` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fruits`
--

LOCK TABLES `fruits` WRITE;
/*!40000 ALTER TABLE `fruits` DISABLE KEYS */;
INSERT INTO `fruits` VALUES (1,'Apple',0.12,0.03),(2,'Pear',0.132,0.03),(3,'Banana',0.14,0.03),(4,'Mango',0.2,0.03),(5,'Avocado',0.3,0.05),(6,'Kiwi',0.076,0.05);
/*!40000 ALTER TABLE `fruits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operatoer`
--

DROP TABLE IF EXISTS `operatoer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operatoer` (
  `opr_id` int(11) NOT NULL,
  `opr_navn` text,
  `ini` text,
  `cpr` text,
  `password` text,
  `aktiv` int(1) DEFAULT NULL,
  PRIMARY KEY (`opr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operatoer`
--

LOCK TABLES `operatoer` WRITE;
/*!40000 ALTER TABLE `operatoer` DISABLE KEYS */;
INSERT INTO `operatoer` VALUES (1,'Hej Med Dig','HMD','234897-2342','hello2u',1),(2,'Thomas Liljegren','TLi','1702921745','1234567',1),(3,'Luigi Cool','LC','090990-9009','naellol',1),(4,'Don Juan','DJu','234567-7891','iloveyou',1),(5,'Kofi Anan','KAn','6969696969','yoloyolo',1),(6,'Anders Fogh','AFo','4817824293','annemett',1),(7,'Britney Spears','BSp','1029402949','balislif',1),(8,'Barack Obama','BOb','1234539834','facebook',1),(9,'Lars Larsen','LLa','0203832233','password',1),(10,'Larsen Lars','LaL','0209231823','password',1),(11,'Tester Test','TeT','1234560123','1111111',1);
/*!40000 ALTER TABLE `operatoer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-17 15:44:01
