create table avaliacao(
    idAvalicao serial not null primary key,
    nota float not null,
    comentario varchar(500) not null,
    data date not null
);