create table users (
                       id bigint not null,
                       email varchar(255),
                       first_name varchar(255),
                       last_name varchar(255),
                       password varchar(255),
                       role varchar(255),
                       primary key (id)
);


INSERT INTO users (id, first_name, last_name, email, password, role)
VALUES (1,'hello','hello1','hello1','hello1', 'role');