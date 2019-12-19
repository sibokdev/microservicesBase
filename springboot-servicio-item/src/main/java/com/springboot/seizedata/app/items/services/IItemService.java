package com.springboot.seizedata.app.items.services;

import java.util.List;

import com.springboot.seizedata.app.items.models.Item;

public interface IItemService {
	
	public List<Item> findAll();
	public Item getItemById(Long id,Integer cantidad);
}
