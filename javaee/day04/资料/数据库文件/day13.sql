-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.22-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.2.0.4675
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 day13 的数据库结构
CREATE DATABASE IF NOT EXISTS `day13` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `day13`;


-- 导出  表 day13.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `hobby` varchar(120) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- 正在导出表  day13.user 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `password`, `age`, `sex`, `email`, `hobby`, `address`, `description`, `birthday`) VALUES
	(1, '牛冰冰', '123', 12, '男', 'tt@qq.com', 'java,c,c++', '人才公寓', '天才', '2016-04-21'),
	(10, '狗蛋', '111', 4, '男', '11@qq.com', 'C,C++,Java,IOS,PHP,Android', '深圳', '天才', '2012-01-01'),
	(11, '张三', '111', 113, '女', '11@qq.com', 'C,C++,Java,IOS,PHP,Android', '上海', '很好很健康', '1999-09-09'),
	(12, '张三三', '111', 19, '男', '11@qq.com', 'C,C++,Java', '上海', '牛', '1992-09-07'),
	(13, '哈哈', '111', 11, '男', '11@qq.com', 'C,C++', '北京', '432432423', '1111-11-11'),
	(14, '张思思', '123', 18, '男', '11@qq.com', 'C,C++,Java,IOS,PHP,Android', '上海', '就覅圣诞节佛isjo', '1998-09-09'),
	(15, '张三3号', '111', 29, '女', '11@qq.com', 'C,C++,Java,IOS,PHP,Android', '南京', '白富美', '1989-01-01'),
	(16, '朱蕊', '1', 12, '男', '1', 'C', NULL, NULL, NULL),
	(17, '张三4号', '698d51a19d8a121ce581499d7b701668', 29, '女', '11@qq.com', 'C,C++,Java,IOS,PHP,Android', '南京', '白富美', '1989-01-01'),
	(18, '赵六', '111', 11, '男', '11@qq.com', 'C,C++,Java', '北京', '个范德萨范德萨', '1998-01-01'),
	(19, '麒麟', '123', 5, '女', '11@qq.com', 'C,C++,Java,IOS,PHP,Android', '上海', '专业贴膜', '2012-12-21');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
