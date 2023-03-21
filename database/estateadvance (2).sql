-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: estateadvance
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignmentbuilding`
--

DROP TABLE IF EXISTS `assignmentbuilding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignmentbuilding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffid` bigint(20) NOT NULL,
  `buildingid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkk3mdegrmfcdlsxqds1m6q238` (`buildingid`),
  KEY `FKf4ibbod44h32ao1o6pb4yq98p` (`staffid`),
  CONSTRAINT `FKf4ibbod44h32ao1o6pb4yq98p` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`),
  CONSTRAINT `FKkk3mdegrmfcdlsxqds1m6q238` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentbuilding`
--

LOCK TABLES `assignmentbuilding` WRITE;
/*!40000 ALTER TABLE `assignmentbuilding` DISABLE KEYS */;
INSERT INTO `assignmentbuilding` VALUES (4,2,2,'2023-02-14 00:20:49','2023-02-14 00:20:49','admin','admin'),(6,2,3,'2023-02-14 22:00:38','2023-02-14 22:00:38','admin','admin'),(14,2,25,'2023-02-24 14:39:48','2023-02-24 14:39:48','admin','admin'),(15,3,26,'2023-02-24 14:40:04','2023-02-24 14:40:04','admin','admin'),(16,6,26,'2023-02-24 14:40:16','2023-02-24 14:40:16','admin','admin'),(17,2,26,'2023-02-24 14:41:02','2023-02-24 14:41:02','admin','admin'),(18,7,26,'2023-02-24 14:44:05','2023-02-24 14:44:05','admin','admin'),(22,2,20,'2023-02-24 14:50:43','2023-02-24 14:50:43','admin','admin'),(23,3,21,'2023-02-24 15:02:23','2023-02-24 15:02:23','admin','admin'),(24,6,21,'2023-02-24 15:02:38','2023-02-24 15:02:38','admin','admin'),(25,7,21,'2023-02-24 15:02:45','2023-02-24 15:02:45','admin','admin'),(27,3,3,'2023-02-24 15:04:31','2023-02-24 15:04:31','admin','admin'),(28,6,3,'2023-02-24 15:05:37','2023-02-24 15:05:37','admin','admin'),(29,3,2,'2023-02-24 15:13:15','2023-02-24 15:13:15','admin','admin'),(31,3,15,'2023-02-24 15:20:44','2023-02-24 15:20:44','admin','admin'),(32,3,25,'2023-02-24 15:25:35','2023-02-24 15:25:35','admin','admin'),(33,12,26,'2023-02-27 22:09:11','2023-02-27 22:09:11','admin','admin');
/*!40000 ALTER TABLE `assignmentbuilding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmentcustomer`
--

DROP TABLE IF EXISTS `assignmentcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignmentcustomer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `customerid` bigint(20) NOT NULL,
  `staffid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqdsk84k71vryc0fsi82v0c4nf` (`customerid`),
  KEY `FKco26n95l1hpuq1suv0briljor` (`staffid`),
  CONSTRAINT `FKco26n95l1hpuq1suv0briljor` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqdsk84k71vryc0fsi82v0c4nf` FOREIGN KEY (`customerid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentcustomer`
--

LOCK TABLES `assignmentcustomer` WRITE;
/*!40000 ALTER TABLE `assignmentcustomer` DISABLE KEYS */;
/*!40000 ALTER TABLE `assignmentcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `structure` varchar(255) DEFAULT NULL,
  `numberofbasement` int(11) DEFAULT NULL,
  `floorarea` int(11) DEFAULT NULL,
  `direction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `rentprice` int(11) DEFAULT NULL,
  `rentpricedescription` varchar(255) DEFAULT NULL,
  `servicefee` varchar(255) DEFAULT NULL,
  `carfee` varchar(255) DEFAULT NULL,
  `motofee` varchar(255) DEFAULT NULL,
  `overtimefee` varchar(255) DEFAULT NULL,
  `waterfee` varchar(255) DEFAULT NULL,
  `electricityfee` varchar(255) DEFAULT NULL,
  `deposit` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `renttime` varchar(255) DEFAULT NULL,
  `decorationtime` varchar(255) DEFAULT NULL,
  `brokeragetee` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `linkofbuilding` varchar(255) DEFAULT NULL,
  `map` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (2,'ACM Tower','96 cao thắng','Phường 4','QUAN_2','n',2,650,'đông','C',200,NULL,'20','','','',NULL,NULL,'','',NULL,'','',' NOI_THAT',NULL,NULL,NULL,NULL,NULL,'2023-02-15 22:00:41',NULL,'admin',NULL),(3,'Alpha 2 Building Tower','153 nguyễn đình chiểu','Phường 6','QUAN_3','n',1,200,'đông','C',300,NULL,'30','','','',NULL,NULL,'','',NULL,'','','','',NULL,NULL,NULL,NULL,'2023-02-22 12:33:10',NULL,'admin',NULL),(14,'duy',NULL,NULL,'QUAN_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2023-02-22 20:03:32','2023-02-22 20:03:32','admin','admin','/building/duy.PNG'),(15,'dy',NULL,NULL,'QUAN_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2023-02-22 20:33:14','2023-02-22 20:33:14','admin','admin',NULL),(16,'dyu',NULL,NULL,'QUAN_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2023-02-22 20:33:26','2023-02-22 20:33:26','admin','admin',NULL),(19,'duy',NULL,NULL,'QUAN_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2023-02-22 21:19:59','2023-02-22 21:19:59','admin','admin',NULL),(20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'[]',NULL,NULL,NULL,NULL,'2023-02-22 21:20:09','2023-02-22 21:20:09','admin','admin',NULL),(21,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'[]',NULL,NULL,NULL,NULL,'2023-02-22 21:20:30','2023-02-22 21:20:30','admin','admin',NULL),(24,NULL,NULL,NULL,'QUAN_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2023-02-22 21:51:38','2023-02-22 21:51:38','admin','admin',NULL),(25,NULL,NULL,NULL,'QUAN_3',NULL,NULL,NULL,'bắc',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2023-02-23 09:43:24','2023-02-23 09:43:24','admin','admin','/building/duy.PNG'),(26,'ASSS',NULL,NULL,'QUAN_3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2023-02-23 10:08:45','2023-02-23 10:08:45','admin','admin','/building/duy.PNG');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentarea`
--

DROP TABLE IF EXISTS `rentarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentarea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` int(11) DEFAULT NULL,
  `buildingid` bigint(20) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqhqoxlvm1iblaew5s0v8n3ut4` (`buildingid`),
  CONSTRAINT `FKqhqoxlvm1iblaew5s0v8n3ut4` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentarea`
--

LOCK TABLES `rentarea` WRITE;
/*!40000 ALTER TABLE `rentarea` DISABLE KEYS */;
INSERT INTO `rentarea` VALUES (3,200,2,NULL,NULL,NULL,NULL),(4,300,2,NULL,NULL,NULL,NULL),(5,400,2,NULL,NULL,NULL,NULL),(6,300,3,NULL,NULL,NULL,NULL),(7,400,3,NULL,NULL,NULL,NULL),(8,500,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `rentarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c36say97xydpmgigg38qv5l2p` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,NULL,NULL,NULL,'ADMIN','Quản trị hệ thống'),(2,NULL,NULL,NULL,NULL,'USER','Nhân viên');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `customerid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKldobv9jeuxje0fjqnhrw6e23v` (`customerid`),
  CONSTRAINT `FKldobv9jeuxje0fjqnhrw6e23v` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,NULL,NULL,'admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','012345678',1,'admin'),(2,NULL,NULL,NULL,NULL,NULL,'nguyen van a','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','012345678',1,'nguyenvana'),(3,NULL,NULL,'admin','2023-02-15 10:53:20',NULL,'Nguyễn Hữu Thiên Duy1','$2a$10$TQVC9qcPzLWGU839dYf6x.yHl6rFzblq6okIQ7m/gS4OmLvWYLpT2',NULL,1,'duy'),(6,'admin','2023-02-22 22:57:59','admin','2023-02-22 22:57:59',NULL,'e','$2a$10$i1pbB0D4VKE9LWUwyg.JieQVrs9It8lgm34iVd1YkR486Fg.SXPr2',NULL,1,'d'),(7,'admin','2023-02-22 22:59:16','admin','2023-02-24 15:26:36',NULL,'b','$2a$10$Ad.onlnDcsYMR.uyvUNzoO7r6G7Jr1z7RnXMsi9F0b5mYRtvybJwq',NULL,1,'m'),(12,'admin','2023-02-22 23:02:17','admin','2023-02-24 15:26:36',NULL,'2','$2a$10$mWmvAI1XpPTGlf/7jaQnFOYBh94tZlgroGfqLNvqwj1eMgV7k/VcS',NULL,1,'dư'),(13,NULL,NULL,'admin','2023-02-22 23:06:01',NULL,'231','$2a$10$g.mk9krNrlDnH/79rtMo4OZ/i.FHnTYuEUFwCvLc171GPlOD8D2Nu',NULL,1,'2w'),(14,'admin','2023-02-22 23:06:25','admin','2023-02-22 23:06:25',NULL,'1','$2a$10$BJmooO1ulN1jyScjmasCE.QTkipZ6NeFbVKwSjXnb0tG.LqlICEjq',NULL,1,'1'),(16,'admin','2023-02-22 23:06:58','admin','2023-02-24 15:26:36',NULL,'3','$2a$10$/pcLxh78M1mOOBAcO.6iN.Tcs4iiNL9mD9p0iViRaf58rhoKRiD1u',NULL,1,'3'),(17,'admin','2023-02-22 23:07:12','admin','2023-02-24 15:26:36',NULL,'4','$2a$10$OC8olAXlb4IaWpT4bKBpeuAZTUNsQUQWsaKqWbQk6Ct9cnWct5BXO',NULL,1,'4'),(18,'admin','2023-02-22 23:07:26','admin','2023-02-24 15:26:36',NULL,'5','$2a$10$wOLclj8k1KZUeMi4nKtSVOopzJfxD6QlDsAgOEXPu04PqFCoUiKK2',NULL,1,'5'),(19,'admin','2023-02-22 23:07:37','admin','2023-02-22 23:07:37',NULL,'6','$2a$10$cirg8liP1qTltktYJdEUrORnKeWMSRlqdVmtulFLfAQPwOzV2Jkka',NULL,1,'6'),(20,NULL,NULL,'admin','2023-02-24 15:27:12',NULL,'le minh duc1','$2a$10$Xuli00DoO2Pa0u0lw6l1N.RuCGUC/bii9M4abfszc.ugz40t95aCa',NULL,1,'duc');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2),(3,2),(6,2),(7,2),(12,2),(13,1),(14,1),(16,2),(17,2),(18,2),(19,1),(20,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-27 22:18:40
