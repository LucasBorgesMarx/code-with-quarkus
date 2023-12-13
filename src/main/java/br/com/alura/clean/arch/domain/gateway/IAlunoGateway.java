package br.com.alura.clean.arch.domain.gateway;

import br.com.alura.clean.arch.domain.entity.EAluno;
import br.com.alura.clean.arch.domain.vo.CPF;
import br.com.alura.clean.arch.infra.model.Aluno;

import java.util.List;

public interface IAlunoGateway {
    void createAluno(EAluno eAluno);

    void adicionarTelefones(EAluno eAluno, String ddd, String numero);

    List<Aluno> listarTodosAlunosMAtriculados();

    Aluno buscarPorCpf(CPF cpf);

}
