package com.jaworskimateuszm.firstproject.controller;

import com.jaworskimateuszm.firstproject.dto.EmailDto;
import com.jaworskimateuszm.firstproject.service.EmailExecutorService;
import com.jaworskimateuszm.firstproject.service.EmailThreadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    // We will be testing services separately, so inheritance is ok.
    private EmailThreadService emailThreadService;
    private EmailExecutorService emailExecutorService;

    public EmailController(EmailThreadService emailThreadService, EmailExecutorService emailExecutorService) {
        this.emailThreadService = emailThreadService;
        this.emailExecutorService = emailExecutorService;
    }

    @GetMapping
    public List<EmailDto> getEmails(){
        return emailThreadService.getEmails();
    }

    @PostMapping
    public boolean addEmails(@RequestBody List<EmailDto> emailList){
        boolean emailsAdded = emailThreadService.addEmails(emailList);
//        boolean emailsAdded = emailExecutorService.addEmails(emailList);
        if (emailsAdded) {
            emailThreadService.createThreads();
//            emailExecutorService.createExecutors();
        }
        return emailsAdded;
    }
}
