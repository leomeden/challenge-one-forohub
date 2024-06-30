package com.forohub.challenge.domain.usuario;

import com.forohub.challenge.domain.perfil.Perfil;

import java.util.Set;

public record DatosCreacionUsuario(
        String login,
        String password,
        String email
        //Set<Perfil> perfiles

) {
}
