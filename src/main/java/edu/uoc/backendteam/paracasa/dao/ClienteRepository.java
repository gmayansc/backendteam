package edu.uoc.backendteam.paracasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

import edu.uoc.backendteam.paracasa.model.Cliente;
import edu.uoc.backendteam.paracasa.model.Producto;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public List<Cliente> findAll();
}
