package modelo;

import java.sql.Date;
import java.sql.Time;

public class Consulta {

    private Integer codigo;

    private Date dataRealizacao;

    private Time horarioRealizacao;

    private Medico medico;

    private Paciente paciente;

    private Consultorio consultorio;

    public Consulta() {
    }

    public Consulta(Integer codigo, Date dataRealizacao, Time horarioRealizacao, Medico medico, Paciente paciente, Consultorio consultorio) {
        this.codigo = codigo;
        this.dataRealizacao = dataRealizacao;
        this.horarioRealizacao = horarioRealizacao;
        this.medico = medico;
        this.paciente = paciente;
        this.consultorio = consultorio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public Time getHorarioRealizacao() {
        return horarioRealizacao;
    }

    public void setHorarioRealizacao(Time horarioRealizacao) {
        this.horarioRealizacao = horarioRealizacao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public String toString() {
        return "Consulta{" + "codigo=" + codigo + ", dataRealizacao=" + dataRealizacao + ", horarioRealizacao=" + horarioRealizacao + ", medico=" + medico + ", paciente=" + paciente + ", consultorio=" + consultorio + '}';
    }
}
