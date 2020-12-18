CREATE DATABASE  IF NOT EXISTS `library_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `library_management`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: library_management
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(100) DEFAULT NULL,
  `category_id` int(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `book_copies` int(11) DEFAULT NULL,
  `book_pub` varchar(100) DEFAULT NULL,
  `publisher_name` varchar(100) DEFAULT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `copyright_year` int(11) DEFAULT NULL,
  `date_receive` varchar(20) DEFAULT NULL,
  `date_added` datetime DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_cate` (`category_id`),
  CONSTRAINT `fk_book_cate` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (15,'Natural Resources',8,'Robin Kerrod',15,'Marshall Cavendish Corporation','Marshall','1-85435-628-3',1997,'','2013-12-11 06:34:27','New'),(16,'Encyclopedia Americana',5,'Grolier',20,'Connecticut','Grolier Incorporation','0-7172-0119-8',1988,'','2013-12-11 06:36:23','Archive'),(17,'Algebra 1',3,'Carolyn Bradshaw, Michael Seals',35,'Pearson Education, Inc','Prentice Hall, New Jersey','0-13-125087-6',2004,'','2013-12-11 06:39:17','Damage'),(18,'The Philippine Daily Inquirer',7,'..',3,'Pasay City','..','..',2013,'','2013-12-11 06:41:53','New'),(19,'Science in our World',4,'Brian Knapp',25,'Regency Publishing Group','Prentice Hall, Inc','0-13-050841-1',1996,'','2013-12-11 06:44:44','Lost'),(20,'Literature',9,'Greg Glowka',20,'Regency Publishing Group','Prentice Hall, Inc','0-13-050841-1',2001,'','2013-12-11 06:47:44','Old'),(21,'Lexicon Universal Encyclopedia',5,'Lexicon',10,'Lexicon Publication','Pulication Inc., Lexicon','0-7172-2043-5',1993,'','2013-12-11 06:49:53','Old'),(22,'Science and Invention Encyclopedia',5,'Clarke Donald, Dartford Mark',16,'H.S. Stuttman inc. Publishing','Publisher , Westport Connecticut','0-87475-450-x',1992,'','2013-12-11 06:52:58','New'),(23,'Integrated Science Textbook ',4,'Merde C. Tan',15,'Vibal Publishing House Inc.','12536. Araneta Avenue Corner Ma. Clara St., Quezon City','971-570-124-8',2009,'','2013-12-11 06:55:27','New'),(24,'Algebra 2',3,'Glencoe McGraw Hill',15,'The McGrawHill Companies Inc.','McGrawhill','978-0-07-873830-2',2008,'','2013-12-11 06:57:35','New'),(25,'Wiki at Panitikan ',7,'Lorenza P. Avera',28,'JGM & S Corporation','JGM & S Corporation','971-07-1574-7',2000,'','2013-12-11 06:59:24','Damage'),(26,'English Expressways TextBook for 4th year',9,'Virginia Bermudez Ed. O. et al',23,'SD Publications, Inc.','Gregorio Araneta Avenue, Quezon City','978-971-0315-33-8',2007,'','2013-12-11 07:01:25','New'),(27,'Asya Pag-usbong Ng Kabihasnan ',8,'Ricardo T. Jose, Ph . D.',21,'Vibal Publishing House Inc.','Araneta Avenue . Cor. Maria Clara St., Quezon City','971-07-2324-3',2008,'','2013-12-11 07:02:56','New'),(28,'Literature (the readers choice)',9,'Glencoe McGraw Hill',20,'..','the McGrawHill Companies Inc','0-02-817934-x',2001,'','2013-12-11 07:05:25','Damage'),(29,'Beloved a Novel',9,'Toni Morrison',13,'..','Alfred A. Knoff, Inc','0-394-53597-9',1987,'','2013-12-11 07:07:02','Old'),(30,'Silver Burdett Engish',2,'Judy Brim',12,'Silver Burdett Company','Silver','0-382-03575-5',1985,'','2013-12-11 09:22:50','Old'),(31,'The Corporate Warriors (Six Classic Cases in American Business)',8,'Douglas K. Ramsey',8,'Houghton Miffin Company','..','0-395-35487-0',1987,'','2013-12-11 09:25:32','Old'),(32,'Introduction to Information System',9,'Cristine Redoblo',10,'CHMSC','Brian INC','123-132',2013,'','2014-01-17 19:00:10','New'),(34,'Fly team',1,'jjj',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,'Fly team',1,'f',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,'Fly team',1,'f',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,'Fly team',1,'f',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,'Sach',1,'Tac gia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,'d',1,'d',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_borrowed`
--

DROP TABLE IF EXISTS `book_borrowed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book_borrowed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `borrow_date` timestamp NOT NULL,
  `return_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_borrowed`
--

LOCK TABLES `book_borrowed` WRITE;
/*!40000 ALTER TABLE `book_borrowed` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_borrowed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_tracking`
--

DROP TABLE IF EXISTS `borrow_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `borrow_tracking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `reader_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `borrow_date` timestamp NOT NULL,
  `return_date` timestamp NOT NULL,
  `is_returned` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_tracking`
--

LOCK TABLES `borrow_tracking` WRITE;
/*!40000 ALTER TABLE `borrow_tracking` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Periodical'),(2,'English'),(3,'Math'),(4,'Science'),(5,'Encyclopedia'),(6,'Filipiniana'),(7,'Newspaper'),(8,'General'),(9,'References');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lost_book_tracking`
--

DROP TABLE IF EXISTS `lost_book_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lost_book_tracking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `reader_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `borrow_date` timestamp NOT NULL,
  `lost_date` timestamp NOT NULL,
  `reason` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lost_book_tracking`
--

LOCK TABLES `lost_book_tracking` WRITE;
/*!40000 ALTER TABLE `lost_book_tracking` DISABLE KEYS */;
/*!40000 ALTER TABLE `lost_book_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader`
--

DROP TABLE IF EXISTS `reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reader` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `people_id` int(11) NOT NULL,
  `reader_card_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `people_id` (`people_id`),
  KEY `type_id` (`type_id`),
  KEY `reader_card_id` (`reader_card_id`),
  CONSTRAINT `reader_ibfk_1` FOREIGN KEY (`people_id`) REFERENCES `people` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `reader_ibfk_2` FOREIGN KEY (`reader_card_id`) REFERENCES `reader_card` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `reader_ibfk_3` FOREIGN KEY (`type_id`) REFERENCES `reader_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader`
--

LOCK TABLES `reader` WRITE;
/*!40000 ALTER TABLE `reader` DISABLE KEYS */;
/*!40000 ALTER TABLE `reader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader_card`
--

DROP TABLE IF EXISTS `reader_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reader_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `end_date` timestamp NOT NULL,
  `book_borrowed_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_borrowed_id` (`book_borrowed_id`),
  CONSTRAINT `reader_card_ibfk_1` FOREIGN KEY (`book_borrowed_id`) REFERENCES `book_borrowed` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader_card`
--

LOCK TABLES `reader_card` WRITE;
/*!40000 ALTER TABLE `reader_card` DISABLE KEYS */;
/*!40000 ALTER TABLE `reader_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader_type`
--

DROP TABLE IF EXISTS `reader_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reader_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader_type`
--

LOCK TABLES `reader_type` WRITE;
/*!40000 ALTER TABLE `reader_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `reader_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `people_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `people_id` (`people_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`people_id`) REFERENCES `people` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `staff_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `staff_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_type`
--

DROP TABLE IF EXISTS `staff_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_type`
--

LOCK TABLES `staff_type` WRITE;
/*!40000 ALTER TABLE `staff_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-16 20:47:59
