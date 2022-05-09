package edu.uoc.backendteam.paracasa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uoc.backendteam.paracasa.dao.PedidoRepository;
import edu.uoc.backendteam.paracasa.model.Pedido;


@Service
public class PedidoService {
	
	@Autowired
    PedidoRepository pedidoRepository;
    
    public ArrayList<Pedido> obtenerPedidos(){
        return (ArrayList<Pedido>) pedidoRepository.findAll();
    }

}
