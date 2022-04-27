package edu.uoc.backendteam.paracasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.uoc.backendteam.paracasa.dao.MenuRepository;

@Controller
public class MenuController {
	@Autowired
	private MenuRepository menuRepository;
	
	
    @GetMapping("/user/menus")
    public String menus(Model model) {

        menuRepository.findAll().forEach(p-> System.out.println(p.getLstProducto()));
        model.addAttribute("datos", menuRepository.findAll());
        return "index-menu";
    }

}
