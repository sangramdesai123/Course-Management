package com.springboot.starter.email.service;

import com.springboot.starter.email.SpringBootEMailApplication;
import com.springboot.starter.email.interfaces.EmailService;
import com.springboot.starter.email.model.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Description(value = "Class that represents test client for sending e-mails.")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootEMailApplication.class })
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void simpleEmailMessageTest()
    {
        Email email = prepareMessage(false);
        Boolean isSent = emailService.sendSimpleMessage(email);

        assertThat(isSent).isEqualTo(true);
    }

    @Test
    public void simpleEmailMessageWithCCList()
    {
        Email email = prepareMessageWithCCList();
        Boolean isSent = emailService.sendMessageWithCC(email);

        assertThat(isSent).isEqualTo(true);
    }

    @Test
    public void emailMessageWithAttachment() throws IOException, MessagingException
    {
        Email email = prepareMessage(true);
        Boolean isSent = emailService.sendMessageWithAttachment(email);

        assertThat(isSent).isEqualTo(true);
    }

    /**
     * Method for preparing E-mail data object with/without attachment.
     *
     * @param attachmentIncluded - flag that indicates is attachment needed or not.
     * @return Email data object.
     */
    private Email prepareMessage(Boolean attachmentIncluded)
    {
        List<String> toList = new ArrayList<>(1);
        toList.add("heril.muratovic@logate.com");

        Email email = new Email();
        email.setSubject("Simple e-mail test");
        email.setRecipients(toList);
        email.setHtml(false);
        email.setBody("This is simple e-mail message.");

        if (attachmentIncluded) {
            email.setAttachmentPath("/attachment/email.jpg");
        }
        return email;
    }

    /**
     * Method for preparing E-mail object with CC list.
     *
     * @return Email data object
     */
    private Email prepareMessageWithCCList()
    {
        List<String> toList = new ArrayList<>(1);
        toList.add("heril.muratovic@logate.com");

        List<String> ccList = new ArrayList<>(1);
        ccList.add("herilmuratovic@yahoo.com");

        Email email = new Email();
        email.setSubject("Simple e-mail test");
        email.setRecipients(toList);
        email.setCcList(ccList);
        email.setHtml(false);
        email.setBody("This is simple e-mail message with CC list.");

        return email;
    }
}
