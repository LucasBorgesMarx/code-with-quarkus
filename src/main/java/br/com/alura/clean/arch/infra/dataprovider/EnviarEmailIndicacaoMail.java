package br.com.alura.clean.arch.infra.dataprovider;

import br.com.alura.clean.arch.app.exception.BusinessException;
import br.com.alura.clean.arch.app.indicacao.IEnviarEmailIndicacao;
import br.com.alura.clean.arch.cross.utils.BusinessCode;
import br.com.alura.clean.arch.domain.gateway.Encryption;
import br.com.alura.clean.arch.infra.model.Aluno;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Slf4j
public class EnviarEmailIndicacaoMail implements IEnviarEmailIndicacao {
    private static final String USER_NAME = "lucas.a.b.p1@example.com";

    private final Encryption encryption;

    public EnviarEmailIndicacaoMail(Encryption encryption) {
        this.encryption = encryption;
    }

    @Override
    public void enviarAluno(Aluno indicado) {
        var props = new Properties();
        // Substitua pelo servidor de SMTP correto
        props.put("mail.smtp.host", "smtp.example.com");
        // Porta SMTP
        props.put("mail.smtp.port", "587");
        // Requer autenticação
        props.put("mail.smtp.auth", "true");
        // Ativa o TLS
        props.put("mail.smtp.starttls.enable", "true");


        // Credenciais do remetente
        final String password = encryption.encryptPassword("sua_senha");
        try {

            // Criando uma sessão com autenticação
            var session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USER_NAME, password);
                }
            });

            // Criação da mensagem
            var message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USER_NAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinatario@example.com"));
            message.setSubject("Assunto do Email");
            message.setText("Conteúdo do Email");

            // Envio da mensagem
            Transport.send(message);

            log.info("Email enviado com sucesso!");

        } catch (MessagingException e) {
            log.error("Erro ao enviar o email: " + e.getMessage());
            throw new BusinessException(BusinessCode.NOT_FOUND);
        }
    }

}
