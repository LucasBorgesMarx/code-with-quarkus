package br.com.alura.clean.arch.domain.gateway;


public interface Encryption {

    String encryptPassword(String password);

    boolean validateCipherPassword(String password, String hashedPassword);

}
