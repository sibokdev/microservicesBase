package com.springboot.seizedata.app.producto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.seizedata.app.producto.models.Productos;
import com.springboot.seizedata.app.producto.service.IProductoService;

@RestController
public class ProductosController {

	@Value("${server.port}")
	private String port;
	
	@Autowired
	IProductoService productosService;
	
	@GetMapping("/listar")
	public List<Productos> listAll(){
		return productosService.findAll().stream().map(producto->{
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Productos findById(@PathVariable Long id) {
		Productos producto=productosService.findById(id);
		producto.setPort(port);
		return producto;
	}
}
