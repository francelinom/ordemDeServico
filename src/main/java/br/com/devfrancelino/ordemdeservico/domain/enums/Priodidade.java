package br.com.devfrancelino.ordemdeservico.domain.enums;

import lombok.Getter;

@Getter
public enum Priodidade {
    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer cod;
    private String descricao;

    Priodidade(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static Priodidade toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Priodidade p : Priodidade.values()) {
            if (cod.equals(p.getCod())) {
                return p;
            }
        }

        throw new IllegalArgumentException("Prioridade inválida" + cod);
    }
}
