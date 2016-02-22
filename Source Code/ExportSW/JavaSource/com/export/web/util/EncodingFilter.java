package com.export.web.util;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	
	private static final String ENCODING = "encoding";
	private FilterConfig filterConfig;
	private String encoding;
	
	public EncodingFilter() {
		encoding = null;
	}

	public void init(FilterConfig filterconfig) {
		this.filterConfig = filterconfig;
		encoding = filterconfig.getInitParameter(ENCODING);
	}

	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain) {
		try {
			servletrequest.setCharacterEncoding(encoding);
			filterchain.doFilter(servletrequest, servletresponse);
		} catch (Exception exception) {
			filterConfig.getServletContext().log(exception.getMessage());
		}
	}

	public void destroy() { }	

}
