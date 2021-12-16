package vn.dls.bi.bard.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Config Jpa for database to save data in spring batch
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "destinationEntityManagerFactory",
        transactionManagerRef = "destinationTransactionManager",
        basePackages = {"vn.dls.bi.bard.repository.destination"}
)
public class DestinationDBConfig {

    @Bean(name = "destinationDataSource")
    @ConfigurationProperties(prefix = "spring.destination-datasource")
    public DataSource destinationDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "destinationEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean destinationEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                              @Qualifier("destinationDataSource") DataSource destinationDataSource) {
        return builder
                .dataSource(destinationDataSource)
                .packages("vn.dls.bi.bard.domain.destination")
                .build();
    }

    @Bean(name = "destinationTransactionManager")
    public PlatformTransactionManager destinationTransactionManager(
            @Qualifier("destinationEntityManagerFactory") EntityManagerFactory destinationEntityManagerFactory) {
        return new JpaTransactionManager(destinationEntityManagerFactory);
    }
}
