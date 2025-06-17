package org.example.demodb.service;

import org.example.demodb.exception.UsuarioException;
import org.example.demodb.model.Usuario;
import org.example.demodb.repository.IRepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuario implements IServiceUsuario{

    @Autowired
    private IRepoUsuario repoUsuario;

    @Override
    public List<Usuario> getAll() {
        return repoUsuario.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repoUsuario.save(usuario);
    }

    @Override
    public void delete(Integer id) {
          repoUsuario.deleteById(id);
    }

    @Override
    public Usuario update(Usuario usuario) {
        Usuario u = repoUsuario.findById(usuario.getId()).orElse(null);
        if (u != null) {
            return repoUsuario.saveAndFlush(usuario);
        }
        return null;
    }

    @Override
    public Usuario findOne(Integer id) throws UsuarioException {
        Usuario u = repoUsuario.findById(id).orElse(null);
        if (u != null) {
            return u;
        }
        throw new UsuarioException("code-001.No existe un usuario con este id:" + id);
    }

    @Override
    public Usuario getLogin(String email, String contrasena) throws UsuarioException {
        return repoUsuario.getLogin(email, contrasena);
    }
}
