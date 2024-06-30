alter table topico
add constraint fk_topico_curso_id foreign key(curso_id) references curso(id);