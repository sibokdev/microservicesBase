package com.springboot.seizedata.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurrido extends ZuulFilter{

	private static Logger log=LoggerFactory.getLogger(PostTiempoTranscurrido.class);
	
	@Override
	public boolean shouldFilter() {
		// definimos que siempre se ejecute el filtro
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// esta es la logica, vamos a obtener el request
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		
		log.info("entrando a post");
		Long tiempoInicio=(Long)request.getAttribute("tiempoInicio");
		Long tiempoFinal=System.currentTimeMillis();
		Long tiempoTranscurrido=tiempoFinal-tiempoInicio;
		log.info(String.format("tiempo transcurrido en segundos %s seg",tiempoTranscurrido.doubleValue()/1000.00));
		log.info(String.format("tiempo transcurrido en milisegundos %s ms",tiempoTranscurrido));
		return request;
	}

	@Override
	public String filterType() {
		// definimos el typo de filtro que se va a utilizar
		return "post";
	}

	@Override
	public int filterOrder() {
		// definimos el orden del filtro
		return 2;
	}

}
