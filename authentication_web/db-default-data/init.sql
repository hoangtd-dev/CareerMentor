CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price FLOAT NOT NULL
);

INSERT INTO users (name, email, password_hash) VALUES
    ('Hoang Tran', 'hoang@gmail.com', '$2a$12$ow6yLgV.3TOAsXqMmaSeW.nbaH7I370JYVcp0J5N7NCcojCvfyacy'),
    ('Edward', 'edward@gmail.com', '$2a$12$e7MOA9LjFIJ5PNYsc/RUg.WKS89Qf62sEo/kQgoFiDZgL7TmsZ5O.'),
    ('Dung Nguyen', 'dung@gmail.com', '$2a$12$42bj0/PmtXhXhaauQGSdXO5Kt40ICrdVCHWcCteFV95VXjWnVvxO.');

INSERT INTO products (name, price) VALUES
    ('Iphone', 100.0),
    ('Car', 2500.5),
    ('Macbook', 200.0);