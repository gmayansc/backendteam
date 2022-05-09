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
import edu.uoc.backendteam.paracasa.model.Pedido;
import edu.uoc.backendteam.paracasa.service.PedidoService;


@RestController
@RequestMapping("/api/pedidos")

public class PedidoRestController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping()
    public ArrayList<Pedido> obtenerPedidos(){
        return pedidoService.obtenerPedidos();
    }

}