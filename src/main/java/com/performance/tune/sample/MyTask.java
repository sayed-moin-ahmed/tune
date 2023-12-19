package com.performance.tune.sample;

public class MyTask {
    public void work() {

        System.out.println("Work");
        try {
            Thread.sleep(1000);
            System.out.println("Sleeping..."+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
