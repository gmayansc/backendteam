package edu.uoc.backendteam.paracasa.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import edu.uoc.backendteam.paracasa.dao.ProductoRepository;
import edu.uoc.backendteam.paracasa.model.Producto;
import edu.uoc.backendteam.paracasa.service.ProductoService;

@RestController
@RequestMapping("/api/productos")

public class ProductoRestController {
    @Autowired
    ProductoService productoService;

    @GetMapping()
    public ArrayList<Producto> obtenerProductos(){
        return productoService.obtenerProductos();
    }

}