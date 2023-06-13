package br.unipar.trabweb.models;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "EnderecoPaciente")
public class EnderecoPaciente implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id Autogerado pelo sistema")
    private Long id;

    @Column(nullable = false, unique = false, length = 255)
    private String logradouro;

    @Column(nullable = true, unique = false, length = 15)
    private int numero;

    @Column(nullable = true, unique = false, length = 50)
    private String complemento;

    @Column(nullable = false, unique = false, length = 50)
    private String bairro;

    @Column(nullable = false, unique = false, length = 150)
    private String cidade;

    @Column(nullable = false, unique = false, length = 2)
    private String uf;

    @Column(nullable = false, unique = false, length = 8)
    private int cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
}
