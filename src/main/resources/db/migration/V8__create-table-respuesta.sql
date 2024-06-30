

create table respuesta
(
    id bigint not null auto_increment,
    mensaje varchar(300) not null,
    topico_id bigint not null,
    fecha_creacion datetime not null,
    autor_id bigint not null,
    solucion tinyint not null,


    primary key(id),

    constraint fk_autor_respuesta_id foreign key(autor_id) references usuarios(id),
    constraint fk_topico_respuesta_id foreign key(topico_id) references topico(id)

);
