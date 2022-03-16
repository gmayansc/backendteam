package edu.uoc.backendteam.paracasa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductoController {

    @GetMapping("/producto-home")
    public String producto(@RequestParam(name="name", required=false, defaultValue="Somos el grupo backendteam") String name, Model model) {
        model.addAttribute("name", name);
        return "producto";
    }

}
