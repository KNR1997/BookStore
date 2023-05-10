package com.bookstore.springboot.library.controller;

import com.bookstore.springboot.library.entity.Message;
import com.bookstore.springboot.library.requestmodels.AdminQuestionRequest;
import com.bookstore.springboot.library.service.MessagesService;
import com.bookstore.springboot.library.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayDeque;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/messages")
public class MessagesController {

    private MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value = "Authorization") String token,
                            @RequestBody Message messageRequest) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messagesService.postMessage(messageRequest, userEmail);
    }

    @PostMapping("/secure/admin/message")
    public void putMessage(@RequestHeader(value = "Authorization") String token,
                           @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        messagesService.putMessage(adminQuestionRequest, userEmail);
    }

}
