package br.unipar.trabweb.model.dto;

import br.unipar.trabweb.enums.EspecialidadeENUM;
import br.unipar.trabweb.models.EnderecoMedico;

//Classe criada para a alteração de cadastro de médicos c/ restrições
public class MedicoCadastroDTO {

    private String nome;
    private String telefone;
    private EnderecoMedico endereco;

    //atributos que não podem ser alterados
    private String email;
    private String crm;
    private EspecialidadeENUM especialidade;

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

    public EnderecoMedico getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoMedico endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public EspecialidadeENUM getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeENUM especialidade) {
        this.especialidade = especialidade;
    }
}
