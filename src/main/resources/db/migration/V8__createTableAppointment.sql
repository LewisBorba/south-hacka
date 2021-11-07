CREATE TABLE if not exists appointment (
    id serial PRIMARY KEY,
    id_patient INTEGER,
    id_medic INTEGER,
    appointment_type VARCHAR(500) NOT NULL,
    available_hours VARCHAR(500) NOT NULL,
    link varchar(255),
    status VARCHAR(50) not null,

    FOREIGN KEY (id_patient) REFERENCES patient(id),
    FOREIGN KEY (id_medic) REFERENCES medic(id)
);