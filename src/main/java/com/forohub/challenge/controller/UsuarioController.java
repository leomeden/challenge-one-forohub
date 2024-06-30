package com.forohub.challenge.controller;


import com.forohub.challenge.domain.usuario.DatosCreacionUsuario;
import com.forohub.challenge.domain.usuario.Usuario;
import com.forohub.challenge.domain.usuario.UsuarioRepository;
import com.forohub.challenge.domain.usuario.UsuarioService;
import com.forohub.challenge.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity agregar(@RequestBody DatosCreacionUsuario datos){


        usuarioService.crearUsuario(datos);

        return ResponseEntity.ok("Verificar si se guardo - el request llego correctamente");
    }
}
