package br.unipar.trabweb.models;


import br.unipar.trabweb.enums.EspecialidadeENUM;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "Medico")
public class Medico implements Serializable {

    /*

    A princípio seria utilizado UUID na geração de chave id, porém a auto-geração não funcionou com as outras classes
    quando era feito um POST na classe Medico via Swagger (ex: classe EnderecoMedico)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id Autogerado pelo sistema")
    private Long id;

    @Column(nullable = false, unique = false, length = 255)
    private String nome;

    @Column(nullable = false, unique = false, length = 255)
    private String email;

    @Column(nullable = false, unique = false, length = 20)
    private String telefone;

    @Column(nullable = false, unique = true, length = 20)
    private String crm;

    @Column(nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private EspecialidadeENUM especialidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoMedico endereco;

    @Column(nullable = false)
    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public EnderecoMedico getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoMedico endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("EnderecoMedico cannot be null");
        }
        this.endereco = endereco;
        endereco.setMedico(this);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
