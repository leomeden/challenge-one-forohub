package com.forohub.challenge.domain.usuario;

import com.forohub.challenge.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passworEncoder;

    public void crearUsuario(DatosCreacionUsuario datos){

        Usuario usuario = new Usuario(datos);

        var encodedPassword = passworEncoder.encode(datos.password());

        usuario.setPassword(encodedPassword);

        usuarioRepository.save(usuario);

    }


}
