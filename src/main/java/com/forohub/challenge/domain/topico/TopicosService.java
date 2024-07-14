package com.forohub.challenge.domain.topico;

import com.forohub.challenge.domain.curso.CursoRepository;
import com.forohub.challenge.domain.topico.validaciones.ValidadorDeTopicos;
import com.forohub.challenge.domain.usuario.UsuarioRepository;
import com.forohub.challenge.infra.errores.ValidacionDeIntegridad;
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

    @Autowired
    private List<ValidadorDeTopicos> validadores;

    public DatosListadoTopico agregarTopico(DatosAgregarTopico datos){

        if(usuarioRepository.findById(datos.idAutor()).isEmpty()){
            throw new ValidacionDeIntegridad("El id del usuario no fue encontrado");
        }

        if(cursoRepository.findById(datos.idCurso()).isEmpty()){
            throw new ValidacionDeIntegridad("El id del curso no fue encontrado");
        }

        validadores.forEach(v->v.validar(datos));

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
        if(topicoRepository.findById(id).isEmpty()){
            throw new ValidacionDeIntegridad("El id del curso no fue encontrado");
        }
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datos);
        return new DatosListadoTopico(topico);
    }

    //delete logico
    public void eliminarTopico(Long id) {
        if(topicoRepository.findById(id).isEmpty()){
            throw new ValidacionDeIntegridad("El id del curso no fue encontrado");
        }
        Topico topico = topicoRepository.getReferenceById(id);
        //topicoRepository.delete(topico);
        topico.desactivarTopico();

    }

    public DatosListadoTopico obtenerTopicoPorId(Long id) {

        if(topicoRepository.findById(id).isEmpty()){
            throw new ValidacionDeIntegridad("El id del curso no fue encontrado");
        }
        return new DatosListadoTopico(topicoRepository.getReferenceById(id));
    }
}
