
    drop table if exists profesores;

    drop table if exists usuarios;

    create table profesores (
        id integer not null auto_increment,
        ape1 varchar(20) not null,
        ape2 varchar(20),
        nombre varchar(30) not null,
        primary key (id)
    );

    create table usuarios (
        idUsuario integer not null auto_increment,
        ape1 varchar(50) not null,
        ape2 varchar(50),
        confirmPassword varchar(50) not null,
        login varchar(50) not null unique,
        nombre varchar(50) not null,
        password varchar(50) not null,
        primary key (idUsuario)
    );
