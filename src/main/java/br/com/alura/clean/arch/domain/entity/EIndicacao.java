package br.com.alura.clean.arch.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EIndicacao {
    private EAluno indicado;
    private EAluno indicante;
    private LocalDateTime dataIndicacao;

    public EIndicacao(EAluno indicado, EAluno indicante) {
        this.indicado = indicado;
        this.indicante = indicante;
        this.dataIndicacao = LocalDateTime.now();
    }
}
