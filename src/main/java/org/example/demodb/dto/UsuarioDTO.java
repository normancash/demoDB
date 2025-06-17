package org.example.demodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @NotBlank(message="El nombre esta vacio")
    private String nombre;
    @NotBlank(message="El apellido esta vacio")
    private String apellido;
    @Email(message="Correo invalido")
    private String email;
    @NotNull(message="Contraseña vacia")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String contrasena;
}
