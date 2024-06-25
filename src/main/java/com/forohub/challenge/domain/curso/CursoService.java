package com.forohub.challenge.domain.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public void agregarCurso(DatosAgregarCurso datos){

        var curso = new Curso(datos);

        cursoRepository.save(curso);

    }
}
