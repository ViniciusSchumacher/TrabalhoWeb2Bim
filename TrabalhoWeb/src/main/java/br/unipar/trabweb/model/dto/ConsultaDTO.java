package br.unipar.trabweb.model.dto;

import java.time.LocalDateTime;

//Classe criada para possibilitar o POST de uma nova consulta utilizando médicos e pacientes já existentes no banco.
public class ConsultaDTO {

    private Long medicoId;
    private Long pacienteId;
    private LocalDateTime horaConsulta;


    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalDateTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }
}
