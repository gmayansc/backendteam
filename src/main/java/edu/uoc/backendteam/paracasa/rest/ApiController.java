package edu.uoc.backendteam.paracasa.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.uoc.backendteam.paracasa.model.Pedido;
import edu.uoc.backendteam.paracasa.model.Producto;
import edu.uoc.backendteam.paracasa.model.Usuario;
import edu.uoc.backendteam.paracasa.service.PedidoService;
import edu.uoc.backendteam.paracasa.service.ProductoService;
import edu.uoc.backendteam.paracasa.service.UsuarioService;

@RestController
@RequestMapping("/api/")
public class ApiController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(path = "producto")
	public ResponseEntity<Producto> producto(@RequestParam("name")String name) {
		Producto producto = productoService.findByName(name);
		ResponseEntity<Producto> response;
		if(producto == null) {
			response = new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}else {
			response = new ResponseEntity<Producto>(producto, HttpStatus.NOT_FOUND);
		}
		
		return response;
	}

	@PostMapping(path = "producto")
	public ResponseEntity<Producto> createProduct(@RequestBody Producto producto) {
		Producto productoSave = productoService.create(producto);
		ResponseEntity<Producto> response = new ResponseEntity<Producto>(productoSave, HttpStatus.OK);


		return response;
	}

	@DeleteMapping(path = "producto/{id}")
	public ResponseEntity deleteProducto(@PathVariable long id) {
		productoService.delete(id);
		ResponseEntity<Producto> response = new ResponseEntity<>(HttpStatus.OK);


		return response;
	}
	
	@GetMapping(path = "pedido")
	public ResponseEntity<List<Pedido>> pedido(Principal principal) {
		String name = principal.getName();
		Usuario user = usuarioService.findByName(name);
		List<Pedido> lstPedido = pedidoService.findByUsuario(user);
		
		return new ResponseEntity<List<Pedido>>(lstPedido, HttpStatus.OK);
	}
	
}
