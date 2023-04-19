package br.com.devfrancelino.ordemdeservico.domain.enums;

import lombok.Getter;

@Getter
public enum Status {
    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private Integer cod;
    private String descricao;

    Status(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static Status toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Status S : Status.values()) {
            if (cod.equals(S.getCod())) {
                return S;
            }
        }

        throw new IllegalArgumentException("Status inválido" + cod);
    }
}
