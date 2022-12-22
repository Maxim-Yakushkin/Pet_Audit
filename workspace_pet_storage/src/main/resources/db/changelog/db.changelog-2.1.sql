--liquibase formatted sql

--changeset portal:1
alter table pet
alter column birthday type date;
