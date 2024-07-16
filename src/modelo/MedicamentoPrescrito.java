package modelo;

import java.sql.Time;

public class MedicamentoPrescrito {
    // identificador
    private Integer codigo;

    // os objetos relacionados vêm primeiro
    private Medicamento medicamento;
    
    private Prescricao prescricao;
    
    // propriedades
    private Integer quantidadePorDia;

    private String periodoDeUso;

    private Time intervaloDeUso;

    public MedicamentoPrescrito() {
    }

    public MedicamentoPrescrito(Integer codigo, Medicamento medicamento, Prescricao prescricao, Integer quantidadePorDia, String periodoDeUso, Time intervaloDeUso) {
        this.codigo = codigo;
        this.medicamento = medicamento;
        this.prescricao = prescricao;
        this.quantidadePorDia = quantidadePorDia;
        this.periodoDeUso = periodoDeUso;
        this.intervaloDeUso = intervaloDeUso;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }

    public Integer getQuantidadePorDia() {
        return quantidadePorDia;
    }

    public void setQuantidadePorDia(Integer quantidadePorDia) {
        this.quantidadePorDia = quantidadePorDia;
    }

    public String getPeriodoDeUso() {
        return periodoDeUso;
    }

    public void setPeriodoDeUso(String periodoDeUso) {
        this.periodoDeUso = periodoDeUso;
    }

    public Time getIntervaloDeUso() {
        return intervaloDeUso;
    }

    public void setIntervaloDeUso(Time intervaloDeUso) {
        this.intervaloDeUso = intervaloDeUso;
    }

    @Override
    public String toString() {
        return "MedicamentoPrescrito{" + "codigo=" + codigo + ", medicamento=" + medicamento + ", prescricao=" + prescricao + ", quantidadePorDia=" + quantidadePorDia + ", periodoDeUso=" + periodoDeUso + ", intervaloDeUso=" + intervaloDeUso + '}';
    }
}
