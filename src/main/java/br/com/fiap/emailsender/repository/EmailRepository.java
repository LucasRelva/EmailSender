package br.com.fiap.emailsender.repository;

import br.com.fiap.emailsender.core.domain.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository  extends JpaRepository<Mail, Integer> {
}
