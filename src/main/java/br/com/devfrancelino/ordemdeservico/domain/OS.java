package br.com.devfrancelino.ordemdeservico.domain;

import br.com.devfrancelino.ordemdeservico.domain.enums.Priodidade;
import br.com.devfrancelino.ordemdeservico.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFechamento;
    private String observacoes;
    private Integer priodidade;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OS os = (OS) o;
        return Objects.equals(id, os.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
