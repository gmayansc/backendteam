package edu.uoc.backendteam.paracasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uoc.backendteam.paracasa.dao.ProductoRepository;
import edu.uoc.backendteam.paracasa.model.Producto;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepository;

    @GetMapping("/producto-home")
    public String producto(@RequestParam(name="name", required=false, defaultValue="Somos el grupo backendteam") String name, Model model) {
        model.addAttribute("name", name);
        return "producto";
    }
    
    @GetMapping("/inserta-producto")
    public String insertar() {
    	Producto p = new Producto();
    	p.setNombre("producto1");
    	p.setDescripcion("des1");
    	p.setKcal(1);
    	
    	productoRepository.save(p);
    	
        return "producto";
    }

}
