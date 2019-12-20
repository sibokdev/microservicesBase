package com.springboot.seizedata.app.items.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springboot.seizedata.app.items.clientes.IProductoClienteRest;
import com.springboot.seizedata.app.items.models.Item;


//esta clase utiliza el Feign para realizar los request post o get, es desarrollado por Netflix.
@Service("serviceFeign")
public class ItemServiceFeign implements IItemService{

	@Autowired
	IProductoClienteRest productoClienteRest;
	
	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return productoClienteRest.findAll().stream().map(p->new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item getItemById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return new Item(productoClienteRest.getItemById(id),cantidad);
	}

}
