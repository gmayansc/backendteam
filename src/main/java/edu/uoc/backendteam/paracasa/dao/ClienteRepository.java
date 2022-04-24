package edu.uoc.backendteam.paracasa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoc.backendteam.paracasa.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public List<Cliente> findAll();
	
	public Cliente findByEmail(String email);
}
