package modelo;

import java.util.ArrayList;
import java.sql.Time;

public class Exame {

    private Integer codigo;

    private String nome;

    private String tipo;

    private String descricao;

    private Time duracao;
    
    private Laboratorio laboratorio;

    private ArrayList<ExamePrescrito> examesPrescritos;

    private ArrayList<ExameRealizado> examesRealizados;

    public Exame() {
    }

    public Exame(Integer codigo, String nome, String tipo, String descricao, Time duracao, Laboratorio laboratorio) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.laboratorio = laboratorio;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
    
    

    public ArrayList<ExamePrescrito> getExamesPrescritos() {
        return examesPrescritos;
    }

    public void setExamesPrescritos(ArrayList<ExamePrescrito> examesPrescritos) {
        this.examesPrescritos = examesPrescritos;
    }

    public ArrayList<ExameRealizado> getExamesRealizados() {
        return examesRealizados;
    }

    public void setExamesRealizados(ArrayList<ExameRealizado> examesRealizados) {
        this.examesRealizados = examesRealizados;
    }

    @Override
    public String toString() {
        return "Exame{" + "codigo=" + codigo + ", nome=" + nome + ", tipo=" + tipo + ", descricao=" + descricao + ", duracao=" + duracao + ", laboratorio=" + laboratorio + ", examesPrescritos=" + examesPrescritos + ", examesRealizados=" + examesRealizados + '}';
    }
}
