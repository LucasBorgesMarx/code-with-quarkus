package br.com.alura.clean.arch.domain.vo;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Getter
@Slf4j
public class CPF {

    private static final int DIGIT_TOTAL = 11;
    private static final int PESO_INI = 10;
    private static final int CPF_SEM_DIG = 9;
    private static final int MENOR_QUE_RESTO = 2;
    private static final Pattern CPF_TOTAL_IGUAL = Pattern.compile("^(\\d)\\1{10}$");
    private static final Pattern CPF_TOTAL = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\w{2,}$", Pattern.UNICODE_CHARACTER_CLASS);
    private static final Pattern REMOVE_NAO_NUM = Pattern.compile("\\D");

    private final String numero;

    public CPF(String numero) {
        this.numero = numero;
        validarCPF(this.numero);
    }

    private static int calcularDigitoVerificador(String parteCpf, int pesoInicial) {
        var soma = 0;
        for (var i = 0; i < parteCpf.length(); i++) {
            soma += Character.getNumericValue(parteCpf.charAt(i)) * pesoInicial;
            pesoInicial--;
        }
        int resto = soma % DIGIT_TOTAL;
        if ((resto < MENOR_QUE_RESTO)) {
            return 0;
        }
        return (DIGIT_TOTAL - resto);
    }

    private void validarCPF(String cpfFormat) {
        if (!CPF_TOTAL.matcher(cpfFormat).matches()) {
            throw new IllegalArgumentException("CPF com formato Inválido!");
        }
        log.info("Remove caracteres não numéricos");
        String cpf = cpfFormat.replaceAll(REMOVE_NAO_NUM.pattern(), "");
        log.info("Verifica se todos os dígitos são iguais (ex: 111.111.111-11)");
        if (CPF_TOTAL_IGUAL.matcher(cpf).matches()) {
            throw new IllegalArgumentException("CPF Inválido todos os dígitos são iguais!");
        }
        log.info("Calcula o primeiro dígito verificador");
        int digito1 = calcularDigitoVerificador(cpf.substring(0, CPF_SEM_DIG), PESO_INI);

        log.info("Calcula o segundo dígito verificador");
        int digito2 = calcularDigitoVerificador(cpf.substring(0, CPF_SEM_DIG) + digito1, DIGIT_TOTAL);
        log.info("Verifica se os dígitos calculados são iguais aos dígitos informados");
        if (!((digito1 == Character.getNumericValue(cpf.charAt(CPF_SEM_DIG))) && (digito2 == Character.getNumericValue(cpf.charAt(PESO_INI))))) {
            throw new IllegalArgumentException("CPF Inválido!");
        }
    }
}
