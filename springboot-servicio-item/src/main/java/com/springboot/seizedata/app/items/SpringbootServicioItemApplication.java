package com.springboot.seizedata.app.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//agregamos ribbon y le indicamos el nombre del microservicio que vamos a consumir
@RibbonClient(name="servicio-productos")
//la anotacion siguiente habilita feign para utilizarlo en el proyecto
@EnableFeignClients
@SpringBootApplication
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
