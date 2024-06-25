package com.forohub.challenge.domain.topico;

import com.forohub.challenge.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicosService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void agregarTopico(DatosAgregarTopico datos){

        var usuario = usuarioRepository.findById(datos.idAutor()).get();

        var topico = new Topico(datos, usuario);

        topicoRepository.save(topico);


    }
}
