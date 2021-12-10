package com.example.demospringbatch.config;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerConfig {

    private final JobLauncher jobLauncher;
    private final Job job;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    @Scheduled(fixedDelay = 60, initialDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void scheduleByFixedRate() throws Exception {
        System.out.println("Batch job starting");
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("time", format.format(Calendar.getInstance().getTime())).toJobParameters();
        jobLauncher.run(job, jobParameters);
        System.out.println("Batch job executed successfully\n");
    }
}
