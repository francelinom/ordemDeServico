package br.com.devfrancelino.ordemdeservico.dto;

import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Setter
@Getter
public class TecnicoDTO implements Serializable {

    private static final Long serialVersionUID = 1L;
    private Integer id;
    private String nome;

    @CPF
    private String cpf;
    private String telefone;

    public TecnicoDTO() {
        super();
    }

    public TecnicoDTO(Tecnico tecnico) {
        super();
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.cpf = tecnico.getCpf();
        this.telefone = tecnico.getTelefone();
    }
}
