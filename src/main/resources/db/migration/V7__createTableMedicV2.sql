CREATE TABLE if not exists medic (
    id serial PRIMARY KEY,
    id_user INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    crp VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,

    FOREIGN KEY (id_user) REFERENCES users (id)
);