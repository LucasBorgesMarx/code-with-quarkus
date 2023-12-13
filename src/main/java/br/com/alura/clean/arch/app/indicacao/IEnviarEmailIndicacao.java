package br.com.alura.clean.arch.app.indicacao;

import br.com.alura.clean.arch.infra.model.Aluno;

public interface IEnviarEmailIndicacao {
    void enviarAluno(Aluno indicado);
}
