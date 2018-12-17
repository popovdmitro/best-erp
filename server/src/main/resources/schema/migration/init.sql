--liquibase formatted sql

--changeset dpopov:init (dbms:postgresql failOnError:true)

CREATE SEQUENCE task_id_seq INCREMENT 1 MINVALUE 1 CACHE 1;

CREATE TABLE task
(
    id BIGINT PRIMARY KEY NOT NULL,
    external_id VARCHAR(50) NOT NULL,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    search_engine VARCHAR(20) NOT NULL,
    query_string VARCHAR(300) NOT NULL,
    frequency VARCHAR(20) NOT NULL,
    country VARCHAR(2),
    language VARCHAR(2),
    due_date DATE,
    proxy_type VARCHAR(20),
    proxy_host VARCHAR(50),
    proxy_port INTEGER,
    proxy_user_name VARCHAR(100),
    proxy_password VARCHAR(200),
    status VARCHAR(20) NOT NULL
);
CREATE INDEX idx_task_external_id ON task (external_id);
CREATE INDEX idx_task_status ON task (status);

--rollback SELECT 1;