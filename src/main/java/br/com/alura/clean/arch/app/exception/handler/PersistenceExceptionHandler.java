package br.com.alura.clean.arch.app.exception.handler;

import br.com.alura.clean.arch.app.exception.util.ExceptionHandlerUtil;
import br.com.alura.clean.arch.cross.utils.BusinessCode;
import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
@Provider
public class PersistenceExceptionHandler implements ExceptionMapper<PersistenceException> {

    public static final String UNIQUE_CONSTRAINT_ERROR = "unique constraint";

    private static BusinessCode processBusinessCode(final String rootCause) {

        if (Pattern.compile(UNIQUE_CONSTRAINT_ERROR, Pattern.CASE_INSENSITIVE)

                .matcher(rootCause)

                .find()) {

            return BusinessCode.ALREADY_EXIST;

        }


        return BusinessCode.CONNECT_BDD;

    }

    private static Response buildResponse(final BusinessCode bc) {

        var errorResponse = Response
                .status(bc.getProblemType().getStatusCode())
                .entity(bc.getMessageCode())
                .type(MediaType.APPLICATION_JSON)
                .build();

        return Response
                .status(bc.getProblemType().getStatusCode())
                .entity(errorResponse)
                .build();

    }

    @Override
    public Response toResponse(final PersistenceException e) {
        String rootCause = ExceptionHandlerUtil.getRootCause(e);

        log.error(rootCause);

        return buildResponse(processBusinessCode(rootCause));

    }
}
