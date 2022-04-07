package edu.uoc.backendteam.paracasa.model.menu;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.uoc.backendteam.paracasa.model.Menu;
import edu.uoc.backendteam.paracasa.model.Producto;

@Entity
@Table(name = "menuProductoAssociation")
public class MenuProductoAssociation implements Serializable {

	private static final long serialVersionUID = -6210892747603716186L;

	@Id
	@EmbeddedId
	private MenuProductoAssociationId id;

	@ManyToOne
	@JoinColumn(name = "menu_id", updatable = false, insertable = false, referencedColumnName = "id")
	@JsonIgnore
	private Menu menu;

	@ManyToOne
	@JoinColumn(name = "producto_id", updatable = false, insertable = false, referencedColumnName = "id")
	private Producto producto;

	public MenuProductoAssociation() {
	}
	
	public MenuProductoAssociationId getId() {
		return id;
	}

	public void setId(MenuProductoAssociationId id) {
		this.id = id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	

	

	

}
