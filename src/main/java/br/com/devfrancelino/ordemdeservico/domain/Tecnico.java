package br.com.devfrancelino.ordemdeservico.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
public class Tecnico extends Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tecnico")
    private List<OS> list = new ArrayList<>();

    public Tecnico() {
        super();
    }

    public Tecnico(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tecnico tecnico = (Tecnico) o;
        return Objects.equals(list, tecnico.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), list);
    }
}
