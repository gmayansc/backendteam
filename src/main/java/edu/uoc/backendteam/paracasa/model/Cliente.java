package edu.uoc.backendteam.paracasa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String direccion;
    private String nombre;

<<<<<<< HEAD
    public Long getId() {
        return id;
    }
=======
	public Long getId() {
		return id;
	}
	
	public Cliente() {}
	
	public Cliente(String email, String direccion, String nombre) {
		this.email = email;
		this.direccion = direccion;
		this.nombre = nombre;
	}
>>>>>>> 8c03ca7b572bf430f27cbb8be76ff256eaae60a0

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
