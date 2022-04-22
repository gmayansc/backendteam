package edu.uoc.backendteam.paracasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uoc.backendteam.paracasa.dao.ProductoRepository;
import edu.uoc.backendteam.paracasa.model.Producto;

import javax.validation.Valid;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepository;

    @GetMapping("/producto-home")
    public String producto(@RequestParam(name="name", required=false, defaultValue="Somos el grupo backendteam") String name, Model model) {
        model.addAttribute("name", name);
        return "producto";
    }

    @GetMapping("/productos")
    public String productos(Model model) {

        productoRepository.findAll().forEach(p-> System.out.println(p.getNombre()));
        model.addAttribute("datos", productoRepository.findAll());
        return "lista-productos";
    }


    @GetMapping("/delete/{id}")
    public String deleteProducto(@PathVariable("id") long id, Model model) {

        Producto producto = productoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("producto id es invalido:" + id));
        productoRepository.delete(producto);

        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("producto id es invalido:" + id));

        model.addAttribute("producto", producto);

        return "update-producto";
    }

    @PostMapping("/update/{id}")
    public String updateProducto(@PathVariable("id") long id, @Valid Producto producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            producto.setId(id);
            return "update-producto";
        }

        productoRepository.save(producto);

        return "redirect:/productos";
    }

    @GetMapping("/nuevo")
    public String mostrarRegistroProducto(Producto producto) {
        return "create-producto";
    }
    

    @PostMapping("/create")
    public String addProducto(@Valid Producto producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-producto";
        }

        productoRepository.save(producto);
        return "redirect:/productos";
    }
    
}
