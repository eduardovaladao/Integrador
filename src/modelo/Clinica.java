package modelo;

import java.util.ArrayList;

public class Clinica {

    private Integer codigo;

    private String nome;

    private String cep;

    private ArrayList<Consultorio> consultorios;

    private ArrayList<Laboratorio> laboratorios;

    public Clinica() {
    }

    public Clinica(Integer codigo, String nome, String cep) {
        this.codigo = codigo;
        this.nome = nome;
        this.cep = cep;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ArrayList<Consultorio> getConsultorios() {
        return consultorios;
    }

    public void setConsultorios(ArrayList<Consultorio> consultorios) {
        this.consultorios = consultorios;
    }

    public ArrayList<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(ArrayList<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }

    @Override
    public String toString() {
        return "Clinica{" + "codigo=" + codigo + ", nome=" + nome + ", cep=" + cep + ", consultorios=" + consultorios + ", laboratorios=" + laboratorios + '}';
    }
}
