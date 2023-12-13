package br.com.alura.clean.arch.app.service.impl;


import br.com.alura.clean.arch.app.dto.request.CreateEnrollmentRequest;
import br.com.alura.clean.arch.app.service.ICreateStudentEnrollmentService;
import br.com.alura.clean.arch.cross.utils.assembler.CreateEnrollmentRequestMapper;
import br.com.alura.clean.arch.domain.usecase.impl.ICadastroAlunoUseCase;
import jakarta.inject.Singleton;

@Singleton
public class CreateStudentEnrollmentService implements ICreateStudentEnrollmentService {
    private final ICadastroAlunoUseCase cadastroAlunoUseCase;

    private final CreateEnrollmentRequestMapper createEnrollmentRequestMapper;

    public CreateStudentEnrollmentService(ICadastroAlunoUseCase cadastroAlunoUseCase, CreateEnrollmentRequestMapper createEnrollmentRequestMapper) {
        this.cadastroAlunoUseCase = cadastroAlunoUseCase;
        this.createEnrollmentRequestMapper = createEnrollmentRequestMapper;
    }

    @Override
    public void createICreateStudentEnrollmentService(CreateEnrollmentRequest createEnrollmentRequest) {
        cadastroAlunoUseCase.execute(createEnrollmentRequestMapper.toEntity(createEnrollmentRequest));
    }
}
