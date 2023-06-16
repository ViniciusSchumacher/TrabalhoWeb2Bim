package br.unipar.trabweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Classe criada para tratar da exceção de agendamento de consulta fora do horário estabelecido.
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConsultaHoraInvalidaException extends RuntimeException {

    public ConsultaHoraInvalidaException(String message) {
        super(message);
    }
}
