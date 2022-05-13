package edu.uoc.backendteam.paracasa.service;

import edu.uoc.backendteam.paracasa.dao.UsuarioRepository;
import edu.uoc.backendteam.paracasa.model.Role;
import edu.uoc.backendteam.paracasa.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {

        usuario.setEnabled(Boolean.TRUE);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Role role = new Role();
        role.setAuthority("ROLE_USER");
        usuario.setRoles(Arrays.asList(role));

        return usuarioRepository.save(usuario);
    }

	@Override
	public Usuario findByName(String name) {
		return usuarioRepository.findByUsername(name);
	}
}
