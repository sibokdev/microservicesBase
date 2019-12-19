package com.springboot.seizedata.app.producto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.seizedata.app.producto.models.Productos;
import com.springboot.seizedata.app.producto.repository.ProductosRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	ProductosRepository productosRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Productos> findAll() {
		// TODO Auto-generated method stub
		return (List<Productos>) productosRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Productos findById(Long id) {
		// TODO Auto-generated method stub
		return productosRepository.findById(id).orElse(null);
	}

}
