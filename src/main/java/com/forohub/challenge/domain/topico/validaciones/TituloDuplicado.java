package com.forohub.challenge.domain.topico.validaciones;

import com.forohub.challenge.domain.topico.DatosAgregarTopico;
import com.forohub.challenge.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TituloDuplicado implements ValidadorDeTopicos{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DatosAgregarTopico datos) {

        if(datos.titulo() == null){
            return;
        }

        var tituloValidar = topicoRepository.findFirstByTitulo(datos.titulo()).isPresent();

        if(tituloValidar){
            throw new ValidationException("El titulo ingresado ya existe!");
        }
    }
}
