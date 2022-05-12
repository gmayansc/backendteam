package edu.uoc.backendteam.paracasa.service;

import edu.uoc.backendteam.paracasa.model.Usuario;

public interface UsuarioService {

    Usuario guardarUsuario(Usuario usuario);
    
    Usuario findByName(String name);

}
