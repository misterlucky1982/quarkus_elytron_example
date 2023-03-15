CREATE TABLE quarkus_user
(
    id        SERIAL,
    login     VARCHAR(255) UNIQUE NOT NULL,
    firstname VARCHAR(255)        NOT NULL,
    lastname VARCHAR(255)        NOT NULL,
    password  VARCHAR(255)        NOT NULL,
    email     VARCHAR(255) UNIQUE NOT NULL,
    role      VARCHAR(255)        NOT NULL
);
INSERT INTO quarkus_user (login, firstname, lastname, password, email, role)
VALUES ('admin1', 'Admin', 'Administrator', md5('1111'), 'admin@mail.my','admin');
INSERT INTO quarkus_user (login, firstname, lastname, password, email, role)
VALUES ('herbert', 'Johnny', 'Herbert', md5('2222'), 'herbert@mail.my','user');
INSERT INTO quarkus_user (login, firstname, lastname, password, email, role)
VALUES ('berger', 'Gerhard', 'Berger', md5('3333'), 'berger@mail.my','custom');
