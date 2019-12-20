package com.springboot.seizedata.app.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//habilitamos el manejo de errores
@EnableCircuitBreaker
//con la siguiente anotacion indicamos que sera un cliente del eureka server y que se va a auto registrar
@EnableEurekaClient
//agregamos ribbon y le indicamos el nombre del microservicio que vamos a consumir
//quitamos ribbon por que ahora se maneja en eureka client
//@RibbonClient(name="servicio-productos")
//la anotacion siguiente habilita feign para utilizarlo en el proyecto
@EnableFeignClients
@SpringBootApplication
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
