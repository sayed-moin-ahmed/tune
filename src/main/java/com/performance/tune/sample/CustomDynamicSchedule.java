package com.performance.tune.sample;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.time.Duration;
import java.util.Date;

public class CustomDynamicSchedule extends PeriodicTrigger implements Trigger {

    private long delayInterval;

    public CustomDynamicSchedule(Duration period) {
        super(period);
    }



    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        Date lastTime = triggerContext.lastActualExecutionTime();
        return (lastTime == null) ? new Date() : new Date(lastTime.getTime() + delayInterval);
    }
}