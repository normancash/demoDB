package org.example.demodb.repository;

import org.example.demodb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoUsuario extends JpaRepository<Usuario, Integer>
{

    @Query("select e from Usuario e where e.email = :email and e.contrasena = :contrasena")
    public Usuario getLogin(String email, String contrasena);

}