package com.batch.config;

import com.batch.steps.ItemDescompressStep;
import com.batch.steps.ItemProcesorStep;
import com.batch.steps.ItemReaderStep;
import com.batch.steps.ItemWriterStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public Job importPersonJob(JobRepository jobRepository,
                               Step descompressStep,
                               Step readStep,
                               Step processStep,
                               Step writeStep) {
        return new JobBuilder("importPersonJob", jobRepository)
                .start(descompressStep)
                .next(readStep)
                .next(processStep)
                .next(writeStep)
                .build();
    }

    @Bean
    public Step descompressStep(JobRepository jobRepository,
                                PlatformTransactionManager transactionManager,
                                ItemDescompressStep itemDescompressStep) {
        return new StepBuilder("descompressStep", jobRepository)
                .tasklet(itemDescompressStep, transactionManager)
                .build();
    }

    @Bean
    public Step readStep(JobRepository jobRepository,
                         PlatformTransactionManager transactionManager,
                         ItemReaderStep itemReaderStep) {
        return new StepBuilder("readStep", jobRepository)
                .tasklet(itemReaderStep, transactionManager)
                .build();
    }

    @Bean
    public Step processStep(JobRepository jobRepository,
                            PlatformTransactionManager transactionManager,
                            ItemProcesorStep itemProcesorStep) {
        return new StepBuilder("processStep", jobRepository)
                .tasklet(itemProcesorStep, transactionManager)
                .build();
    }

    @Bean
    public Step writeStep(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager,
                          ItemWriterStep itemWriterStep) {
        return new StepBuilder("writeStep", jobRepository)
                .tasklet(itemWriterStep, transactionManager)
                .build();
    }
}