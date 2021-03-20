package com.jaworskimateuszm.firstproject.service;

import com.jaworskimateuszm.firstproject.dto.EmailDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    protected List<EmailDto> emails = new ArrayList<>();

    public boolean addEmails(List<EmailDto> emailList) {
        return emails.addAll(emailList);
    }

    public List<EmailDto> getEmails() {
        return emails;
    }
}
