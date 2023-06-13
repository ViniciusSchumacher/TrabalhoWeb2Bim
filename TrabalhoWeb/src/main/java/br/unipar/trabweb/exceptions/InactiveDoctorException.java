package br.unipar.trabweb.exceptions;

//Classe criada para tratar a exceção de médico ou paciente inativo no sistema
public class InactiveDoctorException extends RuntimeException {

    public InactiveDoctorException(String message) {
        super(message);
    }
}

