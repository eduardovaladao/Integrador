package modelo;

import java.sql.Date;
import java.sql.Time;

// Classe Associativa
public class ExamePrescrito {
    // identificador
    private Integer codigo;
    // os objetos relacionados vêm primeiro
    private Exame exame;    
    private Prescricao prescricao;    
    // propriedades
    private Date dataAgendada;

    private Time horarioAgendado;
    
    public ExamePrescrito() {
    }

    public ExamePrescrito(Integer codigo, Exame exame, Prescricao prescricao, Date dataAgendada, Time horarioAgendado) {
        this.codigo = codigo;
        this.exame = exame;
        this.prescricao = prescricao;
        this.dataAgendada = dataAgendada;
        this.horarioAgendado = horarioAgendado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }

    public Date getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(Date dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public Time getHorarioAgendado() {
        return horarioAgendado;
    }

    public void setHorarioAgendado(Time horarioAgendado) {
        this.horarioAgendado = horarioAgendado;
    }

    @Override
    public String toString() {
        return "ExamePrescrito{" + "codigo=" + codigo + ", exame=" + exame + ", prescricao=" + prescricao + ", dataAgendada=" + dataAgendada + ", horarioAgendado=" + horarioAgendado + '}';
    }
}
