package com.forohub.challenge.domain.topico;

import com.forohub.challenge.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public record DatosAgregarTopico(
        String titulo,
        String mensaje,
        Long idAutor
) {
}
