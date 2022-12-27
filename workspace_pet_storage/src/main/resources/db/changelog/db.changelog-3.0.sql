--liquibase formatted sql

--changeset storage:1
ALTER TABLE pet
    RENAME COLUMN typeOfAccommodation TO type_of_accommodation;

--changeset storage:2
drop table greeting;
