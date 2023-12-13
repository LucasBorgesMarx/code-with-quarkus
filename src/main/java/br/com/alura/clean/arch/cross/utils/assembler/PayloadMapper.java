package br.com.alura.clean.arch.cross.utils.assembler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface PayloadMapper {

    static <T> T mapPayload(final String input, final Class<T> clazz) throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Matcher matcher = Pattern.compile("\\\\*\"").matcher(input);
        final String s1 = matcher.replaceAll("\"");
        matcher = Pattern.compile("\"*\\{").matcher(s1);
        final String s2 = matcher.replaceAll("{");
        String cleanedPayload = s2.replace("}\"", "}");

        return objectMapper.readValue(cleanedPayload, clazz);

    }
}
