package com.shy.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**   
 *    
 * 项目名称：platform-weixin-selfInterface   
 * 类名称：SecondDatasourceConfig   
 * 类描述：   
 * 创建人：yuansheng   
 * 创建时间：2016年7月5日 下午3:18:31    
 * @version    
 *    
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManagerFactory", 
        transactionManagerRef = "secondTransactionManager",
        basePackages = { "com.shy.dao.second" })
public class SecondDatasourceConfig {
    
    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix="second.datasource")
    public DataSource barDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("secondDataSource") DataSource barDataSource) {
        return builder
                .dataSource(barDataSource)
                .packages("com.shy.vo.second")
                .persistenceUnit("secondary")
                .build();
    }

    @Bean(name = "secondTransactionManager")
    public PlatformTransactionManager barTransactionManager(
            @Qualifier("secondEntityManagerFactory") EntityManagerFactory secondEntityManagerFactory) {
        return new JpaTransactionManager(secondEntityManagerFactory);
    }
    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}


