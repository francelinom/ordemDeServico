package br.com.devfrancelino.ordemdeservico.controller.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StandardError implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long timestamp;
    private Integer status;
    private String error;

    public StandardError() {
        super();
    }

    public StandardError(Long timestamp, Integer status, String error) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }
}
