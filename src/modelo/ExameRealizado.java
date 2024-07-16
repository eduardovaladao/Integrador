package modelo;

import java.sql.Date;

public class ExameRealizado {
    // identificador
    private Integer codigo;
    
    // os objetos relacionados vêm primeiro
    private Exame exame;
    
    private Paciente paciente;
    
    // propriedades
    private Date dataRealizacao;
    
    private String resultado;
    
    public ExameRealizado() {
    }

    public ExameRealizado(Integer codigo, Exame exame, Paciente paciente, Date dataRealizacao, String resultado) {
        this.codigo = codigo;
        this.exame = exame;
        this.paciente = paciente;
        this.dataRealizacao = dataRealizacao;
        this.resultado = resultado;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "ExameRealizado{" + "codigo=" + codigo + ", exame=" + exame + ", paciente=" + paciente + ", dataRealizacao=" + dataRealizacao + ", resultado=" + resultado + '}';
    }
}
