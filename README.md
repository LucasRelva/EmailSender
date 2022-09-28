# API Rest - Email Sender

## Para rodar essa aplicação é nescessário:

- Java SDK 17
- [Intellij IDEA Community](https://www.jetbrains.com/pt-br/idea/) (suggested)
- [Lombok plugin](https://projectlombok.org/)

## Como rodar localmente:

- Entrar no localhost:8080/h2-console e configurar a datasource url para:
  - datasource.url=jdbc:h2:mem:email-sender

- Para enviar email:

- Enviar post para http://localhost:8080/mail com JSON body seguindo o exemplo


{
"destiny": "email de destino",
"subject": "assunto do email",
"text": "mesnagem do email"
}