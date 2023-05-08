package br.com.devfrancelino.ordemdeservico.dto;

import br.com.devfrancelino.ordemdeservico.domain.Cliente;
import br.com.devfrancelino.ordemdeservico.domain.OS;
import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class OsDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFechamento;
    private Integer prioridade;

    @NotEmpty(message = "O campo observações é requerida.")
    private String observacoes;
    private Integer status;
    private Integer tecnico;
    private Integer cliente;

    public OsDTO() {
        super();
    }

    public OsDTO(OS os) {
        super();
        this.id = os.getId();
        this.dataAbertura = os.getDataAbertura();
        this.dataFechamento = os.getDataFechamento();
        this.prioridade = os.getPriodidade().getCod();
        this.observacoes = os.getObservacoes();
        this.status = os.getStatus().getCod();
        this.tecnico = os.getTecnico().getId();
        this.cliente = os.getCliente().getId();
    }
}
