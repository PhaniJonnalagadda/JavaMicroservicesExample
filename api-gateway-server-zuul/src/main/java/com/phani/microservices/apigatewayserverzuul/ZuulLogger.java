package com.phani.microservices.apigatewayserverzuul;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLogger extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		logger.info("Phani-request->{}, uri->{}",req,req.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre"; //pre,post,error
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
