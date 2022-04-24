package edu.uoc.backendteam.paracasa.model.menu;

import java.io.Serializable;

public class MenuProductoAssociationId implements Serializable {

	private static final long serialVersionUID = -330588757737655399L;
	private Long menu_id;
	private Long producto_id;

	public MenuProductoAssociationId() {
	}

	public MenuProductoAssociationId(Long menu_id, Long producto_id) {
		this.menu_id = menu_id;
		this.producto_id = producto_id;
	}

	public Long getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Long menu_id) {
		this.menu_id = menu_id;
	}

	public Long getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Long producto_id) {
		this.producto_id = producto_id;
	}

}
