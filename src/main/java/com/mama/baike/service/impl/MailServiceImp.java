package com.mama.baike.service.impl;

import com.mama.baike.exception.GlobalException;
import com.mama.baike.exception.GlobalRestException;
import com.mama.baike.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImp implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    private String from = "13571845308@163.com";

    public void sendSimpleMail(String to, String subject, String content)
    {
       /* SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
       throw new GlobalException("失败");
    }
    public void sendHtmlMail(String to, String subject, String content)
    {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
           // logger.info("To:"+to+" Subject: "+ subject+ " 邮件发送成功");
        } catch (MessagingException e) {
           // logger.error("To:"+to+" Subject: "+ subject+"发送邮件时发生异常", e);
        }
    }

}
