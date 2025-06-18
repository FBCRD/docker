create table usuario(
    idusuario serial not null primary key,
    uuid UUID DEFAULT gen_random_uuid(),
    nome varchar(50) not null unique,
    email varchar(50) not null unique,
    senha varchar(20) not null
);