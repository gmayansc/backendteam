package edu.uoc.backendteam.paracasa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.uoc.backendteam.paracasa.model.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
