package br.com.devfrancelino.ordemdeservico.controller.exceptions;

import br.com.devfrancelino.ordemdeservico.services.exceptions.DataIntegratyViolationException;
import br.com.devfrancelino.ordemdeservico.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e) {
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(DataIntegratyViolationException.class)
    public ResponseEntity<StandardError> dataIntegratyViolationException(DataIntegratyViolationException e) {
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
}
