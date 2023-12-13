package br.com.alura.clean.arch.domain.vo;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CPFTest {

    @Test
    @DisplayName("must_validate_as_valid_cpf")
    void testValidCPF() {
        String validCPF = "123.456.789-09";
        assertDoesNotThrow(() -> new CPF(validCPF));
    }

    @Test
    @DisplayName("Shouldn't_validate_cpf_with_invalid_format")
    void testCPFInvalidoFormato() {
        String cpfInvalido = "123.456.789";
        assertThrows(IllegalArgumentException.class, () -> new CPF(cpfInvalido));
    }

    @Test
    @DisplayName("Shouldn't_validate_cpf_invalid_checker_type")
    void testCPFInvalidoDigitosIguais() {
        String invalidCPF = "111.111.111-11";
        assertThrows(IllegalArgumentException.class, () -> new CPF(invalidCPF));
    }

    @Test
    void testCPFInvalidoDigitosVerificadores() {
        String cpfInvalido = "123.456.789-01";
        assertThrows(IllegalArgumentException.class, () -> new CPF(cpfInvalido));
    }
}