package com.jaworskimateuszm.firstproject.service;

import com.jaworskimateuszm.firstproject.dto.EmailDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class EmailService {

    protected final int N = 10; // number of elements for one thread

    protected List<EmailDto> emails = new ArrayList<>();

    public boolean addEmails(List<EmailDto> emailList) {
        return emails.addAll(emailList);
    }

    public List<EmailDto> getEmails() {
        return emails;
    }

    protected List<EmailDto> getFirstNMails() {
        int elements = Math.min(emails.size(), N);
        List<EmailDto> emailList = emails.stream().limit(elements).collect(Collectors.toList());
        emails.removeAll(emailList);
        return emailList;
    }

    protected void sendEmail(List<EmailDto> emailList, String threadName) {
        emailList.forEach(this::send);
        System.out.println(threadName + " send " + emailList.size());
    }

    protected void send(EmailDto email) {
        try {
            int min = 50, max = 500;
            long sendTime = (long)(Math.random() * (max - min + 1) + min);
            TimeUnit.MILLISECONDS.sleep(sendTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
