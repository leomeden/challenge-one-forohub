package com.forohub.challenge.domain.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public record DatosAgregarTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotNull
        Long idAutor,

        @NotNull
        Long idCurso
) {
}
