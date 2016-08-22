package com.shy.controller.test;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	private final static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value="/aspect",method=RequestMethod.GET)
	public String getTestAspect(HttpServletRequest request , HttpServletResponse response){
		Enumeration<String>  e =  request.getParameterNames();
		String key="";
		String value ="";
		while(e.hasMoreElements()){
			key = (String) e.nextElement();
			value = request.getParameter(key);
			log.info("Key="+key+" value="+value); 
		}
		return "200";
	}

}
