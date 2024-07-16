package modelo;

import java.sql.Date;

public class Formacao {
    // identificador
    private Integer codigo;
    
    // os objetos relacionados vêm primeiro depois do código
    private Medico medico;

    private Especialidade especialidade;
    
    // propriedades
    private Date dataFormacao;

    public Formacao() {
    }

    public Formacao(Integer codigo, Medico medico, Especialidade especialidade, Date dataFormacao) {
        this.codigo = codigo;
        this.medico = medico;
        this.especialidade = especialidade;
        this.dataFormacao = dataFormacao;
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    
    public Date getDataFormacao() {
        return dataFormacao;
    }

    public void setDataFormacao(Date dataFormacao) {
        this.dataFormacao = dataFormacao;
    }

    @Override
    public String toString() {
        return "Formacao{" + "codigo=" + codigo + ", medico=" + medico + ", especialidade=" + especialidade + ", dataFormacao=" + dataFormacao + '}';
    }
}
