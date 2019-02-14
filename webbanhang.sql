CREATE DATABASE  IF NOT EXISTS `webbanhang` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `webbanhang`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: webbanhang
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountUser` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `passwordUser` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT '',
  `numberPhone` varchar(45) COLLATE utf8_unicode_ci DEFAULT '',
  `idPosition` int(11) NOT NULL DEFAULT '1',
  `avatar` varchar(45) COLLATE utf8_unicode_ci DEFAULT 'null',
  `address` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '',
  PRIMARY KEY (`id`,`accountUser`),
  KEY `idPosition_idx` (`idPosition`),
  CONSTRAINT `idPosition` FOREIGN KEY (`idPosition`) REFERENCES `account_position` (`idposition`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Lưu tài khoản web';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'boss','boss','haidangbkk59@gmail.com','0924717388',3,'null','Hùng Dũng - Hưng Hà - Thái Bình'),(2,'haidang1','123456','','',1,'null',''),(3,'haidang2','123456','','',2,'null','');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_position`
--

DROP TABLE IF EXISTS `account_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account_position` (
  `idPosition` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idPosition`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='lưu chức vụ của người dùng';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_position`
--

LOCK TABLES `account_position` WRITE;
/*!40000 ALTER TABLE `account_position` DISABLE KEYS */;
INSERT INTO `account_position` VALUES (1,'member'),(2,'admin'),(3,'boss');
/*!40000 ALTER TABLE `account_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id_san_pham` int(11) NOT NULL AUTO_INCREMENT,
  `id_danh_muc` int(11) NOT NULL,
  `ten_san_pham` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `gia_san_pham` int(11) NOT NULL,
  `anh_san_pham` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cmt_san_pham` varchar(45) COLLATE utf8_unicode_ci DEFAULT '',
  `top_san_pham` int(11) DEFAULT '0',
  PRIMARY KEY (`id_san_pham`),
  KEY `id_danh_muc_idx` (`id_danh_muc`),
  CONSTRAINT `id_danh_muc` FOREIGN KEY (`id_danh_muc`) REFERENCES `product_type` (`id_danh_muc`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'Sam Sung 1',2000000,NULL,'Mới 99%',1),(2,2,'ZenFone 2',2000000,'image/ZenFone2.jpg','Mới 90%',2),(3,2,'ZenFone 3',3000000,'image/ZenFone3.jpg','Mới 85%',3),(4,2,'ZenFone 3 Max',4000000,'image/ZenFone3Max.jpg','Mới 90%',4),(5,2,'ZenFone 5',5000000,'image/ZenFone5.jpg','Mới 95%',5),(6,2,'ZenFone 6',6000000,'image/ZenFone6.jpg','Mới 98%',6),(7,3,'IPhone 5',5000000,NULL,'Mới 99%',5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_type` (
  `id_danh_muc` int(11) NOT NULL AUTO_INCREMENT,
  `ten_danh_muc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_danh_muc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Lưu danh mục sản phẩm';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` VALUES (1,'Sam Sung'),(2,'Asus'),(3,'IPhone');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-14  7:59:03
