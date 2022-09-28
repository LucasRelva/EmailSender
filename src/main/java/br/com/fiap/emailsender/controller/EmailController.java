package br.com.fiap.emailsender.controller;

import br.com.fiap.emailsender.core.domain.dto.MailDto;
import br.com.fiap.emailsender.core.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping
    public ResponseEntity<MailDto> sendMail(@RequestBody MailDto mail) {
        MailDto savedMail = service.sendMail(mail);

        return ResponseEntity.ok(savedMail);
    }

    @GetMapping
    public  ResponseEntity<List<MailDto>> findAll() {
        List<MailDto> response = service.findAll();

        return ResponseEntity.ok(response);
    }

}
