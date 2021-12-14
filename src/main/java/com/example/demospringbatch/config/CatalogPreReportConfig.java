package com.example.demospringbatch.config;

import com.example.demospringbatch.model.PreReportDto;
import com.example.demospringbatch.model.PreReportItemReaderView;
import com.example.demospringbatch.service.CatalogPreReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CatalogPreReportConfig {

    private final CatalogPreReportService catalogPreReportService;

    @Bean
    public ItemReader<PreReportItemReaderView> catalogOrderPreReportItemReader() {
        List<PreReportItemReaderView> listPreReport = catalogPreReportService.getCatalogPreReport();
        return new ListItemReader<>(listPreReport);
    }
}
