package br.unipar.trabweb.exceptions;

//Classe criada para tratar a exceção de CRM do médico já salvo no banco de dados.
public class CrmDuplicadoException extends RuntimeException {

    public CrmDuplicadoException(String message) {
        super(message);
    }
}
