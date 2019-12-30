-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `assisttable`
--

DROP TABLE IF EXISTS `assisttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assisttable` (
  `id_good` int(11) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  KEY `id_good` (`id_good`),
  KEY `payment_id` (`payment_id`),
  CONSTRAINT `assisttable_ibfk_1` FOREIGN KEY (`id_good`) REFERENCES `goods` (`ID_GOOD`),
  CONSTRAINT `assisttable_ibfk_2` FOREIGN KEY (`payment_id`) REFERENCES `history_payments` (`PAYMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assisttable`
--

LOCK TABLES `assisttable` WRITE;
/*!40000 ALTER TABLE `assisttable` DISABLE KEYS */;
/*!40000 ALTER TABLE `assisttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buyers`
--

DROP TABLE IF EXISTS `buyers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buyers` (
  `BUYER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BNAME` varchar(20) DEFAULT NULL,
  `BSURNAME` varchar(20) DEFAULT NULL,
  `BCARDNUMBER` varchar(16) DEFAULT NULL,
  `BEMAIL` text,
  `BTELEPHONE` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`BUYER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyers`
--

LOCK TABLES `buyers` WRITE;
/*!40000 ALTER TABLE `buyers` DISABLE KEYS */;
INSERT INTO `buyers` VALUES (1,'Даниил','Жилин','0000000000000001','d.zhilin2013@yandex.ru','+79265498468'),(2,'Роман','Адиянов','0000000000000002','r_adium@mail.ru','+79153821472'),(3,'Анна','Мейлер','0000000000000003','meymeyler@mail.ru','+79151775405');
/*!40000 ALTER TABLE `buyers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `ID_GOOD` int(11) NOT NULL AUTO_INCREMENT,
  `GNAME` text,
  `GPRICE` decimal(12,2) DEFAULT NULL,
  `GEXPIRE_DATE` date DEFAULT NULL,
  `GVENDOR_CODE` varchar(20) DEFAULT NULL,
  `GPLACE` varchar(6) DEFAULT NULL,
  `GQUAINTITY` int(11) DEFAULT NULL,
  `GTYPE` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID_GOOD`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'Доширак',30.00,NULL,'4607065580230','b2',100,5),(2,'Роллтон',33.00,NULL,'4508069580430','b1',100,5),(3,'Сахар',20.00,NULL,'23589655879371','a1',50,4),(4,'Соль',15.00,NULL,'4598713547895','a2',100,4),(5,'Молоко Домик в деревне',30.00,NULL,'8345071257890','с1',50,3),(6,'Йогурт активия',16.00,NULL,'8345848524083','c2',90,3),(7,'Сливки Домик в деревне',30.00,NULL,'8346842987462858','c3',20,3),(8,'Чай гринфилд',50.00,'2020-12-26','7895452486','A6',50,7),(9,'Шоколад',70.00,'2020-01-26','11236987','A8',30,8),(10,'кофе',300.00,'2020-12-28','5156513285','A7',50,7);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_payments`
--

DROP TABLE IF EXISTS `history_payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_payments` (
  `PAYMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CARDNUMBER` int(11) NOT NULL,
  `GOODS_NAME` text,
  `PRICE` decimal(12,2) DEFAULT NULL,
  PRIMARY KEY (`PAYMENT_ID`),
  KEY `CARDNUMBER` (`CARDNUMBER`),
  CONSTRAINT `history_payments_ibfk_1` FOREIGN KEY (`CARDNUMBER`) REFERENCES `buyers` (`BUYER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_payments`
--

LOCK TABLES `history_payments` WRITE;
/*!40000 ALTER TABLE `history_payments` DISABLE KEYS */;
INSERT INTO `history_payments` VALUES (1,2,'1',30.00);
/*!40000 ALTER TABLE `history_payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `ID_TOOL` int(11) NOT NULL AUTO_INCREMENT,
  `ITYPE` varchar(20) DEFAULT NULL,
  `IQUAINTITY` smallint(6) DEFAULT NULL,
  `RESPONSIBLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID_TOOL`),
  KEY `RESPONSIBLE_ID` (`RESPONSIBLE_ID`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`RESPONSIBLE_ID`) REFERENCES `staff` (`STAFF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `STAFF_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SNAME` varchar(20) DEFAULT NULL,
  `SURNAME` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `SPOSITION` varchar(50) DEFAULT NULL,
  `SACCESS_LVL` int(11) DEFAULT NULL,
  `SALARY` decimal(12,2) DEFAULT NULL,
  `STARDATE` date DEFAULT NULL,
  `SPASSWORD` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`STAFF_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Daniil','Zhilin','zhilinoff',' Head of shop',3,150000.00,'2019-11-09','s0302s'),(2,'Андрей','Синельников','andre.slkv','Администратор',3,85000.00,'2020-12-19','1111'),(3,'Максим','Воробьев','maxrusmos','Кассир',2,30000.00,'2020-12-19','2222'),(4,'Михаил','Хатин','m.khatin','Кладовщик',1,30000.00,'2019-12-21','3333');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shop'
--

--
-- Dumping routines for database 'shop'
--
/*!50003 DROP PROCEDURE IF EXISTS `addNewStaff` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp866 */ ;
/*!50003 SET character_set_results = cp866 */ ;
/*!50003 SET collation_connection  = cp866_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewStaff`(sNAME VARCHAR(20), SURNAME VARCHAR(20), POSITION VARCHAR(50), ACCESS_LVL INT, SALARY DECIMAL(12,2), STARTDATE DATE, SPASSWORD VARCHAR(20))
BEGIN
INSERT INTO STAFF(SNAME, SURNAME, SPOSITION, SACCESS_LVL, SALARY, STARDATE, SPASSWORD) VALUES     (NAME, SURNAME, POSITION, ACCESS_LVL, SALARY, STARTDATE, SPASSWORD);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addToBuyers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addToBuyers`( BNAME varchar(20),
		BSURNAME varchar(20),
        BCARDNUMBER varchar(16), 
        BEMAIL TEXT,
        BTELEPHONE VARCHAR(12))
BEGIN	
insert into buyers( BNAME,
		BSURNAME ,
        BCARDNUMBER, 
        BEMAIL ,
        BTELEPHONE )
        values(BNAME,
		BSURNAME ,
        BCARDNUMBER, 
        BEMAIL ,
        BTELEPHONE);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addToGoods` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addToGoods`(
        GNAME TEXT,
        GPRICE decimal(12, 2),
        GVENDOR_CODE varchar(20),
        GEXPIRE_DATE DATE,
        GPLACE VARCHAR(6),
        GQUAINTITY integer,
        GTYPE	 smallint)
BEGIN
insert into goods(GNAME,
        GPRICE,
        GVENDOR_CODE,
        GEXPIRE_DATE,
        GPLACE,
        GQUAINTITY,
        GTYPE)
        values(GNAME,
        GPRICE ,
        GVENDOR_CODE ,
        GEXPIRE_DATE,
        GPLACE,
        GQUAINTITY,
        GTYPE);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addToStaff` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addToStaff`(SNAME VARCHAR(20), SURNAME VARCHAR(20), EMAIL varchar(30), POSITION VARCHAR(50), 
ACCESS_LVL INT, SALARY DECIMAL(12,2), STARTDATE DATE, SPASSWORD VARCHAR(20))
BEGIN
INSERT INTO STAFF(SNAME, SURNAME, EMAIL, SPOSITION, SACCESS_LVL, SALARY, STARDATE, SPASSWORD) 
VALUES (SNAME, SURNAME, EMAIL, POSITION, ACCESS_LVL, SALARY, STARTDATE, SPASSWORD);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `loginToDB` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loginToDB`(email varchar(30), spassword varchar(20))
BEGIN
select email, spassword, SACCESS_LVL from staff
where staff.email = email and staff.spassword = spassword;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-30 18:21:42
