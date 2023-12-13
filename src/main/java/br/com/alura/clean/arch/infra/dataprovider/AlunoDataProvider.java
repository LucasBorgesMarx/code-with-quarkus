package br.com.alura.clean.arch.infra.dataprovider;

import br.com.alura.clean.arch.domain.entity.EAluno;
import br.com.alura.clean.arch.domain.gateway.IAlunoGateway;
import br.com.alura.clean.arch.domain.vo.CPF;
import br.com.alura.clean.arch.domain.vo.Telefone;
import br.com.alura.clean.arch.infra.dataprovider.assembler.AlunoMapper;
import br.com.alura.clean.arch.infra.model.Aluno;
import br.com.alura.clean.arch.infra.repository.IAlunoRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class AlunoDataProvider implements IAlunoGateway {
    @Inject
    IAlunoRepository alunoRepository;

    @Override
    public void createAluno(final EAluno eAluno) {
        var aluno = AlunoMapper.toModel(eAluno);
        alunoRepository.persist(aluno);
    }

    @Override
    public void adicionarTelefones(EAluno eAluno, String ddd, String numero) {
        var aluno = alunoRepository.find("cpf", eAluno.getCpf()).firstResultOptional().orElseThrow();
        aluno.getTelefones().add(new Telefone(ddd, numero).toString());
        Map<String, List<String>> params = new HashMap<>();
        params.put("telefones", aluno.getTelefones());
        alunoRepository.update("telefone =: telefones", params);
    }

    @Override
    public List<Aluno> listarTodosAlunosMAtriculados() {
        return alunoRepository.listAll();
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) {
        return alunoRepository.find("cpf", cpf).firstResultOptional().orElseThrow();
    }
}
