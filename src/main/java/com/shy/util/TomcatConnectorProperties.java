package com.shy.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**   
 *    
 * 项目名称：demo   
 * 类名称：TomcatConnectorProperties   
 * 类描述：   
 * 创建人：yuansheng   
 * 创建时间：2016年5月19日 上午11:18:47     
 * @version    
 *    
 */

@ConfigurationProperties(locations="classpath:tomcat.properties", prefix="tomcat.Connector", ignoreUnknownFields=true)
public class TomcatConnectorProperties {

    private String keepAliveTimeout;
    private String maxKeepAliveRequests;
    private String connectionTimeout;
    private String acceptCount;
    private String maxConnections;
    
    public String getKeepAliveTimeout() {
        return keepAliveTimeout;
    }
    public void setKeepAliveTimeout(String keepAliveTimeout) {
        this.keepAliveTimeout = keepAliveTimeout;
    }
    public String getMaxKeepAliveRequests() {
        return maxKeepAliveRequests;
    }
    public void setMaxKeepAliveRequests(String maxKeepAliveRequests) {
        this.maxKeepAliveRequests = maxKeepAliveRequests;
    }
    public String getConnectionTimeout() {
        return connectionTimeout;
    }
    public void setConnectionTimeout(String connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
    public String getAcceptCount() {
        return acceptCount;
    }
    public void setAcceptCount(String acceptCount) {
        this.acceptCount = acceptCount;
    }
    public String getMaxConnections() {
        return maxConnections;
    }
    public void setMaxConnections(String maxConnections) {
        this.maxConnections = maxConnections;
    }
    
    
}


