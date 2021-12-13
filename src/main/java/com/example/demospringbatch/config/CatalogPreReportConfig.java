package com.example.demospringbatch.config;

import com.example.demospringbatch.model.PreReportDto;
import com.example.demospringbatch.service.CatalogPreReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class CatalogPreReportConfig {

    private final CatalogPreReportService catalogPreReportService;

    @Bean
    public ItemReader<PreReportDto> catalogOrderPreReportItemReader(@Qualifier("sourceEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaCursorItemReader<PreReportDto> result = new JpaCursorItemReader<>();
        result.setEntityManagerFactory(entityManagerFactory);
        result.setQueryString("");
//        result.setParameterValues();
//        JpaPagingItemReader
        return result;
    }
}
