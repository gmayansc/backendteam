package edu.uoc.backendteam.paracasa.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.uoc.backendteam.paracasa.dao.MenuProductoAssociationRepository;
import edu.uoc.backendteam.paracasa.dao.PedidoRepository;
import edu.uoc.backendteam.paracasa.dao.ProductoRepository;
import edu.uoc.backendteam.paracasa.dao.UsuarioRepository;
import edu.uoc.backendteam.paracasa.model.Menu;
import edu.uoc.backendteam.paracasa.model.Pedido;
import edu.uoc.backendteam.paracasa.model.Producto;
import edu.uoc.backendteam.paracasa.model.Usuario;
import edu.uoc.backendteam.paracasa.model.menu.MenuProductoAssociation;
import edu.uoc.backendteam.paracasa.model.menu.MenuProductoAssociationId;

@RequestMapping("/user/")
@Controller
public class PedidoController {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private MenuProductoAssociationRepository menuProductoAssociationRepository;

	@GetMapping("pedido")
	public String productos(Model model) {

		productoRepository.findAll().forEach(p -> System.out.println(p.getNombre()));
		model.addAttribute("datos", productoRepository.findAll());
		model.addAttribute("mensaje", "");
		return "realizar-pedido";
	}

	@GetMapping("/createmenu")
	public String realizarPedido(HttpServletRequest request,Model model, Principal principal) {
		long total = productoRepository.count();

		String name = principal.getName();
		Usuario usuario = usuarioRepository.findByUsername(name);
		List<Producto> lstProduct = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			String productoIdStr = request.getParameter("producto" + i);
			if (productoIdStr != null && !productoIdStr.isEmpty()) {
				long productId = Long.parseLong(productoIdStr);
				Producto p = productoRepository.findById(productId).get();
				lstProduct.add(p);
			}
		}

		Pedido ped1 = new Pedido();
		Menu m1 = new Menu();

		List<Menu> lstMenu = new ArrayList<>();
		lstMenu.add(m1);
		m1.setPedido(ped1);

		ped1.setUser(usuario);
		ped1.setDate(new Date());
		ped1.setLstMenu(lstMenu);
		pedidoRepository.save(ped1);

		for (Producto p : lstProduct) {
			MenuProductoAssociationId idass = new MenuProductoAssociationId();
			idass.setProducto_id(p.getId());
			idass.setMenu_id(m1.getId());

			MenuProductoAssociation mpas = new MenuProductoAssociation();
			mpas.setId(idass);
			mpas.setMenu(m1);
			mpas.setProducto(p);
			
			menuProductoAssociationRepository.save(mpas);
		}
		
		model.addAttribute("datos", productoRepository.findAll());
		model.addAttribute("mensaje", "pedido realizado");
		return "realizar-pedido";

	}
}
