package br.unipar.trabweb.exceptions;

//Classe criada para tratar a exceção de médico ou paciente inativo no sistema
public class MedicoPacienteInativoException extends RuntimeException {

    public MedicoPacienteInativoException(String message) {
        super(message);
    }
}

