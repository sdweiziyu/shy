package com.shy.util;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**   
 *    
 * 项目名称：demo   
 * 类名称：TomcatConnectorSettings   
 * 类描述：   
 * 创建人：yuansheng   
 * 创建时间：2016年5月19日 上午11:32:22     
 * @version    
 *    
 */

@EnableConfigurationProperties(TomcatConnectorProperties.class)
@Component
public class TomcatConnectorSettings implements
        EmbeddedServletContainerCustomizer, EnvironmentAware {
    
    @Autowired
    private TomcatConnectorProperties tomcatConnectorProperties;

    private String keepAliveTimeout;
    private String maxKeepAliveRequests;
    private String connectionTimeout;
    private String acceptCount;
    private String maxConnections;
    
    private Environment environment;
    
    public String getKeepAliveTimeout() {
        return tomcatConnectorProperties.getKeepAliveTimeout();
    }

    public void setKeepAliveTimeout(String keepAliveTimeout) {
        this.keepAliveTimeout = keepAliveTimeout;
    }

    public String getMaxKeepAliveRequests() {
        return tomcatConnectorProperties.getMaxKeepAliveRequests();
    }

    public void setMaxKeepAliveRequests(String maxKeepAliveRequests) {
        this.maxKeepAliveRequests = maxKeepAliveRequests;
    }
    

    public String getConnectionTimeout() {
        return tomcatConnectorProperties.getConnectionTimeout();
    }

    public void setConnectionTimeout(String connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
    

    public String getAcceptCount() {
        return tomcatConnectorProperties.getAcceptCount();
    }

    public void setAcceptCount(String acceptCount) {
        this.acceptCount = acceptCount;
    }
    

    public String getMaxConnections() {
        return  tomcatConnectorProperties.getMaxConnections();
    }

    public void setMaxConnections(String maxConnections) {
        this.maxConnections = maxConnections;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {

        if (container instanceof TomcatEmbeddedServletContainerFactory) {
            customizeTomcat((TomcatEmbeddedServletContainerFactory) container);
        }
    }
    
    
    void customizeTomcat( TomcatEmbeddedServletContainerFactory factory) {
        if (this.getKeepAliveTimeout() != null ){
            customizeKeepAliveTimeout(factory, this.getKeepAliveTimeout());
        }
        
        if (this.getMaxKeepAliveRequests() != null){
            customizeMaxKeepAliveRequests(factory, this.getMaxKeepAliveRequests());
        }
        
        if (this.getConnectionTimeout() != null){
            customizeConnectionTimeout(factory, this.getConnectionTimeout());
        }
        
        if (this.getAcceptCount() != null){
            customizeAcceptCount(factory, this.getAcceptCount());
        }
        
        if (this.getMaxConnections() != null){
            customizeMaxConnections(factory, this.getMaxConnections());
        }
                    
    }
    
    private void customizeKeepAliveTimeout(TomcatEmbeddedServletContainerFactory factory, final String keepAliveTimeout) {
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("keepAliveTimeout", keepAliveTimeout);

            }
        });
    }
    
    private void customizeMaxKeepAliveRequests(TomcatEmbeddedServletContainerFactory factory, final String MaxKeepAliveRequests) {
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("MaxKeepAliveRequests", MaxKeepAliveRequests);

            }
        });
    }
    
    private void customizeConnectionTimeout(TomcatEmbeddedServletContainerFactory factory, final String connectionTimeout) {
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
//                connector.setProperty("MaxKeepAliveRequests", MaxKeepAliveRequests);
                connector.setAttribute("connectionTimeout", connectionTimeout);

            }
        });
    }
    
    private void customizeAcceptCount(TomcatEmbeddedServletContainerFactory factory, final String acceptCount) {
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("acceptCount", acceptCount);

            }
        });
    }
    
    private void customizeMaxConnections(TomcatEmbeddedServletContainerFactory factory, final String maxConnections) {
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setProperty("maxConnections", maxConnections);

            }
        });
    }

}


