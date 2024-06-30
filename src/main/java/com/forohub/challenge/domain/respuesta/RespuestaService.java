package com.forohub.challenge.domain.respuesta;

import com.forohub.challenge.domain.topico.TopicoRepository;
import com.forohub.challenge.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void agregarRespuesta(DatosAgregarRespuesta datos){

        var usuario = usuarioRepository.findById(datos.idAutor()).get();

        var topico = topicoRepository.findById(datos.idTopico()).get();

        var respuesta = new Respuesta(datos, usuario, topico);

        respuestaRepository.save(respuesta);

    }

}
