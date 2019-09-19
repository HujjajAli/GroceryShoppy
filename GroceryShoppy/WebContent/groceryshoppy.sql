/*
SQLyog Enterprise - MySQL GUI v6.56
MySQL - 5.0.81-community-nt : Database - groceryshoppy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`groceryshoppy` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `groceryshoppy`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `admin` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`id`,`admin`,`password`,`username`) values (120,'Nasir Hussain','1234','nasirali@yahoo.com');

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `pImage` varchar(255) default NULL,
  `pName` varchar(255) default NULL,
  `price` double NOT NULL,
  `productID` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `sel_Num` int(11) NOT NULL,
  `email` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `cart` */

insert  into `cart`(`id`,`pImage`,`pName`,`price`,`productID`,`quantity`,`sel_Num`,`email`) values (143,'lgt','Lays Garden Tomato and Basil 100g',25,14,1,1,'amjadali@gmail.com'),(144,'s5','Sprite 2.25L Pack of 2',220,8,1,1,'amjadali@gmail.com'),(145,'s9','Lays Potato Chips 100g',50,7,1,1,'amjadali@gmail.com');

/*Table structure for table `cos_order` */

DROP TABLE IF EXISTS `cos_order`;

CREATE TABLE `cos_order` (
  `id` int(11) NOT NULL,
  `costumerID` int(11) NOT NULL,
  `d_o_o` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `time_O` varchar(255) default NULL,
  `totalPrice` int(11) NOT NULL,
  `address` varchar(255) default NULL,
  `fname` varchar(255) default NULL,
  `mobile` varchar(255) default NULL,
  `costumeDate` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `cos_order` */

insert  into `cos_order`(`id`,`costumerID`,`d_o_o`,`status`,`time_O`,`totalPrice`,`address`,`fname`,`mobile`,`costumeDate`) values (64,49,'Sat Jul 20 15:02:17 PKT 2019','Pending','15:2',1390,'Mir Parho near Colleg, Tando Allahyar','Amjad','03457896577',NULL),(74,49,'Sat Jul 20 15:32:25 PKT 2019','Pending','15:32',315,'Latifabad, Hyderabad','Sarmad Ali','03886578411',NULL),(81,15,'Sat Jul 20 16:01:38 PKT 2019','Pending','16:1',965,'Tando Jam, Hyderabad','Aurangzaib','12115464876',NULL),(92,13,'Sun Jul 21 11:00:37 PKT 2019','Panding','11:0',970,'Talhar, Badin','Sajjad Ali','03355678455',NULL),(100,101,'Sun Jul 21 21:24:32 PKT 2019','Panding','21:24',335,'Qasimabad, Hyderabad','Abdullah','03457889622',NULL),(115,101,'Tue Jul 23 18:10:04 PKT 2019','Panding','18:10',120,'Sachal Goth Gulshan-e-Iqbal, Karachi, Karachi City, Sindh, Karachi','Irfan Ali','03333706512',NULL),(124,15,'Wed Jul 24 08:08:08 PKT 2019','Panding','8:8',365,'Bahar Khan Mirjat, Tando Allahyar','Bahar Khan','03457896541',NULL),(132,15,'Wed Jul 24 11:24:19 PKT 2019','Panding','11:24',120,'fasal town, hyderabad','Jabbar','545454545',NULL),(139,15,'Wed Jul 24 11:36:00 PKT 2019','Panding','11:36',120,'dsdsd, dsds','dsds','4545',NULL);

/*Table structure for table `costumer` */

DROP TABLE IF EXISTS `costumer`;

CREATE TABLE `costumer` (
  `id` int(11) NOT NULL,
  `cosName` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `costumer` */

insert  into `costumer`(`id`,`cosName`,`email`,`password`) values (13,'Amjad Ali','amjadali@gmail.com','amju'),(15,'Aurangzaib','aurangzaib@gmail.com','umar'),(49,'Azadar Amjad ','ma.meerjat@gmail.com','12345'),(101,'Ali Abbas','abbas@hotmail.com','123');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (146);

/*Table structure for table `orderdetail` */

DROP TABLE IF EXISTS `orderdetail`;

CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL,
  `order_ID` int(11) NOT NULL,
  `product_ID` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `orderdetail` */

insert  into `orderdetail`(`id`,`order_ID`,`product_ID`) values (66,64,7),(65,64,8),(67,64,10),(68,64,8),(69,64,10),(70,64,9),(75,74,7),(76,74,8),(77,74,11),(82,81,7),(83,81,8),(84,81,11),(85,81,14),(86,81,10),(87,81,9),(93,92,8),(94,92,6),(95,92,9),(96,92,10),(101,100,5),(102,100,8),(103,100,14),(116,115,14),(117,115,7),(118,115,11),(125,124,7),(126,124,7),(127,124,11),(128,124,8),(133,132,7),(134,132,14),(135,132,11),(140,139,14),(141,139,11),(142,139,7);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `proId` bigint(20) NOT NULL,
  `companey` varchar(255) default NULL,
  `cuisine` varchar(255) default NULL,
  `discount` int(11) NOT NULL,
  `discription` varchar(255) default NULL,
  `extraprice` double NOT NULL,
  `image` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `preference` varchar(255) default NULL,
  `price` double NOT NULL,
  `proCate_id` bigint(20) default NULL,
  `deals` varchar(255) default NULL,
  `desVal` tinyblob,
  `imgs1` varchar(255) default NULL,
  `imgs2` varchar(255) default NULL,
  `imgs3` varchar(255) default NULL,
  `soldcount` int(11) NOT NULL,
  `uploadDate` datetime default NULL,
  `dealimg` varchar(255) default NULL,
  `age` varchar(255) default NULL,
  PRIMARY KEY  (`proId`),
  KEY `FKfmfq8fmx6tah1f7600jxequ5v` (`proCate_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`proId`,`companey`,`cuisine`,`discount`,`discription`,`extraprice`,`image`,`name`,`preference`,`price`,`proCate_id`,`deals`,`desVal`,`imgs1`,`imgs2`,`imgs3`,`soldcount`,`uploadDate`,`dealimg`,`age`) values (5,'Khan Dry Fruits','pakistani',15,'Best for winter use, Khan Dry Fruits Almonds are one of the best on market, something here also , contains something best from farm',120,'m1','Almonds 100g','veg',90,4,'off',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL),(6,'Khan Dry Fruits','pakistani',12,'Best for winter use, Khan Dry Fruits Cashew are one of the best on market, something here also , contains something best from farm',155,'m2','Cashew Nuts 100g','veg',125,4,'off',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL),(7,'Fruito Lay','spanish',8,'Best for winter use, Khan Dry Fruits Lays are one of the best on market, something here also , contains something best from farm',80,'s9','Lays Potato Chips 100g','veg',50,1,'on',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL),(8,'Pepsico','south american',10,'Best for winter use, Khan Dry Fruits Lays are one of the best on market, something here also , contains something best from farm',250,'s5','Sprite 2.25L Pack of 2','veg',220,1,'on',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL),(9,'Unileiver','french',14,'Best for winter use, Khan Dry Fruits Lays are one of the best on market, something here also , contains something best from farm',380,'a5','Surf Excel Matic 100g','nonveg',350,3,'off',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL),(10,'Sunridge','pakistani',6,'Best for winter use, Khan Dry Fruits Lays are one of the best on market, something here also , contains something best from farm',305,'cam','Sunridge Chaki Aata 10 KG ','veg',275,2,'off',NULL,'cas1','cas2','cas3',0,NULL,'cad',NULL),(11,'Bingo','indian',6,'Best for winter use, Khan Dry Fruits Lays are one of the best on market, something here also , contains something best from farm',75,'s9','Bingo Mad Angles 100g','veg',45,1,'on',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL),(14,'Fruito Lay','maxican',4,'Best for winter use, Khan Dry Fruits Lays are one of the best on market, something here also , contains something best from farm',55,'lgt','Lays Garden Tomato and Basil 100g','veg',25,1,'on',NULL,'lgt1','lgt1','lgt1',0,NULL,'lgt3','new');

/*Table structure for table `productcategory` */

DROP TABLE IF EXISTS `productcategory`;

CREATE TABLE `productcategory` (
  `id` bigint(20) NOT NULL,
  `cname` varchar(255) default NULL,
  `discription` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `productcategory` */

insert  into `productcategory`(`id`,`cname`,`discription`,`type`) values (1,'Snacks & Beverages','Local and International Snacks & Beverages Brands','household'),(2,'Bakery','All Bakery Items fresh and warm','kitchen'),(3,'Detergents','All Brands','household'),(4,'Nuts','all types of dry fruit nuts and very fresh','kitchen');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
