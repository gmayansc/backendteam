package edu.uoc.backendteam.paracasa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.uoc.backendteam.paracasa.dao.ClienteRepository;
import edu.uoc.backendteam.paracasa.dao.MenuRepository;
import edu.uoc.backendteam.paracasa.dao.ProductoRepository;
import edu.uoc.backendteam.paracasa.model.Cliente;
import edu.uoc.backendteam.paracasa.model.Menu;
import edu.uoc.backendteam.paracasa.model.Producto;
import edu.uoc.backendteam.paracasa.model.menu.MenuProductoAssociation;

@SpringBootApplication
public class ParaCasaApplication implements CommandLineRunner {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;	
	
	@Autowired
	private MenuRepository menuRepository;

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
		
		if (clienteRepository.count() == 0) {
			List<Cliente> lstCliente = new ArrayList<>();

			Cliente c1 = new Cliente("juan@uoc.edu", "Calle Lujo, 23", "Juan Pérez");
			Cliente c2 = new Cliente("maria@uoc.edu", "Calle Barcelona, 12", "Maria Rodríguez");
			Cliente c3 = new Cliente("pepe@uoc.edu", "Calle Sin Nombre, 39", "Pepe Moreno");

			lstCliente.add(c1);
			lstCliente.add(c2);
			lstCliente.add(c3);

			clienteRepository.saveAll(lstCliente);
		}

		
		if (menuRepository.count() == 0) {
			Cliente c1 = new Cliente("juan@uoc.edu", "Calle Lujo, 23", "Juan Pérez");
			
			List<MenuProductoAssociation> lstProducto = new ArrayList<>();
			MenuProductoAssociation p1 = new MenuProductoAssociation();

			lstProducto.add(p1);
			
			List<Menu> lstMenu = new ArrayList<>();

			Menu m1 = new Menu(c1, lstProducto);
			lstMenu.add(m1);
		}
		
	}

}
