alter table genero
add column idfilme int,
    add constraint idfilme foreign key (idfilme) references filme(idfilme);