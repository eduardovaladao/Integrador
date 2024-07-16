package modelo;

import java.util.ArrayList;

public class Consultorio {

    private Integer codigo;

    private Disponibilidade disponibilidade;

    private Clinica clinica;

    private ArrayList<Consulta> consultas;

    public Consultorio() {
    }

    public Consultorio(Integer codigo, Disponibilidade disponibilidade, Clinica clinica) {
        this.codigo = codigo;
        this.disponibilidade = disponibilidade;
        this.clinica = clinica;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Consultorio{" + "codigo=" + codigo + ", disponibilidade=" + disponibilidade + ", clinica=" + clinica + ", consultas=" + consultas + '}';
    }
}
