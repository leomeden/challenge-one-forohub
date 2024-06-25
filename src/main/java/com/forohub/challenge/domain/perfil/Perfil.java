package com.forohub.challenge.domain.perfil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "perfil")
@Entity(name = "Perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private boolean leer;

    private boolean escribir;

    private boolean borrar;

    private boolean comentar;

    public Perfil(DatosAgregarPerfil datos){
        this.nombre = datos.nombre();
        this.leer = datos.leer();
        this.escribir = datos.escribir();
        this.borrar = datos.borrar();
        this.comentar = datos.comentar();
    }
}
