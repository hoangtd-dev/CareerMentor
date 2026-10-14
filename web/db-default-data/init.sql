CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO users (name, email) VALUES
    ('Hoang Tran', 'hoang@gmail.com'),
    ('Edward', 'edward@gmail.com'),
    ('Dung Nguyen', 'dung@gmail.com');


INSERT INTO products (name, price) VALUES
    ('Iphone', 100.0),
    ('Car', 2500.5),
    ('Macbook', 200.0);