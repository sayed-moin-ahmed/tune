package com.performance.tune.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
public class AppConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //taskRegistrar.setScheduler(taskScheduler());
        taskRegistrar.addTriggerTask(() -> myTask().work(), myTrigger());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(42);
    }

    @Bean
    public CustomDynamicSchedule myTrigger() {
        return  new CustomDynamicSchedule(Duration.ofMillis(1));
    }

    @Bean
    public MyTask myTask() {
        return new MyTask();
    }
}