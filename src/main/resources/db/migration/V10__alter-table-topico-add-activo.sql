alter table topico add activo tinyint not null;
update topico set activo = 1;