package io.microservices.app.zuulfilter;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	private static final Logger log = LogManager.getLogger(ZuulLoggingFilter.class);

	@Override
	public boolean shouldFilter() {
		// enable filtering
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// filter implementation
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

		log.error("request - > {} ,req url -> {} ", request, request.getRequestURI());
		
		
		return null;
	}

	@Override
	public String filterType() {
		// Tpre ,post ,error
		return "pre";
	}

	@Override
	public int filterOrder() {
		// priority of the filter
		return 1;
	}

}
