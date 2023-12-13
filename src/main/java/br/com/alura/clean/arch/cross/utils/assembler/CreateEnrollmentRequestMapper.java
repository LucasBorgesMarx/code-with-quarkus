package br.com.alura.clean.arch.cross.utils.assembler;

import br.com.alura.clean.arch.app.dto.request.CreateEnrollmentRequest;
import br.com.alura.clean.arch.domain.entity.EAluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jakarta")
public interface CreateEnrollmentRequestMapper {
    @Mapping(target = "telefones", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "cpf.numero", source = "cpf")
    @Mapping(target = "email.email", source = "email")
    EAluno toEntity(CreateEnrollmentRequest createEnrollmentRequest);

}
