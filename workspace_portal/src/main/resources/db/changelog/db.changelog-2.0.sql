--liquibase formatted sql

--changeset portal:1
create table if not exists pet
(
    id                  bigserial primary key,
    name                varchar(255),
    birthday            timestamp,
    pet_type            varchar(255) not null,
    chipped             boolean,
    typeOfAccommodation varchar(255)
);
