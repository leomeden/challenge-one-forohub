package com.forohub.challenge.infra.errores;

import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidacionDeIntegridad.class)
    public ResponseEntity tratarErrorIntegridad(ValidacionDeIntegridad e){
        var errores = e.getMessage();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity ErrorValidaciones(ValidationException e){
        var errores = e.getMessage();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity ErrorValidacionToken(TokenExpiredException e){
        var errores = e.getMessage();
        return ResponseEntity.badRequest().body(errores);
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity ErrorNullPointer(NullPointerException e){
//        var errores = e.getMessage();
//        return ResponseEntity.badRequest().body(errores);
//    }




    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
