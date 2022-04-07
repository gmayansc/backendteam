package edu.uoc.backendteam.paracasa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.uoc.backendteam.paracasa.dao.ProductoRepository;
import edu.uoc.backendteam.paracasa.model.Producto;

@SpringBootApplication
public class ParaCasaApplication implements CommandLineRunner {

	@Autowired
	private ProductoRepository productoRepository;

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

	}

}
