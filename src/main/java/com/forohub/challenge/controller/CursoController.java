package com.forohub.challenge.controller;


import com.forohub.challenge.domain.curso.CursoService;
import com.forohub.challenge.domain.curso.DatosAgregarCurso;
import com.forohub.challenge.domain.topico.DatosAgregarTopico;
import jakarta.validation.Valid;
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
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    @Transactional
    public ResponseEntity agregar(@RequestBody DatosAgregarCurso datos){
        cursoService.agregarCurso(datos);
        return ResponseEntity.ok("Verificar si se guardo - el request llego correctamente");
    }


}
