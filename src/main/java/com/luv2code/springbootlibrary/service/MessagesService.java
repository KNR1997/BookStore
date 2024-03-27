package com.luv2code.springbootlibrary.service;

import com.luv2code.springbootlibrary.dao.MessageRepository;
import com.luv2code.springbootlibrary.entity.Message;
import com.luv2code.springbootlibrary.requestmodels.AdminQuestionRequest;
import com.luv2code.springbootlibrary.utils.MyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MessagesService {

    private static final MyLogger logger = MyLogger.getInstance();

    private MessageRepository messageRepository;

    @Autowired
    public MessagesService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void postMessage(Message messageRequest, String userEmail) {
        try {
            Message message = new Message(messageRequest.getTitle(), messageRequest.getQuestion());
            message.setUserEmail(userEmail);
            messageRepository.save(message);
            logger.log("Message posted by user: " + userEmail);
        } catch (Exception e) {
            logger.log("Error occurred while posting message", e);
        }
    }

    public void putMessage(AdminQuestionRequest adminQuestionRequest, String userEmail) {
        try {
            Optional<Message> message = messageRepository.findById(adminQuestionRequest.getId());
            if (!message.isPresent()) {
                throw new Exception("Message not found");
            }

            message.get().setAdminEmail(userEmail);
            message.get().setResponse(adminQuestionRequest.getResponse());
            message.get().setClosed(true);
            messageRepository.save(message.get());
            logger.log("Message updated by admin: " + userEmail);
        } catch (Exception e) {
            logger.log("Error occurred while updating message", e);
        }
    }

}
