package com.springboot.seizedata.app.items.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.seizedata.app.items.models.Item;
import com.springboot.seizedata.app.items.models.Producto;
import com.springboot.seizedata.app.items.services.IItemService;

@RefreshScope
@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	//@Qualifier("serviceRestTemplate")
	IItemService itemService;
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@Autowired
	Environment env;
	
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
	
	
	@GetMapping("/obtener-config")
	public ResponseEntity<?> obtenerConfiguracion(@Value("${server.port}") String puerto) {
		Map<String,String> map=new HashMap();
		map.put("texto", texto);
		map.put("puerto", puerto);
		
		if(env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")) {
			map.put("autor.nombre",env.getProperty("configuracion.autor.nombre"));
			map.put("autor.email",env.getProperty("configuracion.autor.email"));
		}
		
		
		ResponseEntity<Map<String,String>> respuesta=new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
		return respuesta;

	}
	
}
