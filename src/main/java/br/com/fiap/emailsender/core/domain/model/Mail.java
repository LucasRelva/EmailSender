package br.com.fiap.emailsender.core.domain.model;

import br.com.fiap.emailsender.core.domain.dto.MailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String destiny;

    private String subject;

    private String text;

    private LocalDateTime createdAt;



    public MailDto toDto(Mail mail) {
        return MailDto.builder()
                .id(mail.getId())
                .destiny(mail.getDestiny())
                .subject(mail.getSubject())
                .text(mail.getText())
                .createdAt(mail.getCreatedAt())
                .build();
    }

}
