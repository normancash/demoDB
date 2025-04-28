package org.example.demodb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            ,generator = "SEQ_USUARIO")
    @SequenceGenerator(name="SEQ_USUARIO",sequenceName = "SEQ_USUARIO"
            ,allocationSize = 1)
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
}
