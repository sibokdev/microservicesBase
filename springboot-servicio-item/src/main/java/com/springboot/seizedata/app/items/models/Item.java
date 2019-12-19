package com.springboot.seizedata.app.items.models;

public class Item {

	private Producto producto;
	private Integer cantidad;
	private Double total;

	public Item() {
	
	}
	
	public Item(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Double getTotal() {
		return producto.getPrecio()*cantidad.doubleValue();
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
		
		
}
