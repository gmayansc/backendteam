package edu.uoc.backendteam.paracasa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;

	private String descripcion;

	private float kcal;

	private double precio;

	public Producto() {

	}

	public Producto(String nombre, String descripcion, float kcal, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.kcal = kcal;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getKcal() {
		return kcal;
	}

	public void setKcal(float kcal) {
		this.kcal = kcal;
	}

}
