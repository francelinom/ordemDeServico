package br.com.devfrancelino.ordemdeservico.domain;

import br.com.devfrancelino.ordemdeservico.domain.enums.Priodidade;
import br.com.devfrancelino.ordemdeservico.domain.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OS {
    private Integer id;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private String observacoes;
    private Integer priodidade;
    private Integer status;
    private Tecnico tecnico;
    private Cliente cliente;

    public OS() {
        super();
        this.setDataAbertura(LocalDateTime.now());
        this.setPriodidade(Priodidade.BAIXA);
        this.setStatus(Status.ABERTO);
    }

    public OS(Integer id, String observacoes, Priodidade priodidade, Status status, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.setDataAbertura(LocalDateTime.now());
        this.observacoes = observacoes;
        this.priodidade = (priodidade == null) ? 0 : priodidade.getCod();
        this.status = (status == null) ? 0 : status.getCod();
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Priodidade getPriodidade() {
        return Priodidade.toEnum(this.priodidade);
    }

    public void setPriodidade(Priodidade priodidade) {
        this.priodidade = priodidade.getCod();
    }

    public Status getStatus() {
        return Status.toEnum(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.getCod();
    }
}
