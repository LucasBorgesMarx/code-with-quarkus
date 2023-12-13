package br.com.alura.clean.arch.cross.utils;

import br.com.alura.clean.arch.domain.exception.ProblemType;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum BusinessCode {


    SUCCESS("SUCCESS", "success", ProblemType.NO_PROBLEM),

    GENERIC("GENERIC", "error-generic", ProblemType.SYSTEM_ERROR),

    CONNECT_BDD("CONNECT_BDD", "error-connect-bdd", ProblemType.SYSTEM_ERROR),

    EMPTY_BDD("EMPTY_BDD", "error-connect-empty-bdd", ProblemType.RECORD_NOT_FOUND),

    INVALID_PARAMETER("INVALID_PARAMETER", "error-required-parameter", ProblemType.INVALID_PARAMETER),

    ALREADY_EXIST("ALREADY_EXIST", "error-already-exists", ProblemType.SYSTEM_ERROR),

    NOT_FOUND("NOT_FOUND", "not-found", ProblemType.NOT_FOUND),

    STATUS_DESCRIPTION_NOT_FOUND("DATA_NOT_FOUND", "error-communication-status-description-not-exist", ProblemType.SYSTEM_ERROR);

    final String code;
    final String messageCode;
    final ProblemType problemType;

    BusinessCode(final String code, final String messageCode, final ProblemType problemType) {

        this.code = code;

        this.messageCode = messageCode;

        this.problemType = problemType;

    }


    public static BusinessCode getByCode(final String id) {

        return Stream.of(values())

                .filter(bc -> bc.code.equals(id))

                .findFirst()

                .orElse(GENERIC);

    }


    public static boolean isCode(final String id) {

        return Stream.of(values())

                .anyMatch(bc -> bc.messageCode.equals(id));

    }
}
