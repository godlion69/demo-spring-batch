package com.example.demospringbatch.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "sourceEntityManagerFactory",
        transactionManagerRef = "sourceTransactionManager",
        basePackages = {"com.example.demospringbatch.domain.source"}
)
public class SourceDBConfig {

    @Bean(name = "sourceDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource sourceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "sourceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                              @Qualifier("sourceDataSource") DataSource sourceDataSource) {
        return builder
                .dataSource(sourceDataSource)
                .packages("com.example.demospringbatch.domain.source")
                .build();
    }

    @Bean(name = "sourceTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("sourceEntityManagerFactory") EntityManagerFactory sourceEntityManagerFactory) {
        return new JpaTransactionManager(sourceEntityManagerFactory);
    }
}
