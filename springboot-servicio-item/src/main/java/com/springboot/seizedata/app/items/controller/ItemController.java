package com.springboot.seizedata.app.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.seizedata.app.items.models.Item;
import com.springboot.seizedata.app.items.services.IItemService;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	IItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id,@PathVariable int cantidad) {
		return itemService.getItemById(id, cantidad);
	}

}
