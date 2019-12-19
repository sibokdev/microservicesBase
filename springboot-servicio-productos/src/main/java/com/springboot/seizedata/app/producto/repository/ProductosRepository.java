package com.springboot.seizedata.app.producto.repository;

import org.springframework.data.repository.CrudRepository;
import com.springboot.seizedata.app.producto.models.Productos;


public interface ProductosRepository extends CrudRepository<Productos, Long>{

}
