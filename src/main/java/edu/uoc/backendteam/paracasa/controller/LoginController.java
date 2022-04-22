package edu.uoc.backendteam.paracasa.controller;

import edu.uoc.backendteam.paracasa.model.Producto;
import edu.uoc.backendteam.paracasa.model.Usuario;
import edu.uoc.backendteam.paracasa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error,
                        @RequestParam(value="logout", required = false) String logout,
                        Model model, Principal principal, RedirectAttributes flash) {


        if(principal != null) {
            flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
            return "redirect:/";
        }

        if(error != null) {
            model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
        }

        if(logout != null) {
            model.addAttribute("success", "Ha cerrado sesión con éxito!");
        }

        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationUsuario(Model model, Usuario user) {

        model.addAttribute("user", new Usuario());

        return "register-login";
    }

    @PostMapping("/register-process")
    public String processRegister(@Valid Usuario user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register-login";
        }

        usuarioService.guardarUsuario(user);
        return "register-success";
    }

}
