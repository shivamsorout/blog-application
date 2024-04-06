package com.shivam.blogapplication.services.impl;

import com.shivam.blogapplication.entities.EmailDetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender emailSender;
    @Override
    public Set<String> sendEmails(EmailDetails emailDetails) {
        Set<String> successfullySentTo = new HashSet<>();
        int count = 0;
        for (String recipient : emailDetails.getRecipient()) {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper;
            try {
                helper = new MimeMessageHelper(message, true);
                helper.setTo(recipient);
                helper.setSubject(emailDetails.getSubject());
                helper.setText(emailDetails.getMsgBody(),true);

                FileSystemResource file
                        = new FileSystemResource(
                        new File(emailDetails.getAttachment()));

                helper.addAttachment(
                        file.getFilename(), file);

                emailSender.send(message);
                successfullySentTo.add("Email Sent Successfully to: "+recipient + count++);
            } catch (MessagingException e) {
                // Handle exception
                e.printStackTrace();
            }
        }
        return successfullySentTo;
    }
}
