package com.jaworskimateuszm.firstproject.service;

import com.jaworskimateuszm.firstproject.dto.EmailDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class EmailService {

    protected final int N = 10; // number of elements for one thread

    protected List<EmailDto> emails = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean addEmails(List<EmailDto> emailList) {
        return emails.addAll(emailList);
    }

    public List<EmailDto> getEmails() {
        return emails;
    }

    protected synchronized void sendEmail(String threadName) {
        try {
            while(emails.size() > 0) {
                //TODO https://www.baeldung.com/java-email maybe in future developement
                TimeUnit.MILLISECONDS.sleep(1000);
                EmailDto email = emails.stream().filter(e -> !e.getStatus()).findFirst().get();
                emails.remove(email);
                System.out.println(threadName + " deleted " + email.toString());
                System.out.println("Email list size now is: " + emails.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
