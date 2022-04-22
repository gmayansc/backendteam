package edu.uoc.backendteam.paracasa.dao;

import edu.uoc.backendteam.paracasa.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    public Usuario findByUsername(String username);
}
