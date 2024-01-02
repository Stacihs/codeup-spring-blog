package com.codeup.codeupspringblog.services;//package com.codeup.codeupspringblog.services;

import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class PostEmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("staci.holmessegarra@gmail.com")
    private String from;

    public void prepareAndSend(Post post, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.emailSender.send(msg);
        }
        catch (MailException e) {
            // simply log it and go on...
            System.err.println(e.getMessage());
        }
    }
}