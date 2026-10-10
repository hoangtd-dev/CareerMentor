CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL
);

INSERT INTO users (name, email) VALUES
    ('Hoang Tran', 'hoang@gmail.com'),
    ('Edward', 'edward@gmail.com'),
    ('Dung Nguyen', 'dung@gmail.com');