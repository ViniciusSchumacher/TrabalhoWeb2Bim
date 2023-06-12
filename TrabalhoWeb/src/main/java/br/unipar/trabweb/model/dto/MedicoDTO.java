package br.unipar.trabweb.model.dto;

import br.unipar.trabweb.enums.EspecialidadeENUM;

//Classe criada para listar os médicos trazendo nome, email, crm e especialidade (ordenado pelo nome do médico em ordem crescente)
public class MedicoDTO {
    private String nome;
    private String email;
    private String crm;
    private EspecialidadeENUM especialidade;

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
