package br.com.alura.clean.arch.infra.repository;

import br.com.alura.clean.arch.infra.model.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public interface IAlunoRepository extends PanacheRepositoryBase<Aluno , Long> {
}
