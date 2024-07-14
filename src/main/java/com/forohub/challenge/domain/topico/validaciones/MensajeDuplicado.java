package com.forohub.challenge.domain.topico.validaciones;

import com.forohub.challenge.domain.topico.DatosAgregarTopico;
import com.forohub.challenge.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MensajeDuplicado implements ValidadorDeTopicos{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DatosAgregarTopico datos) {

        if(datos.mensaje() == null){
            return;
        }

        var mensajeValidar = topicoRepository.findFirstByMensaje(datos.mensaje()).isPresent();

        if(mensajeValidar){
            throw new ValidationException("El mensaje ingresado ya existe!");
        }
    }
}
