-- MariaDB dump 10.19  Distrib 10.6.7-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: commers
-- ------------------------------------------------------
-- Server version	10.6.7-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `base_item`
--

DROP TABLE IF EXISTS `base_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `sku` varchar(255) NOT NULL COMMENT '재고 번호',
  `seller_id` bigint(20) NOT NULL COMMENT '판매자 ID (FK)',
  `name` varchar(100) DEFAULT NULL COMMENT '이름',
  `item_category` varchar(30) NOT NULL COMMENT '물품 카테고리',
  `price` int(11) NOT NULL COMMENT '가격',
  `stock` int(11) unsigned NOT NULL DEFAULT 1 COMMENT '재고 개수',
  `description` text DEFAULT NULL COMMENT '설명',
  `reg_date_time` datetime DEFAULT NULL,
  `mod_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `BASE_ITEM_UNIQUE` (`sku`),
  KEY `FKblk67vd2t6v7usr7c0dlerp3m` (`seller_id`),
  CONSTRAINT `FKblk67vd2t6v7usr7c0dlerp3m` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_item`
--

LOCK TABLES `base_item` WRITE;
/*!40000 ALTER TABLE `base_item` DISABLE KEYS */;
INSERT INTO `base_item` VALUES (1,'CL834878',1,'청바지','CLOTHES',34000,3,'워싱 청바지','2024-02-19 19:24:40','2024-02-19 19:24:40');
/*!40000 ALTER TABLE `base_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `cart_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `customer_id` bigint(20) NOT NULL COMMENT '고객 ID (FK)',
  `total_product_count` int(11) NOT NULL COMMENT '총 상품 개수',
  PRIMARY KEY (`cart_id`),
  KEY `FKdebwvad6pp1ekiqy5jtixqbaj` (`customer_id`),
  CONSTRAINT `FKdebwvad6pp1ekiqy5jtixqbaj` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_detail`
--

DROP TABLE IF EXISTS `cart_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_detail` (
  `cart_id` bigint(20) NOT NULL COMMENT '장바구니 ID',
  `product_id` bigint(20) NOT NULL COMMENT '상품 ID',
  `quantity` int(11) unsigned NOT NULL COMMENT '수량',
  PRIMARY KEY (`cart_id`,`product_id`),
  KEY `cart_detail_FK_1` (`product_id`),
  CONSTRAINT `cart_detail_FK` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_detail_FK_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='장바구니 상세';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_detail`
--

LOCK TABLES `cart_detail` WRITE;
/*!40000 ALTER TABLE `cart_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `email` varchar(320) NOT NULL COMMENT '이메일',
  `customer_name` varchar(20) NOT NULL COMMENT '이름',
  `password` varchar(100) NOT NULL COMMENT '비밀번호',
  `phone_number` varchar(30) DEFAULT NULL COMMENT '전화 번호',
  `balance` int(11) NOT NULL DEFAULT 0 COMMENT '잔액',
  `verification_code` varchar(255) DEFAULT NULL COMMENT '인증 코드',
  `verify` bit(1) NOT NULL COMMENT '인증 여부',
  `verify_expired_at` datetime DEFAULT NULL COMMENT '인증 만료 일시',
  `reg_date_time` datetime DEFAULT NULL,
  `mod_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (10,'goodks09@test.com','test','$2a$10$05WIs.UcXUe30iN/VxYQJu2x.tSoyfPg9PQW0lg85dNR/TX1CaoFu','01000001234',0,'P5a14OlXlK','','2024-02-15 17:41:47','2024-02-14 17:41:47','2024-02-14 17:41:47');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_role`
--

DROP TABLE IF EXISTS `customer_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_role` (
  `customer_id` bigint(20) NOT NULL,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`customer_id`,`role`),
  CONSTRAINT `customer_role_customer_FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_role`
--

LOCK TABLES `customer_role` WRITE;
/*!40000 ALTER TABLE `customer_role` DISABLE KEYS */;
INSERT INTO `customer_role` VALUES (10,'ROLE_USER');
/*!40000 ALTER TABLE `customer_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `customer_id` bigint(20) NOT NULL COMMENT '고객 ID (FK)',
  `order_code` varchar(30) NOT NULL COMMENT '주문 코드',
  `order_date` datetime NOT NULL COMMENT '주문 일시',
  `order_name` varchar(100) DEFAULT NULL COMMENT '주문명',
  `order_status` varchar(20) NOT NULL COMMENT '주문 상태',
  `payment_method` varchar(20) NOT NULL COMMENT '결제 수단',
  `supply_price` int(11) NOT NULL COMMENT '공급가',
  `discount_amount` int(11) NOT NULL COMMENT '할인 금액',
  `net_price` int(11) NOT NULL COMMENT '판매가',
  `reg_date_time` datetime DEFAULT NULL,
  `mod_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_unique` (`order_code`),
  KEY `order_customer_FK` (`customer_id`),
  CONSTRAINT `order_customer_FK` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `order_detail_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `order_id` bigint(20) NOT NULL COMMENT '주문 ID (FK)',
  `product_code` varchar(30) NOT NULL COMMENT '상품 코드',
  `product_name` varchar(100) DEFAULT NULL COMMENT '상품명',
  `order_status` varchar(20) NOT NULL COMMENT '주문 상태',
  `supply_price` int(11) NOT NULL COMMENT '공급가',
  `discount_amount` int(11) NOT NULL COMMENT '할인가',
  `net_price` int(11) NOT NULL COMMENT '판매가',
  `quantity` int(11) NOT NULL COMMENT '수량',
  `total_amount` int(11) NOT NULL COMMENT '총 금액(판매가 * 수량)',
  `reg_date_time` datetime DEFAULT NULL,
  `mod_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `order_detail_order_FK` (`order_id`),
  CONSTRAINT `order_detail_order_FK` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `seller_id` bigint(20) NOT NULL COMMENT '판매자 ID (FK)',
  `product_code` varchar(30) NOT NULL COMMENT '상품 코드',
  `name` varchar(100) DEFAULT NULL COMMENT '상품명',
  `supply_price` int(11) NOT NULL COMMENT '공급가',
  `discount_amount` int(11) NOT NULL COMMENT '할인 금액',
  `retail_price` int(11) NOT NULL COMMENT '소비자 가격',
  `description` text DEFAULT NULL COMMENT '설명',
  `reg_date_time` datetime DEFAULT NULL,
  `mod_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKesd6fy52tk7esoo2gcls4lfe3` (`seller_id`),
  CONSTRAINT `FKesd6fy52tk7esoo2gcls4lfe3` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_detail` (
  `item_id` bigint(20) NOT NULL COMMENT '아이템 ID (FK)',
  `product_id` bigint(20) NOT NULL COMMENT '상품 ID (FK)',
  `quantity` int(11) NOT NULL COMMENT '수량',
  PRIMARY KEY (`item_id`,`product_id`),
  KEY `product_detail_product_FK` (`product_id`),
  CONSTRAINT `product_detail_base_item_FK` FOREIGN KEY (`item_id`) REFERENCES `base_item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_detail_product_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail`
--

LOCK TABLES `product_detail` WRITE;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seller` (
  `seller_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `email` varchar(320) DEFAULT NULL COMMENT '이메일',
  `name` varchar(20) DEFAULT NULL COMMENT '이름',
  `password` varchar(100) DEFAULT NULL COMMENT '비밀번호',
  `phone_number` varchar(30) DEFAULT NULL COMMENT '전화 번호',
  `verification_code` varchar(255) DEFAULT NULL COMMENT '인증 코드',
  `verify` bit(1) NOT NULL COMMENT '인증 여부',
  `verify_expired_at` datetime DEFAULT NULL COMMENT '인증 만료 일시',
  `reg_date_time` datetime DEFAULT NULL,
  `mod_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`seller_id`),
  UNIQUE KEY `seller_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES (1,'goodks09@test.com','test','$2a$10$05WIs.UcXUe30iN/VxYQJu2x.tSoyfPg9PQW0lg85dNR/TX1CaoFu','01000001234','P5a14OlXlK','','2024-02-15 17:41:47','2024-02-14 17:41:47','2024-02-14 17:41:47');
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'commers'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-19 20:04:50
