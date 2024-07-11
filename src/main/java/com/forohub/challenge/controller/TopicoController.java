package com.forohub.challenge.controller;


import com.forohub.challenge.domain.topico.DatosAgregarTopico;
import com.forohub.challenge.domain.topico.DatosListadoTopico;
import com.forohub.challenge.domain.topico.Topico;
import com.forohub.challenge.domain.topico.TopicosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/topicos")
//@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicosService topicosService;

    @PostMapping
    @Transactional
    public ResponseEntity agregar(@RequestBody @Valid DatosAgregarTopico datos){
        topicosService.agregarTopico(datos);
        return ResponseEntity.ok("Verificar si se guardo - el request llego correctamente");
    }

    @GetMapping
    public List<DatosListadoTopico> listadoTopicos(){
        return topicosService.listarTopicos();
    }
}
