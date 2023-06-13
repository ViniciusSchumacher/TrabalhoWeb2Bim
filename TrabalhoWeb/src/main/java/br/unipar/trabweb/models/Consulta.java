package br.unipar.trabweb.models;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name= "Consulta")
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id Autogerado pelo sistema")
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, unique = false)
    private Paciente pacienteConsulta;

    @ManyToOne
    @JoinColumn(nullable = false, unique = false)
    private Medico medicoConsulta;

    @Column(nullable = false, unique = false)
    private LocalDateTime horaConsulta;

    //horaConsultaFim sem setter pois ele obrigatoriamente será sempre uma hora a mais que a horaConsulta.
    @Column(nullable = false, unique = false)
    private LocalDateTime horaConsultaFim;

    public Consulta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPacienteConsulta() {
        return pacienteConsulta;
    }

    public void setPacienteConsulta(Paciente pacienteConsulta) {
        this.pacienteConsulta = pacienteConsulta;
    }

    public Medico getMedicoConsulta() {
        return medicoConsulta;
    }

    public void setMedicoConsulta(Medico medicoConsulta) {
        this.medicoConsulta = medicoConsulta;
    }

    public LocalDateTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalDateTime horaConsulta) {
        this.horaConsulta = horaConsulta;
        this.horaConsultaFim = horaConsulta.plusHours(1);  // a consulta tem duração de 1 hora
    }

    public LocalDateTime getHoraConsultaFim() {
        return horaConsultaFim;
    }


}
