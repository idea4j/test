package com.github.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

    @Scheduled(fixedRate = 1000)
    public void run() {
        System.out.println("myTask run ...");
    }
}
