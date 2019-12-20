package com.springboot.seizedata.app.items.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.seizedata.app.items.models.Item;
import com.springboot.seizedata.app.items.models.Producto;
import com.springboot.seizedata.app.items.services.IItemService;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	//@Qualifier("serviceRestTemplate")
	IItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	//con la siguiente anotacion indicamos que vamos a tener tolerancia a fallos para este metodo
	@HystrixCommand(fallbackMethod="metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id,@PathVariable int cantidad) {
		return itemService.getItemById(id, cantidad);
	}

	public Item metodoAlternativo(Long id,int cantidad) {
		Producto producto=new Producto();
		producto.setNombre("Hystrixs product");
		producto.setPrecio(300.0);
		producto.setCreateAt(new Date());
		return new Item(producto,cantidad);
	}
}
