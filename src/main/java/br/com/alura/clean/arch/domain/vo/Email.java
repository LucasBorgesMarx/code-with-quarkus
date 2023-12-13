package br.com.alura.clean.arch.domain.vo;

import lombok.Getter;

import java.util.regex.Pattern;


@Getter
public class Email {
    private static final Pattern EMAIL_REGEX = Pattern.compile("[\\w.+-]+@[\\p{L}\\p{N}-]+\\.\\p{L}{2,}", Pattern.UNICODE_CHARACTER_CLASS);
    private final String endereco;

    public Email(String email) {
        this.endereco = email;
        if (endereco == null || !isValid(endereco)) {
            throw new IllegalArgumentException("E-mail inválido!");
        }
    }

    private static boolean isValid(String email) {
        var matcher = EMAIL_REGEX.matcher(email);
        return matcher.matches();
    }
}
