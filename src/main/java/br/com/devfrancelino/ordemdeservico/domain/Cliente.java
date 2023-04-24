package br.com.devfrancelino.ordemdeservico.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Cliente extends Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;

    @OneToMany(mappedBy = "cliente")
    private List<OS> list = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(list, cliente.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), list);
    }
}
