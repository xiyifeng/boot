package com.xyf.boot.configure;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

import com.xyf.boot.filter.ShiroFilter;

//@Configuration
public class WebServiceConfigure {

	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	    factory.setPort(8888); 
	    factory.setSessionTimeout(10, TimeUnit.MINUTES);
	    return factory;
	}
	
    public FilterRegistrationBean filterRegistrationBean(ShiroFilter encodeFilter){  
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();  
        filterRegistrationBean.setFilter(encodeFilter);  
        filterRegistrationBean.setEnabled(true);  
        filterRegistrationBean.addUrlPatterns("/replay/*");  
        return filterRegistrationBean;  
    }

}
