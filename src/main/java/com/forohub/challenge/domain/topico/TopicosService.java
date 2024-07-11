package com.forohub.challenge.domain.topico;

import com.forohub.challenge.domain.curso.CursoRepository;
import com.forohub.challenge.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicosService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public void agregarTopico(DatosAgregarTopico datos){

        var usuario = usuarioRepository.findById(datos.idAutor()).get();

        var curso = cursoRepository.findById(datos.idCurso()).get();

        var topico = new Topico(datos, usuario, curso);

        topicoRepository.save(topico);

    }

    public List<DatosListadoTopico> listarTopicos() {

        return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
    }
}
