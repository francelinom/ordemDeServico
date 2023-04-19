package br.com.devfrancelino.ordemdeservico.domain;

import lombok.Data;

@Data
public abstract class Pessoa {

    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;

}
