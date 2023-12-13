package br.com.alura.clean.arch.infra.dataprovider.assembler;

import br.com.alura.clean.arch.domain.entity.EAluno;
import br.com.alura.clean.arch.infra.model.Aluno;

import java.util.List;
import java.util.Objects;


public final class AlunoMapper {
    private AlunoMapper() {
        throw new UnsupportedOperationException();
    }

    public static Aluno toModel(EAluno eAluno) {
        if (Objects.isNull(eAluno)) {
            return null;
        }
        return Aluno.builder()
                .email(eAluno.getEmail().getEndereco())
                .cpf(eAluno.getCpf().getNumero())
                .nome(eAluno.getNome())
                .telefones(List.of(eAluno.getTelefones().toString()))
                .build();
    }


}
