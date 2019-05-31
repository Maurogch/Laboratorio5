create database dbautos;
use dbautos;

create table Titualres(
    id int auto_increment,
    nombre varchar(50),
    apellido varchar(50),
    primary key(id)
);

create table Autos(
    id int auto_increment,
    modelo int,
    patente varchar(50),
    idTitular int,
    primary key (id),
    foreign key (idTitular) references Titulares (id)
);