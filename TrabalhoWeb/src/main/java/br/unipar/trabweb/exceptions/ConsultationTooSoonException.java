package br.unipar.trabweb.exceptions;

//Classe criada para tratar da exceção de consulta marcada com menos de 30 minutos de antecedência
public class ConsultationTooSoonException extends RuntimeException {
    public ConsultationTooSoonException(String message) {
        super(message);
    }
}
