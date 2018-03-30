-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: donate_system
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `blood_donors`
--

DROP TABLE IF EXISTS `blood_donors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blood_donors` (
  `donors_id` int(11) NOT NULL AUTO_INCREMENT,
  `donors_name` varchar(45) DEFAULT NULL,
  `donors_surname` varchar(45) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `donors_phone` varchar(45) DEFAULT NULL,
  `donors_mail` varchar(45) DEFAULT NULL,
  `donors_lat` double DEFAULT NULL,
  `donors_lng` double DEFAULT NULL,
  `donors_pass` varchar(100) DEFAULT NULL,
  `bloodGroup_id` int(11) DEFAULT NULL,
  `donors_active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`donors_id`),
  KEY `city_id` (`city_id`),
  KEY `bloodGroup_id` (`bloodGroup_id`),
  CONSTRAINT `blood_donors_ibfk_1` FOREIGN KEY (`bloodGroup_id`) REFERENCES `blood_group` (`bloodGroup_id`),
  CONSTRAINT `city_id` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_donors`
--

LOCK TABLES `blood_donors` WRITE;
/*!40000 ALTER TABLE `blood_donors` DISABLE KEYS */;
INSERT INTO `blood_donors` VALUES (27,'Yusuf','unlu',35,'(541) 431-8216','myunlu35@gmail.com',27.19163164062502,38.42210259829678,'e89595c946828469adb24e1bcb5e7feb',8,1),(28,'muhammet','şentürk',16,'5621654853','muhammet.senturk@gmail.com',29.1876198075571,40.11455480365636,'9343abfcbe8a239a803e8dbcb319c34c',2,1),(29,'cevher','yılmaz',18,'0654215454','cevher.yilmaz@gmail.com',33.60764726562502,40.626975638166535,'4a8c7607574d132aa4ac75f2281c37c',3,1),(30,'orkun','inan',10,'0564210','orkun.inan@gmail.com',27.929848649046676,39.67625491758099,'8a865e04b894a448d47b620314246a9',4,1),(31,'gülşan','celep',14,'0564215','gulsan.celep@gmail.com',31.620177944547436,40.72956620177136,'3ec3b68a38bd1dccb227fb39df1a963d',5,1),(32,'sergen','bağ',1,'(541) 321-5513','sergen.bag@gmail.com',35.36539533453163,36.965364730861474,'598115e937e6d1e3e91c524c19da5',6,1),(33,'ibrahim','emektar',34,'(546) 546-4987','ibrahim.emektar@gmail.com',41.10524676948019,29.023557486319987,'598115e937e6d1e3e91c524c19da5',7,1),(39,'ajdar','kurnaz',22,'(111) 111-1111','myunlu30@gmail.com',0,0,'e89595c946828469adb24e1bcb5e7feb',1,1),(41,'yusuf','demir',1,'(111) 111-1111','asdqwe30@gmail.com',0,0,'e89595c946828469adb24e1bcb5e7feb',1,1),(42,'yusuf','bağ',1,'(999) 999-9999','asdqwe31@gmail.com',0,0,'e89595c946828469adb24e1bcb5e7feb',1,1),(43,'yeni','hesap',2,'(222) 222-2222','deneme2@gmail.com',0,0,'598115e937e6d1e3e91c524c19da5',1,0),(44,'testX','testX',1,'(111) 111-1111','testx@gmail.com',0,0,'e89595c946828469adb24e1bcb5e7feb',1,1);
/*!40000 ALTER TABLE `blood_donors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-30 15:47:58
