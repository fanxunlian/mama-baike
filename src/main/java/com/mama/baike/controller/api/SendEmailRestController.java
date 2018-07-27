package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.ResultBody;
import com.mama.baike.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class SendEmailRestController {

    private static final Logger logger = LoggerFactory.getLogger(SendEmailRestController.class);

    @Autowired
    private MailService mailService;

    @RequestMapping("/send")
    @AuthIgnore
    public ResultBody sendEmail()
    {
        ResultBody resultBody = new ResultBody();

        mailService.sendSimpleMail("xunlian_fan001@126.com","1221","111");
        return resultBody;
    }
}
