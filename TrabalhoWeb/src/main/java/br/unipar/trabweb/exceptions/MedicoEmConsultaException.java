package br.unipar.trabweb.exceptions;

//Classe criada para tratar da exceção de médico já estar em uma consulta (Uma hora de duração)
public class MedicoEmConsultaException extends RuntimeException {
    public MedicoEmConsultaException(String message) {
        super(message);
    }
}
