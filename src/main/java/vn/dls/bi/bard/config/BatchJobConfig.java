package vn.dls.bi.bard.config;


import vn.dls.bi.bard.model.PreReportItemReaderView;
import vn.dls.bi.bard.service.PreReportItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private PreReportItemWriter preReportItemWriter;

    @Bean
    public Job createJob(@Qualifier("orderPreReportStep") Step orderPreReportStep) {
        return jobBuilderFactory.get("MyJob")
                .incrementer(new RunIdIncrementer())
                .flow(orderPreReportStep).end().build();
    }

    @Bean
    public Step orderPreReportStep(@Qualifier("catalogOrderPreReportItemReader") ItemReader<PreReportItemReaderView> preReportDtoItemReader) {
        return stepBuilderFactory.get("orderPreReportStep")
                .<PreReportItemReaderView, PreReportItemReaderView> chunk(1)
                .reader(preReportDtoItemReader)
                .writer(preReportItemWriter)
                .build();
    }
}
