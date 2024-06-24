
create table topico(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    fecha_creacion datetime not null,
    status varchar(100) not null,
    autor_id bigint not null,

    primary key(id),

    constraint fk_topico_autor_id foreign key(autor_id) references usuarios(id)

)