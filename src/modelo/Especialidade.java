package modelo;

import java.util.ArrayList;

public class Especialidade {

    private Integer codigo;

    private String nome;
    
    private ArrayList<Formacao> formacoes;

    public Especialidade() {
    }

    public Especialidade(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
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

    public ArrayList<Formacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(ArrayList<Formacao> formacoes) {
        this.formacoes = formacoes;
    }

    @Override
    public String toString() {
        return "Especialidade{" + "codigo=" + codigo + ", nome=" + nome + ", formacoes=" + formacoes + '}';
    }
}
