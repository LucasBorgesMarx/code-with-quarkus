package br.com.alura.clean.arch.domain.vo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class TelefoneTest {
    Telefone telefone;

    @BeforeEach
    void setUp() {
        this.telefone = mock(Telefone.class);
    }


    @Test
    @DisplayName("Must_validate_as_valid_telephone")
    void testValidTelefone() {

        when(telefone.getDdd()).thenReturn("11");
        assertNotNull(telefone.getDdd());
        when(telefone.getNumero()).thenReturn("987654321");
        assertNotNull(telefone.getDdd());

        assertTrue(Telefone.validatePhoneNumber("11", "987654321")); // DDD + número sem formatação
        assertTrue(Telefone.validatePhoneNumber("+1 ", "123-456-7890")); // Número internacional com hífen
        assertTrue(Telefone.validatePhoneNumber("55", "(11) 98765-4321")); // Número com DDD entre parênteses e formatação

    }

    @Test
    @DisplayName("Shouldn't_validate_telephone_with_null")
    void testInvalidTelefone() {
        assertFalse(Telefone.validatePhoneNumber(null, null)); // DDD e número nulos
    }

    @Test
    @DisplayName("Shouldn't_validate_telephone_with_invalid_format")
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> Telefone.validatePhoneNumber("123", "1234")); // Número inválido no construtor
        assertThrows(IllegalArgumentException.class, () -> Telefone.validatePhoneNumber("xyz", "987654321")); // DDD inválido no construtor
        assertThrows(IllegalArgumentException.class, () -> new Telefone("xyz", "987654321")); // DDD inválido no construtor
    }

    @Test
    @DisplayName("Must_assign_the_ddd_and_valid_phone-number")
    void testValidPhoneNumber() {
        String ddd = "11";
        String numero = "999999999";
        var result = new Telefone(ddd, numero);
        assertEquals("11", result.getDdd());
        assertEquals("999999999", result.getNumero());
    }
}