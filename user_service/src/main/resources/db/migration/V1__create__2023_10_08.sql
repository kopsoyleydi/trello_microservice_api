CREATE TABLE users (
                       user_id INT AUTO_INCREMENT,
                       email VARCHAR(255),
                       name VARCHAR(255),
                       surname VARCHAR(255),
                       date_of_birth DATE,
                       primary key (user_id)
);

CREATE TABLE roles (
                       role_id INT AUTO_INCREMENT,
                       role_name VARCHAR(255),
                       primary key (role_id)
);

CREATE TABLE users_roles (
                            user_id INT,
                            role_id INT,
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users (user_id),
                            FOREIGN KEY (role_id) REFERENCES roles (role_id)
);


INSERT INTO roles (role_name)
VALUES ('Admin');
INSERT INTO roles (role_name)
VALUES ('User');
