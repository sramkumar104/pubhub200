CREATE TABLE users
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 NAME VARCHAR(200) UNIQUE NOT NULL,
 email VARCHAR(200) NOT NULL,
 PASSWORD VARCHAR(200) NOT NULL
);