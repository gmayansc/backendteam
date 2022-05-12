package edu.uoc.backendteam.paracasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.uoc.backendteam.paracasa.dao.UsuarioRepository;
import edu.uoc.backendteam.paracasa.model.Usuario;

@Controller
public class ClienteController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
    @GetMapping("/user/clientes")
    public String clientes(Model model) {
    	
    	Iterable<Usuario> lstUsuario = usuarioRepository.findAll();

    	lstUsuario.forEach(p-> System.out.println(p.getUsername()));
        model.addAttribute("datos", lstUsuario);
        return "index-cliente";
    }

}
