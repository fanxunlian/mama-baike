package com.mama.baike.service;

public interface MailService {
    public void sendSimpleMail(String to, String subject, String content);
    public void sendHtmlMail(String to, String subject, String content);
}
