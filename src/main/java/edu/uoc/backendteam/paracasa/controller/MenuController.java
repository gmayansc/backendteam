package edu.uoc.backendteam.paracasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uoc.backendteam.paracasa.dao.ClienteRepository;
import edu.uoc.backendteam.paracasa.dao.MenuRepository;
import edu.uoc.backendteam.paracasa.dao.ProductoRepository;
import edu.uoc.backendteam.paracasa.model.Producto;

import javax.validation.Valid;

@Controller
public class MenuController {
	@Autowired
	private MenuRepository menuRepository;
	
	
    @GetMapping("/menus")
    public String menus(Model model) {

        menuRepository.findAll().forEach(p-> System.out.println(p.getCliente()));
        model.addAttribute("datos", menuRepository.findAll());
        return "index-menu";
    }

}
