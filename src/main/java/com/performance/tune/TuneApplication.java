package com.performance.tune;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskHolder;

import java.util.Set;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class TuneApplication {

	@Autowired
	private ScheduledTaskHolder scheduledTaskHolder;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(TuneApplication.class, args);
	}


//	@Scheduled(cron = "0 */1 * * * *")
//	public void test() throws InterruptedException {
//		System.out.print("Testing................");
//		Stream.of(123).map(e-> {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException ex) {
//				throw new RuntimeException(ex);
//			}
//			return e;
//		}).findFirst();
//	}
//
//
//	@Scheduled(cron = "*/1 * * * * *")
//	public void test1(){
//		testYearlyCronTaskScheduled();
//	}
//	public void testYearlyCronTaskScheduled() {
//		Set<ScheduledTask> scheduledTasks = scheduledTaskHolder.getScheduledTasks();
//		scheduledTasks.forEach(scheduledTask -> scheduledTask.getTask().getRunnable().getClass().getDeclaredMethods());
//		scheduledTasks.stream()
//				.forEach(e->System.out.println(e.toString()));
//	}

}
