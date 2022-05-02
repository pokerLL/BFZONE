DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `article_id` int NOT NULL,
  `user_id` int NOT NULL,
  `follow` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;

/*Data for the table `comments` */

insert  into `comments`(`id`,`article_id`,`user_id`,`follow`,`content`,`date`) values 
(1,6,9,0,'写得真好啊',''),
(2,2,9,0,'写得真好啊','2020-01-01'),
(3,3,9,0,'写得真好啊','2020-01-01'),
(4,1,9,0,'写得真好啊','2020-01-01'),
(5,5,9,0,'写得真好啊','2020-01-01'),
(6,4,9,0,'写得真好啊','2020-01-01'),
(7,4,7,0,'鞭辟入里，作者用心了','2020-01-01'),
(8,7,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(9,2,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(10,3,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(11,1,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(12,5,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(13,4,7,3,'鞭辟入里，作者用心了','2020-01-01'),
(14,4,2,2,'写得太好了吧','2020-01-01'),
(15,7,2,2,'写得太好了吧','2020-01-01'),
(16,2,2,2,'写得太好了吧','2020-01-01'),
(17,3,2,2,'写得太好了吧','2020-01-01'),
(18,1,2,2,'写得太好了吧','2020-01-01'),
(19,5,2,2,'写得太好了吧','2020-01-01'),
(20,4,2,2,'写得太好了吧','2020-01-01');