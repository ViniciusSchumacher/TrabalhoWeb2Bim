package br.unipar.trabweb.exceptions;

//Classe criada para tratar a exceção de médico ou paciente não encontrados via id
public class MedicoPacienteNaoEncontradoException extends RuntimeException {

    public MedicoPacienteNaoEncontradoException(String message) {
        super(message);
    }
}
