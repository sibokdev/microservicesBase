package com.springboot.seizedata.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTiempoTranscurrido extends ZuulFilter{

	private static Logger log=LoggerFactory.getLogger(PreTiempoTranscurrido.class);
	
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
		Long tiempoInicio=System.currentTimeMillis();
		log.info(String.format("%s request enrutado a %s",request.getMethod(),request.getRequestURL().toString()));
		request.setAttribute("tiempoInicio", tiempoInicio);
		return request;
	}

	@Override
	public String filterType() {
		// definimos el typo de filtro que se va a utilizar
		return "pre";
	}

	@Override
	public int filterOrder() {
		// definimos el orden del filtro
		return 1;
	}

}
