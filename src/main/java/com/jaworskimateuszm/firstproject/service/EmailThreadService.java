package com.jaworskimateuszm.firstproject.service;

import org.springframework.stereotype.Service;

@Service
public class EmailThreadService extends EmailService {

    public void createThreads() {
        int threadsNumber = emails.size() / N + 1;
        for (int i = 0; i < threadsNumber; i++) {
            Thread thread = new Thread(() ->
                    sendEmail(getFirstNMails(), Thread.currentThread().getName())
            );
            thread.start();
        }
    }
}
