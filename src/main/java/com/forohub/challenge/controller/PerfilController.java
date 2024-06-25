package com.forohub.challenge.controller;

import com.forohub.challenge.domain.perfil.DatosAgregarPerfil;
import com.forohub.challenge.domain.perfil.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    @Transactional
    public ResponseEntity agregar(@RequestBody DatosAgregarPerfil datos){
        perfilService.agregarPerfil(datos);
        return ResponseEntity.ok("Verificar si se guardo - el request llego correctamente");
    }
}
