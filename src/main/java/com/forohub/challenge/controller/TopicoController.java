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
    public ResponseEntity<String> agregar(@RequestBody @Valid DatosAgregarTopico datos){
        topicosService.agregarTopico(datos);
        return ResponseEntity.ok("Verificar si se guardo - el request llego correctamente");
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 5, sort = "titulo") Pageable paginacion){
        return ResponseEntity.ok(topicosService.listarTopicos(paginacion));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datos){
        topicosService.actualizarTopico(id, datos);
        return ResponseEntity.ok("Se actualizó con éxito");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id){
        topicosService.eliminarTopico(id);
        return ResponseEntity.ok("Se eliminó con éxito");
    }
}
