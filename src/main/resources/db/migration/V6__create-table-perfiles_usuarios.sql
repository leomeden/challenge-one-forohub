

create table perfiles_usuarios
(
    id bigint not null auto_increment,
    usuarios_id bigint not null,
    perfil_id bigint not null,

    primary key(id),

    constraint fk_usuarios_perfil_id foreign key(usuarios_id) references usuarios(id),
    constraint fk_perfil_usuarios_id foreign key(perfil_id) references perfil(id)

);
