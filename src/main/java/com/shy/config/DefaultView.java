package com.shy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**  
 * 类说明   
 *  
 * @author weizy  
 * @version v1.0
 * @date 2017年2月24日 上午11:24:23
 */
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "forward:/login.html" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
    } 
}
