package com.forohub.challenge.domain.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public void agregarPerfil(DatosAgregarPerfil datos){

        var perfil = new Perfil(datos);

        perfilRepository.save(perfil);
    }


}
