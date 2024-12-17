CREATE TABLE persons(
id INTEGER NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
city VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);

insert into persons(name, city) values('Ish', 'NJ');