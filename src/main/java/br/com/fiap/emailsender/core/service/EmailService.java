package br.com.fiap.emailsender.core.service;

import br.com.fiap.emailsender.core.domain.dto.MailDto;
import br.com.fiap.emailsender.core.domain.model.Mail;
import br.com.fiap.emailsender.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    JavaMailSender emailSender;

    @Autowired
    EmailRepository repository;

    public MailDto sendMail(MailDto mail) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("fiap.sprint.microservice@gmail.com");
        message.setTo(mail.getDestiny());
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());

        emailSender.send(message);

        Mail mailToSave = Mail.builder()
                .destiny(mail.getDestiny())
                .subject(mail.getSubject())
                .text(mail.getText())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(mailToSave);

        return mailToSave.toDto(mailToSave);
    }

    public List<MailDto> findAll() {

        List<Mail> mails = repository.findAll();
       List<MailDto> mailsToReturn = new ArrayList<>();

        mails.stream().forEach(mail -> {
            mailsToReturn.add(mail.toDto(mail));
       });

       return  mailsToReturn;
    }
}
