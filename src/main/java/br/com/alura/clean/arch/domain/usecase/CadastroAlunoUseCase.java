package br.com.alura.clean.arch.domain.usecase;

import br.com.alura.clean.arch.domain.entity.EAluno;
import br.com.alura.clean.arch.domain.gateway.IAlunoGateway;
import br.com.alura.clean.arch.domain.usecase.impl.ICadastroAlunoUseCase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CadastroAlunoUseCase implements ICadastroAlunoUseCase {

    private final IAlunoGateway gateway;

    public CadastroAlunoUseCase(IAlunoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(EAluno eAluno) {
        gateway.createAluno(eAluno);
    }
}
