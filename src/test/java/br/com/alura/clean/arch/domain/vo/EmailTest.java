package br.com.alura.clean.arch.domain.vo;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


class EmailTest {


    @Test
    @DisplayName("must_create_emails_with_valid_addresses")
    void testShouldCreateEmailWithValidAddresses() {
        String validEmail = "example@example.com";
        assertDoesNotThrow(() -> new Email(validEmail).getEndereco());
    }

    @Test
    @DisplayName("Shouldn't_create_emails_with_invalid_addresses")
    void testShouldCreateEmailWithInvalidAddresses() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("E-mailInvalido"));
    }

}