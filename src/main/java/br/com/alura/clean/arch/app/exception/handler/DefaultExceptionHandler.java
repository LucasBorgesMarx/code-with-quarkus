package br.com.alura.clean.arch.app.exception.handler;

import br.com.alura.clean.arch.app.exception.util.ExceptionHandlerUtil;
import br.com.alura.clean.arch.cross.utils.BusinessCode;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
public class DefaultExceptionHandler implements ExceptionMapper<Exception> {


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
    public Response toResponse(final Exception e) {
        if (e instanceof IllegalArgumentException || e instanceof NotFoundException) {
            String rootCause = ExceptionHandlerUtil.getRootCause(e);

            log.error(rootCause);

            return buildResponse(BusinessCode.INVALID_PARAMETER);
        }
        return buildResponse(BusinessCode.GENERIC);

    }
}
