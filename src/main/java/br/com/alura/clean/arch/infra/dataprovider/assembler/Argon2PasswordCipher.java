package br.com.alura.clean.arch.infra.dataprovider.assembler;

import br.com.alura.clean.arch.domain.gateway.Encryption;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.inject.Singleton;

import java.nio.charset.StandardCharsets;

@Singleton
public class Argon2PasswordCipher implements Encryption {

    private static final int HASHED_PASSWORD = 65536;
    private static final int HASHED_PASSWORD_PRIMARY = 10;
    private static final int HASHED_PASSWORD_SECOND = 1;

    @Override
    public String encryptPassword(String password) {
        var argon2 = Argon2Factory.create();
        return argon2.hash(HASHED_PASSWORD_PRIMARY, HASHED_PASSWORD, HASHED_PASSWORD_SECOND, password.toCharArray(), StandardCharsets.UTF_8);
    }

    @Override
    public boolean validateCipherPassword(String password, String hashedPassword) {
        return hashedPassword.equals(encryptPassword(password));
    }
}
