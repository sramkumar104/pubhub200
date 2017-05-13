CREATE TABLE users
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 NAME VARCHAR(200) UNIQUE NOT NULL,
 email VARCHAR(200) NOT NULL,
 PASSWORD VARCHAR(200) NOT NULL
);

CREATE TABLE orders
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 user_id INT,
 total_price INT NOT NULL DEFAULT 0,
 ordered_date TIMESTAMP DEFAULT NOW(),
 modified_date TIMESTAMP DEFAULT NOW(),
 cancelled_date DATETIME,
 delivered_date DATETIME,
 STATUS VARCHAR(50) DEFAULT 'ORDERED' ,
 reason VARCHAR(100) ,
 CONSTRAINT fk_users_id FOREIGN KEY(user_id) REFERENCES users(id)
 );
 
 CREATE TABLE order_items
(
id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT NOT NULL,
book_id INT NOT NULL,
quantity INT NOT NULL,
ordered_date TIMESTAMP DEFAULT NOW(),
CONSTRAINT fk_orders_id FOREIGN KEY(order_id) REFERENCES orders(id),
CONSTRAINT fk_books_id FOREIGN KEY(book_id) REFERENCES books(id)
);