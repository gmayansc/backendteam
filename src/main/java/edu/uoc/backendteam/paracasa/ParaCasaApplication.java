package edu.uoc.backendteam.paracasa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.uoc.backendteam.paracasa.dao.MenuProductoAssociationRepository;
import edu.uoc.backendteam.paracasa.dao.MenuRepository;
import edu.uoc.backendteam.paracasa.dao.PedidoRepository;
import edu.uoc.backendteam.paracasa.dao.ProductoRepository;
import edu.uoc.backendteam.paracasa.dao.UsuarioRepository;
import edu.uoc.backendteam.paracasa.model.Menu;
import edu.uoc.backendteam.paracasa.model.Pedido;
import edu.uoc.backendteam.paracasa.model.Producto;
import edu.uoc.backendteam.paracasa.model.Usuario;
import edu.uoc.backendteam.paracasa.model.menu.MenuProductoAssociation;
import edu.uoc.backendteam.paracasa.model.menu.MenuProductoAssociationId;

@SpringBootApplication
public class ParaCasaApplication implements CommandLineRunner {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private MenuProductoAssociationRepository menuProductoAssociationRepository;

	public static void main(String[] args) {
		SpringApplication.run(ParaCasaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//
		if (productoRepository.count() == 0) {
			List<Producto> lstProducto = new ArrayList<>();

			Producto p1 = new Producto("hamburgesa1", "hamburgesa1", 1000, 21);
			Producto p2 = new Producto("hamburgesa2", "hamburgesa2", 1000, 22);
			Producto p3 = new Producto("hamburgesa3", "hamburgesa3", 1000, 20);

			lstProducto.add(p1);
			lstProducto.add(p2);
			lstProducto.add(p3);

			productoRepository.saveAll(lstProducto);
		}

		if (menuRepository.count() == 0) {
			Usuario u1 = usuarioRepository.findByUsername("natalia");
			Producto p1 = productoRepository.findByNombre("hamburgesa1");
			Producto p2 = productoRepository.findByNombre("hamburgesa2");
			Producto p3 = productoRepository.findByNombre("hamburgesa3");
			
			Menu m1 = new Menu();
			Menu m2 = new Menu();
			
			List<Menu> lstMenu = new ArrayList<>();
			lstMenu.add(m1);
			lstMenu.add(m2);
			
			
			Pedido ped1 = new Pedido();
			ped1.setUser(u1);
			ped1.setDate(new Date());
			ped1.setLstMenu(lstMenu);
			pedidoRepository.save(ped1);
			

			MenuProductoAssociationId idass = new MenuProductoAssociationId();
			idass.setProducto_id(p1.getId());
			idass.setMenu_id(m1.getId());

			MenuProductoAssociation mpas = new MenuProductoAssociation();
			mpas.setId(idass);
			mpas.setMenu(m1);
			mpas.setProducto(p1);
			
			MenuProductoAssociationId idass2 = new MenuProductoAssociationId();
			idass2.setProducto_id(p2.getId());
			idass2.setMenu_id(m1.getId());

			MenuProductoAssociation mpas2 = new MenuProductoAssociation();
			mpas2.setId(idass2);
			mpas2.setMenu(m1);
			mpas2.setProducto(p2);
			
			MenuProductoAssociationId idass3 = new MenuProductoAssociationId();
			idass3.setProducto_id(p3.getId());
			idass3.setMenu_id(m2.getId());

			MenuProductoAssociation mpas3 = new MenuProductoAssociation();
			mpas3.setId(idass3);
			mpas3.setMenu(m2);
			mpas3.setProducto(p3);

			menuProductoAssociationRepository.save(mpas);
			menuProductoAssociationRepository.save(mpas2);
			menuProductoAssociationRepository.save(mpas3);

		}

	}

}
