package br.com.fiap.emailsender.core.domain.dto;

import br.com.fiap.emailsender.core.domain.model.Mail;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MailDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    private String destiny;

    private String subject;

    private String text;

    private LocalDateTime createdAt;
}
