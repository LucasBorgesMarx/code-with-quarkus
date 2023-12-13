package br.com.alura.clean.arch.domain.vo;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;


@Getter
@Slf4j
public class Telefone {

    private static final Pattern TELEFONE_REGEX = Pattern.compile("^(\\+?\\d{1,3}[- ]?)?\\(?\\d{2,3}\\)?[- ]?\\d{3,5}[- ]?\\d{4}$");

    private final String ddd;
    private final String numero;

    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
        validatePhoneNumber(this.ddd, this.numero);
    }

    public static boolean validatePhoneNumber(String ddd, String telefone) {
        log.info("Iniciando a validação do número de telefone");
        boolean verifyValidPhone = TELEFONE_REGEX.matcher(new StringBuilder().append(ddd).append(telefone)).matches();
        if ((telefone != null || ddd != null) && !verifyValidPhone) {
            log.info("Numero de telefone inválido!");
            throw new IllegalArgumentException("Numero de telefone inválido!");
        }
        return verifyValidPhone;
    }
}
