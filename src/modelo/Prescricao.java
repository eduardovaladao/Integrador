package modelo;

import java.util.ArrayList;
import java.sql.Date;

public class Prescricao {

    private Integer codigo;

    private Date dataRealizacao;

    private String diagnostico;
    
    private String indicacoes;
    
    private Consulta consulta;
    
    private ArrayList<ExamePrescrito> examesPrescritos;
    
    private ArrayList<MedicamentoPrescrito> medicamentosPrescritos;
    
    public Prescricao() {
    }

    public Prescricao(Integer codigo, Date dataRealizacao, String diagnostico, String indicacoes, Consulta consulta) {
        this.codigo = codigo;
        this.dataRealizacao = dataRealizacao;
        this.diagnostico = diagnostico;
        this.indicacoes = indicacoes;
        this.consulta = consulta;
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

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }
    
    

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public ArrayList<ExamePrescrito> getExamesPrescritos() {
        return examesPrescritos;
    }

    public void setExamesPrescritos(ArrayList<ExamePrescrito> examesPrescritos) {
        this.examesPrescritos = examesPrescritos;
    }

    public ArrayList<MedicamentoPrescrito> getMedicamentosPrescritos() {
        return medicamentosPrescritos;
    }

    public void setMedicamentosPrescritos(ArrayList<MedicamentoPrescrito> medicamentosPrescritos) {
        this.medicamentosPrescritos = medicamentosPrescritos;
    }

    @Override
    public String toString() {
        return "Prescricao{" + "codigo=" + codigo + ", dataRealizacao=" + dataRealizacao + ", diagnostico=" + diagnostico + ", consulta=" + consulta + ", examesPrescritos=" + examesPrescritos + ", medicamentosPrescritos=" + medicamentosPrescritos + '}';
    }
}
