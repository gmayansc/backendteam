package edu.uoc.backendteam.paracasa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import edu.uoc.backendteam.paracasa.model.menu.MenuProductoAssociation;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MenuProductoAssociation> lstProducto;

	public Menu() {
	}

	public Menu(List<MenuProductoAssociation> lstProducto) {
		this.lstProducto = lstProducto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<MenuProductoAssociation> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<MenuProductoAssociation> lstProducto) {
		this.lstProducto = lstProducto;
	}

}
