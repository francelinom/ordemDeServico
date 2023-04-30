package br.com.devfrancelino.ordemdeservico.dto;

import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Setter
@Getter
public class TecnicoDTO implements Serializable {

    private static final Long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message = "O campo nome é requerido")
    private String nome;

    @CPF
    @NotEmpty(message = "O campo CPF é requerido")
    private String cpf;
    @NotEmpty(message = "O campo telefone é requerido")
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
