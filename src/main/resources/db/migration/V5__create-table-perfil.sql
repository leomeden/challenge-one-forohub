
create table perfil(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    leer tinyint not null,
    escribir tinyint not null,
    borrar tinyint not null,
    comentar tinyint not null,


    primary key(id)

)