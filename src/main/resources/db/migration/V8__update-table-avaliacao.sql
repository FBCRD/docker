alter table avaliacao
add column idusuario int,
    add constraint idusuario foreign key (idusuario) references usuario(idusuario),
add column idfilme int,
    add constraint idfilme foreign key (idfilme) references filme(idfilme);
