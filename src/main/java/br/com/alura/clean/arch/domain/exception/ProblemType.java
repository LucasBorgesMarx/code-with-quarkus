package br.com.alura.clean.arch.domain.exception;

import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.Getter;

@Getter
public enum ProblemType {
    INVALID_FORMAT_DATA("/invalid-format-data", "Invalid formatted data", HttpResponseStatus.BAD_REQUEST.code()),

    INVALID_DATA("/invalid-data", "invalid data", HttpResponseStatus.BAD_REQUEST.code()),

    INCONSISTENT_DATA("/inconsistent-data", "inconsistent data", HttpResponseStatus.OK.code()),

    SYSTEM_ERROR("/system-error", "System Error", HttpResponseStatus.INTERNAL_SERVER_ERROR.code()),

    INVALID_PARAMETER("/invalid-parameter", "Invalid Parameter", HttpResponseStatus.BAD_REQUEST.code()),

    INCOMPREHENSIBLE_MESSAGE("/incomprehensible-message", "Incomprehensible Message", HttpResponseStatus.BAD_REQUEST.code()),

    RECORD_NOT_FOUND("/record-not-found", "Resource not found", HttpResponseStatus.OK.code()),

    ENTITY_IN_USE("/entity-in-use", "Entity in Use", HttpResponseStatus.OK.code()),

    BUSINESS_ERROR("/business-error", "Business rule violation", HttpResponseStatus.OK.code()),

    RECORD_ALREADY_EXISTS("/record-already-exists", "Record already exists", HttpResponseStatus.OK.code()),

    NO_PROBLEM("/no-problem", "No problem", HttpResponseStatus.OK.code()),

    GENERIC("/generic", "Generic", HttpResponseStatus.OK.code()),

    NOT_FOUND("/not-found", "Not found", HttpResponseStatus.NOT_FOUND.code());


    final String title;

    final String uri;

    final int statusCode;


    ProblemType(String path, String title, int statusCode) {

        this.uri = "https://api.clean.arch.com" + path;

        this.title = title;

        this.statusCode = statusCode;

    }


}
