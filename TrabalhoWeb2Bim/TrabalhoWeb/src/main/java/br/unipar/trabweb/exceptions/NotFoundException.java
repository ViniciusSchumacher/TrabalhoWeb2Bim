package br.unipar.trabweb.exceptions;

//Classe criada para tratar a exceção de médico ou paciente não encontrados via id
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
