--liquibase formatted sql

--changeset portal:1
create table if not exists greeting
(
    id         bigserial primary key,
    message    varchar(255) not null,
    created_at timestamp not null
);