--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	5.7.22

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
-- Table structure for table `category`
--

DROP DATABASE IF EXISTS inventory;
CREATE DATABASE IF NOT EXISTS inventory;
USE inventory;

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `id_product` int(11) NOT NULL,
  `name_category` text NOT NULL,
  `measurement` text NOT NULL,
  PRIMARY KEY (`id_category`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `category_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consume`
--

DROP TABLE IF EXISTS `consume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consume` (
  `id_consume` int(11) NOT NULL AUTO_INCREMENT,
  `expiration` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_consume`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consume`
--

LOCK TABLES `consume` WRITE;
/*!40000 ALTER TABLE `consume` DISABLE KEYS */;
INSERT INTO `consume` VALUES (1,'2020-12-11 04:00:00'),(2,'2030-01-01 04:00:00'),(3,'2020-01-01 04:00:00'),(4,'2019-01-01 04:00:00'),(5,'2020-02-02 04:00:00');
/*!40000 ALTER TABLE `consume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `durable`
--

DROP TABLE IF EXISTS `durable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `durable` (
  `id_durable` int(11) NOT NULL AUTO_INCREMENT,
  `size_durable` int(11) NOT NULL,
  `weigh_durable` int(11) NOT NULL,
  PRIMARY KEY (`id_durable`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `durable`
--

LOCK TABLES `durable` WRITE;
/*!40000 ALTER TABLE `durable` DISABLE KEYS */;
INSERT INTO `durable` VALUES (1,1,1),(2,1,0),(3,12,12),(4,1,1),(5,1,1),(6,12,12);
/*!40000 ALTER TABLE `durable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `id_inventory` int(11) NOT NULL AUTO_INCREMENT,
  `id_product` int(11) NOT NULL,
  `ini_quantity` int(11) NOT NULL,
  `available_quatity` int(11) NOT NULL,
  `products` int(11) NOT NULL,
  PRIMARY KEY (`id_inventory`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,1,120,120,1);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `id_stock` int(11) NOT NULL,
  `id_brand` int(11) NOT NULL,
  `id_durable` int(11) NOT NULL,
  `id_consume` int(11) NOT NULL,
  `name_product` text NOT NULL,
  `price` decimal(10,4) NOT NULL,
  `status` text NOT NULL,
  `location` text NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id_product`),
  KEY `id_consume` (`id_consume`),
  KEY `id_brand` (`id_brand`),
  KEY `id_stock` (`id_stock`),
  KEY `id_durable` (`id_durable`),
  CONSTRAINT `product_durable` FOREIGN KEY (`id_durable`) REFERENCES `durable` (`id_durable`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`id_consume`) REFERENCES `consume` (`id_consume`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_productBrand` FOREIGN KEY (`id_brand`) REFERENCES `productbrand` (`id_brand`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_stock` FOREIGN KEY (`id_stock`) REFERENCES `stock` (`id_stock`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,4,1,6,5,'CocaZero 1Lt',10.0000,'true','lpz',120);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productbrand`
--

DROP TABLE IF EXISTS `productbrand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productbrand` (
  `id_brand` int(11) NOT NULL AUTO_INCREMENT,
  `name_brand` text NOT NULL,
  `origin_brand` text NOT NULL,
  PRIMARY KEY (`id_brand`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productbrand`
--

LOCK TABLES `productbrand` WRITE;
/*!40000 ALTER TABLE `productbrand` DISABLE KEYS */;
INSERT INTO `productbrand` VALUES (1,'CocaCola Brand','None');
/*!40000 ALTER TABLE `productbrand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `id_stock` int(11) NOT NULL AUTO_INCREMENT,
  `max_quantity` int(11) NOT NULL,
  `min_quantity` int(11) NOT NULL,
  PRIMARY KEY (`id_stock`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,1000,0),(2,1,0),(3,100000,0),(4,10000,0);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'inventory'
--

--
-- Dumping routines for database 'inventory'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-01 12:49:09
