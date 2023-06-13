package br.unipar.trabweb.exceptions;

//Classe criada para tratar da exceção de médico já estar em uma consulta (Uma hora de duração)
public class DoctorUnavailableException extends RuntimeException {
    public DoctorUnavailableException(String message) {
        super(message);
    }
}
