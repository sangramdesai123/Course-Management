package com.springboot.starter.email.interfaces;

import com.springboot.starter.email.model.Email;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

@Component
public interface EmailService {

    Boolean sendSimpleMessage(Email email);
    Boolean sendMessageWithCC(Email email);
    Boolean sendMessageWithAttachment(Email email) throws IOException, MessagingException;

}
