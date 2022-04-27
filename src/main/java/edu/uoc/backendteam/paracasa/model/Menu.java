package edu.uoc.backendteam.paracasa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.uoc.backendteam.paracasa.model.menu.MenuProductoAssociation;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MenuProductoAssociation> lstProducto;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pedido_id")
	@JsonIgnore
	private Pedido pedido;
	
	public Menu() {
	}

	public Menu(List<MenuProductoAssociation> lstProducto) {
		this.lstProducto = lstProducto;
	}

}
