package br.com.alura.clean.arch.domain.entity;


import br.com.alura.clean.arch.domain.vo.CPF;
import br.com.alura.clean.arch.domain.vo.Email;
import br.com.alura.clean.arch.domain.vo.Telefone;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EAluno {
    private CPF cpf;
    private String nome;
    private Email email;
    private String senha;
    @Builder.Default
    private List<Telefone> telefones = new ArrayList<>();

}
