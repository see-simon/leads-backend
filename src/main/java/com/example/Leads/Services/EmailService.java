package com.example.Leads.Services;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    private final JavaMailSender mailSender;

    // ✅ Constructor injection
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendLeadEmail(String name, String surname, String email, String phone, String description ) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("marcialebogang7@gmail.com");
        message.setSubject("New Lead Received");

        message.setText(
                "Name: " + name + " " +
                        "Surname: " + surname + " contact :\n" +
                        "Email: " + email + "\n" +
                        "Phone: " + phone+ " interested in your services  " +  description +" needs to be called "
        );

        message.setFrom("marcialebogang7@gmail.com");

        mailSender.send(message);
    }
}
