package br.unipar.trabweb.exceptions;


//Classe criada para tratar da exceção de máximo de uma consulta por dia por paciente
public class ConsultaNoMesmoDiaException extends RuntimeException {
    public ConsultaNoMesmoDiaException(String message) {
        super(message);
    }
}
