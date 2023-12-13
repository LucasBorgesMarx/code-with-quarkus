package br.com.alura.clean.arch.app.exception.handler;

import br.com.alura.clean.arch.app.exception.util.ExceptionHandlerUtil;
import br.com.alura.clean.arch.cross.utils.BusinessCode;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Variant;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Slf4j
@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
    private static Response buildResponse() {

        var errorResponse = Response
                .status(BusinessCode.INVALID_PARAMETER.getProblemType().getStatusCode())
                .entity(BusinessCode.INVALID_PARAMETER.getMessageCode())
                .type(MediaType.APPLICATION_JSON)
                .build();

        return Response
                .status(BusinessCode.INVALID_PARAMETER.getProblemType().getStatusCode())
                .entity(errorResponse)
                .build();

    }

    @Override
    public Response toResponse(final ConstraintViolationException e) {
        String rootCause = ExceptionHandlerUtil.getRootCause(e);

        log.error(rootCause);

        return buildResponse();

    }
}
