package com.example.demospringbatch.config;

import com.example.demospringbatch.domain.destination.CvCatalogPreReportRefund;
import com.example.demospringbatch.domain.source.OscCatalogPreReportRefund;
import com.example.demospringbatch.service.MyCustomProcessor;
import com.example.demospringbatch.service.MyCustomReader;
import com.example.demospringbatch.service.MyCustomWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private MyCustomReader myCustomReader;
    @Autowired
    private MyCustomWriter myCustomWriter;
    @Autowired
    private MyCustomProcessor myCustomProcessor;

    @Bean
    public Job createJob() {
        return jobBuilderFactory.get("MyJob")
                .incrementer(new RunIdIncrementer())
                .flow(createStep()).end().build();
    }

    @Bean
    public Step createStep() {
        return stepBuilderFactory.get("MyStep")
                .<OscCatalogPreReportRefund, CvCatalogPreReportRefund> chunk(1)
                .reader(myCustomReader)
                .processor(myCustomProcessor)
                .writer(myCustomWriter)
                .build();
    }
}
