CREATE TABLE if not exists users (
	id serial not null primary key,
	username varchar(255) not null,
	token varchar(255) not null,
	email varchar(255) not null,
	password varchar(255) not null
);


