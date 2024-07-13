package com.forohub.challenge.domain.topico;

import com.forohub.challenge.domain.curso.CursoRepository;
import com.forohub.challenge.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Long.valueOf;

@Service
public class TopicosService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DatosListadoTopico agregarTopico(DatosAgregarTopico datos){

        var usuario = usuarioRepository.findById(datos.idAutor()).get();

        var curso = cursoRepository.findById(datos.idCurso()).get();

        var topico = new Topico(datos, usuario, curso);

        return new DatosListadoTopico(topicoRepository.save(topico)) ;

    }

    public Page<DatosListadoTopico> listarTopicos(Pageable paginacion) {

        //return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new);
    }

    public DatosListadoTopico actualizarTopico(Long id, DatosActualizarTopico datos) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datos);
        return new DatosListadoTopico(topico);
    }

    //delete logico
    public void eliminarTopico(Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        //topicoRepository.delete(topico);
        topico.desactivarTopico();

    }

    public DatosListadoTopico obtenerTopicoPorId(Long id) {
        return new DatosListadoTopico(topicoRepository.getReferenceById(id));
    }
}
