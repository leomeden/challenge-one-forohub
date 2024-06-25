package com.forohub.challenge.domain.perfil;

public record DatosAgregarPerfil(
        String nombre,

        boolean leer,

        boolean escribir,

        boolean borrar,

        boolean comentar

) {
}
