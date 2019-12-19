package com.springboot.seizedata.app.items.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.seizedata.app.items.models.Item;
import com.springboot.seizedata.app.items.models.Producto;

@Service
public class ItemServiceImpl implements IItemService{

	//utilizando el restTemplate tradicional.
	//
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		List<Producto> productos=Arrays.asList(restTemplate.getForObject("http://localhost:8001/listar",Producto[].class ));
		
		return productos.stream().map(p->new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item getItemById(Long id, Integer cantidad) {
		Map<String,String> pathVariables=new HashMap<String,String>();
		pathVariables.put("id",id.toString());
	
		Producto producto=restTemplate.getForObject("http://localhost:8001/ver/{id}", Producto.class,pathVariables);
		
		return new Item(producto,cantidad);
	}

}
