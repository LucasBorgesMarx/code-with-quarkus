package br.com.alura.clean.arch.app.exception.handler;

import br.com.alura.clean.arch.app.exception.BusinessException;
import br.com.alura.clean.arch.cross.utils.BusinessCode;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {


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
    public Response toResponse(final BusinessException e) {
        if (e.getBusinessCode() == BusinessCode.NOT_FOUND) {

            return Response.status(BusinessCode.NOT_FOUND.getProblemType().getStatusCode()).build();

        }
        return buildResponse(e.getBusinessCode());

    }
}
