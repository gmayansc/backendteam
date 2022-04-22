package edu.uoc.backendteam.paracasa.service;

import edu.uoc.backendteam.paracasa.dao.UsuarioRepository;
import edu.uoc.backendteam.paracasa.model.Role;
import edu.uoc.backendteam.paracasa.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsServiceImpl")
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username);

        if(usuario == null) {
            log.error("Error en el Login: no existe el usuario {} en el sistema!" ,username);
            throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        for(Role role: usuario.getRoles()) {
            log.info("Role: {}",role.getAuthority());
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        if(authorities.isEmpty()) {
            log.error("Error en el Login: Usuario {} no tiene roles asignados!",username);
            throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);

    }
}
