package edu.uoc.backendteam.paracasa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uoc.backendteam.paracasa.dao.ProductoRepository;
import edu.uoc.backendteam.paracasa.model.Producto;

@Service
public class ProductoService {
	
	@Autowired
    ProductoRepository productoRepository;
    
    public ArrayList<Producto> obtenerProductos(){
        return (ArrayList<Producto>) productoRepository.findAll();
    }

}
