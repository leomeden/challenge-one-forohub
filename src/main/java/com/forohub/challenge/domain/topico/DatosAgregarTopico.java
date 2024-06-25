package com.forohub.challenge.domain.topico;

public record DatosAgregarTopico(
        String titulo,
        String mensaje,
        Long idAutor,
        Long idCurso
) {
}
