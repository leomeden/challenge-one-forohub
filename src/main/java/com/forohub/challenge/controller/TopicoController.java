package com.forohub.challenge.controller;


import com.forohub.challenge.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<DatosListadoTopico> agregar(@RequestBody @Valid DatosAgregarTopico datos, UriComponentsBuilder uriComponentsBuilder){
        DatosListadoTopico topico =  topicosService.agregarTopico(datos);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.id()).toUri();
        return ResponseEntity.created(url).body(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 5, sort = "titulo") Pageable paginacion){
        return ResponseEntity.ok(topicosService.listarTopicos(paginacion));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosListadoTopico> actualizarTopico(@PathVariable Long id){

        return ResponseEntity.ok(topicosService.obtenerTopicoPorId(id));
    }



    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosListadoTopico> actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datos){

        return ResponseEntity.ok(topicosService.actualizarTopico(id, datos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicosService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
