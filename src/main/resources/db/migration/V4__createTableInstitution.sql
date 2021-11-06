CREATE TABLE if not exists institution (
    id serial PRIMARY KEY,
    id_user INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    cnpj varchar(255) not null,
    FOREIGN KEY (id_user) REFERENCES users (id)
);