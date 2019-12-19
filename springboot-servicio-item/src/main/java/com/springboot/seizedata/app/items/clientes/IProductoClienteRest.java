package com.springboot.seizedata.app.items.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.seizedata.app.items.models.Item;
import com.springboot.seizedata.app.items.models.Producto;

//cuando agregamos ribbon se puede eliminar la configuracion de url debajo, ya que se va a agregar un valor al properties
//de spring
//@FeignClient(name="servicio-productos",url="localhost:8001")
//se agrego decode404 por que estaba lanzando la excepcion
//Spring Cloud : FeignClient feign.FeignException$NotFound: status 404 reading
//al agregar esa propiedad al feign client, se recibio otra excepcion
@FeignClient(name="servicio-productos",decode404=true)
public interface IProductoClienteRest {

	@GetMapping("/listar")
	public List<Producto> findAll();
	
	@GetMapping("/ver/{id}")
	public Producto getItemById(@PathVariable Long id);
	
}
