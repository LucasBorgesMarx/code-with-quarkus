package br.com.alura.clean.arch.app.rest;


import br.com.alura.clean.arch.app.dto.request.CreateEnrollmentRequest;
import br.com.alura.clean.arch.app.service.ICreateStudentEnrollmentService;
import br.com.alura.clean.arch.cross.utils.BusinessCode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Path("/hello")
@Slf4j
public class Entrypoint {
    @Inject
    ICreateStudentEnrollmentService service;

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response matricularAluno(final @Valid CreateEnrollmentRequest createEnrollmentRequest) {
        service.createICreateStudentEnrollmentService(createEnrollmentRequest);
        return Response.ok().entity(BusinessCode.SUCCESS).build();
    }
}
