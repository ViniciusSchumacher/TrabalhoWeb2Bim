package br.unipar.trabweb.model.dto;

//Classe criada para listar os pacientes trazendo nome, email e cpf (ordenado pelo nome do paciente em ordem crescente)
public class PacienteDTO {

    private String nome;
    private String email;
    private String cpf;

    //Getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
