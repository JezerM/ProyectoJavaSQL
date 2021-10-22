create database Libros

use Libros

create table Autor(
idAutor int primary key identity (1,1) not null,
nombrePila varchar(60) not null,
apellidoPaterno varchar(60) not null
);

create table Libro(
isbn varchar(10) not null primary key,
titulo varchar(100) not null,
numeroEdicion int not null,
copyright varchar(50) not null,
);

create table isbnAutor(
idAutor int not null foreign key references Autor(idAutor)
	on update cascade on delete cascade,
isbn varchar(10) not null foreign key references Libro(isbn)
	on update cascade on delete cascade
);