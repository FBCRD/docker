alter table filme
add column idgenero int,
    add constraint idGenero foreign key (idgenero)references genero(idgenero),
add column idavaliacao int,
    add constraint idavaliacao foreign key (idavaliacao)references avaliacao(idavalicao);

