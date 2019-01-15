INSERT INTO users(username,password,enabled) VALUES ('mike','{noop}ekim',true);
INSERT INTO users(username,password,enabled) VALUES ('admin','{noop}pass',true);

INSERT INTO authorities(username,authority) VALUE ('mike','USER');
INSERT INTO authorities(username,authority) VALUE ('admin','ADMIN');
INSERT INTO authorities(username,authority) VALUE ('admin','USER');

