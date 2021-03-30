package com.jaworskimateuszm.firstproject.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EmailExecutorService extends EmailService {

    public void createExecutors() {
        int executorsNumber = emails.size() / N + 1;
        ExecutorService executorService = Executors.newFixedThreadPool(executorsNumber);
        executorService.execute(() -> sendEmail(getFirstNMails(), "Executor"));
        executorService.shutdown();
    }

}
