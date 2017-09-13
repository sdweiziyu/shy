package com.shy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shy.util.StringUtil;



@WebFilter(filterName="loginFilter",urlPatterns="*")
public class loginFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(loginFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("filter init ...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			logger.info("执行过滤操作");
		    HttpServletRequest req = (HttpServletRequest)request;
		    HttpSession session = req.getSession(false);
		    if(session!=null){
		    	if(!"".equals(StringUtil.killNull(session.getAttribute("_userSelf")))){
		    		chain.doFilter(request, response);
		    	}else{
		    		request.getRequestDispatcher("/login").forward(request, response);
		    	}
		    }else{
		    	request.getRequestDispatcher("/login").forward(request, response);
		    }
		
	}

	@Override
	public void destroy() {
		
	}

}
