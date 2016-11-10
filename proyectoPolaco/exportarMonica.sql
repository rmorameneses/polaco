CREATE DATABASE  IF NOT EXISTS `proyectomonica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proyectomonica`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectomonica
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (22,'Luis Vendetta','Dulce nombre Coronado','luis@zubeldia.com'),(23,'A','ef','ewdfs'),(24,'B','sdf','wefwe'),(26,'Ruben','San jeronimo	','rubenmorameneses@gmail.com'),(27,'Jose','sn jeronimo','jose@fdkjn'),(29,'Geo','wdsjknsjkdn','rubwenmdlks'),(30,'Men','sakjndjsn','defsdfk'),(31,'Xmen','sklmdaslk','328wijo');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientextelefono`
--

DROP TABLE IF EXISTS `clientextelefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientextelefono` (
  `idclienteXtelefono` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `idTelefono` int(11) NOT NULL,
  PRIMARY KEY (`idclienteXtelefono`),
  KEY `cxtCliente_idx` (`idCliente`),
  KEY `cxtTel_idx` (`idTelefono`),
  CONSTRAINT `cxtCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cxtTel` FOREIGN KEY (`idTelefono`) REFERENCES `telefono` (`idtelefono`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientextelefono`
--

LOCK TABLES `clientextelefono` WRITE;
/*!40000 ALTER TABLE `clientextelefono` DISABLE KEYS */;
INSERT INTO `clientextelefono` VALUES (9,22,21),(11,26,23),(12,27,24),(13,29,25),(14,30,26),(15,31,27);
/*!40000 ALTER TABLE `clientextelefono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `idLog` int(11) NOT NULL AUTO_INCREMENT,
  `Registro` varchar(100) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idLog`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (51,'Insertado en cliente en: 2016-10-26 21:56:15 Luis Vendetta','insercion'),(52,'Insertado en telefono en: 2016-10-26 21:56:15 347835387','insercion'),(53,'Insertado en tarjeta en: 2016-10-26 21:56:15 IDCliente: 22','insercion'),(54,'Insertado en pago en: 2016-10-26 21:56:15 Abono: 140000','insercion'),(55,'Insertado en cliente en: 2016-10-30 16:54:59 A','insercion'),(56,'Insertado en cliente en: 2016-10-30 16:54:59 B','insercion'),(57,'Insertado en tarjeta en: 2016-10-30 16:57:33 IDCliente: 22','insercion'),(58,'Insertado en tarjeta en: 2016-10-30 16:57:33 IDCliente: 23','insercion'),(59,'Insertado en tarjeta en: 2016-10-30 16:57:33 IDCliente: 24','insercion'),(62,'Insertado en cliente en: 2016-10-31 22:43:08 Ruben','insercion'),(63,'Insertado en telefono en: 2016-10-31 22:43:08 83930272','insercion'),(64,'Insertado en tarjeta en: 2016-10-31 22:43:08 IDCliente: 26','insercion'),(65,'Insertado en pago en: 2016-10-31 22:43:08 Abono: 100000','insercion'),(66,'Insertado en pago en: 2016-11-01 16:13:20 Abono: 100000','insercion'),(67,'Insertado en pago en: 2016-11-01 22:12:16 Abono: 10000','insercion'),(68,'Insertado en pago en: 2016-11-01 22:22:35 Abono: 1000','insercion'),(69,'Insertado en pago en: 2016-11-01 22:22:35 Abono: 1000','insercion'),(70,'Insertado en cliente en: 2016-11-06 01:07:33 Jose','insercion'),(71,'Insertado en telefono en: 2016-11-06 01:07:33 89825896','insercion'),(72,'Insertado en tarjeta en: 2016-11-06 01:07:33 IDCliente: 27','insercion'),(73,'Insertado en pago en: 2016-11-06 01:07:33 Abono: 10000','insercion'),(74,'Insertado en cliente en: 2016-11-06 15:40:31 sadjans','insercion'),(75,'Insertado en cliente en: 2016-11-06 16:44:35 Geo','insercion'),(76,'Insertado en telefono en: 2016-11-06 16:44:35 92039489','insercion'),(77,'Insertado en tarjeta en: 2016-11-06 16:44:35 IDCliente: 29','insercion'),(78,'Insertado en pago en: 2016-11-06 16:44:36 Abono: 19000','insercion'),(79,'Insertado en cliente en: 2016-11-07 00:16:02 Men','insercion'),(80,'Insertado en telefono en: 2016-11-07 00:16:02 298379','insercion'),(81,'Insertado en tarjeta en: 2016-11-07 00:16:02 IDCliente: 30','insercion'),(82,'Insertado en pago en: 2016-11-07 00:16:02 Abono: 100000','insercion'),(83,'Insertado en cliente en: 2016-11-07 00:28:01 Xmen','insercion'),(84,'Insertado en telefono en: 2016-11-07 00:28:01 234789','insercion'),(85,'Insertado en tarjeta en: 2016-11-07 00:28:01 IDCliente: 31','insercion'),(86,'Insertado en pago en: 2016-11-07 00:28:01 Abono: 19900','insercion'),(87,'Insertado en pago en: 2016-11-07 11:11:16 Abono: 10000000','insercion'),(88,'Insertado en pago en: 2016-11-07 11:15:03 Abono: 10000000','insercion'),(89,'Insertado en pago en: 2016-11-07 11:34:22 Abono: 10000000','insercion'),(90,'Insertado en pago en: 2016-11-07 11:34:38 Abono: 10000000','insercion');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagos` (
  `idpagos` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(100) DEFAULT NULL,
  `abono` int(11) NOT NULL,
  `idTarjeta` int(11) NOT NULL,
  PRIMARY KEY (`idpagos`),
  KEY `pagosIdTarjetaFK_idx` (`idTarjeta`),
  CONSTRAINT `pagosIdTarjetaFK` FOREIGN KEY (`idTarjeta`) REFERENCES `tarjeta` (`idtarjeta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
INSERT INTO `pagos` VALUES (4,'10/12/2017',140000,7),(5,'10/12/2017',100000,8),(6,'10/12/2017',100000,7),(7,'1/10/2016',10000,7),(8,'1/10/2016',1000,7),(9,'1/10/2016',1000,7),(10,'10/12/2017',10000,9),(11,'10/12/2017',19000,10),(12,'3/11/2016',100000,11),(13,'10/11/2016',19900,12),(14,'7/10/2016',10000000,8),(15,'7/10/2016',10000000,8),(16,'7/11/2016',10000000,8),(17,'7/11/2016',10000000,8);
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjeta` (
  `idtarjeta` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `fecha` varchar(100) DEFAULT NULL,
  `idPagos` int(11) NOT NULL,
  `Idcontrol` varchar(100) DEFAULT NULL,
  `productos` varchar(5000) DEFAULT NULL,
  `saldoTotal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtarjeta`),
  UNIQUE KEY `Idcontrol` (`Idcontrol`),
  KEY `tarjClientefk_idx` (`idCliente`),
  KEY `tarjTipPagofk_idx` (`idPagos`),
  CONSTRAINT `tarjClientefk` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tarjTipPagofk` FOREIGN KEY (`idPagos`) REFERENCES `tipopagos` (`idtipoPagos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
INSERT INTO `tarjeta` VALUES (4,23,'gdf',1,'098765','dfgdfg',NULL),(5,22,'ssd',1,'1345','werg',NULL),(6,24,'yhjgtf',1,'56456','eghghjk',NULL),(7,22,'Sabados',1,'104289','productos',1000000),(8,26,'Domingos',2,'1234567890','wiiu, ps4 pro, camarote',100000000),(9,27,'Domingo',3,'0987654321','mueble',19990),(10,29,'sabado',3,'1984389','sdnkjsndjkwa	',18000000),(11,30,'sajdhjl',3,'2189739','wkjdnsdj\n	',1000000),(12,31,'kjdsnfsj',2,'218999','wkjdnaksjnd\n	',1010000);
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono` (
  `idtelefono` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`idtelefono`),
  UNIQUE KEY `numero_UNIQUE` (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono`
--

LOCK TABLES `telefono` WRITE;
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
INSERT INTO `telefono` VALUES (27,234789),(26,298379),(23,83930272),(24,89825896),(25,92039489),(21,347835387);
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopagos`
--

DROP TABLE IF EXISTS `tipopagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopagos` (
  `idtipoPagos` int(11) NOT NULL AUTO_INCREMENT,
  `tipoPago` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipoPagos`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopagos`
--

LOCK TABLES `tipopagos` WRITE;
/*!40000 ALTER TABLE `tipopagos` DISABLE KEYS */;
INSERT INTO `tipopagos` VALUES (1,'Semanal'),(2,'Quincenal'),(3,'Mensual');
/*!40000 ALTER TABLE `tipopagos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-07 19:16:17
