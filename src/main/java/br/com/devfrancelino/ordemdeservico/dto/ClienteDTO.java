package br.com.devfrancelino.ordemdeservico.dto;

import br.com.devfrancelino.ordemdeservico.domain.Cliente;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Getter
@Setter
public class ClienteDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O campo nome é requerido")
    private String nome;

    @CPF
    @NotEmpty(message = "O campo CPF é requerido")
    private String cpf;

    @NotEmpty(message = "O campo telefone é requerido")
    private String telefone;

    public ClienteDTO() {
        super();
    }

    public ClienteDTO(Cliente cliente) {
        super();
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
    }
}
