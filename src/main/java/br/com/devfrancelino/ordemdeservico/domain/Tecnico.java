package br.com.devfrancelino.ordemdeservico.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Tecnico extends Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tecnico")
    private List<OS> list = new ArrayList<>();

    public Tecnico() {
        super();
    }

    public Tecnico(Integer id, String nome, String cpf, String telefone) {
        super();
    }
}
