package modelo;

import java.util.ArrayList;

public class Laboratorio {

    private Integer codigo;

    private String tipo;

    private Disponibilidade disponibilidade;

    private Clinica clinica;

    private ArrayList<Exame> exames;

    public Laboratorio() {
    }

    public Laboratorio(Integer codigo, String tipo, Disponibilidade disponibilidade, Clinica clinica) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.disponibilidade = disponibilidade;
        this.clinica = clinica;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public ArrayList<Exame> getExames() {
        return exames;
    }

    public void setExames(ArrayList<Exame> exames) {
        this.exames = exames;
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "codigo=" + codigo + ", tipo=" + tipo + ", disponibilidade=" + disponibilidade + ", clinica=" + clinica + ", exames=" + exames + '}';
    }
}
