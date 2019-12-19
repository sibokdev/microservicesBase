package com.springboot.seizedata.app.producto.service;

import java.util.List;

import com.springboot.seizedata.app.producto.models.Productos;

public interface IProductoService {
	public List<Productos> findAll();
	public Productos findById(Long id);
}
