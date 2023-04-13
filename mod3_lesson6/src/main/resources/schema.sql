DROP TABLE IF EXISTS books;

CREATE TABLE authors(
id INT AUTO_INCREMENT PRIMARY KEY,
firstName VARCHAR(250) NOT NULL,
lastName VARCHAR(250) NOT NULL
);

CREATE TABLE books(
id INT AUTO_INCREMENT PRIMARY KEY,
authorId INT NOT NULL,
title VARCHAR(250) NOT NULL,
priceOld VARCHAR(250) DEFAULT NULL,
price VARCHAR(250) DEFAULT NULL,
FOREIGN KEY (authorId)  REFERENCES authors(id)
);

