package edu.uoc.backendteam.paracasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

import edu.uoc.backendteam.paracasa.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	public List<Producto> findAll();
}
