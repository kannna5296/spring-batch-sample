package com.example.batchdemo.job;

import com.example.batchdemo.listener.JobListener;
import com.example.batchdemo.tasklet.Tasklet01;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
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
public class Job01 {

    @Autowired
    private Tasklet01 tasklet01;
    @Autowired private JobBuilderFactory jobBuilderFactory;
    @Autowired private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(tasklet01)
                .build();
    }

    //1バッチ内に2Step必要な時は
    //taskletの追加と、ここにstep2メソッドの追加が必要

    @Bean
    public Job job(Step step1) throws Exception {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(step1)
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobListener();
    }
}
