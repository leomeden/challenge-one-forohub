package com.forohub.challenge.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String autor,
        String categoria,
        String curso

        ) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
                topico.getAutor().getUsername(), topico.getCurso().getCategoria().toString(),
                topico.getCurso().getNombre());
    }
}
