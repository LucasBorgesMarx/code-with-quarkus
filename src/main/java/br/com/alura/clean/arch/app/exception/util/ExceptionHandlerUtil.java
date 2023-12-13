package br.com.alura.clean.arch.app.exception.util;

import java.util.Optional;

public class ExceptionHandlerUtil {
    private ExceptionHandlerUtil() {

        super();

    }


    private static Throwable getExceptionRootCause(Throwable t) {

        if (t.getCause() == null) {

            return t;

        }

        var rootCause = t.getCause();


        if (Optional.ofNullable(rootCause.getCause()).isPresent()) {

            rootCause = getExceptionRootCause(t.getCause());

        }

        return rootCause;

    }


    public static String getRootCause(Throwable t) {

        if (t.getCause() == null) {

            return t.toString()

                    .substring(t.toString().indexOf(":") + 1)

                    .trim();

        }

        var rootCause = t.getCause();


        if (Optional.ofNullable(rootCause.getCause()).isPresent()) {

            rootCause = getExceptionRootCause(t.getCause());

        }


        return rootCause.toString()

                .substring(rootCause.toString().indexOf(":") + 1)

                .trim();

    }
}
