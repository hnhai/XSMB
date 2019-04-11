package com.hai.xsmb.batch.configuration;
import com.hai.xsmb.batch.quazt.CrawJob;
import org.quartz.*;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class QuartzConfig {

    private static int SCHEDULER_DELAY_STARTUP = 5;

    @Bean
    public SchedulerFactoryBeanCustomizer customizer() {
        return schedulerFactoryBean -> schedulerFactoryBean
                .setStartupDelay(SCHEDULER_DELAY_STARTUP);
    }

    @Bean
    public JobDetail crawJob() {
        return JobBuilder.newJob(CrawJob.class)
                .withIdentity(CrawJob.JOB_NAME,
                       CrawJob.GROUP)
                .storeDurably().build();
    }

    @Bean
    public CronTrigger crawTrigger(){
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                .cronSchedule(CrawJob.Expression)
                .inTimeZone(timeZone);
        return TriggerBuilder.newTrigger().forJob(crawJob())
                .withIdentity(CrawJob.TRIGGER_NAME,
                        CrawJob.GROUP)
                .withSchedule(cronScheduleBuilder).build();
    }
}
