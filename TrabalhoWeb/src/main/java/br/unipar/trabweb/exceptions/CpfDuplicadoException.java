package br.unipar.trabweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Classe criada para tratar a exceção de CPF do paciente já salvo no banco de dados.
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfDuplicadoException extends RuntimeException {

    public CpfDuplicadoException(String message) {
        super(message);
    }
}
