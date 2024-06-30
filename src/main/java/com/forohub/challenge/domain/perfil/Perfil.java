package com.forohub.challenge.domain.perfil;

import com.forohub.challenge.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "perfiles_usuarios",
            joinColumns=@JoinColumn(name="perfil_id", referencedColumnName="id"),
            inverseJoinColumns =@JoinColumn(name = "usuarios_id"))
    private Set<Usuario> usuarios;

    public Perfil(DatosAgregarPerfil datos){
        this.nombre = datos.nombre();
        this.leer = datos.leer();
        this.escribir = datos.escribir();
        this.borrar = datos.borrar();
        this.comentar = datos.comentar();
    }
}
