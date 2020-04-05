
-- Dumping database structure for hibernatedemos
DROP DATABASE IF EXISTS springbootdemos;
CREATE DATABASE springbootdemos; 
USE springbootdemos;


-- Dumping structure for table hibernatedemos.employee
DROP TABLE IF EXISTS customer_spring;
CREATE TABLE IF NOT EXISTS customer_spring (
  customer_id int(11) unsigned NOT NULL AUTO_INCREMENT,
  customer_name varchar(20) DEFAULT NULL,
  billingtime datetime DEFAULT NULL,
  billingamount double DEFAULT NULL,
  PRIMARY KEY (customer_id)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

INSERT INTO customer_spring (customer_id, customer_name, billingtime, billingamount) VALUES
	(1001, 'MSD',  '2020-02-24 00:00:00', 100000),
	(1002, 'James',  '2020-02-24 00:00:00', 5000),
	(1003, 'Rocky',  '2020-02-24 00:00:00', 100000);
commit;
-----END----
