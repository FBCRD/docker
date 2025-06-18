alter table usuario
ADD column idlistafav int,
ADD Constraint idlistafav foreign key (idlistafav) references listafavoritos(idlistafav);

alter table usuario
add column idfilme int,
    add constraint idfilme foreign key (idfilme) references filme(idfilme);

