package edu.uoc.backendteam.paracasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uoc.backendteam.paracasa.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
