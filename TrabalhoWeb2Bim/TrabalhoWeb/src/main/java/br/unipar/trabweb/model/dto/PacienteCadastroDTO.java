package br.unipar.trabweb.model.dto;

import br.unipar.trabweb.models.EnderecoPaciente;

//Classe criada para a alteração de cadastro de pacientes c/ restrições
public class PacienteCadastroDTO {

    private String nome;
    private String telefone;
    private EnderecoPaciente endereco;

    //atributos que não podem ser alterados
    private String email;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoPaciente getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoPaciente endereco) {
        this.endereco = endereco;
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

    // getters and setters
    // ...
}
