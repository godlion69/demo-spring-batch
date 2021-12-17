package vn.dls.bi.bard.config;

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

/**
 * Config Jpa for database to read data in spring batch
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "sourceEntityManagerFactory",
        transactionManagerRef = "sourceTransactionManager",
        basePackages = {"vn.dls.bi.bard.repository.source"}
)
public class SourceDBConfig {

    @Bean(name = "sourceDataSource")
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource sourceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sourceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                              @Qualifier("sourceDataSource") DataSource sourceDataSource) {
        return builder
                .dataSource(sourceDataSource)
                .packages("vn.dls.bi.bard.domain.source")
                .build();
    }

    @Bean(name = "sourceTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("sourceEntityManagerFactory") EntityManagerFactory sourceEntityManagerFactory) {
        return new JpaTransactionManager(sourceEntityManagerFactory);
    }
}
