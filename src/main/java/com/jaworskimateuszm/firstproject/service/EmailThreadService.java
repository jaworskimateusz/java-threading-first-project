package com.jaworskimateuszm.firstproject.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailThreadService extends EmailService {

    List<Thread> threads = new ArrayList<>();

    public void createThreads() {
        int threadsNumber = emails.size() / N;
        for (int i = 0; i < threadsNumber; i++) {
            Thread thread = new Thread(() ->
                    sendEmail(Thread.currentThread().getName())
            );
            thread.start();
            threads.add(thread);
        }
    }

}
