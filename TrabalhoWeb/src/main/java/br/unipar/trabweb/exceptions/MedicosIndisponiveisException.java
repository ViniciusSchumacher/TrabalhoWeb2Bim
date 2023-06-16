package br.unipar.trabweb.exceptions;

/*
Classe criada para tratar da exceção de não haver médicos disponíveis caso nenhum tenha sido adicionado na consulta e
os outros estejam ocupados/inativos.
*/
public class MedicosIndisponiveisException extends RuntimeException {
    public MedicosIndisponiveisException(String message) {
        super(message);
    }
}