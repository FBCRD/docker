create table listafavoritos(
    idlistaFav serial not null primary key,
    nomelista varchar(50) not null,
    idusuario int,
    idfilme int,
    foreign key (idusuario) REFERENCES usuario,
    foreign key (idfilme) REFERENCES filme
);