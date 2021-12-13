package com.example.demospringbatch.config;


import com.example.demospringbatch.domain.destination.OscCatalogPreReport;
import com.example.demospringbatch.model.PreReportDto;
import com.example.demospringbatch.service.MyCustomProcessor;
import com.example.demospringbatch.service.MyCustomWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
//    @Autowired
//    private MyCustomReader myCustomReader;
    @Autowired
    private MyCustomWriter myCustomWriter;
    @Autowired
    private MyCustomProcessor myCustomProcessor;

    @Bean
    public Job createJob(@Qualifier("orderPreReportStep") Step orderPreReportStep) {
        return jobBuilderFactory.get("MyJob")
                .incrementer(new RunIdIncrementer())
                .flow(orderPreReportStep).end().build();
    }

    @Bean
    public Step orderPreReportStep(@Qualifier("catalogOrderPreReportItemReader") ItemReader<PreReportDto> preReportDtoItemReader) {
        return stepBuilderFactory.get("orderPreReportStep")
                .<PreReportDto, OscCatalogPreReport> chunk(1)
                .reader(preReportDtoItemReader)
                .processor(myCustomProcessor)
                .writer(myCustomWriter)
                .build();
    }
}
