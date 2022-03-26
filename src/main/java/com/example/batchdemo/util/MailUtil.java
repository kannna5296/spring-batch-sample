package com.example.batchdemo.util;

// using SendGrid's Java Library
// https://github.com/sendgrid/sendgrid-java
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MailUtil {

    @Value("${sendgrid.apiKey}")
    public String key;

    @Value("${sendgrid.host}")
    public String host;

    @Value("${mail.to}")
    public String toAddress;

    @Value("${mail.from}")
    public String fromAddress;

    public void send() throws IOException {
        //ベタ書き
        Email from = new Email(fromAddress);
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email(toAddress);
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(key);
        sg.setHost(host);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}