package br.com.alura.clean.arch.infra.model;

import br.com.alura.clean.arch.domain.entity.EAluno;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Indicacao {
    private EAluno indicado;
    private EAluno indicante;
    private LocalDateTime dataIndicacao;
}
