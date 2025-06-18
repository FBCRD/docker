create table filme(
    idfilme serial not null primary key,
    titulo varchar(200) not null unique,
    descricao varchar(400) not null,
    datalancamento varchar(30) not null,
    duracao int not null
);
