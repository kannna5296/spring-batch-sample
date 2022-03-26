package com.example.batchdemo.tasklet;

import com.example.batchdemo.util.MailUtil;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tasklet01 implements Tasklet {

    @Autowired
    MailUtil mailUtil;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("tasklet01!!");
        mailUtil.send();
        return RepeatStatus.FINISHED;
    }

}
