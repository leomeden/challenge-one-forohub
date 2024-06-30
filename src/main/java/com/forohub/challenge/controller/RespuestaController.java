package com.forohub.challenge.controller;

import com.forohub.challenge.domain.respuesta.DatosAgregarRespuesta;
import com.forohub.challenge.domain.respuesta.RespuestaService;
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
@RequestMapping("/respuestas")
public class RespuestaController {


    @Autowired
    private RespuestaService respuestaService;

    @PostMapping
    @Transactional
    public ResponseEntity agregar(@RequestBody @Valid DatosAgregarRespuesta datos){
        respuestaService.agregarRespuesta(datos);
        return ResponseEntity.ok("Verificar si se guardo - el request llego correctamente");
    }
}
