package modelo;

import java.util.ArrayList;

public class Medicamento {

    private Integer codigo;

    private String nome;

    private String tipo;

    private String uso;

    private String descricao;
    
    private ArrayList<MedicamentoPrescrito> medicamentosPrescritos;

    public Medicamento() {
    }

    public Medicamento(Integer codigo, String nome, String tipo, String uso, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.uso = uso;
        this.descricao = descricao;
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

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<MedicamentoPrescrito> getMedicamentosPrescritos() {
        return medicamentosPrescritos;
    }

    public void setMedicamentosPrescritos(ArrayList<MedicamentoPrescrito> medicamentosPrescritos) {
        this.medicamentosPrescritos = medicamentosPrescritos;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "codigo=" + codigo + ", nome=" + nome + ", tipo=" + tipo + ", uso=" + uso + ", descricao=" + descricao + ", medicamentosPrescritos=" + medicamentosPrescritos + '}';
    }
}
