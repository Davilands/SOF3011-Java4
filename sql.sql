drop database java4

create database  java4

use java4

CREATE TABLE users (
    userid INT IDENTITY(1,1) NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    isActive BIT DEFAULT 1,
    PRIMARY KEY (userid),
    CONSTRAINT uq_email UNIQUE (email)
);

CREATE TABLE user_logs (
    log_id INT IDENTITY(1,1) NOT NULL,
    userid INT NOT NULL,
    login_time DATETIME NOT NULL CONSTRAINT DF_user_logs_login_time DEFAULT GETDATE(),
    logout_time DATETIME,
    PRIMARY KEY (log_id),
    FOREIGN KEY (userid) REFERENCES users(userid)
);

INSERT INTO user_logs (userid)
SELECT TOP 10 userid FROM users;

INSERT INTO users (username, email, password)
VALUES 
    ('john_doe', 'john_doe@example.com', 'password1'),
    ('jane_doe', 'jane_doe@example.com', 'password2'),
    ('bob_smith', 'bob_smith@example.com', 'password3'),
    ('sara_jones', 'sara_jones@example.com', 'password4'),
    ('mike_taylor', 'mike_taylor@example.com', 'password5'),
    ('kim_nguyen', 'kim_nguyen@example.com', 'password6'),
    ('dan_brown', 'dan_brown@example.com', 'password7'),
    ('tina_foster', 'tina_foster@example.com', 'password8'),
    ('matt_jackson', 'matt_jackson@example.com', 'password9'),
    ('amy_lee', 'amy_lee@example.com', 'password10');

	select * from users
	select * from user_logs

	delete from user_logs